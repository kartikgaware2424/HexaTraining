package org.example.Main;

import org.example.Dao.BankDao;
import org.example.Dao.BankDaoImpl;
import org.example.Model.Accounts;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccountMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BankDao dao=new BankDaoImpl();
        Accounts accounts=new Accounts();

        System.out.println("Enter FirstName:");
        accounts.setFirstName(sc.next());
        System.out.println("Enter LastName:");
        accounts.setLastName(sc.next());
        System.out.println("Enter City:");
        accounts.setCity(sc.next());
        System.out.println("Enter State:");
        accounts.setState(sc.next());
        System.out.println("Enter Amount:");
        accounts.setAmount(sc.nextDouble());
        System.out.println("Enter CheqFacil (YEs/NO):");
        accounts.setCheqFacil(sc.next());
        System.out.println("Enter Account Type  (Savings/Current):");
        accounts.setAccountType(sc.next());

        try {
            System.out.println(dao.createAccount(accounts));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
