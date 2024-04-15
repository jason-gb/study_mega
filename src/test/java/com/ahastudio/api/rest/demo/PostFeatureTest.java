package com.ahastudio.api.rest.demo;

import com.ahastudio.api.rest.demo.dtos.PostDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PostFeatureTest {
    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("게시물 추가하고 목록 확인")
    public void List() {
        String url = "http://localhost:" + port + "/posts";

        // restTemplate.postForLocation(url, new PostDto("ID", "NEW POST", "제"));
        restTemplate.postForLocation(url, new PostDto("id", "새 글", "제곧내"));

        String body = restTemplate.getForObject(url, String.class);

        assertThat(body).contains("새 글");
        assertThat(body).contains("제곧내");

        String id = findLastId(body);

        restTemplate.delete(url + "/" + id);

        body = this.restTemplate.getForObject(url, String.class);

        assertThat(body).doesNotContain(id);
        assertThat(body).doesNotContain("새 글");
        assertThat(body).doesNotContain("제곧내");
//        assertThat(body).contains("새 글");
//        assertThat(body).contains("제곧내");


//        Pattern pattern = Pattern.compile("\"id\":\"([^\"]+)\"");
//        Matcher matcher = pattern.matcher(body);
//        assertThat(matcher.find()).isTrue();
//        assertThat(matcher.find()).isTrue();
//        assertThat(matcher.find()).isTrue();
//        assertThat(matcher.group(1)).isEqualTo("xxx"); //group괄호 안에 0을 넣으면 전체 1을 넣으면 comlile안의 () 안에 내용

    }

    private String findLastId(String body) {
        Pattern pattern = Pattern.compile("\"id\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(body);

        String id = "";
        while (matcher.find()) {
            id = matcher.group(1);
        }
        return id;
    }
}
