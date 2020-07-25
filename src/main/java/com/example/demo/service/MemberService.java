package com.example.demo.service;

import com.example.demo.model.entity.Member;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface MemberService extends UserDetailsService {
    Optional<Member> findByEmail(String email);
}
