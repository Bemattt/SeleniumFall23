package com.fall23.ui.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class NewUserName {
    public static String firstName;
    private  String lastName;
    private  String userName;
    private  String password;
}
