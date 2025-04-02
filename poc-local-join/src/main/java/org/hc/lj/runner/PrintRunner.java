package org.hc.lj.runner;

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
import java.net.UnknownHostException;

@Slf4j
@Component
public class PrintRunner implements ApplicationRunner, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (context instanceof ServletWebServerApplicationContext webServerAppContext && context.getBean(DataSource.class) instanceof HikariDataSource hikariDataSource) {
            String hostAddress = getLocalHostAddress();
            log.info("admin path: http://{}:{}/applications", hostAddress, webServerAppContext.getWebServer().getPort());
            log.info("ko-time path: http://{}:{}/koTime", hostAddress, webServerAppContext.getWebServer().getPort());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    private String getLocalHostAddress() throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        if (!localhost.getHostAddress().equals("127.0.0.1")) {
            return localhost.getHostAddress();
        }
        // 获取所有网络接口的地址
        InetAddress[] allAddresses = InetAddress.getAllByName(localhost.getHostName());
        for (InetAddress address : allAddresses) {
            if (!address.isLoopbackAddress() && address instanceof java.net.Inet4Address) {
                return address.getHostAddress();
            }
        }
        // 如果没有找到合适的地址，返回本地地址
        return localhost.getHostAddress();
    }
}
