FROM IMAGE_APP

MAINTAINER USERNAME_DOCKER <MAIL_DOCKER>

RUN apt-get update
RUN apt-get install -y openjdk-8-jdk

RUN mkdir /app

RUN mkdir /app/java

WORKDIR /app

COPY . /app

RUN chmod +x entrypoint.sh

ENTRYPOINT ["/bin/bash", "-c", "entrypoint.sh"]

COPY target/NAME_PROJECT_JAVA-VERSION_PROJECT_JAVA.jar /javacle

CMD ["java","-jar","java/NAME_PROJECT_JAVA-VERSION_PROJECT_JAVA.jar"]