package edu;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@NoArgsConstructor //기본생성자 생성
@AllArgsConstructor
@Getter @Setter
@ToString
@Slf4j

public class Student {

    //@Slf4j로 커버 가능
//    private static final Logger log = LoggerFactory.getLogger(Student.class);

    private Long id;
    private String firstName;
    private String lastName;


    public void logInfo() {
        log.info("Student id: {}, name: {} {}", id, firstName,lastName);
    }

//    public Student(){ //기본생성자 @NoArgsConstructor로 커버 가능
//
//    }

//    @AllArgsConstructor로 커버 가능
//    public Student(Long id, String firstName, String lastName){
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

//    public Long getId() { //@Getter로 커버
//        return id;
//    }
//
//    public void setId(Long id) { //@Setter로 커버
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    // @ToString으로 커버
//    @Override
//    public String toString() {
//        return "Student{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "'}";
//    }



}
