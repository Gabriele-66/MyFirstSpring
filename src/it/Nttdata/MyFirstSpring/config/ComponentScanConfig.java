package it.nttdata.myfirstspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("it.nttdata.myfirstspring")
@PropertySource("classpath:coach.properties")
public class ComponentScanConfig {}
