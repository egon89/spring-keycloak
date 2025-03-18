package com.egon.spring_keycloak.components;

import com.egon.spring_keycloak.configurations.security.JwtConverter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Aspect
@Component
public class PermissionAspect {

  private final ApplicationContext applicationContext;

  public PermissionAspect(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Around("@annotation(CheckPermission)")
  public Object checkPermissionAop(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();

    MethodSignature signature = (MethodSignature) joinPoint.getSignature();

    Method method = signature.getMethod();

    CheckPermission annotation = method.getAnnotation(CheckPermission.class);

    Class<? extends FindProductUseCaseStrategy> strategyClass = annotation.strategy();

    Object target = joinPoint.getTarget();

    Map<String, ? extends FindProductUseCaseStrategy> strategies = applicationContext.getBeansOfType(strategyClass);

    System.out.println(strategies);

    // user
    final var authentication = SecurityContextHolder.getContext().getAuthentication();

    final var user = new UserDto(getRoles(authentication));

    // Find the matching strategy
    FindProductUseCaseStrategy selectedStrategy = strategies.values().stream()
        .filter(strategy -> strategy.supports(user))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("No suitable strategy found"));

    // Get the bean name of the selected strategy
    String selectedBeanName = selectedStrategy.getBeanName();

    System.out.printf("selectedBeanName %s%n", selectedBeanName);

    FindProductUseCaseStrategy strategyBean =
        applicationContext.getBean(selectedBeanName, FindProductUseCaseStrategy.class);

    // Inject the selected strategy into the service
    setUpStrategyBean(target, strategyBean);

    Object proceed = joinPoint.proceed();

    long executionTime = System.currentTimeMillis() - start;

    System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");

    return proceed;
  }

  private static void setUpStrategyBean(Object target, FindProductUseCaseStrategy strategyBean) throws IllegalAccessException {
    for (Field field : target.getClass().getDeclaredFields()) {
      if (FindProductUseCaseStrategy.class.isAssignableFrom(field.getType())) {
        field.setAccessible(true);
        field.set(target, strategyBean);
        break;
      }
    }
  }

  private List<String> getRoles(Authentication authentication) {
    final var credentials = authentication.getCredentials();
    try {
      final var authenticationToken = new JwtConverter().convert((Jwt) credentials);
      final var authorities = Optional.ofNullable(authenticationToken)
          .map(AbstractAuthenticationToken::getAuthorities)
          .orElse(Collections.emptyList());

      return authorities.stream().map(Object::toString).toList();
    } catch (Exception e) {
      return Collections.emptyList();
    }
  }
}
