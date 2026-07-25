package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.controller;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.Transaction;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.TransactionStatus;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.service.TransactionService;

public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Transaction initiateTransaction(String bookingId) {
        return transactionService.initiateTransaction(bookingId);
    }

    public void handleTransactionCallback(String providerRef, TransactionStatus status) {
        transactionService.handleCallback(providerRef, status);
    }
}
