package leetcode.designPatterns.Problems.ATMWithdrawal.service;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.Account;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.TransactionResult;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.WithdrawalRequest;
import leetcode.designPatterns.Problems.ATMWithdrawal.exception.AccountNotFoundException;
import leetcode.designPatterns.Problems.ATMWithdrawal.repository.AccountRepository;
import leetcode.designPatterns.Problems.ATMWithdrawal.repository.TransactionRepository;

//@Service
public class WithdrawalService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public WithdrawalService(
            AccountRepository accountRepository,
            TransactionRepository transactionRepository) {

        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    //@Transactional
    public TransactionResult withdraw(WithdrawalRequest request) {

        validateRequest(request);

        TransactionResult existing =
                transactionRepository.findByIdempotencyKey(
                        request.getIdempotencyKey());

        if (existing != null) {
            return existing;
        }

        Account account = accountRepository.findById(request.getAccountId())
                        .orElseThrow(() -> new AccountNotFoundException(request.getAccountId()));

        account.withdraw(request.getAmount());

        accountRepository.save(account);

        TransactionResult result = TransactionResult.success(request.getAmount());

        transactionRepository.save(request.getIdempotencyKey(), result);

        return result;
    }

    private void validateRequest(
            WithdrawalRequest request) {

        if (request == null) {
            throw new IllegalArgumentException(
                    "Withdrawal request cannot be null");
        }

        if (request.getAccountId() == null ||
                request.getAccountId().isBlank()) {

            throw new IllegalArgumentException(
                    "Account ID is required");
        }

        if (request.getIdempotencyKey() == null ||
                request.getIdempotencyKey().isBlank()) {

            throw new IllegalArgumentException(
                    "Idempotency key is required");
        }
    }
}
