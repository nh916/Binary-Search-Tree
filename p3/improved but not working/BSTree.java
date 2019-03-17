//Name: Navid Hariri
//Date:12/8/2018
//assignment:Binary Search Tree Project 3

import java.util.ArrayList;
import java.util.Collections;


public class BSTree<E extends Comparable<E>> {

//    todo the master sample keeps only the max and the average

//    todo the max and size should currently match
//    do i put the length/size/height of the tree in the size? no. nodeleve max gives you that already
//          what does he exactly mean by the size of the tree? i dont think he said that
//    and besides just the height is there anything else that he wants? max and on average where are most of the nodes
//  is it the falling height or is it the number of nodes? which way does he want me to calculate it


//    todo sometimes the height comes out wrong after deletion. Why? who cares. i dont think he asked for that, but it could be that my deletion and the animation are different

//    TODO nodeLevel definition
//    oh he wants you to get the height of the tree and report the max of the 1000 runs and the average. then compare that with what an expected binary search tree would be doing


//    do we need a full/balanced tree or does it not matter cant be its random and in result we see what it would be vs a full tree theoretically


//    todo do i need a comapreTo method in node? currently not using CompareTo. I think that needs to change
//    use compare to instead of the < or >

//    todo element should be a BSTElement, and not E element. right? because it needs to be generic

//    todo how do we do nodeLevel and get the average and the max
//      it basically does an inorder traversal of all the nodes and gets their height from least node and gets the height from that node to the root and adds that to the arraylist. At the end it gets the height, which is also the longest node, and it basically gets how many other ones were at that level
//    there should be 6 lines of answers for this program and only with the max and average. The max node level from the roo and the average level from the root.


//    todo is everything I am currently doing generic or is it based on int?
//    todo does it NEED to be based on generics?
//    todo should i have <E> for all the places where I am using anything I created?

//    todo check assertion in verify and see if it really works

//    todo should power be private or public? int or double?

//    todo make sure that the things being initialized in the constructor are correct. is method call good practice currently. from him its just a style thing but whats a better style

//    todo how to use an assertion for verifyInorder?
//    todo both verification needs to be tested and tried

    private BSTNode<E> root;

    private int size;
    private int power;


    private ArrayList<Integer> key;

//    this ArrayList can be used to keep the half deleted to reinsert. That way we could delete any half from either beginning, middle, end, or whichever way we want to delete the half. That way its in the ArrayList and we can replace it back at any time we want
//    private ArrayList<Integer> halfOfBST;



    //constructor
    public BSTree(int power) {
        root = null;
        this.power = power;
        key = new ArrayList<Integer>();
//        halfOfBST = new ArrayList<Integer>();

        initializeTree();
    }


    private void initializeTree() {
        int n = (int) Math.pow(2, power) - 1;
        for (int i = 0; i < n; i++) {
            this.key.add(i);
        }
        Collections.shuffle(key);
    }





    public void create() {
        for (int i = 0; i < key.size(); i++) {
//            halfOfBST.add(key.get(i));

            insert(root, new BSTNode<E>(key.get(i)));
        }
    }


    public void deleteHalf() {
        int half = key.size() / 2;

        for (int i = 0; i < half; i++) {
//            the way we did with Ian. should this be gone??
//            delete(root, new BSTNode<E>(key.get(i)));

//            the way with deleting from anywhere
//            halfOfBST.add(key.get(i));
            deleteKey(key.get(i));

// we can also do delete with an ArrayList as well so we dont have to just delete and insert from the begining and we can delete from anywhere and the half we changed will always be there to put back. More flexibility
//            for (int j = 0; j < halfOfBST.size(); j++) {
//                deleteKey(halfOfBST.get(i));
//            }

        }

    }


    public void reinsert() {
        int half = key.size() / 2;
        for (int i = 0; i < half; i++) {
            insert(key.get(i));
        }

//        or
//        for (int i = 0; i < halfOfBST.size(); i++) {
//            insert(halfOfBST.get(i));
//        }
    }






    public void inorder() {
        inorder(root);
    }

//also pass in a sample object for it to add the number to in visit order
    private void inorder(BSTNode<E> node) {
        if (node == null)
            return;

//         first recur on left child
        inorder(node.getLeft());

//        visit
//        Sample allTheNodes = new Sample("look inside tree");
//        allTheNodes.add(node.getData());
//        System.out.print(allTheNodes);

//         now recur on right child
        inorder(node.getRight());
    }


    public void insert(E target) {
//        todo does this "root= ..."    make sense
        root = insert(root, new BSTNode<E>(target));
    }


    private BSTNode<E> insert(BSTNode<E> node, BSTNode<E> target) {
//        we are at a leaf, (no lef or right)
        if (node == null) {
            size++;
            return target;
        }
        if (node.compareTo(target) > 0) {
            // node.key > nNode.key
//            inserting to the left
            node.setLeft(insert(node.getLeft(), target));
        }
//            inserting to the right
        else {
            node.setRight(insert(node.getRight(), target));
        }
        return node;
    }







