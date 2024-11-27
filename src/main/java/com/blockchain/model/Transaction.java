package com.blockchain.model;

public class Transaction {
    private String sender;    // 发送方地址
    private String recipient; // 接收方地址
    private double amount;    // 交易金额
    private long timestamp;   // 交易时间戳
    private String signature; // 交易签名

    public Transaction(String sender, String recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }

    // Getters and Setters
    // ... 省略标准的getter和setter方法
} 