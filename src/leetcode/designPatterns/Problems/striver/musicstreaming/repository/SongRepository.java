package leetcode.designPatterns.Problems.striver.musicstreaming.repository;

import leetcode.designPatterns.Problems.striver.musicstreaming.domain.Song;

import java.util.List;
import java.util.Optional;

public interface SongRepository {
    Song save(Song song);
    Optional<Song> findById(String id);
    Optional<Song> findBySongId(String songId);
    List<Song> findByTitle(String title);
    List<Song> findByArtistId(String artistId);
    List<Song> findByAlbumId(String albumId);
    List<Song> findByGenre(String genre);
    List<Song> findAllByIds(List<String> songIds);
}
