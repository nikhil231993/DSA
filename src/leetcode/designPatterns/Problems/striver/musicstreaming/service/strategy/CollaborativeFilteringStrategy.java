package leetcode.designPatterns.Problems.striver.musicstreaming.service.strategy;

import leetcode.designPatterns.Problems.striver.musicstreaming.domain.ListeningHistory;
import leetcode.designPatterns.Problems.striver.musicstreaming.domain.Song;

import java.util.*;

public class CollaborativeFilteringStrategy implements RecommendationStrategy {
    @Override
    public List<Song> generate(String userId, List<ListeningHistory> history) {
        // TODO: Find users with similar listening patterns
        // TODO: Recommend songs they listened to but current user hasn't
        // Complex algorithm - simplified for interview
        return Collections.emptyList();
    }
}
