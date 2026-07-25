package leetcode.designPatterns.Problems.striver.atm.service;

import leetcode.designPatterns.Problems.striver.atm.domain.Session;
import leetcode.designPatterns.Problems.striver.atm.repository.SessionRepository;

public class SessionService {
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session startSession(String atmId, String cardId) {
        // TODO: Get account ID from bank servers.
        String accountId = "ACC_001"; // Placeholder

        Session session = new Session(
                "SESSION_" + System.currentTimeMillis(),
                atmId,
                cardId,
                accountId);

        return sessionRepository.save(session);
    }

    public void endSession(String sessionId) {
        sessionRepository.endSession(sessionId);
    }

    public Session getCurrentSession(String atmId) {
        return sessionRepository.findActiveByATM(atmId).orElse(null);
    }

    public void handleSessionTimeout(String sessionId) {
        // TODO: Implement session timeout logic
        endSession(sessionId);
    }

    public Session getSession(String sessionId) {
        return sessionRepository.findById(sessionId).orElse(null);
    }
}
