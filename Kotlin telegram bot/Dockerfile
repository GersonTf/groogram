FROM gradle:7.2.0-jdk11 AS build
COPY . /home/gradle
RUN gradle build -x check

FROM openjdk:11.0.12-jre-buster
WORKDIR /home/app
COPY --from=build /home/gradle/build/docker/layers/libs /home/app/libs
COPY --from=build /home/gradle/build/docker/layers/resources /home/app/resources
COPY --from=build /home/gradle/build/docker/layers/application.jar /home/app/application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/application.jar"]
