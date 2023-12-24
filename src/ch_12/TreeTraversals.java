package ch_12;

import utility_classes.Node;
import utility_classes.TreeUtilities;

public class TreeTraversals {

    public static void inOrderTraversal(Node node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.getLeft());
        System.out.print(" " + node.getKey());
        inOrderTraversal(node.getRight());
    }

    public static void preOrderTraversal(Node node){
        if (node == null){
            return;
        }
        System.out.print(" " + node.getKey());
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    public static void postOrderTraversal(Node node){
        if (node == null){
            return;
        }
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.print(" " + node.getKey());
    }

    public static void treeTraversalDriverCode(){
        Node node = TreeUtilities.createBinarySearchTree();
        System.out.println("--------------------- In Order Traversal -----------------");
        inOrderTraversal(node);
        System.out.println("\n--------------------- Pre Order Traversal -----------------");
        preOrderTraversal(node);
        System.out.println("\n--------------------- Post Order Traversal -----------------");
        postOrderTraversal(node);
    }


}
