import java.util.Arrays;


class MyHashMap {
    MyLinkedList[] list;
    Hash hashFunction;
    final int initialSize = 257;

    public MyHashMap(Hash hashFunction) {
        list = new MyLinkedList[initialSize];
        for (int i = 0; i < list.length; i++) {
            list[i] = new MyLinkedList();
        }

        this.hashFunction = hashFunction;
    }

    public void put(int key, int value) {
        // If the key already exists in the map, update the corresponding value.
        Integer index = getHashKeyOrNull(key);
        if (index == null) {
            return;
        }

        list[index].add(key, value);
    }

    public int get(int key) {
        //or -1 if this map contains no mapping for the key.
        Integer index = getHashKeyOrNull(key);
        if (index == null) {
            return -1;
        }

        return list[index].getValue(key);
    }

    public void remove(int key) {
        Integer index = getHashKeyOrNull(key);
        if (index == null) {
            return ;
        }

        list[index].remove(key);
    }

    private Integer getHashKeyOrNull(int key) {
        Integer hashedKey = (Integer) hashFunction.hashcodeOrNull(key);
        if (hashedKey == null) {
            assert (hashedKey != null);
            return null;
        }

        return hashedKey % initialSize;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */