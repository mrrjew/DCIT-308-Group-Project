package src.utils;

public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        T data;
        Node left, right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a new element into the BST
    public void insert(T data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node node, T data) {
        if (node == null) {
            return new Node(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRecursive(node.right, data);
        }

        return node;
    }

    // Search for a specific element in the BST
    public T search(T data) {
        Node result = searchRecursive(root, data);
        if (result != null) {
            return result.data;
        }
        return null;
    }

    private Node searchRecursive(Node node, T data) {
        if (node == null || data.equals(node.data)) {
            return node;
        }

        if (data.compareTo(node.data) < 0) {
            return searchRecursive(node.left, data);
        } else {
            return searchRecursive(node.right, data);
        }
    }

    // Delete an element from the BST
    public void delete(T data) {
        root = deleteRecursive(root, data);
    }

    private Node deleteRecursive(Node node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = deleteRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = deleteRecursive(node.right, data);
        } else {
            // Node to be deleted found
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.data = findMin(node.right).data;
            node.right = deleteRecursive(node.right, node.data);
        }

        return node;
    }

    // Find the minimum node in the BST
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // In-order traversal of the tree to display all elements
    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println(node.data);
            inOrderRecursive(node.right);
        }
    }
}
