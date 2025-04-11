package org.hc.jds.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.hc.jds.repository.db4",
        entityManagerFactoryRef = "db4EntityManagerFactory",
        transactionManagerRef = "db4TransactionManager"
)
public class DB4DataSourceConfig {
    @Bean(name = "db4DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db4")
    public DataSource db4DataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "db4EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean db4EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("db4DataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("org.hc.jds.entity.db4")
                .persistenceUnit("db4")
                .build();
    }

    @Bean(name = "db4TransactionManager")
    public PlatformTransactionManager db4TransactionManager(
            @Qualifier("db4EntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
}
