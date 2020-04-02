FROM IMAGE_APP
FROM maven:3.2-jdk-8
FROM bash:4.4

MAINTAINER USERNAME_DOCKER <MAIL_DOCKER>

RUN /bin/sh -c mvn clean install -Dmaven.test.skip=true

CMD ["bash", "entrypoint.sh"]

RUN /bin/sh -c mvn clean install -Dmaven.test.skip=true

RUN mkdir /app

WORKDIR /app

COPY target/NAME_PROJECT_JAVA-VERSION_PROJECT_JAVA.jar /app

CMD ["java","-jar","NAME_PROJECT_JAVA-VERSION_PROJECT_JAVA.jar"]
