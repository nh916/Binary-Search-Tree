//Name: Navid Hariri
//Date:12/8/2018
//assignment:Binary Search Tree Project 3

public class BSTNode<E> {

//    TODO is this element even needed? I think a BSTElement makes more sense here. Should i just change all instances of where i used this element and replace it somehow
    //private E element;

    //    TODO make sure that this element makes sense being here. If i put <E> here it breaks. why?
    private BSTElement<E> element;
//    private E element;

//    todo should this even be an <E> ???


    private BSTNode<E> leftLink;
    private BSTNode<E> rightLink;

    //    constrcutor
    public BSTNode(E target) {
        element = new BSTElement(target);
    }



    public int compareTo(BSTNode<E> other) {
        return element.compareTo((E) other.element);
    }


    //    fix the get method
    public E getElement () {
        return element;
    }

    //    change this later because it does exactly the same as get##
    public Integer getData(){
        return element.getData();
    }

    public BSTNode<E> getLeft () {
        return leftLink;
    }
    public BSTNode<E> getRight () {
        return rightLink;
    }






    //    TODO since i changed the element, is this set now working, or is the element here needs to change?
    public void set (E target){
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