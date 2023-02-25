# Database for oauth2 authorization server

## building & running docker image
```
docker build . --tag postgres_oauth
docker run -d -p 5432:5432 --name postgres -e POSTGRES_USER=richard -e POSTGRES_PASSWORD=test123 postgres_oauth
docker stop postgres; docker rm postgres
```



