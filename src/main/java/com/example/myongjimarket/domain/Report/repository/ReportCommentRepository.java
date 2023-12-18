package com.example.myongjimarket.domain.Report.repository;

import com.example.myongjimarket.domain.Report.ReportComment;
import com.example.myongjimarket.domain.Report.ReportPost;
import com.example.myongjimarket.domain.UTPComment.UTPComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportCommentRepository extends JpaRepository<ReportComment, Long> {
    Optional<ReportComment> findByReportedComment(UTPComment reportedComment);
}
