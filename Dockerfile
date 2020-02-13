FROM openjdk:8
ADD build/libs/demo-0.0.1-ERT.jar demo-0.0.1-ERT.jar
ADD src/main/resources/application.yml application.yml
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "demo-0.0.1-ERT.jar"]