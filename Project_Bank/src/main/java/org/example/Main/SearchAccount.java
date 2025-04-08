package org.example.Main;

import org.example.Dao.BankDao;
import org.example.Dao.BankDaoImpl;
import org.example.Model.Accounts;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchAccount {
    public static void main(String[] args) {
        int accountNo;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the account Number....");
        accountNo=sc.nextInt();
        BankDao dao=new BankDaoImpl();
        try {
          Accounts account=  dao.searchAccount(accountNo);
          if(account!=null)
          {
              System.out.println(account);
          }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
