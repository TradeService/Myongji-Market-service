package com.example.myongjimarket.domain.TalentDonationPost.service;

import com.example.myongjimarket.domain.TalentDonationPost.TalentDonationPost;
import com.example.myongjimarket.domain.TalentDonationPost.dto.TalentDonationPostDto;
import com.example.myongjimarket.domain.TalentDonationPost.repository.TalentDonationPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalentDonationPostService {

    @Autowired
    TalentDonationPostRepository talentDonationPostRepository;

    @Autowired
    TalentDonationPostDto talentDonationPostDto;

    public Optional<TalentDonationPostDto> getPostById(Long id) {
        return talentDonationPostRepository.findById(id).map(talentDonationPostDto::convertToDto);
    }

    public List<TalentDonationPostDto> getAllPosts() {
        List<TalentDonationPost> allPosts = talentDonationPostRepository.findAll();
        return talentDonationPostDto.convertToDtoList(allPosts);
    }

    public TalentDonationPostDto addNewPost(TalentDonationPostDto newPostDto) {
        TalentDonationPost newPost = talentDonationPostDto.convertToEntity(newPostDto);
        TalentDonationPost savedPost = talentDonationPostRepository.save(newPost);
        return talentDonationPostDto.convertToDto(savedPost);
    }

    public void updatePost(Long id, TalentDonationPostDto updatedPostDto) {
        talentDonationPostRepository.findById(id).ifPresent(post -> {
            post.setTitle(updatedPostDto.getTitle());
            post.setContent(updatedPostDto.getContent());
            post.setTopic(updatedPostDto.getTopic());
            post.setPicture(updatedPostDto.getPicture());
            post.setPlace(updatedPostDto.getPlace());
            post.setCreated_at(updatedPostDto.getCreated_at());
            post.setUpdated_at(updatedPostDto.getUpdated_at());
            post.setPerson(updatedPostDto.getPerson());
            post.setPlan(updatedPostDto.getPlan());

            talentDonationPostRepository.save(post);
        });
    }

    public void deletePost(Long postId) {
        talentDonationPostRepository.deleteById(postId);
    }
}
