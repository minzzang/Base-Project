package com.example.demo.controller;

import com.example.demo.model.dto.MemberDto;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("hello world!");
    }

    @GetMapping("/user/signup")
    public ResponseEntity<String> signUp() {
        return ResponseEntity.ok("get sign up");
    }

    @PostMapping("/user/signup")
    public ResponseEntity<String> processSignUp(MemberDto memberDto) {
//        memberService.processSignUp(memberDto);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        return new ResponseEntity<>(headers, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/login")
    public ResponseEntity<String> login(MemberDto memberDto, Model model) {
        UserDetails findUser =
            memberService.loadUserByUsername(memberDto.getUserEmail());
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> message = new HttpEntity<>("get log in \n" + memberDto.getUserEmail() + ", " + memberDto.getPassword());
        headers.setContentType(MediaType.APPLICATION_JSON);
        model.addAttribute("user", findUser);
        return new ResponseEntity<>(headers, HttpStatus.OK);
//        return ResponseEntity.ok(
//            "get log in \n"
//                + memberDto.getUserEmail()
//                + ","
//                + memberDto.getPassword()
//        );
    }

    @GetMapping("/user/login/result")
    public ResponseEntity<String> processLogin() {
        return ResponseEntity.ok("hello world!");
    }

    @GetMapping("/user/logout/result")
    public ResponseEntity<String> processLogout() {
        return ResponseEntity.ok("hello world!");
    }

    @GetMapping("/user/denied")
    public ResponseEntity<String> denied() {
        return ResponseEntity.ok("hello world!");
    }

    @GetMapping("/user/info")
    public ResponseEntity<String> myInfo() {
        return ResponseEntity.ok("hello world!");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("hello world!");
    }
}
