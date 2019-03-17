//Name: Navid Hariri
//Date:12/8/2018
//assignment:Binary Search Tree Project 3

public class BSTElement<T> implements Comparable<T> {

//    private T data;
    private Integer key;


    //    constructor
    public BSTElement(int key) {
        setData(key);
        this.key = key;
    }


    public Integer getData() {
        return key;
    }

//    public int compareTo(BSTElement<T> other){
//        if (key.compareTo(other.key) > 0){
//            return 1;
//        }
//        else if (key.compareTo(other.key) < 0){
//            return -1;
//        }
//        else{
//            return 0;
//        }
//    }


    public void setData(Integer newKey) {
        this.key = newKey;
    }

    @Override
    public String toString() {
        return "" + key;
    }


        @Override
    public int compareTo(T temp) {
        BSTElement<T> other = (BSTElement<T>) temp;

        if (this.key.compareTo(other.key) > 0) {
            return 1;
        } else if (this.key.compareTo(other.key) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}