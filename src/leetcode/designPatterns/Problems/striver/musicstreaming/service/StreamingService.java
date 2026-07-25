package leetcode.designPatterns.Problems.striver.musicstreaming.service;

import leetcode.designPatterns.Problems.striver.musicstreaming.domain.AudioQuality;
import leetcode.designPatterns.Problems.striver.musicstreaming.domain.Song;
import leetcode.designPatterns.Problems.striver.musicstreaming.domain.SubscriptionTier;
import leetcode.designPatterns.Problems.striver.musicstreaming.domain.User;
import leetcode.designPatterns.Problems.striver.musicstreaming.repository.SongRepository;
import leetcode.designPatterns.Problems.striver.musicstreaming.repository.UserRepository;

import java.util.Optional;

public class StreamingService {
    private SongRepository songRepository;
    private UserRepository userRepository;
    private CacheService cacheService;

    public StreamingService(SongRepository songRepository, UserRepository userRepository,
                            CacheService cacheService) {
        this.songRepository = songRepository;
        this.userRepository = userRepository;
        this.cacheService = cacheService;
    }

    public String getStreamUrl(String songId, String userId) {
        Optional<Song> songOpt = songRepository.findBySongId(songId);
        if (songOpt.isEmpty()) {
            throw new IllegalArgumentException("Song not found: " + songId);
        }

        // Determine quality based on subscription tier
        Optional<User> userOpt = userRepository.findById(userId);
        AudioQuality quality = AudioQuality.STANDARD;
        if (userOpt.isPresent() && userOpt.get().getSubscriptionTier() == SubscriptionTier.PREMIUM) {
            quality = AudioQuality.PREMIUM;
        }

        Song song = songOpt.get();
        // TODO: Generate actual stream URL with quality parameter
        return song.getAudioUrl() + "?quality=" + quality.name();
    }

    public byte[] getChunk(String songId, long start, long end) {
        // Check cache first
        Optional<byte[]> cachedChunk = cacheService.getChunk(songId, start, end);
        if (cachedChunk.isPresent()) {
            return cachedChunk.get();
        }

        // TODO: Fetch from CDN/storage
        // For interview, return mock data
        byte[] chunk = new byte[(int)(end - start + 1)];
        // In production: fetch from CDN using HTTP range request

        // Cache the chunk
        // Do this in bg to unblock request handling thread
        // TTL to be 1 hour
        cacheService.putChunk(songId, start, end, chunk);

        return chunk;
    }

    public void downloadFullSong(String songId, String deviceId) {
        // TODO: Download full song and store in device cache
        // This would be async in production
    }
}
