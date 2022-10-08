package com.example.assignment1;

import java.time.LocalDate;
import java.util.Date;

public class Transaksi {
    public User user;
    public Product product;
    public Integer TransactionID;
    public Integer Quantity;
    public Date TransactionDate;

    public Transaksi(User user, Product product, Integer transactionID, Integer quantity, Date transactionDate) {
        this.user = user;
        this.product = product;
        TransactionID = transactionID;
        Quantity = quantity;
        TransactionDate = transactionDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(Integer transactionID) {
        TransactionID = transactionID;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "user=" + user +
                ", product=" + product +
                ", TransactionID=" + TransactionID +
                ", Quantity=" + Quantity +
                ", TransactionDate=" + TransactionDate +
                '}';
    }
}
