package leetcode.designPatterns.Problems.striver.atm.domain.strategy;

import leetcode.designPatterns.Problems.striver.atm.domain.Denomination;
import leetcode.designPatterns.Problems.striver.atm.domain.Transaction;

import java.util.Map;

public interface TransactionStrategy {
    Transaction processTransaction(String sessionId, long amount, Map<Denomination, Integer> notes);
}
