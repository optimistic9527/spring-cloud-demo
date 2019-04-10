FROM java:8
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' > /etc/timezone
COPY target/gateway-0.0.1-SNAPSHOT.jar /usr/local/application/gateway.jar
EXPOSE 9090 9090
LABEL version=0.0.1.release
ENTRYPOINT ["java", "-jar", "/usr/local/application/gateway.jar"]