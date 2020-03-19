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

echo 'Atualizando pacotes... . . .  .  .  .    .    .'
git pull origin develop

echo 'Digite o nome do seu projeto: '
read nameContainerDocker

echo 'Digite a imagem docker RPI java para esse projeto: '
read imageDocker

imageDockerPostgre="tobi312/rpi-postgresql:9.6"

echo 'Configurando Dockerfile'

if [[ "$(docker images -q ${imageDocker} 2> /dev/null)" == "" ]]; then
  docker pull ${imageDocker}
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

echo 'Qual o profile do seu projeto será utilizado?'
echo 'Ex.: "prd" (Produção) - "dev" (Desenvolvimento) - "test" (Testes) - outros'
read typeProfileProperties


echo 'Digite a porta do seu projeto: '
read portJProject

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

docker run -t --restart unless-stopped --name ${nameDatabase} -d -p ${portDatabase}:5432 -v /home/pi/.local/share/postgresql:/var/lib/postgresql/data -e POSTGRES_PASSWORD=${passDatabase} ${imageDockerPostgre}

PROFILE_ACTIVE=${typeProfileProperties}
NAME_DATABASE=${nameDatabase}
USER_DATABASE=${userDatabase}
PASS_DATABASE=${passDatabase}
HOST_DATABASE=${hostDatabase}
PORT_DATABASE=${portDatabase}
PORT_JPROJECT=${portJProject}

sed -e "s|dev|$PROFILE_ACTIVE|" -i src/main/resources/application.properties
sed -e "s|NAME_DATABASE|$NAME_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|USER_DATABASE|$USER_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|PASS_DATABASE|$PASS_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|HOST_DATABASE|$HOST_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|PORT_DATABASE|$PORT_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|9999|$PORT_JPROJECT|" -i src/main/resources/application-${typeProfileProperties}.properties

echo 'Criando tabelas do banco de dados... . . .  .  .  .    .'

mvn clean install -Dmaven.test.skip=true

sed -e "s|create|nome|" -i src/main/resources/application-${typeProfileProperties}.properties


if [ ${typeProfileProperties} != "test" ]
then
    mvn clean install -Dmaven.test.skip=true
else
    mvn clean install
fi

docker build -t "img-rpi-${nameContainerDocker}" .

docker run -t --restart unless-stopped -d --name ${nameContainerDocker} -p ${portJProject}:8080 "img-rpi-${nameContainerDocker}"

docker ps

IP_SERVER_RPI=$(hostname -I | awk '{print $1}')

echo 'Acesse http://${IP_SERVER_RPI}:${portJProject}'