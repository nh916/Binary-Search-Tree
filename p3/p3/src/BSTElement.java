//Name: Navid Hariri
//Date:12/8/2018
//assignment:Binary Search Tree Project 3

public class BSTElement<T extends Comparable <T> > implements Comparable<BSTElement<T>>{

    private Integer data;


    //    constructor
    public BSTElement(Integer data){
        setData(data);
    }


    public int getData(){
        return data;
    }

//    @Override
    public int compareTo(BSTElement<T> other) {
        return data.compareTo(other.data);
    }


//        @Override
        public int compareTo(Integer other) {
            return data.compareTo(other);
        }

//        public int compareTo(Integer other) {
//            if (data > other) {
//                return 1;
//            } else if (data < other) {
//                return -1;
//            } else {
//                return 0;
//            }
//        }



    public void setData(Integer data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "" + data;
    }



}