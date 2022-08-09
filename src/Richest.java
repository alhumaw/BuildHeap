

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


import java.io.FileWriter;
class Richest{
    /*
    store 10,000 numbers from a text file in an array
    build heap out of the array
    process the rest of the elements in the text file into the array
    Case 1: if x<= current root, skip x
    Case 2: if x is > current root, copy x into the min heap. call min heapify on the new top
    Once done, sort the array using min heap sort. should be in descending order. 
    output the results into Richest.output
     */


    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(new File(args[0]));
        int[] data = new int[10000];
        int n = data.length;

        // store first 10,000
        for(int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(s.nextLine());
        }
        // make a heap out of it
        BuildHeap.buildHeap(data, n);
        // variable to compare values
        int cur = Integer.parseInt(s.nextLine());
        // iterator
        while(s.hasNextLine()){
            // data does not belong in heap, continue
            if(cur <= data[0]){
                cur = Integer.parseInt(s.nextLine());
            }
            // replace root with cur data, then heapify
           else if(cur > data[0]){
                data[0] = cur;
                BuildHeap.heapify(data, n, 0);
                cur = Integer.parseInt(s.nextLine());
            }
           //System.out.println(cur);
        }

        // my bad way of handling the last node
         if(cur > data[0]){
            data[0] = cur;
            BuildHeap.heapify(data, n, 0);
        }
        // sorting in descending order
         BuildHeap.minHeapSort(data, n);
        s.close();
        // output to Richest.output
        FileWriter writer = new FileWriter("Richest.output");
        for(int str : data){
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}