//Name: Navid Hariri
//Date: 12/8/2018
//Assignment: Binary Search Tree Project 3

public class BSTP3 {

    private int power;
    private int trial;

    //  constructor
    public BSTP3(int power){
        this.power = power;
        trial = 1000;
    }

//    todo for the report try to see if you can print out the results in a excel sheet to get the graph out of it and compare your graph with the Big 0 bst graph

//    todo does he want an average of the average and the max of the max?

//    todo how do I explain my findings against a real tree? what does this all mean???

//    todo i need to use verify to show that my tree is valid here. Verify needs to be doing something right now


    private void create(){
        Sample createMax = new Sample("Create Max");
        Sample createAverage = new Sample("Create Average");

        for (int i = 0; i < trial; i++) {
            Sample temporary = new Sample("temporary");
            BSTree tree = new BSTree(power);
            tree.create();
            tree.nodeLevel(temporary);
            createAverage.add(temporary.getAverage());
            createMax.add(temporary.getMax());
        }

//        testing purposes
//        treeCreate.nodeLevel(temporary);
//        createAverage.add(temporary.getAverage());
//        createMax.add(temporary.getMax());

        System.out.println(createMax);
        System.out.println(createAverage);
    }


    private void deleteHalf(){
        Sample deleteMax = new Sample("Delete Max");
        Sample deleteAverage = new Sample("Delete Average");

        for (int i = 0; i < trial; i++) {
            Sample temporary = new Sample("temporary");
            BSTree tree = new BSTree(power);
            tree.create();
            tree.deleteHalf();
            tree.nodeLevel(temporary);
            deleteMax.add(temporary.getMax());
            deleteAverage.add(temporary.getAverage());
        }
        System.out.println(deleteMax);
        System.out.println(deleteAverage);
    }


    private void reinsert(){
        Sample reinsertMax = new Sample("Reinsert Max");
        Sample reinsertAverage = new Sample("Reinsert Average");

        for (int i = 0; i < trial; i++) {
            Sample temporary = new Sample("temporary");
            BSTree tree = new BSTree(power);
            tree.create();
            tree.deleteHalf();
            tree.reinsert();
            tree.nodeLevel(temporary);
            reinsertMax.add(temporary.getMax());
            reinsertAverage.add(temporary.getAverage());
        }

        System.out.println(reinsertMax);
        System.out.println(reinsertAverage);

    }





    public static void main(String[] args){
//        todo should this even have a constrcutor? should it be empty?
        BSTP3 project3 = new BSTP3(10);

        project3.create();

        System.out.println("\n");
        project3.deleteHalf();

        System.out.println("\n");
        project3.reinsert();
    }



}