import java.util.ArrayList;


class MyHashMap {
    private ArrayList<Integer> indexOfArray;
    private ArrayList<Integer> values;

    public MyHashMap() {
        //'+ 1' make size of Array to 257 that is nearist Prime Number 
        indexOfArray = new ArrayList<>();
        values = new ArrayList<>();
    }

    public void put(int key, int value) {
        // If the key already exists in the map, update the corresponding value.
        if (indexOfArray.contains(key)) {
            int position = convertValuesOfIndex(key);

            values.add(position, value);
            values.remove((Integer) key);

        } else {
            indexOfArray.add(key);
            values.add(value);
        }
    }

    public int get(int key) {
        //or -1 if this map contains no mapping for the key.
        //return hashArray.get(hashCode(key)).get(0);
        if (!indexOfArray.contains(key))
        {
            return -1;
        }

        return values.get(convertValuesOfIndex(key));
    }

    public void remove(int key) {
        if (indexOfArray.contains(key))
        {
            values.remove(convertValuesOfIndex(key));
            indexOfArray.remove((Integer) key);
        }
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

    public void printHashMap() {
        for (int i = 0; i < indexOfArray.size(); i++)
        {
            System.out.printf("%d : %d \n", indexOfArray.get(i), values.get(i));
        }
        System.out.println();
    }

    private int convertValuesOfIndex(int hashMapKey) {
        return indexOfArray.indexOf(hashMapKey);
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