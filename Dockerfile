FROM openjdk:17
MAINTAINER volodymyr.tymchuk

COPY ["target/library-spring.jar", "library-spring.jar"]
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "library-spring.jar"]