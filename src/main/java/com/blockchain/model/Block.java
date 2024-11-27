package com.blockchain.model;

import java.util.List;

public class Block {
    private String hash;           // 当前区块的哈希值
    private String previousHash;   // 前一个区块的哈希值
    private long timestamp;        // 时间戳
    private List<Transaction> transactions; // 交易列表
    private int nonce;            // 工作量证明的随机数
    private int difficulty;       // 挖矿难度

    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();
        this.difficulty = 4; // 初始难度值
        this.nonce = 0;
    }

    // Getters
    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getNonce() {
        return nonce;
    }

    public int getDifficulty() {
        return difficulty;
    }

    // Setters
    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", timestamp=" + timestamp +
                ", transactions=" + transactions +
                ", nonce=" + nonce +
                ", difficulty=" + difficulty +
                '}';
    }
} 