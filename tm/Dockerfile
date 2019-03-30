FROM java:8
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' > /etc/timezone
COPY ./txlcn-tm-5.0.2.RELEASE.jar /usr/local/application/tm.jar
COPY ./config/application.properties /usr/local/application/config/application.properties
EXPOSE 8070 8070
ENTRYPOINT ["java", "-jar", "/usr/local/application/tm.jar","--spring.config.location=/usr/local/application/config/application.properties"]
