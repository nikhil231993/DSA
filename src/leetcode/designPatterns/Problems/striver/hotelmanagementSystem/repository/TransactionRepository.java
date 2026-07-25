package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.Transaction;

import java.util.Optional;

public interface TransactionRepository {
    Transaction save(Transaction transaction);

    Optional<Transaction> findByProviderRef(String providerRef);
}
