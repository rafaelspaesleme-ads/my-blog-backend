FROM IMAGE_APP
FROM maven:3.2-jdk-8
FROM bash:4.4

MAINTAINER USERNAME_DOCKER <MAIL_DOCKER>

RUN mkdir /app

COPY . /app

WORKDIR /app

RUN chmod 777 /usr/local/bin/docker-entrypoint.sh \
    && chmod +x /usr/local/bin/docker-entrypoint.sh \
    && ln -s /usr/local/bin/docker-entrypoint.sh /

CMD ["bash", "mvn clean install -Dmaven.test.skip=true"]

CMD ["bash", "entrypoint.sh"]

CMD ["bash", "mvn clean install -Dmaven.test.skip=true"]

CMD ["java","-jar","target/NAME_PROJECT_JAVA-VERSION_PROJECT_JAVA.jar"]
