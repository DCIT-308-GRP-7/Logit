package ds;

import java.util.ArrayList;
import java.util.Iterator;

public class DStacks<Type> {
    private ArrayList<Type> data;
    private int sizeOfStack = 0;

    public DStacks(int sizeOfStack) {
        this.data = new ArrayList(sizeOfStack);
        this.sizeOfStack = sizeOfStack;
    }

    public ArrayList<Type> getData() {
        return data;
    }

    //checks if the stack is full by comparing the size with the initial size
    public boolean isFull() {
        return this.data.size() >= this.sizeOfStack;
    }


    //push items to the stack
    public void push(Type item) {
        if (this.isFull()) {
            System.out.println("The Stack is Full");
        } else {
            this.data.add(item);
        }
    }


    //pop the first element from the stack
    public Type pop() {
        if (this.data.size() < 1) {
            System.out.println("Cannot Pop On an Empty Stack");
            return null;
        } else {
            Type val = this.data.get(this.data.size() - 1);
            this.data.remove(this.data.size() - 1);
            return val;
        }
    }


    //returns the size of the stack
    public int getSize() {
        return this.data.size();
    }


    //check the first element of the stack
    public Type peek() {
        Type val = this.data.get(this.data.size() - 1);
        return val;
    }


    //display all the elements in the stack
    public void show() {
        Iterator var2 = this.data.iterator();

        while(var2.hasNext()) {
            Type t = (Type) var2.next();
            System.out.print(t + " ");
        }

    }


    //returns the data in the stack in an array
    public Object[] result() {
        return this.data.toArray();
    }
}


// testing push
