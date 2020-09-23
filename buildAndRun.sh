#!/bin/sh

docker stop mp-core

docker rm mp-core

docker rmi mp-core_mp
#
mvn clean package
docker-compose up

read