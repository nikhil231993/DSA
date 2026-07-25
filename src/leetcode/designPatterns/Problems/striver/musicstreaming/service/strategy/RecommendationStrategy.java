package leetcode.designPatterns.Problems.striver.musicstreaming.service.strategy;

import leetcode.designPatterns.Problems.striver.musicstreaming.domain.ListeningHistory;
import leetcode.designPatterns.Problems.striver.musicstreaming.domain.Song;

import java.util.List;

public interface RecommendationStrategy {
    List<Song> generate(String userId, List<ListeningHistory> history);
}
