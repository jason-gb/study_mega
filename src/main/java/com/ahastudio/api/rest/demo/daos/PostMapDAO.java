package com.ahastudio.api.rest.demo.daos;

import com.ahastudio.api.rest.demo.dtos.PostDto;
import com.ahastudio.api.rest.demo.exceptions.PostNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostMapDAO implements PostDAO {
    private Map<String, PostDto> postDtos;

    public PostMapDAO() {
        this.postDtos = new HashMap<>();
        this.postDtos.put("1", new PostDto("1", "제목", "테스트 입니다."));
        this.postDtos.put("2", new PostDto("2", "2등", "2등이다!"));
    }

    @Override
    public List<PostDto> findAll() {
        //id순서대로 나오지 않음에 주의
        return new ArrayList<>(postDtos.values());
    }

    @Override
    public PostDto find(String id) {
        PostDto postDto = postDtos.get(id);
        if (postDto == null) {
            throw new PostNotFound();
        }
        return postDto;
    }

    @Override
    public void save(PostDto postDto) {
        postDtos.put(postDto.getId(), postDto);
    }

    @Override
    public void delete(String id) {
        postDtos.remove(id);
    }
}
