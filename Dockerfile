FROM openjdk:17-jdk-slim

# JAR 파일 복사
COPY target/jeckjeck-0.0.1-SNAPSHOT.jar app.jar

# JSP 파일 경로 복사
COPY src/main/webapp/ /src/main/webapp/

# 포트 설정
EXPOSE 9909
# 실행 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]