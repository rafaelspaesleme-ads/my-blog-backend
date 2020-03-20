FROM IMAGE_APP

MAINTAINER USERNAME_DOCKER <MAIL_DOCKER>

RUN apt-get update
RUN apt-get install -y openjdk-8-jdk

COPY entrypoint.sh /usr/local/bin/
RUN ln -s /usr/local/bin/entrypoint.sh /

ENTRYPOINT ["entrypoint.sh"]

RUN mkdir /app

WORKDIR /app

COPY target/NAME_PROJECT_JAVA-VERSION_PROJECT_JAVA.jar /app/app.jar

COPY app.jar /app

CMD ["java","-jar","app.jar"]