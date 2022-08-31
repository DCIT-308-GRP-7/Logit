package classes;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleIntegerProperty quantity;
    public SimpleFloatProperty cost_price;
    public SimpleFloatProperty selling_price;
    public SimpleFloatProperty gross_price;

    public Product(int id, String name, int quantity, float cost_price, float selling_price, float gross_price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.cost_price = new SimpleFloatProperty(cost_price);
        this.selling_price = new SimpleFloatProperty(selling_price);
        this.gross_price = new SimpleFloatProperty(gross_price);
    }

    public String getName() {
        return name.get();
    }

    public int getId() {
        return id.get();
    }

    public float getCost_price() {
        return cost_price.get();
    }

    public float getSelling_price() {
        return selling_price.get();
    }

    public float getGross_price() {
        return gross_price.get();
    }

    public int getQuantity() {
        return quantity.get();
    }

}
