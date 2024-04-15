package com.ahastudio.api.rest.demo.daos;

import com.ahastudio.api.rest.demo.dtos.PostDto;
import com.ahastudio.api.rest.demo.exceptions.PostNotFound;

import java.util.ArrayList;
import java.util.List;

public class PostListDAO implements PostDAO {

    private final List<PostDto> postDtos;

    public PostListDAO() {
        this.postDtos = new ArrayList(List.of(
                new PostDto("1", "제목", "테스트 입니다."),
                new PostDto("2", "2등", "2동 입니다.")
        ));

    }

    @Override
    public List<PostDto> findAll() {

        return new ArrayList<>(postDtos);
    }

    @Override
    public PostDto find(String id) {
        return postDtos.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow(PostNotFound::new);
    }

    @Override
    public void save(PostDto postDto) {
        postDtos.add(postDto);
    }

    @Override
    public void delete(String id) {
        PostDto postDto = find(id);
        postDtos.remove(postDto);
    }
}
