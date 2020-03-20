echo 'Criando tabelas do banco de dados... . . .  .  .  .    .'

apt install maven

mvn clean install

sed -e "s|create|none|" -i src/main/resources/application-TYPE_PROFILE_SPRING.properties


if [ TYPE_PROFILE_SPRING != "test" ]
then
    mvn clean install -Dmaven.test.skip=true
else
    mvn clean install
fi