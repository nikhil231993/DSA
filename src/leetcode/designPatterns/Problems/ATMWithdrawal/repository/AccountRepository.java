package leetcode.designPatterns.Problems.ATMWithdrawal.repository;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.Account;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findById(String accountId);

    Account save(Account account);
}
