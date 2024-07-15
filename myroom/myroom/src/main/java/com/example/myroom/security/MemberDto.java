package com.example.myroom.security;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

    private String memberId;

    static public MemberDto toDto(Member member){
        return MemberDto.builder()
                .memberId(member.getMemberId())
                .build();
    }

    public Member toEntity(){
        return Member.builder()
                .memberId(memberId)
                .build();
    }

}
