package com.dataStructuresAndAlgorithms.Lab5;

public class Main {

    public static void main(String[] args) {
        int[] listB = {20, 89, 6, 42, 55, 59, 41, 69, 75, 66};

        //ShellSort Algorithm
        shellSort(listB);

        System.out.println("Shell sorted list: ");
        for (int i = 0; i < listB.length; i++)
            System.out.println(listB[i]);

        System.out.println("");

        //QuickSort Algorithm
        int[] listC = {69, 0, 70, 6, 38, 38, 24, 56, 44, 26, 73, 77, 30, 45, 97, 65};
        quickSort(listC);
        System.out.println("Quick sorted list: ");
        for (int i = 0; i < listC.length; i++)
            System.out.println(listC[i]);
    }

        public static void shellSort(int[] array)
        {
            int inner, outer;
            int temp;
            int h = 1; // find initial value of h
            while(h <= array.length/3)
                h = h*3 + 1; // (1, 4, 13, 40, 121, ...)
            while(h>0) // decreasing h, until h=1
            {
// h-sort the file
                for(outer=h; outer<array.length; outer++)
                {
                    temp = array[outer];
                    inner = outer;
// one subpass (eg 0, 4, 8)
                    while(inner > h-1 && array[inner-h] >= temp)
                    {
                        array[inner] = array[inner-h];
                        inner -= h;
                    }
                    array[inner] = temp;
                } // end for
                h = (h-1) / 3; // decrease h
            } // end while(h>0)
        } // end shellSort()
//--------------------------------------------------------------

    public static void quickSort(int[] array)
    {
        recQuickSort(0, array.length-1, array);
    }
    //--------------------------------------------------------------
    public static void recQuickSort(int left, int right, int [] array)
    {
        if(right-left <= 0) // if size <= 1,
            return; // already sorted
        else // size is 2 or larger
        {
            int pivot = array[right]; // rightmost item
// partition range
            int partition = partitionIt(left, right, pivot, array);
            recQuickSort(left, partition-1, array); // sort left side
            recQuickSort(partition+1, right, array); // sort right side
        }
    } // end recQuickSort()
    //--------------------------------------------------------------
    public static int partitionIt(int left, int right, int pivot, int[] array)
    {
        int leftPtr = left-1; // left (after ++)
        int rightPtr = right; // right-1 (after --)
        while(true)
        { // find bigger item
            while( array[++leftPtr] < pivot )
                ; // (nop)
// find smaller item
            while(rightPtr > 0 && array[--rightPtr] > pivot)
                ; // (nop)
            if(leftPtr >= rightPtr) // if pointers cross,
                break; // partition done
            else{ // not crossed, so
                int temp = array[leftPtr]; // A into temp
                array[leftPtr] = array[rightPtr]; // B into A
                array[rightPtr] = temp; // temp into B
            }
        } // end while(true)
        int temp = array[leftPtr]; // A into temp
        array[leftPtr] = array[right]; // B into A
        array[right] = temp; // temp into B
        return leftPtr; // return pivot location
    } // end partitionIt()
    }






