FROM IMAGE_APP

MAINTAINER USERNAME_DOCKER <MAIL_DOCKER>

RUN apt-get update
RUN apt-get install -y openjdk-8-jdk
RUN apt install maven
RUN mvn clean install
RUN /bin/bash -c "entrypoint.sh"

RUN mkdir /app

RUN mkdir /app/java

WORKDIR /app

COPY . /app

COPY target/NAME_PROJECT_JAVA-VERSION_PROJECT_JAVA.jar /java

CMD ["java","-jar","java/NAME_PROJECT_JAVA-VERSION_PROJECT_JAVA.jar"]