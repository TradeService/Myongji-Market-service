package com.example.myongjimarket.domain.Report.service;

import com.example.myongjimarket.domain.Report.ReportComment;
import com.example.myongjimarket.domain.Report.repository.ReportCommentRepository;
import com.example.myongjimarket.domain.UTPComment.UTPComment;
import com.example.myongjimarket.domain.UTPComment.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportCommentService {
    private final ReportCommentRepository reportCommentRepository;
    private final CommentRepository commentRepository;

    public ReportCommentService(ReportCommentRepository reportCommentRepository, CommentRepository commentRepository) {
        this.reportCommentRepository = reportCommentRepository;
        this.commentRepository = commentRepository;
    }
    public Long reportComment(Long commentId) {
        UTPComment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다: " + commentId));

        Optional<ReportComment> existingReport = reportCommentRepository.findByReportedComment(comment);
        if (existingReport.isPresent()) {
            ReportComment report = existingReport.get();
            report.setReportCount(report.getReportCount() + 1);
            reportCommentRepository.save(report);
        } else {
            ReportComment newReport = new ReportComment();
            newReport.setReportedComment(comment);
            newReport.setReportCount(1);
            newReport.setType("U");
            reportCommentRepository.save(newReport);
        }
        return comment.getPost().getId();
    }

}
