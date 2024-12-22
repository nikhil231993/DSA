package leetcode.designPatterns.Problems.DesignATM;

public class UserBankAccount {

    int balance;

    public void withdrawalBalance(int amount) {
        balance = balance - amount;
    }
}
