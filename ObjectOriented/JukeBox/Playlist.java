package JukeBox;

import java.util.Queue;

public class Playlist {
    private Song song ;
    private Queue<Song> songs;
    public Playlist(Song song, Queue<Song> songs) {
        this.song = song;
        this.songs = songs;
    }
    public Song getNextSong(){
        return songs.peek();
    }
    public void queueUpSong(Song song){
        songs.add(song);
    }
    public boolean isEmpty(){
        return songs.isEmpty();
    }
}
