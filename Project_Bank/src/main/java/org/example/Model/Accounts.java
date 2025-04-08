package org.example.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor

public class Accounts {
    private int accountNo;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private double amount;
    private String cheqFacil;
    private String accountType;
}
