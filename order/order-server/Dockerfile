FROM java:8
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' > /etc/timezone
COPY target/order-server-0.0.1-SNAPSHOT.jar /usr/local/application/order.jar
EXPOSE 9001 9001
LABEL version=0.0.1.release
ENTRYPOINT ["java", "-jar", "/usr/local/application/order.jar"]