    // do we count the root or not? also does he want the height of it or the amount of nodes in it??
    public int height(BSTNode<E> node) {
        if (node == null) {
            return 0;
        }

        int lefth = height(node.getLeft());
        int righth = height(node.getRight());

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }



//    todo how can i test the assertion to make sure that it is working?
//    todo this is currently useless because I cannot be sure that the tree is verified from my driver class.

//        public boolean verify(BSTNode root) {
    public boolean verify() {
        if (root == null) {
            return true;
        } else {
            return verify(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    private boolean verify(BSTNode<E> root, Integer minValue, Integer maxValue) {
        if (root == null) {
            return true;
        }
        assert(root.getData() >= minValue && root.getData() < maxValue && verify(root.getLeft(), minValue, root.getData()) && verify(root.getRight(), root.getData(), maxValue));
            return true;
    }


//    second verify that uses inOrder traversal that checks to see if the tree is verified
    public boolean verifyInorder(){
        return verifyInorder(root);
    }

    public boolean verifyInorder(BSTNode<E> root){
        if (root == null){
            return true;
        }
        else {
            return verifyInorder(root.getLeft()) && verifyInorder(root.getRight()) && compare(root, root.getLeft(), true) && compare(root,root.getRight(),false);
        }

    }

    public boolean compare(BSTNode<E> parent, BSTNode<E> child, boolean isLeft){
        if (child == null){
            return true;
        }
        if (isLeft){
            return parent.getData() > child.getData();
        }
        else {
            return parent.getData() <= child.getData();
        }
    }





//    This method mainly calls deleteRec()
    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }


//     A recursive function to insert a new key in BST
    private BSTNode<E> deleteRec(BSTNode<E> root, int key){
//         Base Case: If the tree is empty
        if (root == null) {
//            return root;
            return null;
        }

//         Otherwise, recur down the tree
        if (key < root.getData()) {
            root.setLeft(deleteRec(root.getLeft(), key));
        }

        else if (key > root.getData()) {
            root.setRight(deleteRec(root.getRight(), key));
        }

            // if key is same as root's key, then This is the node
            // to be deleted
        else {
            // node with only one child or no child
            if (root.getLeft() == null) {
                size--;
                return root.getRight();
            }
            else if (root.getRight() == null) {
                size--;
                return root.getLeft();
            }

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            else {

                root.set(minValue(root.getRight()));

                // Delete the inorder successor
                root.setRight(deleteRec(root.getRight(), root.getData()));
            }
        }

        return root;
    }

//    find the successor
    private int minValue(BSTNode<E> root){

//        int minv = root.getData();
//        while (root.getLeft() != null){
//            minv = root.getLeft().getData();
//            root = root.getLeft();
//        }
//        return minv;

        if (root.getLeft() == null){
            return root.getData();
        }
        else {
            return minValue(root.getLeft());
        }

    }



    public void nodeLevel(Sample s) {
        nodeLevel(root,s, 1);
    }


    private void nodeLevel(BSTNode<E> node,Sample s, int depth) {
        if (node == null) {
            return;
        }
        else {
            nodeLevel(node.getLeft(),s,depth+1);
            s.add(depth);
            nodeLevel(node.getRight(),s,depth+1);
        }
    }





    public static void main(String[] args) {

        Sample create = new Sample("create");
        BSTree test = new BSTree(3);
        System.out.println(test.key);

        test.create();
            test.nodeLevel(create);
            System.out.println(create);
            System.out.println(create.getAverage());
        System.out.println("created");
        System.out.println("verification: " + test.verify());
        System.out.println("inorder verification: " + test.verifyInorder());
        System.out.println("tree height : " + test.height(test.root));
//        using size to count all of the nodes in the tree
        System.out.println("number of nodes: " + test.size);
        System.out.println("inOrder traversal: ");
        test.inorder();
        test.nodeLevel(create);
        System.out.println("\n");
        System.out.println("this here is the nodeLevel of each node from inOrder");
        System.out.println(create);


        Sample deleted = new Sample("delete half");
        test.deleteHalf();
        System.out.println("\n" + "\n" + "half deleted");
        System.out.println("verification: " + test.verify());
        System.out.println("inorder verification: " + test.verifyInorder());
        System.out.println("tree height : " + test.height(test.root));
//        using size to count all of the nodes in the tree
        System.out.println("nodes: " + test.size);
        System.out.println("inOrder traversal: ");
        test.inorder();
        test.nodeLevel(deleted);
        System.out.println("\n");
        System.out.println("this here is the nodeLevel of each node from inOrder");
        System.out.println(deleted);


        Sample reinsert = new Sample("reinsert");
        System.out.println("\n" + "\n" + "reinsert");
        test.reinsert();
        System.out.println("verification: " + test.verify());
        System.out.println("inorder verification: " + test.verifyInorder());
        System.out.println("tree height : " + test.height(test.root));
        System.out.println("nodes: " + test.size);
        test.inorder();
        test.nodeLevel(reinsert);
        System.out.println("\n");
        System.out.println("this here is the nodeLevel of each node from inOrder");
        System.out.println(reinsert);

// this works. it was wrong before because it was doing it recursively and it was deleting half and replacing the root
        System.out.println(test.root);
    }


}