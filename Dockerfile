FROM openjdk:11
EXPOSE 8081
ADD build/libs/JCLO-1-1.1-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java", "-jar", "/myapp.jar"]