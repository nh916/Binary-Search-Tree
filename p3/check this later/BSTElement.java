//Name: Navid Hariri
//Date:12/8/2018
//assignment:Binary Search Tree Project 3

public class BSTElement implements Comparable<BSTElement> {
//    TODO why do we have 2 constructors here?
//    TODO is everything good here? should there be more, or be less, or change what i got?
//    todo do we need <E> here?

    private Integer data;

//    constructor
//    public BSTElement(){
//        data = 0;
//    }


//    constructor
    public BSTElement(Integer data){
        setData(data);
    }


    public int getData(){
        return data;
    }

    public int compareTo(BSTElement other){
        if (data > other.data){
            return 1;
        }
        else if (data < other.data){
            return -1;
        }
        else{
            return 0;
        }
    }


    public void setData(Integer data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "" + data;
    }



}