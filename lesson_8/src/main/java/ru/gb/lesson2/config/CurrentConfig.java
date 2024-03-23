package ru.gb.lesson2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.lesson2.aspects.LoggerAspect;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class CurrentConfig {
    @Bean
    public LoggerAspect loggingAspect() {
        return new LoggerAspect();
    }
}