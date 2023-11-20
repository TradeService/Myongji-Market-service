package com.example.thingimarket.controller.transaction;

import com.example.thingimarket.dto.transaction.TransactionPostDTO;
import com.example.thingimarket.service.transaction.TransactionPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
//public class TransactionController {
//
//    @GetMapping("/test")
//    public String test(){
//        return "transaction/test";
//    }
//}

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionPostService service;

    @Autowired
    public TransactionController(TransactionPostService service) {
        this.service = service;
    }

    @GetMapping("/new")
    public String showNewTransactionForm(Model model) {
        return null;
    }

    @PostMapping
    public String createTransactionPost(@ModelAttribute TransactionPostDTO postDTO) {
        return null;
    }

    @GetMapping("/{id}")
    public String viewTransactionPost(@PathVariable Long id, Model model) {
        return null;
    }
}
