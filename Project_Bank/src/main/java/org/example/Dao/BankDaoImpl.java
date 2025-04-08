package org.example.Dao;

import org.example.Model.Accounts;
import org.example.Util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDaoImpl implements  BankDao {
    Connection connection;
    PreparedStatement pst;
    @Override
    public String createAccount(Accounts accounts) throws SQLException, ClassNotFoundException {
        int accno = generateAccountNo();
        accounts.setAccountNo(accno);
        connection= ConnectionHelper.getConnection();
        String cmd="Insert into Accounts(AccountNo, FirstName, LastName, City, State,Amount,CheqFacil,AccountType) values(?,?,?,?,?,?,?,?)";
        pst=connection.prepareStatement(cmd);
        pst.setInt(1,accno);
        pst.setString(2,accounts.getFirstName());
        pst.setString(3,accounts.getLastName());
        pst.setString(4,accounts.getCity());
        pst.setString(5,accounts.getState());
        pst.setDouble(6,accounts.getAmount());
        pst.setString(7,accounts.getCheqFacil());
        pst.setString(8,accounts.getAccountType());
        pst.executeUpdate();

        return "Detail Inserted SuccessFully....";
    }

    @Override
    public Accounts searchAccount(int AccountNo) throws SQLException, ClassNotFoundException {
        Accounts accounts=null;
        connection=ConnectionHelper.getConnection();
        String cmd="Select * from accounts where accountNo=?";
        pst= connection.prepareStatement(cmd);
        pst.setInt(1,AccountNo);
        ResultSet rs= pst.executeQuery();

        if(rs.next())
        {
            accounts=new Accounts();
            accounts.setAccountNo(rs.getInt("accountNo"));
            accounts.setFirstName(rs.getString("firstName"));
            accounts.setLastName(rs.getString("lastName"));
            accounts.setCity(rs.getString("city"));
            accounts.setState(rs.getString("state"));
            accounts.setAmount(rs.getDouble("amount"));
            accounts.setCheqFacil(rs.getString("cheqFacil"));
            accounts.setAccountType(rs.getString("accountType"));

        }
        return accounts;
    }

    @Override
    public String deposit(int AccountNo, double Depositammount) throws SQLException, ClassNotFoundException {

       Accounts account=searchAccount(AccountNo);
       if(account!=null)
       {
           connection =ConnectionHelper.getConnection();
           String cmd="update accounts set amount=amount+? where accountno=?";
           pst= connection.prepareStatement(cmd);
           pst.setDouble(1,Depositammount);
           pst.setInt(2,AccountNo);
           pst.executeUpdate();

           cmd="insert into trans(AccountNo,TransAmount ,TransType) values (?,?,?)";
           pst=connection.prepareStatement(cmd);
           pst.setInt(1,AccountNo);
           pst.setDouble(2,Depositammount);
           pst.setString(3,"C");
           pst.executeUpdate();
           return  "Amount credited  to the account ";
       }
        return "Account not found ....";
    }

    @Override
    public String withdraw(int AccountNo, double WithdrawAmount) throws SQLException, ClassNotFoundException {
        Accounts accounts=searchAccount(AccountNo);
        if(accounts!=null)
        {
            double balance=accounts.getAmount()-WithdrawAmount;
            if(balance>0)
            {
                connection =ConnectionHelper.getConnection();
                String cmd="update accounts set amount=amount-? where accountno=?";
                pst= connection.prepareStatement(cmd);
                pst.setDouble(1,WithdrawAmount);
                pst.setInt(2,AccountNo);
                pst.executeUpdate();

                cmd="insert into trans(AccountNo,TransAmount ,TransType) values (?,?,?)";
                pst=connection.prepareStatement(cmd);
                pst.setInt(1,AccountNo);
                pst.setDouble(2,WithdrawAmount);
                pst.setString(3,"C");
                pst.executeUpdate();
                return  "Amount debited  from the account ";

            }else
            {
                return "Insufficent balance ....";
            }
        }
        return "account not  found ....";
    }

    private int generateAccountNo() throws SQLException, ClassNotFoundException {
        connection = ConnectionHelper.getConnection();
        String cmd = "select case when max(accountNo) IS NULL THEN 1 else "
                + " max(accountNo)+1 end accno from Accounts";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        rs.next();
        int accno = rs.getInt("accno");
        return accno;
    }
}
