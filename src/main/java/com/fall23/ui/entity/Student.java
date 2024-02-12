package com.fall23.ui.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private int mobileNumber;
    private String dateOfBirth;
    private String subjects;
    private String hobbies;
    private String currentAddress;

}
