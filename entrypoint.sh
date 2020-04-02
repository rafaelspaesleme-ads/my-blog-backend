#!/bin/bash

echo 'Criando tabelas do banco de dados... . . .  .  .  .    .'

sed -e "s|create|none|" -i src/main/resources/application-TYPE_PROFILE_SPRING.properties

