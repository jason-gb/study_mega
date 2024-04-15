package com.ahastudio.api.rest.demo;

public class nomal {
    @Test
    public void post() {
        String url = "http://localhost:" + port + "/posts";

        PostDto postDto = new PostDto("ID", "새 글", "제곧내");

        restTemplate.postForLocation(url, postDto);

        String body = restTemplate.getForObject(url, String.class);

        assertThat(body).contains("새 글");
        assertThat(body).contains("제곧내");

        String id = findLastId(body);

        restTemplate.delete(url + "/" + id);

        body = this.restTemplate.getForObject(url, String.class);

        assertThat(body).doesNotContain("새 글");
    }
}