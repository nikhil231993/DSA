package leetcode.designPatterns.Problems.striver.atm.domain.state;

import leetcode.designPatterns.Problems.striver.atm.domain.ATM;
import leetcode.designPatterns.Problems.striver.atm.domain.Denomination;

import java.util.Map;

public interface SupportsNotes {
    void processTransaction(ATM atm, long amount, Map<Denomination, Integer> notes);
}