package org.hc.ssjds.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Slf4j
@Component
public class H2DataSourceRunner implements ApplicationRunner, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (context instanceof ServletWebServerApplicationContext webServerAppContext) {
            log.info("h2 path: http://{}:{}/h2-console",  InetAddress.getLocalHost().getHostAddress(), webServerAppContext.getWebServer().getPort());
            log.info("JDBC URL: jdbc:h2:mem:config;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;MODE=MYSQL");
            log.info("username：sa");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
