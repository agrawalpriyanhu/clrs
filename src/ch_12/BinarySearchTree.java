package ch_12;

import utility_classes.Node;
import utility_classes.TreeUtilities;

public class BinarySearchTree {

    public static Node binarySearch(Node root, int key){
        Node temp = root;
        while (temp != null && temp.getKey() != key){
            if (temp.getKey() > key){
                temp = temp.getLeft();
            }
            else {
                temp = temp.getRight();
            }
        }
        return temp;
    }

    public static Node binarySearchMinimum(Node root){
        if (root == null){
            return root;
        }
        Node temp = root;
        while (temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp;
    }

    public static Node binarySearchMaximum(Node root){
        if (root == null){
            return root;
        }
        Node temp = root;
        while (temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp;
    }

    public static Node treeSuccessor(Node x){
        if (x == null)
            return null;
        if (x.getRight() != null){
            return binarySearchMinimum(x.getRight());
        }
        Node parent = x.getParent();
        while (parent != null && parent.getLeft() != x){
            x = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    public static Node treePredecessor(Node x){
        if (x == null)
            return x;
        if (x.getLeft() != null)
            return binarySearchMaximum(x.getLeft());
        Node parent = x.getParent();
        while (parent != null && parent.getRight() != x){
            x = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    public static void bstInsert(Node root, Node node){
        if (root == null){
            root = node;
        }
        Node temp = root, nodeParent = null;
        while (temp != null){
            nodeParent = temp;
            if (temp.getKey() > node.getKey()){
                temp = temp.getLeft();
            }
            else {
                temp = temp.getRight();
            }
        }
        node.setParent(nodeParent);
        if (node.getKey() > nodeParent.getKey())
            nodeParent.setRight(node);
        else
            nodeParent.setLeft(node);
    }

    public static void bstDelete(Node x){
        // when x has no child
        if (x.getLeft() == null && x.getRight() == null){
            if (x.getParent().getRight() == x){
                x.getParent().setRight(null);
            }
            else {
                x.getParent().setLeft(null);
            }
        }
        // When x has only one child
        else if (x.getLeft() == null || x.getRight() == null) {
            if (x.getParent().getLeft() == x){
                x.getParent().setLeft(x.getRight() == null ? x.getLeft() : x.getRight());
            }
            else {
                x.getParent().setRight(x.getRight() == null ? x.getLeft() : x.getRight());
            }
        }
        // When x has both children
        else {
            Node successor = treeSuccessor(x);
            x.setKey(successor.getKey());
            bstDelete(successor);
        }
    }

// --------------------  DRIVER METHODS BELOW ----------------------------------
    public static void binarySearchDriverCode(){
        Node root = TreeUtilities.createBinarySearchTree();
        Node found = binarySearch(root, 28);
        System.out.println("For key 28 " + (found == null ? null : found.getKey()));
        found = binarySearch(root, 13);
        System.out.println("For key 13 " + (found == null ? null : found.getKey()));
    }

    public static void binarySearchMinimumDriverCode(){
        Node root = TreeUtilities.createBinarySearchTree();
        Node min = binarySearchMinimum(root);
        System.out.println( "Minimum = " + (min == null ? null : min.getKey()));
    }

    public static void binarySearchMaximumDriverCode(){
        Node root = TreeUtilities.createBinarySearchTree();
        Node max = binarySearchMaximum(root);
        System.out.println( "Minimum = " + (max == null ? null : max.getKey()));
    }

    public static void treeSuccessorDriverCode(){
        TreeUtilities.createBinarySearchTree();
        Node[] nodes = TreeUtilities.getNodes();
        Node successor = treeSuccessor(nodes[4]);
        System.out.println( "successor of 8 = " + (successor == null ? null : successor.getKey()));
    }

    public static void treePredecessorDriverCode(){
        TreeUtilities.createBinarySearchTree();
        Node[] nodes = TreeUtilities.getNodes();
        Node predecessor = treePredecessor(nodes[4]);
        System.out.println( "predecessor of 8 = " + (predecessor == null ? null : predecessor.getKey()));
    }

    public static void bstInsertDriverCode(){
        Node root = TreeUtilities.createBinarySearchTree();
        bstInsert(root, new Node(9));
        TreeTraversals.inOrderTraversal(root);
    }

    public static void bstDeleteDriverCode(){
        Node root = TreeUtilities.createBinarySearchTree();
        Node[] nodes = TreeUtilities.getNodes();
        bstDelete(nodes[3]);
        TreeTraversals.inOrderTraversal(root);
    }

}
