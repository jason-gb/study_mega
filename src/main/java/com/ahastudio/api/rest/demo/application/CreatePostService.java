package com.ahastudio.api.rest.demo.application;

import com.ahastudio.api.rest.demo.dtos.PostDto;
import com.ahastudio.api.rest.demo.models.MultilineText;
import com.ahastudio.api.rest.demo.models.Post;
import com.ahastudio.api.rest.demo.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatePostService {


    private final PostRepository postRepository;

    public CreatePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto createPost(PostDto postDto) {
        // TODO : 원본 내용을 고치지 말 것

        /*String id = TsidCreator.getTsid().toString();

        PostDto newPostDto = new PostDto();
        postDto.setId(id);
        postDto.setTitle(postDto.getTitle());
        postDto.setContent(postDto.getContent());

        postDAO.save(newPostDto);*/

        Post post = new Post(
                postDto.getTitle(),
                MultilineText.of(postDto.getContent()));

        postRepository.save(post);

        return new PostDto(post);
    }


}
