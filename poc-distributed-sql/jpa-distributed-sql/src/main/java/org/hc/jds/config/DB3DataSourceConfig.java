package org.hc.jds.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.hc.jds.repository.db3",
        entityManagerFactoryRef = "db3EntityManagerFactory",
        transactionManagerRef = "db3TransactionManager"
)
public class DB3DataSourceConfig {

    @Bean(name = "db3DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db3")
    public DataSource db3DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db3EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean db3EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("db3DataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("org.hc.jds.entity.db3")
                .persistenceUnit("db3")
                .build();
    }

    @Bean(name = "db3TransactionManager")
    public PlatformTransactionManager db3TransactionManager(
            @Qualifier("db3EntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
}
