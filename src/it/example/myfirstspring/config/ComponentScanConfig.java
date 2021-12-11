package it.example.myfirstspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("it.example.myfirstspring")
@PropertySource("classpath:coach.properties")
public class ComponentScanConfig {}
