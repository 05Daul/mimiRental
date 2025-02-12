# Build Stage
FROM gradle:8.11.1-jdk17 AS build

# 작업 디렉토리 생성
WORKDIR /myapp

# 프로젝트 전체 파일을 복사
COPY . /myapp

# Gradle 실행 권한 추가
RUN chmod +x /myapp/gradlew

# Gradle 빌드 실행 (테스트 제외)
RUN /myapp/gradlew clean build --no-daemon -x test

# Run Stage
FROM openjdk:17-alpine

# 작업 디렉토리 생성
WORKDIR /myapp

# 빌드된 JAR 파일 복사
COPY --from=build /myapp/build/libs/*SNAPSHOT.jar /myapp/mimiRental.jar

# 애플리케이션 실행 포트
EXPOSE 5678

# 애플리케이션 실행 명령어
ENTRYPOINT ["java", "-jar", "/myapp/mimiRental.jar"]
