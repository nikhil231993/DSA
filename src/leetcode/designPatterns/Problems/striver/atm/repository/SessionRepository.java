package leetcode.designPatterns.Problems.striver.atm.repository;

import leetcode.designPatterns.Problems.striver.atm.domain.Session;

import java.util.Optional;

public interface SessionRepository {
    Session save(Session session);

    Optional<Session> findById(String sessionId);

    Optional<Session> findActiveByATM(String atmId);

    void endSession(String sessionId);
}
