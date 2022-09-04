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

        System.out.println(stack);
    }
}
