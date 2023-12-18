package com.example.myongjimarket.domain.Post.controller;
import com.example.myongjimarket.domain.Post.Post;
import com.example.myongjimarket.domain.Post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String listPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts/index";
    }

    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/new";
    }

    @PostMapping
    public String savePost(@RequestParam("title") String title,
                           @RequestParam("content") String content,
                           @RequestParam(value = "image", required = false) MultipartFile imageFile) throws IOException {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

        if (imageFile != null && !imageFile.isEmpty()) {
            post.setImage(imageFile.getBytes());
        }

        postService.savePost(post);
        return "redirect:/posts";
    }


    @GetMapping("/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            if (post.getImage() != null) {
                String base64Image = Base64.getEncoder().encodeToString(post.getImage());
                model.addAttribute("image", base64Image);
            }
        }
        return "posts/edit";
    }


    @PostMapping("/{id}")
    public String updatePost(@PathVariable Long id,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @RequestParam(value = "image", required = false) MultipartFile imageFile) throws IOException {
        Post post = postService.getPostById(id);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);

            if (imageFile != null && !imageFile.isEmpty()) {
                post.setImage(imageFile.getBytes());
            }
            postService.savePost(post);
        }
        return "redirect:/posts";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}

