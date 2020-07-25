package com.example.demo.service;

import com.example.demo.model.dto.MemberDto;
import com.example.demo.model.entity.Member;
import com.example.demo.repository.MemberRepository;
import java.util.Collections;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    final MemberRepository memberRepository;

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberRepository.findUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = findByEmail(email)
            .orElseThrow(() ->
                new UsernameNotFoundException("유저가 존재하지 않습니다."));

        return new User(
            member.getEmail(),
            member.getPassword(),
            Collections.singleton(new SimpleGrantedAuthority("USER"))
        );
    }

//    public void processSignUp(MemberDto memberDto) {
//        Optional<Member> user = memberRepository.findUserByEmail(memberDto.getUserEmail());
//        if (Objects.isNull(user))
//        if (user.isPresent()) {
//            return;
//        }
//
//    }
}
