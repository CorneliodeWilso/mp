FROM payara/micro

COPY ./jars/postgresql-42.2.6.jar /opt/payara/database-connector.jar

COPY ./target/mp-core.war $DEPLOY_DIR

ENTRYPOINT ["--addLibs","/opt/payara/config/postgresql-42.2.6.jar"]
ENTRYPOINT [  "java", "-jar", "/opt/payara/payara-micro.jar","--nocluster","--logo", "--deploy","/opt/payara/deployments/mp-core.war"]

EXPOSE 8080