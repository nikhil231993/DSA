package leetcode.designPatterns.Problems.striver.atm.controller;

import leetcode.designPatterns.Problems.striver.atm.domain.ATM;
import leetcode.designPatterns.Problems.striver.atm.domain.Session;
import leetcode.designPatterns.Problems.striver.atm.domain.exception.InvalidATMOperationException;
import leetcode.designPatterns.Problems.striver.atm.service.ATMService;
import leetcode.designPatterns.Problems.striver.atm.service.SessionService;

public class SessionController {
    private SessionService sessionService;
    private ATMService atmService;

    public SessionController(SessionService sessionService, ATMService atmService) {
        this.sessionService = sessionService;
        this.atmService = atmService;
    }

    public Session startSession(String atmId, String cardId) {
        ATM atm = atmService.getATM(atmId);
        if (atm == null)
            return null;
        System.out.println("[SessionController] startSession handled by state during insertCard");
        return atm.getCurrentSession();
    }

    public void endSession(String sessionId) {
        Session session = sessionService.getSession(sessionId);
        if (session == null)
            return;
        ATM atm = atmService.getATM(session.getAtmId());
        if (atm == null)
            return;
        try {
            atm.endSession();
        } catch (InvalidATMOperationException ex) {
            System.out.println("[ERROR] " + ex.getMessage());
        }
    }
}