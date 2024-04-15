package com.ahastudio.api.rest.demo.controllers;

import com.ahastudio.api.rest.demo.application.CreatePostService;
import com.ahastudio.api.rest.demo.application.DeletePostService;
import com.ahastudio.api.rest.demo.application.GetPostService;
import com.ahastudio.api.rest.demo.application.GetPostsService;
import com.ahastudio.api.rest.demo.application.UpdatePostService;
import com.ahastudio.api.rest.demo.dtos.PostDto;
import com.ahastudio.api.rest.demo.exceptions.PostNotFound;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
@RequestMapping("/posts")
public class PostController {
    private final GetPostsService getPostsService;
    private final GetPostService getPostService;
    private final CreatePostService createPostService;
    private final UpdatePostService updatePostService;
    private final DeletePostService deletePostService;

    public PostController(GetPostsService getPostsService,
                          GetPostService getPostService,
                          CreatePostService createPostService,
                          UpdatePostService updatePostService,
                          DeletePostService deletePostService) {
        this.getPostsService = getPostsService;
        this.getPostService = getPostService;
        this.createPostService = createPostService;
        this.updatePostService = updatePostService;
        this.deletePostService = deletePostService;
    }

    @GetMapping
    public List<PostDto> list() {
        List<PostDto> postDtos = getPostsService.getPostDtos();
        return postDtos;
    }


    @GetMapping("/{id}")
    public PostDto detail(@PathVariable String id) throws JsonProcessingException {
        PostDto postDto = getPostService.getPostDto(id);

        return postDto;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(@RequestBody PostDto postDto) {
        //post추가 -> 기능
        PostDto created = createPostService.createPost(postDto);

        return created;
    }

    @PatchMapping("/{id}")
    public PostDto update(@PathVariable String id, @RequestBody PostDto postDto) {
        PostDto updated = updatePostService.updatePost(id, postDto);

        return updated;
    }

    @DeleteMapping("/{id}")
    public PostDto delete(@PathVariable String id) {
        PostDto deleted = deletePostService.deletePost(id);

        return deleted;
    }

    @ExceptionHandler(PostNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //http status를 not found처리를 해주는 것 이거 안하면 다 똑같음
    public String postNotFound() {
        return "게시물을 찾을 수 없습니다! ";
    }

}
