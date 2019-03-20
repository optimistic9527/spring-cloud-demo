FROM java:8
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' > /etc/timezone
COPY target/register-0.0.1-SNAPSHOT.jar /usr/local/application/register.jar
EXPOSE 8761 8761
LABEL version=0.0.1.release
ENTRYPOINT ["java", "-jar", "/usr/local/application/register.jar"]