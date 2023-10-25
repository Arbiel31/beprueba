FROM eclipse-temurin:17.0.8.1_1-jre-jammy
VOLUME /tmp
COPY build/libs/*.jar prueba.jar
ENTRYPOINT ["java","-jar","/prueba.jar"]