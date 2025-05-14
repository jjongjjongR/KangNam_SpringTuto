package com.example.boardproject2.dto;


import com.example.boardproject2.entity.Member;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MemberForm {


    private Long id;
    private String email;
    private String password;

    //DTO -> Entity
    public Member toMember(){
        return new Member(this.id, this.email, this.password);

    }

}
