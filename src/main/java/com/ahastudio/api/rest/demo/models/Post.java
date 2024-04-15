package com.ahastudio.api.rest.demo.models;

public class Post {
    private PostId id;

    private String title;

    private MultilineText content;

    public Post(PostId id, String title, MultilineText content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Post(String title, MultilineText content) {
        this.id = PostId.generate();
        this.title = title;
        this.content = content;
    }

    public PostId id() {
        return id;
    }

    public String title() {
        return title;
    }

    public MultilineText content() {
        return content;
    }

    public void update(String title, MultilineText content) {
        //title에 대한 유효성 검사
        //권한검사 내가 처리할 수 있는지 등등 검사를 여기서 함
        this.title = title;
        this.content = content;
    }
    //getter는 절대 비즈니스 로직을 위해 쓰지 않는다.
    //최대한 getter없이 분산시켜서 한다.
}
