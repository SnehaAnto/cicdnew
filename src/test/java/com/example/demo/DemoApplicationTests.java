package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    private DoubleNumController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
    @Test
    void doubleShouldReturnDefaultValue() {

        int result = this.restTemplate.getForObject("http://localhost:" + port + "/double?value=" + 5, Integer.class);
        assertThat(result).isEqualTo(10);
    }

}

