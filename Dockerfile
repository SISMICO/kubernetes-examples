FROM gradle:7-jdk11 AS TEMP_BUILD
COPY --chown=gradle:gradle Kotlin /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11-jre-slim
EXPOSE 8080
RUN mkdir /app
COPY --from=TEMP_BUILD /home/gradle/src/build/libs/Kotlin-0.0.1-SNAPSHOT.jar /app/spring-boot-application.jar
ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]
