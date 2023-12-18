package com.example.myongjimarket.domain.Manager.service;
import com.example.myongjimarket.domain.Manager.dto.request.CommentReportDTO;
import com.example.myongjimarket.domain.Manager.dto.request.PostReportDTO;
import com.example.myongjimarket.domain.Manager.dto.request.UserReportDTO;
import com.example.myongjimarket.domain.Report.repository.ReportCommentRepository;
import com.example.myongjimarket.domain.Report.repository.ReportPostRepository;
import com.example.myongjimarket.domain.UTPComment.UTPComment;
import com.example.myongjimarket.domain.UTPComment.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ManagerService {
    private final ReportPostRepository reportPostRepository;
    private final ReportCommentRepository reportCommentRepository;
    private final CommentRepository commentRepository;

    public ManagerService(ReportPostRepository reportPostRepository, ReportCommentRepository reportCommentRepository, CommentRepository commentRepository) {
        this.reportPostRepository = reportPostRepository;
        this.reportCommentRepository = reportCommentRepository;
        this.commentRepository = commentRepository;
    }

    public List<PostReportDTO> getReportedPosts() {
        return reportPostRepository.findAll().stream()
                .map(reportPost -> new PostReportDTO(
                        reportPost.getReportedPost().getId(),
                        reportPost.getReportedPost().getTitle(),
                        reportPost.getReportedPost().getCreatedAt().toInstant(), // Timestamp를 Instant로 변환
                        reportPost.getReportCount()
                ))
                .collect(Collectors.toList());
    }
    public List<CommentReportDTO> getReportedComments() {
        return reportCommentRepository.findAll().stream()
                .map(reportComment -> new CommentReportDTO(
                        reportComment.getReportedComment().getCommentID(),
                        reportComment.getReportedComment().getContent(),
                        reportComment.getReportedComment().getWritedDate(),
                        reportComment.getReportCount()
                ))
                .collect(Collectors.toList());
    }


    public void deleteComment(Long commentId) {
        UTPComment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));

        commentRepository.delete(comment);
    }

}

