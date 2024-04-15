package com.ahastudio.api.rest.demo.repositories;

import com.ahastudio.api.rest.demo.models.MultilineText;
import com.ahastudio.api.rest.demo.models.Post;
import com.ahastudio.api.rest.demo.models.PostId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository {
    private final Map<PostId, Post> posts;

    public PostRepository() {
        this.posts = new HashMap<PostId, Post>();

        this.posts.put(PostId.of("1"),
                new Post(PostId.of("1"), "제목", MultilineText.of("테스트 입니다.")));
        this.posts.put(PostId.of("2"),
                new Post(PostId.of("2"), "2등", MultilineText.of("2등이다!")));
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    public Post find(PostId id) {
        return posts.get(id);
    }

    public void save(Post post) {
        posts.put(post.id(), post);
    }

    public void delete(String id) {
        posts.remove(id);
    }
}
