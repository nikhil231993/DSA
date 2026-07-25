package leetcode.designPatterns.Problems.striver.digitalwallet.controller;

import leetcode.designPatterns.Problems.striver.digitalwallet.domain.AccountStatement;
import leetcode.designPatterns.Problems.striver.digitalwallet.domain.Wallet;
import leetcode.designPatterns.Problems.striver.digitalwallet.service.TransactionService;
import leetcode.designPatterns.Problems.striver.digitalwallet.service.WalletService;

public class WalletController {
    private WalletService walletService;
    private TransactionService transactionService;

    public WalletController(WalletService walletService, TransactionService transactionService) {
        this.walletService = walletService;
        this.transactionService = transactionService;
    }

    public Wallet createWallet(String userId) {
        return walletService.createWallet(userId);
    }

    public long getBalance(String accountNumber) {
        return walletService.getByAccountNumber(accountNumber).getBalanceMinor();
    }

    public AccountStatement getStatement(String accountNumber, Long startUtc, Long endUtc) {
        return transactionService.getStatement(accountNumber, startUtc, endUtc);
    }
}

