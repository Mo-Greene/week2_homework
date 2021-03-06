package com.sparta.week2_homework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Person extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String address;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String job;

    public Person(PersonRequestDto requestDto){
        this.name = requestDto.getName();
        this.address = requestDto.getAddress();
        this.age = requestDto.getAge();
        this.job = requestDto.getJob();

    }

    public Person(String name, String address, int age, String job) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.job = job;
    }



    //get으로 할때

    public void update(PersonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.address = requestDto.getAddress();
        this.age = requestDto.getAge();
        this.job = requestDto.getJob();
    }

}