package com.busiwave.boot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class, webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
// springboot 1.5.1 version, WebIntegrationTest class was deprecated from 1.4 in favor of SpringBootTest
// @WebIntegrationTest
public class ShipwreckControllerWebIntegrationTest {

    @Test
    public void testListAll() throws IOException {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);

        assertThat( response.getStatusCode(), equalTo(HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.getBody());

        assertThat( responseJson.isMissingNode(), is(false));
        assertThat( responseJson.toString(), equalTo("[{\"id\":1,\"name\":\"test\",\"description\":\"test add\",\"condition\":\"good\",\"depth\":180000,\"latitude\":36.0,\"longitude\":180.0,\"yearDiscovered\":1981},{\"id\":2,\"name\":\"test2\",\"description\":\"test edit\",\"condition\":\"very good\",\"depth\":180000,\"latitude\":36.0,\"longitude\":180.0,\"yearDiscovered\":1800}]"));
        // line above will generate:

//        java.lang.AssertionError:
//        Expected: "[]"
//        but: was "[{\"id\":1,\"name\":\"test\",\"description\":\"test add\",\"condition\":\"good\",\"depth\":180000,\"latitude\":36.0,\"longitude\":180.0,\"yearDiscovered\":1981},{\"id\":2,\"name\":\"test2\",\"description\":\"test edit\",\"condition\":\"very good\",\"depth\":180000,\"latitude\":36.0,\"longitude\":180.0,\"yearDiscovered\":1800}]"
//        Expected :[]
//        Actual   :[{\"id\":1,\"name\":\"test\",\"description\":\"test add\",\"condition\":\"good\",\"depth\":180000,\"latitude\":36.0,\"longitude\":180.0,\"yearDiscovered\":1981},{\"id\":2,\"name\":\"test2\",\"description\":\"test edit\",\"condition\":\"very good\",\"depth\":180000,\"latitude\":36.0,\"longitude\":180.0,\"yearDiscovered\":1800}]
    }
}
