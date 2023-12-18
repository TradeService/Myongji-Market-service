package com.example.myongjimarket.domain.Manager.controller;

import com.example.myongjimarket.domain.Manager.dto.request.CommentReportDTO;
import com.example.myongjimarket.domain.Manager.dto.request.PostReportDTO;
import com.example.myongjimarket.domain.Manager.service.ManagerService;
import com.example.myongjimarket.domain.UTPComment.service.CommentService;
import com.example.myongjimarket.domain.UsedTransactionPost.service.UTPService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/manager")
@Controller
public class ManagerController {
    private final ManagerService managerService;
    private final UTPService utpService;
    private final CommentService commentService;

    public ManagerController(ManagerService managerService,UTPService utpService,CommentService commentService) {
        this.managerService = managerService;
        this.utpService = utpService;
        this.commentService = commentService;
    }

    @GetMapping("")
    public String showReportMain(Model model) {
        List<PostReportDTO> reportedPosts = managerService.getReportedPosts();
        List<CommentReportDTO> reportedComments = managerService.getReportedComments();
        model.addAttribute("reportedPosts", reportedPosts);
        model.addAttribute("reportedComments", reportedComments);
        return "managerPage/main";
    }
    @PostMapping("/deletePost")
    public String deletePost(@RequestParam("postId") Long postId) {
        utpService.deletePost(postId);
        return "redirect:/manager";
    }

    @PostMapping("/deleteComment")
    public String deleteComment(@RequestParam("commentId") Long commentId) {
        managerService.deleteComment(commentId);
        return "redirect:/manager";
    }
}
