FROM openjdk:8-jre-alpine
ADD build/libs/news.jar news.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "news.jar"]