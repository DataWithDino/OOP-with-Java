package a3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Song extends AbstractSong{
    private final ArrayList<Line> zeilen= new ArrayList<>();
    public Song(Line... lines){
        Collections.addAll(zeilen, lines);
    }
    @Override
    public Line getLine(int index) {
        if(index>zeilen.size()){
            throw new IndexOutOfBoundsException();
        }
        return zeilen.get(index);
    }

    @Override
    public int length() {
        return zeilen.size();
    }
    @Override
    public int numberOfStrophes(){
        int count = 0;
        for(Line line:zeilen){
            if (line == getRefrain()){
                count+=1;
            }
        }
        return count;
    }
}
