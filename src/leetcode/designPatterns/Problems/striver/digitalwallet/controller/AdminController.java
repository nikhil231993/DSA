package leetcode.designPatterns.Problems.striver.digitalwallet.controller;

import leetcode.designPatterns.Problems.striver.digitalwallet.domain.Wallet;
import leetcode.designPatterns.Problems.striver.digitalwallet.service.WalletService;

public class AdminController {
    private WalletService walletService;

    public AdminController(WalletService walletService) {
        this.walletService = walletService;
    }

    public Wallet suspendWallet(String accountNumber) {
        return walletService.suspendWallet(accountNumber);
    }

    public Wallet closeWallet(String accountNumber) {
        return walletService.closeWallet(accountNumber);
    }

    public Wallet reopenWallet(String accountNumber) {
        return walletService.reopenWallet(accountNumber);
    }
}

