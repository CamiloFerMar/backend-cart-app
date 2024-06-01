FROM amazoncorretto:17.0.10
LABEL key="Camilo"

ADD build/libs /opt/spring-boot

### Set Environment
ENV SERVER_HOME /opt/spring-boot

WORKDIR /opt/spring-boot

### Open Ports
EXPOSE 9000

ENV JAVA_OPTS "-Dspring.profiles.active=docker -Dfile.encoding=UTF-8 -Duser.timezone=UTC"

### Start instance
ENTRYPOINT exec java -jar /opt/spring-boot/cartapp-0.0.1-SNAPSHOT.jar