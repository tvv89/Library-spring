FROM openjdk:17
MAINTAINER volodymyr.tymchuk
COPY target/Library-0.0.1-SNAPSHOT.jar library-spring.jar
ENTRYPOINT ["java","-jar","/library-spring.jar"]