package leetcode.designPatterns.Problems.striver.atm.controller;

import leetcode.designPatterns.Problems.striver.atm.domain.*;
import leetcode.designPatterns.Problems.striver.atm.domain.exception.InvalidATMOperationException;
import leetcode.designPatterns.Problems.striver.atm.service.ATMService;
import leetcode.designPatterns.Problems.striver.atm.service.SessionService;
import leetcode.designPatterns.Problems.striver.atm.service.TransactionService;

import java.util.Map;

public class TransactionController {
    private TransactionService transactionService; // kept for future direct access if needed
    private SessionService sessionService;
    private ATMService atmService;

    public TransactionController(TransactionService transactionService,
                                 SessionService sessionService,
                                 ATMService atmService) {
        this.transactionService = transactionService;
        this.sessionService = sessionService;
        this.atmService = atmService;
    }

    public Transaction showBalance(String sessionId) {
        Session session = sessionService.getSession(sessionId);
        if (session == null)
            return null;
        ATM atm = atmService.getATM(session.getAtmId());
        if (atm == null)
            return null;
        try {
            atm.selectTransaction(TransactionType.BALANCE);
            atm.processTransaction(0);
            return atm.getLastTransaction();
        } catch (InvalidATMOperationException ex) {
            System.out.println("[ERROR] " + ex.getMessage());
            return null;
        }
    }

    public Transaction withdrawCash(String sessionId, long amountMinorUnits) {
        Session session = sessionService.getSession(sessionId);
        if (session == null)
            return null;
        ATM atm = atmService.getATM(session.getAtmId());
        if (atm == null)
            return null;
        try {
            atm.selectTransaction(TransactionType.WITHDRAW);
            atm.processTransaction(amountMinorUnits);
            return atm.getLastTransaction();
        } catch (InvalidATMOperationException ex) {
            System.out.println("[ERROR] " + ex.getMessage());
            return null;
        }
    }

    public Transaction depositCash(String sessionId, Map<Denomination, Integer> notes) {
        Session session = sessionService.getSession(sessionId);
        if (session == null)
            return null;
        ATM atm = atmService.getATM(session.getAtmId());
        if (atm == null)
            return null;
        long amount = calculateAmount(notes);
        try {
            atm.selectTransaction(TransactionType.DEPOSIT);
            atm.processTransaction(amount, notes);
            return atm.getLastTransaction();
        } catch (InvalidATMOperationException ex) {
            System.out.println("[ERROR] " + ex.getMessage());
            return null;
        }
    }

    private long calculateAmount(Map<Denomination, Integer> notes) {
        if (notes == null)
            return 0;
        return notes.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getValue() * entry.getValue())
                .sum();
    }
}