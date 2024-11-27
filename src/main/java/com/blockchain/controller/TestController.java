package com.blockchain.controller;

import com.blockchain.model.Block;
import com.blockchain.model.Transaction;
import com.blockchain.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BlockchainService blockchainService;

    // 测试系统是否运行
    @GetMapping("/ping")
    public String ping() {
        return "区块链系统正在运行！";
    }

    // 创建测试交易
    @PostMapping("/create-transaction")
    public ResponseEntity<?> createTestTransaction() {
        Transaction transaction = new Transaction(
            "TestSender",
            "TestReceiver",
            100.0
        );
        blockchainService.addTransaction(transaction);
        return ResponseEntity.ok("测试交易已创建");
    }

    // 触发测试挖矿
    @PostMapping("/mine")
    public ResponseEntity<?> testMining() {
        blockchainService.minePendingTransactions("TestMiner");
        return ResponseEntity.ok("区块已被挖出");
    }

    // 获取区块链状态
    @GetMapping("/status")
    public ResponseEntity<?> getBlockchainStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("isValid", blockchainService.isChainValid());
        status.put("latestBlock", blockchainService.getLatestBlock());
        return ResponseEntity.ok(status);
    }
} 