package net.datasa.web.controller;

import lombok.extern.slf4j.Slf4j;
import net.datasa.web.model.User;
import net.datasa.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class UserController {

    // 필드 주입
    @Autowired
    private UserService userService;

    // 회원가입 페이지 요청 처리
    @GetMapping("register")
    public String register() {
        log.info("회원가입 페이지 호출");

        return "register"; // templates/register.html 반환
    }

    // 회원가입 요청 처리 (GET 방식)
    @ResponseBody
    @GetMapping("register_v1")
    public String registerV1(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "email") String email) {
        log.info("회원가입 v1 요청");
        log.info("name: {}", name);
        log.info("email: {}", email);

        return "ok";
    }

    // 회원가입 요청 처리 (POST 방식)
    @PostMapping("register_v2")
    public ResponseEntity<String> registerV2(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "email") String email) {
        log.info("회원가입 v2 요청");
        log.info("name: {}", name);
        log.info("email: {}", email);

        return ResponseEntity.ok("회원가입 완료");
    }

    // 회원가입 요청 처리 (POST 방식)
    @PostMapping("register_v3")
    public String registerV3(
            @ModelAttribute User user) {
        log.info("회원가입 v3 요청");
        log.info("회원가입 전, user: {}", user);

        userService.registerUser(user);

        log.info("회원가입 후, user: {}", user);

        return "register_success";
    }

    // 회원목록 페이지 요청 처리
    @GetMapping("user-list")
    public String userList(Model model) {
        log.info("회원목록 페이지 호출");

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "user_list";
    }

    // 회원 상세정보 요청 처리
    @GetMapping("user-detail")
    public String userDetailV1(
            @RequestParam(name = "id") Long id,
            Model model) {
        log.info("회원 상세정보 페이지 호출");
        log.info("id: {}", id);

        User user = userService.getUserById(id).orElse(null);
        model.addAttribute("user", user);

        return "user_detail";
    }

    // 회원 상세정보 요청 처리
    @GetMapping("user-detail/{id}")
    public String userDetailV2(
            @PathVariable(name = "id") Long id,
            Model model) {
        log.info("회원 상세정보 페이지 호출");
        log.info("id: {}", id);

        User user = userService.getUserById(id).orElse(null);
        model.addAttribute("user", user);

        return "user_detail";
    }

}

