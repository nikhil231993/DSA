package leetcode.designPatterns.Problems.ATMWithdrawal.controller;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.Account;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.TransactionResult;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.TransferRequest;
import leetcode.designPatterns.Problems.ATMWithdrawal.service.TransferService;

//@RestController
//@RequestMapping("/api")
//public class TransferController {
//
//    private final TransferService transferService;
//
//    public TransferController(
//            TransferService transferService) {
//
//        this.transferService = transferService;
//    }
//
//    @PostMapping("/transfers")
//    public ResponseEntity<TransactionResult> transfer(
//            @RequestBody TransferRequest request) {
//
//        TransactionResult result =
//                transferService.transfer(request);
//
//        return ResponseEntity.ok(result);
//    }
//
//    @GetMapping("/accounts/{accountId}")
//    public ResponseEntity<Account> getAccount(
//            @PathVariable String accountId) {
//
//        Account account =
//                transferService.getAccount(accountId);
//
//        return ResponseEntity.ok(account);
//    }
//}
