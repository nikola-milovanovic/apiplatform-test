package com.example.demo;

import org.apache.catalina.valves.ValveBase;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

  @Bean
  public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
    return new TomcatServletWebServerFactory() {
      @Override
      protected void postProcessContext(org.apache.catalina.Context context) {
        ValveBase valve = new RequestLoggingValve();
        context.getPipeline().addValve(valve);
      }
    };
  }

}
