import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        ArrayList<Integer> intergerList = new ArrayList<>(Collections.nCopies(size, 0));

        intergerList.set(3, 5);
        int i = 0;
        for (Integer integer : intergerList) {
            System.out.printf("%d(%d) ", integer, i++);
        }

    }
}