package com.example.myongjimarket.domain.TalentDonationPost.controller;

import com.example.myongjimarket.domain.TalentDonationPost.dto.TalentDonationPostDto;
import com.example.myongjimarket.domain.TalentDonationPost.service.TalentDonationPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/talent-transaction")
public class TalentDonationController {
    @Autowired
    TalentDonationPostService talentDonationPostService;

    @GetMapping("/post")
    public String getPostById(@RequestParam("id") Long id, Model model) {
        TalentDonationPostDto post = talentDonationPostService.getPostById(id);
        model.addAttribute("post", post);
        return "talentDonationPosts/show";
    }

    @GetMapping("")
    public String getAllPosts(Model model) {
        List<TalentDonationPostDto> posts = talentDonationPostService.getAllPosts();
        model.addAttribute("posts", posts);
        return "talentDonationPosts/main";
    }

    @GetMapping("/new")
    public String showNewPost(Model model) {
        model.addAttribute("newPost", new TalentDonationPostDto());
        return "talentDonationPosts/new";
    }

    @PostMapping("/save")
    public String saveNewPost(@ModelAttribute TalentDonationPostDto newPost) {
        newPost.setCreated_at(LocalDateTime.now());

        TalentDonationPostDto savedPost = talentDonationPostService.saveNewPost(newPost);
        Long postId = savedPost.getId();
        return "redirect:/talent-transaction";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        TalentDonationPostDto talentDonationPostDto = talentDonationPostService.getPostById(id);
        model.addAttribute("post", talentDonationPostDto);
        return "talentDonationPosts/update";
    }

    @PostMapping("/edit")
    public String editPost(@ModelAttribute TalentDonationPostDto talentDonationPostDto) {
        talentDonationPostService.updatePost(talentDonationPostDto);
        return "redirect:/talent-transaction";
    }

    @GetMapping("/delete")
    public String deletePost(@RequestParam("id") Long id) {
        talentDonationPostService.deletePost(id);
        return "redirect:/talent-transaction";
    }
}
