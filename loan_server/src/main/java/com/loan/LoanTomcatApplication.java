package com.loan;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;

/**
 * @author GuoKang
 * @date 2019-04-17 21:17
 */
@SpringBootApplication(scanBasePackages = "com.loan")
@MapperScan({"com.loan.**.dao"})
@EnableCaching
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class LoanTomcatApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LoanTomcatApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(LoanTomcatApplication.class, args);
    }
}
