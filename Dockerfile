FROM payara/micro

COPY ./jars/mssql-jdbc-8.4.1.jre11.jar /opt/payara/database-connector.jar

COPY ./target/mp-core.war $DEPLOY_DIR

ENTRYPOINT ["--addLibs","/opt/payara/config/mssql-jdbc-8.4.1.jre11.jar"]
ENTRYPOINT [  "java", "-jar", "/opt/payara/payara-micro.jar","--nocluster","--logo", "--deploy","/opt/payara/deployments/mp-core.war"]

EXPOSE 8080