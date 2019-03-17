//Name: Navid Hariri
//Date:12/8/2018
//assignment:Binary Search Tree Project 3

import java.util.ArrayList;
import java.util.Collections;

public class Sample {

    public ArrayList<Double> data;
    private double mean;
    private double median;
    private double stdev;
    private double max;
    private double min;
    private String name;


    public Sample(String name) {
        this.name = name;
        data = new ArrayList<Double>();
    }

//    add method that adds the data to the ArrayList

    public void add(double value){
        data.add(value);
    }


    public double getMax(){
        this.max = Collections.max(data);
        return max;
    }

    public double getAverage(){
        double sum = 0;

        for (int i = 0; i < data.size(); i++) {
            sum = sum + data.get(i);
        }
        this.mean = sum / data.size();
        return mean;
    }




    // One method to calculate and set the min, max, mean, standard deviation, median, and then send the results to toString
    public void computeStats() {

        Collections.sort(data);
        this.min = Collections.min(data);
        this.max = Collections.max(data);

        // Calculates mean
        double sum = 0;

        for (int i = 0; i < data.size(); i++) {
            sum = sum + data.get(i);
        }
        mean = sum / data.size();
        // Calculates mean END


        // calculates Standard Deviation
        double sumSquares = 0;
        for (int i = 0; i < data.size(); i++) {
            sumSquares = sumSquares + Math.pow(data.get(i) - this.mean, 2);
        }
        stdev = Math.sqrt(sumSquares / data.size());
        // calculates Standard Deviation END


        // Calculates Median
        if (data.size() % 2 == 0) {

            // Finds the two index in the middle. The first index and the previous one
            int rightIndex = data.size() / 2;
            int leftIndex = ((data.size() / 2) - 1);

            // adds together the two numbers and divides them by 2 to get the even median
            median = (data.get(rightIndex) + data.get(leftIndex)) / 2;
        } else {
            // if the amounts of value in the ArrayList is odd, it finds the index of the middle value and sets the value as the median
            int indexMiddle = data.size() / 2;

            median = data.get(indexMiddle);
        }
    }


//    public String toString() {
//        return String.format("Name: %s  size = %d, mean = %.2f, median = %.2f stdDev = %.2f min = %.2f max = %.2f",
//                name, data.size(), mean, median, stdev, min, max);
//
//    }




    public String toString() {
        return String.format("Name: %s  size = %d, mean = %.2f, max = %.2f",
                name, data.size(), getAverage(), getMax());

//        String test =  "max: " + getMax() + " average: " + getAverage();
//        return test;

    }



}