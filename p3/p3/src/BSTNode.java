//Name: Navid Hariri
//Date:12/8/2018
//assignment:Binary Search Tree Project 3

public class BSTNode<E extends Comparable <E> > {

    //private E element;

    private BSTElement element;


    private BSTNode<E> leftLink;
    private BSTNode<E> rightLink;

    //    constrcutor
    public BSTNode(int target) {
        element = new BSTElement(target);
    }



    public int compareTo(BSTNode<E> other) {
        return element.compareTo(other.element);
    }


    //    fix the get method
    public BSTElement getElement () {
        return element;
    }

    //    change this later because it does exactly the same as get##
    public int getData(){
        return element.getData();
    }

    public BSTNode<E> getLeft () {
        return leftLink;
    }
    public BSTNode<E> getRight () {
        return rightLink;
    }






    public void set (int target){
        element.setData(target);
    }
    public void setLeft (BSTNode<E> node) {
        leftLink = node;
    }

    public void setRight (BSTNode<E> node) {
        rightLink = node;
    }



    @Override
    public String toString() {
        return "BSTNode:" + "\n" +
                "\t"+ "element=" + element.getData() + "\n" +
                "\t" + "leftLink=" + leftLink.getData() + "\n" +
                "\t" + "rightLink=" + rightLink.getData() + "\n";
    }
}