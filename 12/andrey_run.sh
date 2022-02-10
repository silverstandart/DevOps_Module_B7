#!/bin/bash
# Andreys favicon run

# site url from which favicon will be downloaded
export ENV_SITE_URL=http://google.com
echo ENV_SITE_URL=${ENV_SITE_URL}

# run docker with image my_image in background and get CID of container
CID=$(docker run --env ENV_SITE_URL=${ENV_SITE_URL} -d --name favicon -v vol:/andrey my_image true)
echo CID=$CID

sleep 2

# copy from container volume vol into host folder 
docker cp $CID:/andrey/favicon.ico ./favicon.ico

sleep 2

# remove container
echo remove container `docker ps -q -l`
docker rm `docker ps -q -l`
# remove volume
echo remove volume vol
docker volume rm vol

echo downloaded file ${PWD}/favicon.ico 

