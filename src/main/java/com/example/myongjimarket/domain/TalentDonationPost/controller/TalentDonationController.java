package com.example.myongjimarket.domain.TalentDonationPost.controller;

import com.example.myongjimarket.domain.TalentDonationPost.dto.TalentDonationPostDto;
import com.example.myongjimarket.domain.TalentDonationPost.service.TalentDonationPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/talent")
public class TalentDonationController {
    @Autowired
    TalentDonationPostService talentDonationPostService;

    @GetMapping("/{id}")
    public Optional<TalentDonationPostDto> getPostById(@PathVariable Long id) {
        return talentDonationPostService.getPostById(id);
    }

    @GetMapping("")
    public List<TalentDonationPostDto> getAllPosts() {
        return talentDonationPostService.getAllPosts();
    }

    @PostMapping("")
    public TalentDonationPostDto addNewPost(@RequestBody TalentDonationPostDto newPost) {
        return talentDonationPostService.addNewPost(newPost);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody TalentDonationPostDto updatedPost) {
        talentDonationPostService.updatePost(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        talentDonationPostService.deletePost(id);
    }
}
