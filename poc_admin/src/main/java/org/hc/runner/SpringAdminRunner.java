package org.hc.runner;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.net.InetAddress;

@Slf4j
@Component
public class SpringAdminRunner implements ApplicationRunner, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (context instanceof ServletWebServerApplicationContext webServerAppContext && context.getBean(DataSource.class) instanceof HikariDataSource hikariDataSource) {
            log.info("admin path: http://{}:{}/applications", InetAddress.getLocalHost().getHostAddress(), webServerAppContext.getWebServer().getPort());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
