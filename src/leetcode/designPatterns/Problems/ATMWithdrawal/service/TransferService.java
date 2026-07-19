package leetcode.designPatterns.Problems.ATMWithdrawal.service;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.Account;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.TransactionResult;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.TransferRequest;
import leetcode.designPatterns.Problems.ATMWithdrawal.exception.AccountNotFoundException;
import leetcode.designPatterns.Problems.ATMWithdrawal.exception.InvalidAmountException;
import leetcode.designPatterns.Problems.ATMWithdrawal.repository.AccountRepository;
import leetcode.designPatterns.Problems.ATMWithdrawal.repository.TransactionRepository;

import java.math.BigDecimal;

//@Service
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransferService(
            AccountRepository accountRepository,
            TransactionRepository transactionRepository) {

        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    //@Transactional
    public TransactionResult transfer(
            TransferRequest request) {

        validateRequest(request);

        TransactionResult existing = transactionRepository.findByIdempotencyKey(request.getIdempotencyKey());

        if (existing != null) {
            return existing;
        }

        Account sourceAccount = accountRepository.findById(request.getSourceAccountId())
                        .orElseThrow(() -> new AccountNotFoundException(request.getSourceAccountId()));

        Account destinationAccount =
                accountRepository.findById(request.getDestinationAccountId())
                        .orElseThrow(() -> new AccountNotFoundException(request.getDestinationAccountId()));

        sourceAccount.withdraw(request.getAmount());

        destinationAccount.deposit(request.getAmount());

        accountRepository.save(sourceAccount);
        accountRepository.save(destinationAccount);

        TransactionResult result = TransactionResult.success(request.getAmount());

        transactionRepository.save(request.getIdempotencyKey(), result);

        return result;
    }

    public Account getAccount(String accountId) {
        return accountRepository
                .findById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException(accountId)
                );
    }

    private void validateRequest(
            TransferRequest request) {

        if (request == null) {
            throw new IllegalArgumentException(
                    "Transfer request cannot be null"
            );
        }

        if (request.getSourceAccountId() == null ||
                request.getSourceAccountId().isBlank()) {

            throw new IllegalArgumentException(
                    "Source account ID is required"
            );
        }

        if (request.getDestinationAccountId() == null ||
                request.getDestinationAccountId().isBlank()) {

            throw new IllegalArgumentException(
                    "Destination account ID is required"
            );
        }

        if (request.getSourceAccountId()
                .equals(request.getDestinationAccountId())) {

            throw new IllegalArgumentException(
                    "Source and destination accounts must differ"
            );
        }

        if (request.getAmount() == null ||
                request.getAmount()
                        .compareTo(BigDecimal.ZERO) <= 0) {

            throw new InvalidAmountException(
                    "Transfer amount must be greater than zero"
            );
        }

        if (request.getIdempotencyKey() == null ||
                request.getIdempotencyKey().isBlank()) {

            throw new IllegalArgumentException(
                    "Idempotency key is required"
            );
        }
    }
}
