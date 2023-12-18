package com.example.myongjimarket.domain.Report.repository;
import com.example.myongjimarket.domain.Report.ReportPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReportPostRepository extends JpaRepository<ReportPost, Long> {
    Optional<ReportPost> findByReportedPostId(Long reportedPostId);
}
