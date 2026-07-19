package leetcode.designPatterns.Problems.ATMWithdrawal.repository;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.Account;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.AccountStatus;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

//@Repository
public class InMemoryAccountRepository implements AccountRepository {

    private final Map<String, Account> accounts =
            new ConcurrentHashMap<>();

    //@PostConstruct
    public void initializeAccounts() {
        save(new Account(
                "account-1", "customer-1",
                new BigDecimal("1000.00"), AccountStatus.ACTIVE
        ));

        save(new Account(
                "account-2", "customer-2",
                new BigDecimal("500.00"), AccountStatus.ACTIVE
        ));
    }

    @Override
    public Optional<Account> findById(String accountId) {

        return Optional.ofNullable(accounts.get(accountId));
    }

    @Override
    public Account save(Account account) {
        accounts.put(account.getAccountId(), account);

        return account;
    }
}
