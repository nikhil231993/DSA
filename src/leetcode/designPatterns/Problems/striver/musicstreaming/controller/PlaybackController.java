package leetcode.designPatterns.Problems.striver.musicstreaming.controller;

import leetcode.designPatterns.Problems.striver.musicstreaming.domain.PlaybackSource;
import leetcode.designPatterns.Problems.striver.musicstreaming.domain.RepeatMode;
import leetcode.designPatterns.Problems.striver.musicstreaming.service.PlaybackService;

public class PlaybackController {
    private PlaybackService playbackService;

    public PlaybackController(PlaybackService playbackService) {
        this.playbackService = playbackService;
    }

    public PlaybackService.PlaybackStateResponse play(String userId, PlaybackSource sourceType, String sourceId, Long startPosition) {
        return playbackService.play(userId, sourceType, sourceId, startPosition);
    }

    public PlaybackService.PlaybackStateResponse pause(String sessionId) {
        return playbackService.pause(sessionId);
    }

    public PlaybackService.PlaybackStateResponse resume(String sessionId) {
        return playbackService.resume(sessionId);
    }

    public PlaybackService.PlaybackStateResponse skipNext(String sessionId) {
        return playbackService.skipNext(sessionId);
    }

    public PlaybackService.PlaybackStateResponse skipPrevious(String sessionId) {
        return playbackService.skipPrevious(sessionId);
    }

    public PlaybackService.PlaybackStateResponse getState(String sessionId) {
        return playbackService.getState(sessionId);
    }

    public PlaybackService.PlaybackStateResponse toggleShuffle(String sessionId, boolean enabled) {
        return playbackService.toggleShuffle(sessionId, enabled);
    }

    public PlaybackService.PlaybackStateResponse setRepeatMode(String sessionId, RepeatMode mode) {
        return playbackService.setRepeatMode(sessionId, mode);
    }

    // Called in constant intervals.
    public void updatePosition(String sessionId, long position) {
        playbackService.updatePosition(sessionId, position);
    }
}

