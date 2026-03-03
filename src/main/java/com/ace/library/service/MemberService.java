package com.ace.library.service;

import com.ace.library.dto.MemberDto;
import com.ace.library.entity.Member;
import com.ace.library.exception.ResourceNotFoundException;
import com.ace.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));
    }

    public Member createMember(MemberDto dto) {
        Member member = Member.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .membershipDate(dto.getMembershipDate())
                .build();
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, MemberDto dto) {
        Member member = getMemberById(id);
        member.setFirstName(dto.getFirstName());
        member.setLastName(dto.getLastName());
        member.setEmail(dto.getEmail());
        member.setPhone(dto.getPhone());
        member.setMembershipDate(dto.getMembershipDate());
        return memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        getMemberById(id);
        memberRepository.deleteById(id);
    }
}
