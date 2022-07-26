FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/servicio-config-server-0.0.1-SNAPSHOT.jar servicio-config-server.jar
ENTRYPOINT ["java", "-jar", "/servicio-config-server.jar"]