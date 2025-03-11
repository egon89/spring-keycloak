# Spring Keycloak

## get token
```shell
curl --location 'http://localhost:8081/realms/user-info/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'client_id=user-info-client' \
--data-urlencode 'username=admin@example.com' \
--data-urlencode 'password=secret' \
--data-urlencode 'grant_type=password'
```

