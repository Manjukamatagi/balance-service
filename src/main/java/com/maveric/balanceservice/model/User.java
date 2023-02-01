package com.maveric.balanceservice.model;

import com.maveric.balanceservice.enumeration.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
//@Entity
@Getter
@Setter
@Builder
//@Table(name = "user")
public class User {
    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String _id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String email;
    private String address;
    private LocalDate dateOfBirth;
//    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String role;
    private String Password;

}
