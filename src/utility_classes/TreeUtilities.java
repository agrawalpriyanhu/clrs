package utility_classes;

public class TreeUtilities {
    private static Node[] nodes = new Node[20];
    public static Node createBinarySearchTree(){
        for (int i = 0; i < 20; i++){
            nodes[i] = new Node(2*i);
        }
        setParentAndChild(0, 1, -1, -1);
        setParentAndChild(1, 3, 0,2);
        setParentAndChild(2, 1, -1, -1);
        setParentAndChild(3, 7,1,5);
        setParentAndChild(4, 5, -1, -1);
        setParentAndChild(5, 3, 4, 6);
        setParentAndChild(6, 5, -1, -1);
        setParentAndChild(7, 12, 3, 10);
        setParentAndChild(8, 9, -1, -1);
        setParentAndChild(9, 10, 8, -1);
        setParentAndChild(10, 7, 9, 11);
        setParentAndChild(11, 10, -1, -1);
        setParentAndChild(12, -1, 7, 16);
        setParentAndChild(13, 14, -1, -1);
        setParentAndChild(14, 16, 13, 15);
        setParentAndChild(15, 14, -1, -1);
        setParentAndChild(16, 12, 14, 18);
        setParentAndChild(17, 18, -1, -1);
        setParentAndChild(18, 16, 17, 19);
        setParentAndChild(19, 18, -1, -1);
        return nodes[12];
    }

    private static void setParentAndChild(int nodeIndex, int parentIndex, int leftIndex, int rightIndex) {
        if (parentIndex != -1)
            nodes[nodeIndex].setParent(nodes[parentIndex]);
        if (rightIndex != -1)
            nodes[nodeIndex].setRight(nodes[rightIndex]);
        if(leftIndex != -1)
            nodes[nodeIndex].setLeft(nodes[leftIndex]);
    }

    public static Node[] getNodes(){
        return nodes;
    }
}
