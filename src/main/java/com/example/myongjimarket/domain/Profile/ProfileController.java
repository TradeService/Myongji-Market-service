package com.example.myongjimarket.domain.Profile;

import com.example.myongjimarket.domain.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@RestController
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping()
    public ModelAndView getUserProfile(
            @RequestParam("nickname") String nickname
    ){
        System.out.println("닉네임"+nickname);
        User user = profileService.getUserProfile(nickname);
        if (user.getProfileImageURL() == null || user.getProfileImageURL().isEmpty()) {
            user.setProfileImageURL("/image.jpg");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("soyun/mypage");
        return modelAndView;
    }
    @PostMapping("")
    public ModelAndView updateUerProfile(
            @RequestParam("nickname") String nickname,
            @RequestParam("profileImageURL") MultipartFile file,
            @RequestParam("password") String password
    ){
        ModelAndView modelAndView = new ModelAndView();
        try {
            String filePath = storeFile(file);
            User user = profileService.getUserProfile(nickname);
            user.setPassword(password);
            user.setProfileImageURL(filePath);
            profileService.updateUserProfile(user);

            modelAndView.addObject("user", user);
            modelAndView.setViewName("soyun/mypage");
            return modelAndView;

        } catch (IOException e) {
            e.printStackTrace();
            modelAndView.setViewName("soyun/mypage");
            return modelAndView;
        }
    }
    private String storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Path fileStorageLocation = Paths.get("D:/mju-web-programming/downloadsProfiles/").toAbsolutePath().normalize();
        Path targetLocation = fileStorageLocation.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return fileName; // 파일명 반환
    }
}
