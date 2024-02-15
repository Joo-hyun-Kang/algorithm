package submit;


class MyHashMap {
    MyLinkedList2[] list;
    SimpleHashCode2 hashFunction;
    final int initialSize = 257;

    public MyHashMap() {
        list = new MyLinkedList2[initialSize];
        for (int i = 0; i < list.length; i++) {
            list[i] = new MyLinkedList2();
        }

        this.hashFunction = new SimpleHashCode2();
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

    static class MyLinkedList2 {
        private Node2 root;

        public MyLinkedList2() {
        }

        public void add(int key, int value) {
            Node2 targetNode = TryGetIndexAndNull(key);
            if (targetNode == null) {
                Node2 lastNode = TryFindLastNodeOrNull();
                SetNewNode(lastNode, key, value);
            } else {
                targetNode.setValue(value);
            }
        }

        public void remove(int key) {
            Node2 targetNode = TryGetIndexAndNull(key);
            if (targetNode == null) {
                return ;
            }

            if (targetNode == root) {
                if (root.getNextNode() == null) {
                    root = null;
                } else {
                    Node2 nextNode = root.getNextNode();
                    nextNode.setPreNode(null);

                    root = nextNode;
                }

            } else {
                Node2 preNode = targetNode.getPreNode();
                Node2 nextNode = targetNode.getNextNode();

                preNode.setNextNode(nextNode);
                if (nextNode != null) {
                    nextNode.setPreNode(preNode);
                }

                targetNode.setPreNode(null);
                targetNode.setNextNode(null);
            }
        }

        public int getValue(int key) {
            Node2 targetNode = TryGetIndexAndNull(key);
            if (targetNode == null) {
                return -1;
            }
            return targetNode.getValue();
        }

        public void PrintAllNode() {
            if (root == null) {
                System.out.println("No Value");
                return ;
            }

            StringBuilder builder = new StringBuilder();

            Node2 current = root;
            builder.append(current.getKey());
            builder.append(" ");
            builder.append(current.getValue());
            builder.append(", ");

            while (current.getNextNode() != null) {
                current = current.getNextNode();
                builder.append(current.getKey());
                builder.append(" ");
                builder.append(current.getValue());
                builder.append(", ");
            }

            System.out.println(builder.toString());
        }

        private Node2 TryGetIndexAndNull(int key) {
            Node2 current = root;
            while (current != null) {
                if (key == current.getKey()) {
                    return current;
                }

                current = current.getNextNode();
            }

            return null;
        }

        private Node2 TryFindLastNodeOrNull() {
            if (root == null) {
                return null;
            }

            Node2 current = root;
            Node2 nextNode = root;

            nextNode = nextNode.getNextNode();
            while (nextNode != null) {
                current = current.getNextNode();
                nextNode = nextNode.getNextNode();
            }

            return current;
        }

        private void SetNewNode(Node2 node, int key, int value) {
            if (node == null) {
                root = new Node2(key, value);
                return;
            }
            else {
                node.setNextNode(new Node2(key, value));
            }
            Node2 newNode = node.getNextNode();
            newNode.setPreNode(node);
        }

    }


    static class SimpleHashCode2 {
        public Object hashcodeOrNull(Object value) {
            if (value == null) {
                return null;
            }

            int valueInt = (Integer) value;
            byte[] array = intToByteArray(valueInt);

            int hash = 0;
            for (byte b : array) {
                // 常に正の数がなるようにする
                int positiveByte = b & 0xFF;
                hash += positiveByte;
            }

            return hash;
        }

        public int calculateCollision() {
            final int TEST_RANGE = 1_000_000;
            int[] counts = new int[TEST_RANGE];

            for (int i = 0; i < TEST_RANGE; i++) {
                Integer value = (Integer) hashcodeOrNull(i);
                if (value == null) {
                    return -1;
                }

                counts[i]++;
            }

            int collision = 0;
            for (int count : counts) {
                if (count > 1) {
                    collision++;
                }
            }

            return collision;
        }

        private byte[] intToByteArray(int value) {
            return new byte[] {
                    (byte)(value >>> 24),
                    (byte)(value >>> 16),
                    (byte)(value >>> 8),
                    (byte)value};
        }
    }


    public static class Node2 {
        private int key;
        private int value;
        private Node2 preNode;
        private Node2 nextNode;


        public Node2(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public Node2 getPreNode() {
            return preNode;
        }

        public void setPreNode(Node2 preNode) {
            this.preNode = preNode;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node2 getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node2 nextNode) {
            this.nextNode = nextNode;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */