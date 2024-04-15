package com.ahastudio.api.rest.demo.daos;

import com.ahastudio.api.rest.demo.dtos.PostDto;

import java.util.List;

public interface PostDAO {

    List<PostDto> findAll();

    PostDto find(String id);

    void save(PostDto postDto);

    void delete(String id);

}