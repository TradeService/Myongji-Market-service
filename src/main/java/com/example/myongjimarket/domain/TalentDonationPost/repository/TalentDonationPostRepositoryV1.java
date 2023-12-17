//package com.example.myongjimarket.domain.TalentDonationPost.repository;
//
//import com.example.myongjimarket.domain.TalentDonationPost.dto.TalentDonationPostDto;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class TalentDonationPostRepositoryV1 {
//    static public ArrayList<TalentDonationPostDto> talents;
//
//    static {
//        talents = new ArrayList<>();
//        talents.add(new TalentDonationPostDto("1", "test1", "Hello test1!!!"));
//        talents.add(new TalentDonationPostDto("2", "test2", "Hello test2!!!"));
//        talents.add(new TalentDonationPostDto("3", "test3", "Hello test3!!!"));
//    }
//
//    public TalentDonationPostDto insertTalent(TalentDonationPostDto talent) {
//        talents.add(talent);
//        return talent;
//    }
//
//    public List<TalentDonationPostDto> getAllTalent() {
//        return talents;
//    }
//
//    public TalentDonationPostDto getTalentById(String id) {
//        return talents.stream()
//                .filter(TalentDonationPostDto -> TalentDonationPostDto.getId().equals(id))
//                .findAny()
//                .orElse(new TalentDonationPostDto("", "", ""));
//    }
//
//    public void updateTalentTitle(String id, TalentDonationPostDto talent) {
//         talents.stream()
//                .filter(TalentDonationPostDto -> TalentDonationPostDto.getId().equals(id))
//                .findAny()
//                .orElse(new TalentDonationPostDto("", "", ""))
//                .setTitle(talent.getTitle());
//    }
//
//    public void deleteTalent(String id) {
//        talents.removeIf(TalentDonationPostDto -> TalentDonationPostDto.getId().equals(id));
//    }
//}
