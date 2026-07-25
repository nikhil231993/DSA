package leetcode.designPatterns.Problems.striver.musicstreaming.service.strategy;

import leetcode.designPatterns.Problems.striver.musicstreaming.domain.ListeningHistory;
import leetcode.designPatterns.Problems.striver.musicstreaming.domain.Song;
import leetcode.designPatterns.Problems.striver.musicstreaming.repository.SongRepository;

import java.util.*;

public class PopularityBasedStrategy implements RecommendationStrategy {
    private SongRepository songRepository;

    public PopularityBasedStrategy(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> generate(String userId, List<ListeningHistory> history) {
        // TODO: Return most popular songs (would need popularity score in Song entity)
        // For interview, return random songs
        return Collections.emptyList();
    }
}
