package com.blockchain.service;

import com.blockchain.model.Block;
import com.blockchain.model.Transaction;
import com.blockchain.util.CryptoUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockchainService {
    private List<Block> blockchain;
    private List<Transaction> pendingTransactions;

    public BlockchainService() {
        this.blockchain = new ArrayList<>();
        this.pendingTransactions = new ArrayList<>();
        // 创建创世区块
        createGenesisBlock();
    }

    private void createGenesisBlock() {
        Block genesisBlock = new Block("0");
        genesisBlock.setHash(calculateHash(genesisBlock));
        blockchain.add(genesisBlock);
    }

    public Block getLatestBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    public void addTransaction(Transaction transaction) {
        // 验证交易
        if (validateTransaction(transaction)) {
            pendingTransactions.add(transaction);
        }
    }

    public void minePendingTransactions(String minerAddress) {
        Block block = new Block(getLatestBlock().getHash());
        block.setTransactions(new ArrayList<>(pendingTransactions));
        
        // 挖矿过程
        mineBlock(block);
        
        blockchain.add(block);
        pendingTransactions.clear();
        
        // 给矿工发放奖励
        Transaction reward = new Transaction("System", minerAddress, 10.0);
        pendingTransactions.add(reward);
    }

    private void mineBlock(Block block) {
        String target = new String(new char[block.getDifficulty()]).replace('\0', '0');
        while (!block.getHash().substring(0, block.getDifficulty()).equals(target)) {
            block.setNonce(block.getNonce() + 1);
            block.setHash(calculateHash(block));
        }
    }

    private String calculateHash(Block block) {
        return CryptoUtil.sha256(
            block.getPreviousHash() +
            block.getTimestamp() +
            block.getNonce()
        );
    }

    private boolean validateTransaction(Transaction transaction) {
        // 实现交易验证逻辑
        return true; // 简化版本
    }

    public boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            // 验证当前区块的哈希
            if (!currentBlock.getHash().equals(calculateHash(currentBlock))) {
                return false;
            }

            // 验证区块链接
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }
} 