# Documentation
basiert auf basis von spring-security 5.1 
https://docs.spring.io/spring-security/site/docs/5.2.15.RELEASE/reference/html5/#samples

## wichtige Objekte
- UserDetailsService
- ClientDetailsService
- SecurityConfig

## features
- speichert und authentifiziert clients auf Basis von ClientDetailsService
- bietet vordefinierte Rollen (z.B. Admin) an
- stellt tokens aus

## database
```
docker exec -it 3df6bc2a96a2 psql -U richard -f /setupPostgresDb.sql
docker exec -it 3df6bc2a96a2 psql -U richard -d users -f /schema.sql
```

## scripts
```
docker build . --tag postgres_oauth
docker rmi postgres_oauth
docker stop postgres; docker rm postgres

docker run -d -p 5432:5432 --name postgres postgres_oauth
docker exec -it postgres psql -U richard -d users
```

## API
```
curl --location --request POST 'http://localhost:8090/registration/client/123' \
--header 'Authorization: Bearer 84ec9ead-99b0-4578-8262-d8d390aa05ee' \
--header 'Content-Type: application/json' \
--data-raw '{
   "clientId":"richard",
   "clientSecret":"pelikan"
}'
```


