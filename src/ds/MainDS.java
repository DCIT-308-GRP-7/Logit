package ds;

import classes.Product;

public class MainDS {
    public static void main(String args[]) {
        ArrayStack<Product> stack = new ArrayStack<Product>();

        Product prod = new Product(2, "Coke", 23, 2.0f, 3.0f, 26.0f, 2);
        Product prod1 = new Product(2, "Coke", 23, 2.0f, 3.0f, 26.0f, 2);
        Product prod2 = new Product(2, "Coke", 23, 2.0f, 3.0f, 26.0f, 2);
        Product prod3 = new Product(2, "Coke", 23, 2.0f, 3.0f, 26.0f, 2);
        Product prod4 = new Product(2, "Coke", 23, 2.0f, 3.0f, 26.0f, 2);

        stack.push(prod);


        DQueues<String> que = new DQueues<String>(56);
        que.enqueue("Prince");
        que.enqueue("Gyan");
        que.enqueue("Dimafo");
        que.enqueue("Looka");

        DStacks<String> st = new DStacks<String>(56);
        st.push("Name1");
        st.push("Name2");
        st.push("Name3");
        st.push("Name5nf");

        st.show();
        System.out.println();
        st.pop();
        st.show();
        System.out.println();
        st.pop();
        st.show();
        System.out.println();
        st.pop();
    }
}
