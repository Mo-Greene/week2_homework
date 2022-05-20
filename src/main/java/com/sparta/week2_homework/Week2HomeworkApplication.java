package com.sparta.week2_homework;

import com.sparta.week2_homework.domain.Person;
import com.sparta.week2_homework.domain.PersonRepository;
import com.sparta.week2_homework.domain.PersonRequestDto;
import com.sparta.week2_homework.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week2HomeworkApplication {

    public static void main(String[] args) { SpringApplication.run(Week2HomeworkApplication.class, args);
    }

    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
        return (args) -> {
            personRepository.save(new Person("장틔", "주공아파트", 28, "목수"));

            List<Person> personList = personRepository.findAll();
            for (int i = 0; i < personList.size(); i++){
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getAddress());
                System.out.println(person.getAge());
                System.out.println(person.getJob());
            }

            PersonRequestDto requestDto = new PersonRequestDto("장틔", "신길로29", 29,"무즥");
            personService.update(1L, requestDto);
            personList = personRepository.findAll();
            for (int i = 0; i < personList.size(); i++){
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getAddress());
                System.out.println(person.getAge());
                System.out.println(person.getJob());
            }
        };
    }
}
