FROM java:8-jre

ADD ./build/libs/stackexchange-0.0.1.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/stackexchange-0.0.1.jar"]

EXPOSE 8080