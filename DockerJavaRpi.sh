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

echo ''
echo 'Configurando Dockerfile'
echo ''

echo 'Digite a imagem docker RPI java para esse projeto: '
read imageDocker

imageDockerPostgre="tobi312/rpi-postgresql:9.6"

if [[ "$(docker images -q ${imageDocker} 2> /dev/null)" == "" ]]; then
  docker pull ${imageDocker}
fi

echo 'Digite seu username Docker: '
read usernameDocker

echo 'Digite seu email: '
read mailDocker

echo 'Configurando projeto'
echo ''

echo 'Digite o nome do seu projeto: '
read nameContainerDocker

echo 'Digite a versão do seu projeto: '
read versionProject

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

echo 'Digite a porta do banco de dados: '
read portDatabase

IMAGE_APP=${imageDocker}
USERNAME_DOCKER=${usernameDocker}
MAIL_DOCKER=${mailDocker}
NAME_PROJECT_JAVA=${nameContainerDocker}
VERSION_PROJECT_JAVA=${versionProject}

PROFILE_ACTIVE=${typeProfileProperties}
IMAGE_POSTGRES=${imageDockerPostgre}
PORT_JPROJECT=${portJProject}

NAME_DATABASE=${nameDatabase}
USER_DATABASE=${userDatabase}
PASS_DATABASE=${passDatabase}
PORT_DATABASE=${portDatabase}

TYPE_PROFILE_SPRING=${typeProfileProperties}

sed -e "s|NAME_PROJECT_JAVA|$NAME_PROJECT_JAVA|" -i docker-compose.yml

sed -e "s|IMAGE_APP|$IMAGE_APP|" -i Dockerfile
sed -e "s|USERNAME_DOCKER|$USERNAME_DOCKER|" -i Dockerfile
sed -e "s|MAIL_DOCKER|$MAIL_DOCKER|" -i Dockerfile
sed -e "s|NAME_PROJECT_JAVA|$NAME_PROJECT_JAVA|" -i Dockerfile
sed -e "s|VERSION_PROJECT_JAVA|$VERSION_PROJECT_JAVA|" -i Dockerfile

sed -e "s|dev|$PROFILE_ACTIVE|" -i src/main/resources/application.properties
sed -e "s|IMAGE_POSTGRES|$IMAGE_POSTGRES|" -i docker-compose.yml
sed -e "s|99999|$PORT_JPROJECT|" -i docker-compose.yml

sed -e "s|NAME_DATABASE|$NAME_DATABASE|" -i docker-compose.yml
sed -e "s|USER_DATABASE|$USER_DATABASE|" -i docker-compose.yml
sed -e "s|PASS_DATABASE|$PASS_DATABASE|" -i docker-compose.yml
sed -e "s|00000|$PORT_DATABASE|" -i docker-compose.yml

sed -e "s|NAME_DATABASE|$NAME_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|USER_DATABASE|$USER_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|PASS_DATABASE|$PASS_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|HOST_DATABASE|db|" -i src/main/resources/application-${typeProfileProperties}.properties
sed -e "s|PORT_DATABASE|$PORT_DATABASE|" -i src/main/resources/application-${typeProfileProperties}.properties

sed -e "s|TYPE_PROFILE_SPRING|$TYPE_PROFILE_SPRING|" -i entrypoint.sh

mvn clean install -Dmaven.test.skip=true

cat docker-compose.yml

echo 'Aperte enter para continuar: '
read enter1

cat Dockerfile

bash execute-docker-compose.sh