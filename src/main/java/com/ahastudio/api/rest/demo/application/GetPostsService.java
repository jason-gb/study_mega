package com.ahastudio.api.rest.demo.application;

import com.ahastudio.api.rest.demo.dtos.PostDto;
import com.ahastudio.api.rest.demo.models.Post;
import com.ahastudio.api.rest.demo.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPostsService {


    private final PostRepository postRepository;

    public GetPostsService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDto> getPostDtos() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(post -> new PostDto(post)).toList();
    }


}
