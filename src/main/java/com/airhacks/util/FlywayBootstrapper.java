package com.airhacks.util;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.sql.DataSource;

@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class FlywayBootstrapper {

    @Inject
    Logger logger;

    @Resource(lookup = "java:global/mp_core")
    private DataSource dataSource;

    @PostConstruct
    public void startup() {

        logger.info("Migrating database");

        Flyway flyway = new Flyway();


        flyway.setDataSource(dataSource);
        flyway.setLocations("db/sqlserver");
        flyway.setTable("schema_version_mp");

        MigrationInfo migrationInfo = flyway.info().current();

        if (migrationInfo == null) {
            logger.info("No existing database at the actual datasource");
        } else {
            logger.info("Found a database with the version: " + migrationInfo.getVersion() + "-" + migrationInfo.getDescription());
        }


        flyway.migrate();
        logger.info("Successfully migrated to database version: {}", flyway.info().current().getVersion());
    }

}
