FROM amazoncorretto:17
ARG JAR_FILE=build/libs/*.jar
COPY build/libs/mobile-0.0.1.jar mobile.jar
ENTRYPOINT ["java", "-jar", "/mobile.jar"]