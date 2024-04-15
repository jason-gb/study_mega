package com.ahastudio.api.rest.demo.application;

import com.ahastudio.api.rest.demo.dtos.PostDto;
import com.ahastudio.api.rest.demo.models.Post;
import com.ahastudio.api.rest.demo.models.PostId;
import com.ahastudio.api.rest.demo.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPostService {


    private final PostRepository postRepository;

    public GetPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto getPostDto(String id) {
        // return postDAO.find(id);
        Post post = postRepository.find(PostId.of(id));

        return new PostDto(post);
    }


}
