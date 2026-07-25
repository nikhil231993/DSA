package leetcode.designPatterns.Problems.striver.atm.repository;

import leetcode.designPatterns.Problems.striver.atm.domain.CashDrawer;
import leetcode.designPatterns.Problems.striver.atm.domain.Denomination;

import java.util.Map;
import java.util.Optional;

public interface CashDrawerRepository {
    CashDrawer save(CashDrawer cashDrawer);
    Optional<CashDrawer> findByATMId(String atmId);
    void updateCashInventory(String atmId, Map<Denomination, Integer> notes);
}