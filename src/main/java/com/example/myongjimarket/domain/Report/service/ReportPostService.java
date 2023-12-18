package com.example.myongjimarket.domain.Report.service;

import com.example.myongjimarket.domain.Report.ReportPost;
import com.example.myongjimarket.domain.Report.repository.ReportPostRepository;
import com.example.myongjimarket.domain.UsedTransactionPost.UsedTransactionPost;
import com.example.myongjimarket.domain.UsedTransactionPost.repository.UTPRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportPostService {
    private final ReportPostRepository reportPostRepository;
    private final UTPRepository utpRepository;
    public ReportPostService(ReportPostRepository reportPostRepository, UTPRepository utpRepository){
        this.reportPostRepository = reportPostRepository;
        this.utpRepository = utpRepository;
    }

    public void reportPost(Long postId) {
        UsedTransactionPost post = utpRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다: " + postId));

        Optional<ReportPost> existingReport = reportPostRepository.findByReportedPostId(post.getId());
        if(existingReport.isPresent()) {
            ReportPost report = existingReport.get();
            report.setReportCount(report.getReportCount() + 1);
            reportPostRepository.save(report);
        } else {
            ReportPost report = new ReportPost();
            report.setReportedPost(post);
            report.setReportedUser(post.getUser());
            report.setReportCount(1);
            report.setType("U");
            reportPostRepository.save(report);
        }
    }
}