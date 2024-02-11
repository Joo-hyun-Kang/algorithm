public class MyLinkedList {
    private Node root;

    public MyLinkedList() {
    }

    // 1 -> 5
    // 3 -> 7

    // remove

    public void add(int key, int value) {
        Node targetNode = TryGetIndexAndNull(key);
        if (targetNode == null) {
            Node lastNode = TryFindLastNodeOrNull();
            SetNewNode(lastNode, key, value);
        } else {
            targetNode.setValue(value);
        }
    }

    private void SetNewNode(Node node, int key, int value) {
        if (node == null) {
            root = new Node(key, value);
            return;
        }
        else {
            node.setNextNode(new Node(key, value));
        }
        Node newNode = node.getNextNode();
        newNode.setPreNode(node);
    }

//    public void remove(int key) {
//        Node node = TryGetIndexAndNull(key);
//        if (node == null) {
//            return ;
//        }
//
//        // remove node and connect pre and post Node
//
//
//    }

    private Node TryGetIndexAndNull(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.getKey()) {
                return current;
            }

            current = current.getNextNode();
        }

        return null;
    }

    public void PrintAllNode() {
        if (root == null) {
            System.out.println("No Value");
            return ;
        }

        StringBuilder builder = new StringBuilder();

        Node current = root;
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

    private Node TryFindLastNodeOrNull() {
        if (root == null) {
            return null;
        }

        Node current = root;
        Node nextNode = root;

        nextNode = nextNode.getNextNode();
        while (nextNode != null) {
            current = current.getNextNode();
            nextNode = nextNode.getNextNode();
        }

        return current;
    }

}
