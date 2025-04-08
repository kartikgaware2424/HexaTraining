package org.example.Dao;

import org.example.Model.Accounts;

import java.sql.SQLException;

public interface BankDao {
    String createAccount(Accounts accounts) throws SQLException, ClassNotFoundException;
    Accounts searchAccount(int AccountNo) throws SQLException, ClassNotFoundException;
    String deposit(int AccountNo,double Depositammount) throws SQLException, ClassNotFoundException;
    String withdraw(int AccountNo,double WithdrawAmount) throws SQLException, ClassNotFoundException;
}
