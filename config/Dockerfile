FROM java:8
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' > /etc/timezone
COPY target/config-1.0.0.jar /usr/local/application/config.jar
EXPOSE 9000 9000
LABEL version=0.0.1.release
ENTRYPOINT ["java", "-jar", "/usr/local/application/config.jar"]