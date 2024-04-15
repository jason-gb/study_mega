package com.ahastudio.api.rest.demo.application;

import com.ahastudio.api.rest.demo.dtos.PostDto;
import com.ahastudio.api.rest.demo.models.Post;
import com.ahastudio.api.rest.demo.models.PostId;
import com.ahastudio.api.rest.demo.repositories.PostRepository;
import org.springframework.stereotype.Service;


@Service
public class DeletePostService {

    //private final PostDAO postDAO;
    private final PostRepository postRepository;

    public DeletePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto deletePost(String id) {
        /*PostDto postDto = postDAO.find(id);

        postDAO.delete(id);*/

        Post post = postRepository.find(PostId.of(id));

        postRepository.delete(id);

        return new PostDto(post);
    }

}
