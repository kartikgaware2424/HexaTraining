package org.example.Main;

import org.example.Dao.BankDao;
import org.example.Dao.BankDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class WithDrawAccountMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the account No :");
        int accountNo=sc.nextInt();

        System.out.println("Enter the  amount to transfer :");
        double withdraw= sc.nextDouble();
        BankDao dao=new BankDaoImpl();

        try {
            System.out.println( dao.withdraw(accountNo,withdraw));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
