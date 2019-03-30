FROM java:8
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' > /etc/timezone
COPY target/user-server-0.0.1-SNAPSHOT.jar /usr/local/application/user.jar
EXPOSE 9003 9003
LABEL version=0.0.1.release
ENTRYPOINT ["java", "-jar", "/usr/local/application/user.jar"]