package leetcode.designPatterns.Problems.ATMWithdrawal.controller;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.TransactionResult;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.WithdrawalRequest;
import leetcode.designPatterns.Problems.ATMWithdrawal.service.WithdrawalService;

import java.math.BigDecimal;

//@RestController
//@RequestMapping("/accounts")
//public class WithdrawalController {
//
//    private final WithdrawalService withdrawalService;
//
//    public WithdrawalController(
//            WithdrawalService withdrawalService) {
//
//        this.withdrawalService = withdrawalService;
//    }
//
//    @PostMapping("/{accountId}/withdrawals")
//    public ResponseEntity<TransactionResult> withdraw(
//            @PathVariable String accountId,
//            @RequestHeader("Idempotency-Key")
//            String idempotencyKey,
//            @RequestBody BigDecimal amount) {
//
//        WithdrawalRequest request =
//                new WithdrawalRequest(
//                        accountId,
//                        amount,
//                        idempotencyKey);
//
//        TransactionResult result =
//                withdrawalService.withdraw(request);
//
//        return ResponseEntity.ok(result);
//    }
//}
