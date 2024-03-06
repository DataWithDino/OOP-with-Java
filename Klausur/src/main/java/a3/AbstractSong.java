package a3;

public abstract class AbstractSong implements ISong{

    @Override
    public String toString(){
        StringBuilder songText = new StringBuilder();

        for (int i = 0; i < length(); i++) {
            Line line = getLine(i);
            if (line != null) {
                songText.append(line).append("\n");
            }
        }return songText.toString();
    }
}
