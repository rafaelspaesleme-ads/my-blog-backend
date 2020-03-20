#!/bin/bash

echo ''
echo ''
echo 'Press enter to continue: '
read enter

mkdir "compose"

mv docker-compose.yml compose

mv compose/docker-compose.yml .

rm -R compose

docker-compose up -d