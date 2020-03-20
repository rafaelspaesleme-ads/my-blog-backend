FROM IMAGE_APP

MAINTAINER USERNAME_DOCKER <MAIL_DOCKER>

RUN apt-get update
RUN apt-get install -y openjdk-8-jdk

RUN mkdir /app

WORKDIR /app

COPY target/NAME_PROJECT_JAVA-VERSION_PROJECT_JAVA.jar app.jar

COPY app.jar /app

CMD ["java","-jar","app.jar"]