package leetcode.designPatterns.Problems.ATMWithdrawal.controller;

import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentRequest;
import leetcode.designPatterns.Problems.ATMWithdrawal.domain.PaymentResult;
import leetcode.designPatterns.Problems.ATMWithdrawal.service.PaymentGatewayService;

//@RestController
//@RequestMapping("/api/payments")
//public class PaymentController {
//
//    private final PaymentGatewayService paymentGatewayService;
//
//    public PaymentController(
//            PaymentGatewayService paymentGatewayService) {
//
//        this.paymentGatewayService = paymentGatewayService;
//    }
//
//    @PostMapping
//    public ResponseEntity<PaymentResult> makePayment(
//            @RequestBody PaymentRequest request) {
//
//        PaymentResult result =
//                paymentGatewayService.makePayment(request);
//
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(result);
//    }
//}
