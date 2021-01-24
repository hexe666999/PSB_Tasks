package com.company.PSB_task_3;


import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WebController {

    @PostMapping(value = "/request", produces = "application/json")

    public String webService (HttpServletRequest request) throws IOException, InterruptedException {
        Scanner s = new Scanner(request.getInputStream()).useDelimiter("\\A");
        String requestBody = s.hasNext() ? s.next() : "";

        return RequestProcessor.responseBuilder(requestBody);

    }
}


