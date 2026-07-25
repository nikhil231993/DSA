package leetcode.designPatterns.Problems.striver.digitalwallet.controller;

import leetcode.designPatterns.Problems.striver.digitalwallet.domain.Transaction;
import leetcode.designPatterns.Problems.striver.digitalwallet.domain.TransactionStatus;
import leetcode.designPatterns.Problems.striver.digitalwallet.service.TransactionService;

import java.util.Map;

public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Transaction transfer(String fromAccountNumber, String toAccountNumber, long amountMinor, String description) {
        return transactionService.transfer(fromAccountNumber, toAccountNumber, amountMinor, description);
    }

    public Transaction initiateDeposit(String accountNumber, long amountMinor, String paymentMethod,
                                       String paymentGateway, Map<String, String> paymentDetails) {
        return transactionService.initiateDeposit(accountNumber, amountMinor, paymentMethod, paymentGateway, paymentDetails);
    }

    public void handlePaymentCallback(String providerRef, TransactionStatus status) {
        transactionService.handleDepositCallback(providerRef, status);
    }

    public Transaction withdraw(String accountNumber, long amountMinor, String description) {
        return transactionService.withdraw(accountNumber, amountMinor, description);
    }
}

