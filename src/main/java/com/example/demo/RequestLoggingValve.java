package com.example.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

import javax.servlet.ServletException;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestLoggingValve extends ValveBase {
  private static final Logger logger = LoggerFactory.getLogger(RequestLoggingValve.class);

  @Override
  public void invoke(Request request, Response response) throws IOException, ServletException {
    try {
      logger.info("Request method: {}", request.getMethod());
      logger.info("Request URI: {}", request.getRequestURI());

      Enumeration<String> headerNames = request.getHeaderNames();
      while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        logger.info("Header: {} = {}", headerName, request.getHeader(headerName));
      }

      byte[] requestBody = request.getInputStream().readAllBytes();
      logger.info("Request body: {}", new String(requestBody, StandardCharsets.UTF_8));
    } catch (Exception e) {
      logger.error("Error logging request", e);
    }

    getNext().invoke(request, response);
  }

}
