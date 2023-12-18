package com.example.myongjimarket.domain.TalentDonationPost.service;

import com.example.myongjimarket.domain.TalentDonationPost.TalentDonationPost;
import com.example.myongjimarket.domain.TalentDonationPost.dto.TalentDonationPostDto;
import com.example.myongjimarket.domain.TalentDonationPost.repository.TalentDonationPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TalentDonationPostService {
    @Autowired
    TalentDonationPostRepository talentDonationPostRepository;

    @Autowired
    TalentDonationPostDto talentDonationPostDto;

    public TalentDonationPostDto getPostById(Long id) {
        return new TalentDonationPostDto (talentDonationPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no id")));    }

    public List<TalentDonationPostDto> getAllPosts() {
        List<TalentDonationPost> posts = talentDonationPostRepository.findAll();
        return talentDonationPostDto.convertToDtoList(posts);
    }

    public TalentDonationPostDto saveNewPost(TalentDonationPostDto newPostDto) {
        TalentDonationPost newPost = talentDonationPostDto.convertToEntity(newPostDto);
        TalentDonationPost savedPost = talentDonationPostRepository.save(newPost);
        return talentDonationPostDto.convertToDto(savedPost);
    }

    public void updatePost(TalentDonationPostDto updatedPostDto) {
        Optional<TalentDonationPost> talentDonationPostDto1=talentDonationPostRepository.findById(updatedPostDto.getId());
        TalentDonationPost newpost = talentDonationPostDto1.get();
        newpost.setTitle(updatedPostDto.getTitle());
        newpost.setContent(updatedPostDto.getContent());
        newpost.setTopic(updatedPostDto.getTopic());
        newpost.setPicture(updatedPostDto.getPicture());
        newpost.setPlace(updatedPostDto.getPlace());
        newpost.setUpdated_at(LocalDateTime.now());
        newpost.setPerson(updatedPostDto.getPerson());
        newpost.setPlan(updatedPostDto.getPlan());
        talentDonationPostRepository.save(newpost);
    }

    public void deletePost(Long postId) {
        talentDonationPostRepository.deleteById(postId);
    }
}
