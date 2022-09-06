package main;

import classes.Product;
import classes.Sale;
import classes.Vendor;
import ds.DQueues;
import ds.DStacks;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Management {
    // data structures
    public  Map<Integer, String> productSales = new HashMap<Integer, String>() ;              // <Sale ID, Product Code>
    public HashMap<String, String> vendors = new HashMap<String, String>();

    // <Vendor Name, Vendor Category>

    public DStacks<Product> Beverages = new DStacks<Product>(100);
    public DStacks<Product> Bread_Bakery = new DStacks<Product>(100);
    public DStacks<Product> Canned_Jarred = new DStacks<Product>(100);
    public DStacks<Product> Dairy = new DStacks<Product>(100);


    public DQueues<Product> Dry_Baking = new DQueues<Product>(100);
    public DQueues<Product> Frozen = new DQueues<Product>(100);
    public DQueues<Product> Meat = new DQueues<Product>(100);

    public List<Product> Produce = new ArrayList<Product>(100);
    public List<Product> Cleaners = new ArrayList<Product>(100);
    public List<Product> Paper = new ArrayList<Product>(100);
    public List<Product> Personal = new ArrayList<Product>(100);

    // add a product
    public void addProduct(Product product){
        System.out.println(product);

        // category of product
        int cat_id = product.category.getValue();
        if (cat_id == 1 ) {
            System.out.println("=====================Pushing to stack============================");
            Beverages.push(product);
        } else if (cat_id == 2 ) {
            System.out.println("=====================Enqueuing Product============================");
            Bread_Bakery.push(product);
        } else if (cat_id == 3 ) {
            System.out.println("=====================Adding to List============================");
            Canned_Jarred.push(product);
        }else if (cat_id == 4 ) {
            System.out.println("=====================Enqueuing Product============================");
            Dairy.push(product);
        }else if (cat_id == 5 ) {
            System.out.println("=====================Enqueuing Product============================");
            Dry_Baking.enqueue(product);
        }else if (cat_id == 6 ) {
            System.out.println("=====================Enqueuing Product============================");
            Frozen.enqueue(product);
        }else if (cat_id == 7 ) {
            System.out.println("=====================Enqueuing Product============================");
            Meat.enqueue(product);
        }else if (cat_id == 8 ) {
            System.out.println("=====================Enqueuing Product============================");
            Produce.add(product);
        }else if (cat_id == 9 ) {
            System.out.println("=====================Enqueuing Product============================");
            Cleaners.add(product);
        }else if (cat_id == 10 ) {
            System.out.println("=====================Enqueuing Product============================");
            Paper.add(product);
        }else if (cat_id == 11 ) {
            System.out.println("=====================Enqueuing Product============================");
            Personal.add(product);
        }
    }


    // delete product
    public void deleteProduct(int cat_id){

        if (cat_id == 1 ) {
            System.out.println("=====================Pushing to stack============================");
            Beverages.pop();
        } else if (cat_id == 2 ) {
            System.out.println("=====================Enqueuing Product============================");
            Bread_Bakery.pop();
        } else if (cat_id == 3 ) {
            System.out.println("=====================Adding to List============================");
            Canned_Jarred.pop();
        }else if (cat_id == 4 ) {
            System.out.println("=====================Enqueuing Product============================");
            Dairy.pop();
        }else if (cat_id == 5 ) {
            System.out.println("=====================Enqueuing Product============================");
            Dry_Baking.dequeue();
        }else if (cat_id == 6 ) {
            System.out.println("=====================Enqueuing Product============================");
            Frozen.dequeue();
        }else if (cat_id == 7 ) {
            System.out.println("=====================Enqueuing Product============================");
            Meat.dequeue();
        }else if (cat_id == 8 ) {
            System.out.println("=====================Enqueuing Product============================");
            Produce.remove(0);
        }else if (cat_id == 9 ) {
            System.out.println("=====================Enqueuing Product============================");
            Cleaners.remove(0);
        }else if (cat_id == 10 ) {
            System.out.println("=====================Enqueuing Product============================");
            Paper.remove(0);
        }else if (cat_id == 11 ) {
            System.out.println("=====================Enqueuing Product============================");
            Personal.remove(0);
        }
    }

    public void deleteProduct(int cat_id, Product p) {
        if (cat_id == 8 ) {
            System.out.println("=====================Enqueuing Product============================");
            Produce.remove(p);
        }else if (cat_id == 9 ) {
            System.out.println("=====================Enqueuing Product============================");
            Cleaners.remove(p);
        }else if (cat_id == 10 ) {
            System.out.println("=====================Enqueuing Product============================");
            Paper.remove(p);
        }else if (cat_id == 11 ) {
            System.out.println("=====================Enqueuing Product============================");
            Personal.remove(p);
        }
    }


    // add a product sale
    public void addProductSale(Sale sale){
        int saleID = sale.id;
        String productCode = sale.product_code;

        // add to Map data structure
        productSales.put(saleID, productCode);

    }


    // add a product sale
    public void addVendor(Vendor vendor){
        String vendor_name = vendor.getName();
        String vendor_category = vendor.getCategory();

        // add vendor information to HashMap data structure
        vendors.put(vendor_name, vendor_category);
    }


    // method for javafx collections
    public ObservableList<Product> dsToObservableList(Integer category){
        ObservableList<Product> products = FXCollections.observableArrayList();


        if (category == 1) {
            Iterator<Product> iter = Beverages.getData().iterator();
            while (iter.hasNext()) products.add(iter.next());
        } else if (category == 2) {
            Iterator<Product> iter2 = Bread_Bakery.getData().iterator();
            while (iter2.hasNext())  products.add(iter2.next());
        } else if (category == 3) {
            Iterator<Product> iter2 = Canned_Jarred.getData().iterator();
            while (iter2.hasNext()) products.add(iter2.next());
        } else if (category == 4) {
            Iterator<Product> iter2 = Dairy.getData().iterator();
            while (iter2.hasNext()) products.add(iter2.next());
        } else if (category == 5) {
            Iterator<Product> iter2 = Dry_Baking.getData().iterator();
            while (iter2.hasNext()) products.add(iter2.next());
        } else if (category == 6) {
            Iterator<Product> iter2 = Frozen.getData().iterator();
            while (iter2.hasNext()) products.add(iter2.next());
        } else if (category == 7) {
            Iterator<Product> iter2 = Meat.getData().iterator();
            while (iter2.hasNext()) products.add(iter2.next());
        } else if (category == 8) {
            Iterator<Product> iter2 = Produce.iterator();
            while (iter2.hasNext()) products.add(iter2.next());
        } else if (category == 9) {
            Iterator<Product> iter2 = Cleaners.iterator();
            while (iter2.hasNext()) products.add(iter2.next());
        } else if (category == 10) {
            Iterator<Product> iter2 = Paper.iterator();
            while (iter2.hasNext()) products.add(iter2.next());
        } else if (category == 11) {
            Iterator<Product> iter2 = Personal.iterator();
            while (iter2.hasNext()) products.add(iter2.next());
        }


        return products;
    }


    // method for javafx collections
    public ObservableList<Product> dsToObservableList(){
        ObservableList<Product> products = FXCollections.observableArrayList();

        Iterator<Product> iter = Beverages.getData().iterator();
        while (iter.hasNext()) products.add(iter.next());

        Iterator<Product> iter2 = Bread_Bakery.getData().iterator();
        while (iter2.hasNext())  products.add(iter2.next());

        Iterator<Product> iter3 = Canned_Jarred.getData().iterator();
        while (iter3.hasNext()) products.add(iter3.next());

        Iterator<Product> iter4 = Dairy.getData().iterator();
        while (iter4.hasNext()) products.add(iter4.next());

        Iterator<Product> iter5 = Dry_Baking.getData().iterator();
        while (iter5.hasNext()) products.add(iter5.next());

        Iterator<Product> iter6 = Frozen.getData().iterator();
        while (iter6.hasNext()) products.add(iter6.next());

        Iterator<Product> iter7 = Meat.getData().iterator();
        while (iter7.hasNext()) products.add(iter7.next());

        Iterator<Product> iter8 = Produce.iterator();
        while (iter8.hasNext()) products.add(iter8.next());

        Iterator<Product> iter9 = Cleaners.iterator();
        while (iter9.hasNext()) products.add(iter9.next());

        Iterator<Product> iter10 = Paper.iterator();
        while (iter10.hasNext()) products.add(iter10.next());

        Iterator<Product> iter11 = Personal.iterator();
        while (iter11.hasNext()) products.add(iter11.next());

        return products;
    }
}
