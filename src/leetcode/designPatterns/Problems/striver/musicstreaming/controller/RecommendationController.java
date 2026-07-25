package leetcode.designPatterns.Problems.striver.musicstreaming.controller;

import leetcode.designPatterns.Problems.striver.musicstreaming.domain.Song;
import leetcode.designPatterns.Problems.striver.musicstreaming.service.RecommendationService;

import java.util.List;

public class RecommendationController {
    private RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    public List<Song> getRecommendations(String userId) {
        return recommendationService.getRecommendations(userId);
    }
}
