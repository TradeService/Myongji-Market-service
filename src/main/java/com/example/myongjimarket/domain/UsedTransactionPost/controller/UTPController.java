package com.example.myongjimarket.domain.UsedTransactionPost.controller;
import com.example.myongjimarket.domain.Report.service.ReportCommentService;
import com.example.myongjimarket.domain.Report.service.ReportPostService;
import com.example.myongjimarket.domain.UTPComment.service.CommentService;
import com.example.myongjimarket.domain.UsedTransactionPost.UsedTransactionPost;
import com.example.myongjimarket.domain.UsedTransactionPost.dto.request.UTPCreateRequest;
import com.example.myongjimarket.domain.UsedTransactionPost.dto.request.UTPReadAllRequest;
import com.example.myongjimarket.domain.UsedTransactionPost.dto.request.UTPReadByIdRequest;
import com.example.myongjimarket.domain.UsedTransactionPost.dto.request.UTPUpdateRequest;
import com.example.myongjimarket.domain.UsedTransactionPost.service.UTPService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
@Controller
@RequestMapping("/used-transaction")
public class UTPController {
    private final UTPService utpService;
    private final CommentService commentService;
    private final ReportPostService reportPostService;
    private final ReportCommentService reportCommentService;

    public UTPController(UTPService utpService, CommentService commentService, ReportPostService reportPostService, ReportCommentService reportCommentService){
        this.utpService = utpService;
        this.commentService = commentService;
        this.reportPostService = reportPostService;
        this.reportCommentService = reportCommentService;
    }
    @GetMapping()
    public String UTPMain(Model model){
        List<UTPReadAllRequest> posts = utpService.getAllPosts();
        model.addAttribute("posts", posts);
        return "usedTransactionPosts/main";
    }
    @GetMapping("/filter")
    public String filterPostsByTopic(@RequestParam("topic") String topic, Model model) {
        List<UTPReadAllRequest> filteredPosts = utpService.getPostsByTopic(topic);
        model.addAttribute("posts", filteredPosts);
        return "usedTransactionPosts/main";
    }
    @GetMapping("new")
    public String newPost(Model model){
        model.addAttribute("usedTransactionPost", new UsedTransactionPost());
        return "usedTransactionPosts/new";
    }
    @PostMapping("/save")
    public String createPost(@ModelAttribute UTPCreateRequest postDTO, RedirectAttributes redirectAttributes) throws IOException {
        utpService.createPost(postDTO);
        redirectAttributes.addFlashAttribute("successMessage", "게시글이 작성되었습니다.");
        return "redirect:/used-transaction";
    }

    @GetMapping("/detail")
    public String viewDetails(@RequestParam("id") Long id, Model model) {
        UTPReadByIdRequest postDetails = utpService.getPostDetails(id);
        model.addAttribute("post", postDetails);
        return "usedTransactionPosts/detail";
    }
    @GetMapping("/edit")
    public String editPost(@RequestParam("id") Long id, Model model) {
        UTPReadByIdRequest post = utpService.getPostById(id);
        model.addAttribute("post", post);
        return "usedTransactionPosts/edit";
    }
    @PostMapping("/update")
    public String updatePost(@ModelAttribute UTPUpdateRequest post, RedirectAttributes redirectAttributes) throws IOException {
        utpService.updatePost(post);
        redirectAttributes.addFlashAttribute("successMessage", "수정되었습니다.");
        return "redirect:/used-transaction";
    }
    @GetMapping("/delete")
    public String deletePost(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        utpService.deletePost(id);
        redirectAttributes.addFlashAttribute("successMessage", "삭제되었습니다.");
        return "redirect:/used-transaction";
    }
    @PostMapping("/addComment")
    public String addComment(@RequestParam("postId") Long postId, @RequestParam("content") String content, RedirectAttributes redirectAttributes) {
        commentService.addComment(postId, content);
        redirectAttributes.addFlashAttribute("successMessage", "댓글 작성이 완료되었습니다.");
        return "redirect:/used-transaction/detail?id=" + postId;
    }

    @PostMapping("/like")
    public String likePost(@RequestParam("postId") Long postId, RedirectAttributes redirectAttributes) {
        utpService.likePost(postId);
        redirectAttributes.addFlashAttribute("successMessage", "좋아요+1");
        return "redirect:/used-transaction/detail?id=" + postId;
    }
    @PostMapping("/reportPost")
    public String reportPost(@RequestParam("postId") Long postId, RedirectAttributes redirectAttributes) {
        try {
            reportPostService.reportPost(postId);
            redirectAttributes.addFlashAttribute("successMessage", "게시글 신고가 접수되었습니다.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "게시글 신고 처리 중 오류가 발생했습니다.");
        }
        return "redirect:/used-transaction/detail?id=" + postId;
    }
    @PostMapping("/reportComment")
    public String reportComment(@RequestParam("commentId") Long commentId, RedirectAttributes redirectAttributes) {
        try {
            Long postId = reportCommentService.reportComment(commentId);
            redirectAttributes.addFlashAttribute("successMessage", "댓글 신고가 접수되었습니다.");
            return "redirect:/used-transaction/detail?id=" + postId;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "댓글 신고 처리 중 오류가 발생했습니다.");
            return "redirect:/used-transaction";
        }
    }
}