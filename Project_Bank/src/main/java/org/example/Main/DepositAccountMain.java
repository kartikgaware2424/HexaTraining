package org.example.Main;

import org.example.Dao.BankDao;
import org.example.Dao.BankDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class DepositAccountMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the account No :");
        int accountNo=sc.nextInt();

        System.out.println("Enter the deposit amount :");
        double deposit= sc.nextDouble();
        BankDao dao=new BankDaoImpl();

        try {
            System.out.println(dao.deposit(accountNo,deposit));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
