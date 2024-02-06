import java.util.ArrayList;
import java.util.Arrays;


class MyHashMap {
    int[] values;
    final int initalValue = 1000001;

    public MyHashMap() {
        values = new int[initalValue];

        Arrays.fill(values, -1);
//        why inital ?
//        for (int value : values) {
//            value = -1;
//        }
    }

    public void put(int key, int value) {
        // If the key already exists in the map, update the corresponding value.
        if (key < 0 || key > initalValue - 1) {
            return;
        }

        values[key] = value;
    }

    public int get(int key) {
        //or -1 if this map contains no mapping for the key.
        if (key < 0 || key > initalValue - 1) {
            return 0;
        }

        return values[key];
    }

    public void remove(int key) {
        if (key < 0 || key > initalValue - 1) {
            return ;
        }

        values[key] = -1;
    }

    public int hashCode(int value) {
        byte[] array = intToByteArray(value);

        int hash = 0;
        for (int i = 0; i < array.length; i++)
        {
            hash += array[i];
        }

        return hash;
    }

    private byte[] intToByteArray(int value) {
        return new byte[] {
                (byte)(value >>> 24),
                (byte)(value >>> 16),
                (byte)(value >>> 8),
                (byte)value};
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */