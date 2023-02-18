#!/bin/bash
### OHNE SUDO!!! ###


host=127.0.0.1
user=postgres
password=test123
port=5432
image=postgres_with_scripts

#docker build --no-cache -t $image .
container=$(docker run -d -e POSTGRES_USER=$user, POSTGRES_PASSWORD=$password -p $port:5432 $image:latest) 
echo $container
sleep 5
docker exec -it $container /bin/bash "createDb.sh" $host  $user


