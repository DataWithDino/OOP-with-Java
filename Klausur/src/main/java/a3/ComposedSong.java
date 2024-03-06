package a3;

public class ComposedSong extends AbstractSong{
    private final ISong  first;
    private final ISong second;
    public ComposedSong(ISong first, ISong second){
        if (first.getRefrain()!=second.getRefrain()){
            throw new IllegalArgumentException("Refrain muss gleich sein");
        }
        this.first=first;
        this.second=second;
    }

    @Override
    public Line getLine(int index) {
        if(index>first.length()+second.length()){
            throw new IndexOutOfBoundsException();
        }
        if(index>first.length()){
            return second.getLine(index-first.length());
        }
        return first.getLine(index);
    }

    @Override
    public int length() {
        return first.length()+second.length();
    }

    @Override
    public int numberOfStrophes() {
        return 0;
    }
}
