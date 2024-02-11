import java.util.HashMap;
import java.util.Map;

public class MyLinkedList {
    private Node root;

    public MyLinkedList() {
    }

    public void add(int key, int value) {
        Node targetNode = TryGetIndexAndNull(key);
        if (targetNode == null) {
            Node lastNode = TryFindLastNodeOrNull();
            SetNewNode(lastNode, key, value);
        } else {
            targetNode.setValue(value);
        }
    }

    public void remove(int key) {
        Node targetNode = TryGetIndexAndNull(key);
        if (targetNode == null) {
            return ;
        }

        if (targetNode == root) {
            if (root.getNextNode() == null) {
                root = null;
            } else {
                Node nextNode = root.getNextNode();
                nextNode.setPreNode(null);

                root = nextNode;
            }

        } else {
            Node preNode = targetNode.getPreNode();
            Node nextNode = targetNode.getNextNode();

            preNode.setNextNode(nextNode);
            if (nextNode != null) {
                nextNode.setPreNode(preNode);
            }

            targetNode.setPreNode(null);
            targetNode.setNextNode(null);
        }
    }

    public int getValue(int key) {
        Node targetNode = TryGetIndexAndNull(key);
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

}
