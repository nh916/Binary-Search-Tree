//Name: Navid Hariri
//Date:12/8/2018
//assignment:Binary Search Tree Project 3

public class BSTElement implements Comparable<BSTElement> {
//    TODO is everything good here? should there be more, or be less, or change what i got?
//    todo do we need <T> here?

    private T data;
    private Integer key;


//    constructor
    public BSTElement(T data, Integer key){
        setData(data);
        this.key = key;
    }


    public T getData(){
        return data;
    }

    public int compareTo(BSTElement<T> other){
        if (key.compareTo(other.key) > 0){
            return 1;
        }
        else if (key.compareTo(other.key) < 0){
            return -1;
        }
        else{
            return 0;
        }
    }


    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "" + data;
    }



}