package ds;

import java.util.ArrayList;
import java.util.Iterator;

public class DQueues<Type> {
    private ArrayList<Type> data;

    //initialize the queue with a given size
    public DQueues(int sizeOfStack) {

        this.data = new ArrayList(sizeOfStack);
    }

    public ArrayList<Type> getData() {
        return data;
    }

    //adds to the end of the queue
    public void enqueue(Type item) {

        this.data.add(item);
    }


    //add all items in the array to the end of the queue
    public void enqueueAll(Type[] item) {
        Object[] var5 = item;
        int var4 = item.length;


        //loop to populate the queue with the array elements
        for(int var3 = 0; var3 < var4; ++var3) {
            Type i = (Type) var5[var3];
            this.data.add(i);
        }

    }


    //remove the element in front of the queue
    public Type dequeue() {
        Type val = this.data.get(0);
        this.data.remove(0);
        return val;
    }


    //removes all the elements in the queue
    public void dequeueAll() {
        this.data.removeAll(this.data);
    }


    //checks the element in front of the queue
    public Type peek() {
        Type val = this.data.get(0);
        return val;
    }


    //returns the size of the queue
    public int getSize() {
        return this.data.size();
    }


    //displays all the elements in the queue using enhanced for loop
    public void show() {
        Iterator var2 = this.data.iterator();

        while(var2.hasNext()) {
            Type t = (Type) var2.next();
            System.out.print(t + " ");
        }

    }


    //returns all the element in an array format
    public Object[] result() {
        return this.data.toArray();
    }
}

