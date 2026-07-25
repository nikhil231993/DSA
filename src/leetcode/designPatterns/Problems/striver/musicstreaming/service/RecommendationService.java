package leetcode.designPatterns.Problems.striver.musicstreaming.service;

import leetcode.designPatterns.Problems.striver.musicstreaming.domain.ListeningHistory;
import leetcode.designPatterns.Problems.striver.musicstreaming.domain.Song;
import leetcode.designPatterns.Problems.striver.musicstreaming.repository.ListeningHistoryRepository;
import leetcode.designPatterns.Problems.striver.musicstreaming.service.strategy.RecommendationStrategy;

import java.util.List;

public class RecommendationService {
    private ListeningHistoryRepository listeningHistoryRepository;
    private RecommendationStrategy strategy;

    public RecommendationService(ListeningHistoryRepository listeningHistoryRepository,
                                 RecommendationStrategy strategy) {
        this.listeningHistoryRepository = listeningHistoryRepository;
        this.strategy = strategy;
    }

    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Song> getRecommendations(String userId) {
        List<ListeningHistory> history = listeningHistoryRepository.findByUserId(userId);
        return strategy.generate(userId, history);
    }
}
