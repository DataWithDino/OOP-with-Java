package a2;

public class Main {

    public static void main(String[] args) {
        Train train = new Train();
        for (int i = 0; i < 1; i++) {
            train.insertFirst();
        }
        for (int i = 0; i < 3; i++) {
            train.insertSecond();
        }
        System.out.println(train);
    }
}
