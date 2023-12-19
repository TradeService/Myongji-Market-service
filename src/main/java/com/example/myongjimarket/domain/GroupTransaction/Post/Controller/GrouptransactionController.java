package com.example.myongjimarket.domain.GroupTransaction.Post.Controller;

import com.example.myongjimarket.domain.GroupTransaction.Post.Dto.Post;
import com.example.myongjimarket.domain.GroupTransaction.Post.Service.GroupTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/group-transaction")
public class GrouptransactionController {
    private final GroupTransactionService groupTransactionService;

    @Autowired
    public GrouptransactionController(GroupTransactionService groupTransactionService) {
        this.groupTransactionService = groupTransactionService;
    }
    @GetMapping
    public String getAllGroupTransaction(Model model){
        model.addAttribute("posts",groupTransactionService.getAllGroupTransaction());
        return "posts/GroupTransaction/index";
    }
    @GetMapping("/post")
    public String showWriteForm(Model model){
        Post post =new Post();
        model.addAttribute("post", post);
        return "posts/GroupTransaction/new";
    }
    @PostMapping("/post")
    public String savePost(@ModelAttribute Post post) {
        groupTransactionService.savePost(post);
        return "redirect:/group-transaction";
    }
    @GetMapping("/post/{id}")
    public String getGroupTransactionById(Model model,@PathVariable Long id){
        model.addAttribute("post", groupTransactionService.getPostById(id));
        return "posts/GroupTransaction/get";
    }
    @GetMapping("/edit")
    public String editPost(@RequestParam("id") Long id, Model model){
        Post post = groupTransactionService.getPostById(id);
        model.addAttribute("post",post);
        return "posts/GroupTransaction/edit";
    }
    @PostMapping("/update")
    public String updatePost(@ModelAttribute Post post) {
        groupTransactionService.updatePost(post);
        return "redirect:/group-transaction";
    }
    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        groupTransactionService.deletePost(id);
        return "redirect:/group-transaction";
    }
}
