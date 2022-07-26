FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/servicio-eureka-server-0.0.1-SNAPSHOT.jar servicio-eureka-server.jar
ENTRYPOINT ["java", "-jar", "/servicio-eureka-server.jar"]