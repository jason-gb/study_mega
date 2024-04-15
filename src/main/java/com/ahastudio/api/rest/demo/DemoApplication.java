package com.ahastudio.api.rest.demo;

import com.ahastudio.api.rest.demo.application.DeletePostService;
import com.ahastudio.api.rest.demo.application.PostService;
import com.ahastudio.api.rest.demo.controllers.PostController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DemoApplication.class);
        PostService postService = context.getBean("postService", PostService.class);
        DeletePostService deletePostService = context.getBean("deletePostService", DeletePostService.class);
        PostController postController = context.getBean("postController", PostController.class);

        System.out.println("-".repeat(100));
        System.out.println(postService);
        System.out.println(deletePostService);
        System.out.println(postController);

        //SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public PostRepository postRepository() {
//        System.out.println("*".repeat(100));
//        System.out.println("Create PostRepository");
//        System.out.println("*".repeat(100));
//
//        return new PostRepository();
//    }
//
//    @Bean
//    public PostService postService() {
//        return new PostService(postRepository());
//    }
//
//    @Bean
//    public GetPostDtoListService getPostDtoListService() {
//        return new GetPostDtoListService(postRepository());
//    }
//
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry
//                        .addMapping("/**")
//                        .allowedMethods("GET", "POST", "PATCH", "DELETE", "OPTIONS")
//                        .allowedOrigins("https://seed2whale.github.io");
//
//            }
//        };
//    }

}
