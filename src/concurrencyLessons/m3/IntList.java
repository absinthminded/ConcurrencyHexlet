package concurrencyLessons.m3;

import java.util.ArrayList;

public class IntList {

    private int[] data = new int[10];

    private int size;

    public int getSize(){
        return size;
    }

    public synchronized void add (int element) {
        if (data.length == size) {
            int[] newData = new int[data.length * 2 + 1];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = element;
    }

    public synchronized int getElement(int index){
        return data[index];
    }
}
