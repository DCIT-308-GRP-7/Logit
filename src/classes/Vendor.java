package classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Vendor {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty category;


    public Vendor(int id, String name, int category) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleIntegerProperty(category);

    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public int getCategory() {
        return category.get();
    }

}
