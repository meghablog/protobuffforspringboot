package com.application.database.application;

import com.application.database.application.dto.EmployeeProto;
import com.google.protobuf.util.JsonFormat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)

public class Prototest {
    @Autowired
    TestRestTemplate restTemplate;


    public static final String URL = "/api";


    @Test
    public void getStudentById() throws Exception {
        var response = this.restTemplate.getForObject(URL + "/employees/{id}", EmployeeProto.EmployeeMsg.class ,101);
        String jsonResponse = JsonFormat.printer().print(response);
        verifyResponse(jsonResponse);
    }

    private void verifyResponse(String jsonResponse) {
        System.out.println("jsonResponse = " + jsonResponse);
    }


}
