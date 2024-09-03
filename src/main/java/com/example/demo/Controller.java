package com.example.demo;

import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @PostMapping("/acceptbody")
  public ResponseEntity<String> acceptBody(@RequestHeader HttpHeaders requestHeaders, @RequestBody String body) {
    // Log all headers
    System.out.println("Request Headers:");
    for (Map.Entry<String, String> entry : requestHeaders.toSingleValueMap().entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    // Log the body
    System.out.println("Body: " + body);

    // Include request headers in the response body
    StringBuilder responseBody = new StringBuilder("Headers and body received\n\nRequest Headers:\n");
    for (Map.Entry<String, String> entry : requestHeaders.toSingleValueMap().entrySet()) {
      responseBody.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
    }
    responseBody.append("\nBody:\n").append(body);

    // Respond with the headers and body
    return new ResponseEntity<>(responseBody.toString(), HttpStatus.OK);
  }


}
