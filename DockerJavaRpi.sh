#!/bin/bash

# Script para configuração de um ambiente Java Docker em uma
# arquitetura RaspBerry Pi ARM.
#
# Execute esse script como root
#
# Created per Rafael Paes Leme

echo '+========================================================+'
echo '=====                                               == ==='
echo '========-   CRIANDO DOCKERFILE SPRING BOOT RPI   -========'
echo '=====                                               == ==='
echo '+========================================================+'

echo 'Dê um nome para a imagem Docker do seu projeto: '
read nameImageDocker

imageDocker="hypriot/rpi-java";

echo 'Configurando Dockerfile'

if [[ "$(docker images -q ${imageDocker} 2> /dev/null)" == "" ]]; then
  docker pull hypriot/rpi-java
fi

echo 'Digite seu username Docker: '
read usernameDocker

echo 'Digite seu email: '
read mailDocker

IMAGE_DOCKER=${imageDocker}
USERNAME_DOCKER=${usernameDocker}
MAIL_DOCKER=${mailDocker}

sed -e "s|IMAGE_DOCKER|$IMAGE_DOCKER|" -i ./Dockerfile
sed -e "s|USERNAME_DOCKER|$USERNAME_DOCKER|" -i ./Dockerfile
sed -e "s|MAIL_DOCKER|$MAIL_DOCKER|" -i ./Dockerfile

echo 'Configurando projeto'
echo ''

echo 'Qual a profile do seu projeto será utilizado?'
echo 'Ex.: "prd" (Produção) - "dev" (Desenvolvimento) - "test" (Testes) - outros'
read typeProfileProperties

echo 'Configurando o banco de dados'
echo ''

echo 'Digite o nome do banco de dados: '
read nameDatabase

echo 'Digite o username do banco de dados: '
read userDatabase

echo 'Digite a senha do banco de dados: '
read passDatabase

echo 'Digite o host real do banco de dados: '
read hostDatabase

echo 'Digite a porta do banco de dados: '
read portDatabase

NAME_DATABASE=${nameDatabase}
USER_DATABASE=${userDatabase}
PASS_DATABASE=${passDatabase}
HOST_DATABASE=${hostDatabase}
PORT_DATABASE=${portDatabase}

sed -e "s|NAME_DATABASE|$NAME_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|USER_DATABASE|$USER_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|PASS_DATABASE|$PASS_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|HOST_DATABASE|$HOST_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|PORT_DATABASE|$PORT_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties

if [ ${typeProfileProperties} != "test" ]
then
    mvn clean install
    mvn package -Dmaven.test.skip=true
else
    mvn clean install
    mvn package
fi

docker build -t ${nameImageDocker} .