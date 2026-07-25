package leetcode.designPatterns.Problems.striver.musicstreaming.repository;

import leetcode.designPatterns.Problems.striver.musicstreaming.domain.PlaybackSession;

import java.util.Optional;

public interface PlaybackSessionRepository {
    PlaybackSession save(PlaybackSession session);
    Optional<PlaybackSession> findBySessionId(String sessionId);
    Optional<PlaybackSession> findByUserId(String userId);
}
