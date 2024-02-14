package com.fall23.ui.data;

import com.fall23.entity.User;
import com.fall23.ui.entity.Employee;
import com.github.javafaker.Faker;

public class JavaFaker {

    static Faker faker = new Faker();

    public static Employee createNewEmployeeWithFakeData(){
        Employee employee = new Employee();
        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setEmail(faker.internet().emailAddress());
        employee.setAge(faker.number().randomDigit());
        employee.setSalary(faker.number().randomDigit());
        employee.setDepartment(faker.commerce().department());

        return employee;
    }

    public static Faker registrationFormWithRandomData() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String username = faker.name().username();
        String password = faker.internet().password();
        return faker;
    }
    public static User createNewUserWithFakerData(){
        User user = new User();
        user.setFirstname(faker.name().firstName());
        user.setLastname(faker.name().lastName());
        user.setEmailAddress(faker.internet().emailAddress());
        user.setUsername(faker.name().username());
        user.setPassword(faker.internet().password(10, 30));
//        String password = RandomStringUtils.randomAlphanumeric(10);
//        user.setPassword(password);
        user.setBio("Lorem Ipsum is simply dummy text of the printing and " +
                "typesetting industry. Lorem Ipsum has been the industry's standard dummy " +
                "text ever since the 1500s, when an unknown printer took a galley of type and " +
                "scrambled it to make a type specimen book. It has survived not only five centuries.");
        return user;
    }

}
