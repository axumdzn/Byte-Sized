package com.bytesize.daos;

import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.entities.Transaction;
import com.bytesize.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImp implements TransactionDAO{
    @Override
    public Transaction createTransaction(Transaction newTransaction) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into transactions values(default, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,newTransaction.getAmount());
            ps.setString(2,newTransaction.getStatus());
            ps.setInt(3,newTransaction.getProductId());
            ps.setInt(4,newTransaction.getBuyerId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            newTransaction.setTransactionId(rs.getInt("transactionId"));
            return newTransaction;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Transaction getTransactionInfo(int transactionId) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from transactions where transactionId = ?";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,transactionId);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            rs.next();
            Transaction result = new Transaction(rs.getInt("transactionId"),rs.getInt("amount"),
                    rs.getString("status"),rs.getInt("productId"),rs.getInt("buyerID"));
            return result;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Transaction updateTransactionStatus(int transactionId, String status) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "update transactions set status = ? where transactionId = ?";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, status);
            ps.setInt(2, transactionId);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Transaction result = new Transaction(rs.getInt("transactionId"),rs.getInt("amount"),
                    rs.getString("status"),rs.getInt("productId"),rs.getInt("buyerID"));
            return result;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Transaction> getAllTransactionByBuyerId(int buyerId) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from transactions where buyerId = ?";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,buyerId);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            List<Transaction> transactions = new ArrayList<>();
            while(rs.next()){
                Transaction transaction = new Transaction(rs.getInt("transactionId"),rs.getInt("amount"),rs.getString("status"),
                        rs.getInt("productId"),rs.getInt("buyerID"));
                transactions.add(transaction);
            };
            if(transactions.size()==0){
                throw new IdNotFound("No rating found with this id");
            }
            return transactions;


        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Transaction> getAllTransactionByProductId(int productId) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from transactions where productId = ?";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,productId);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            List<Transaction> transactions = new ArrayList<>();
            while(rs.next()){
                Transaction transaction = new Transaction(rs.getInt("transactionId"),rs.getInt("amount"),rs.getString("status"),
                        rs.getInt("productId"),rs.getInt("buyerID"));
                transactions.add(transaction);
            };
            if(transactions.size()==0){
                throw new IdNotFound("No rating found with this id");
            }
            return transactions;


        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}

