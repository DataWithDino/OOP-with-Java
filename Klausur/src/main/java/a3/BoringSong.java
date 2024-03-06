package a3;

public class BoringSong extends ComposedSong{
    public BoringSong(ISong song){
        super(song, song);
    }
}
