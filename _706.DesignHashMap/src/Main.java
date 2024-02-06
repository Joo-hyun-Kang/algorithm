import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Arraylistような自動的にソートなれないデータ構造しよう。。

        {
            System.out.println("\n====From Leetcode Test=====");

            MyHashMap myHashMap = new MyHashMap();

            myHashMap.put(1, 1); // The map is now [[1,1]]
            myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]

            int values = myHashMap.get(1);// return 1, The map is now [[1,1], [2,2]]
            assert (values == 1);

            values = myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
            assert (values == -1);

            myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)

            values = myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
            assert (values == 1);

            myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]

            values = myHashMap.get(2);// return -1 (i.e., not found), The map is now [[1,1]]
            assert (values == -1);
        }


    }
}