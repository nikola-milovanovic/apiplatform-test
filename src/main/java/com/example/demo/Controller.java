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
  public ResponseEntity<String> acceptBody(@RequestHeader HttpHeaders headers, @RequestBody String body) {
    // Log all headers
    System.out.println("Headers:");
    for (Map.Entry<String, String> entry : headers.toSingleValueMap().entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    // Log the body
    System.out.println("Body: " + body);

    // Respond with a confirmation message
    return new ResponseEntity<>("Headers and body received", HttpStatus.OK);
  }


}
