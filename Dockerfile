FROM openjdk:18
ADD /target/jwtapptest-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8075
ENTRYPOINT ["java", "-jar", "backend.jar"]