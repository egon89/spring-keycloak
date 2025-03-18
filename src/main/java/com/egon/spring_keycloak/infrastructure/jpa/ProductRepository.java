package com.egon.spring_keycloak.infrastructure.jpa;

import com.egon.spring_keycloak.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
