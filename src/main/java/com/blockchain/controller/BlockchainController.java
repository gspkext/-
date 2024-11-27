package com.blockchain.controller;

import com.blockchain.model.Transaction;
import com.blockchain.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blockchain")
public class BlockchainController {
    
    @Autowired
    private BlockchainService blockchainService;

    @PostMapping("/transactions")
    public String createTransaction(@RequestBody Transaction transaction) {
        blockchainService.addTransaction(transaction);
        return "交易已添加到待处理列表";
    }

    @PostMapping("/mine")
    public String minePendingTransactions(@RequestParam String minerAddress) {
        blockchainService.minePendingTransactions(minerAddress);
        return "区块已被挖出";
    }

    @GetMapping("/chain")
    public boolean validateChain() {
        return blockchainService.isChainValid();
    }
} 