package task3.model;

import java.io.Serializable;

public class Car implements Serializable {

    private int id;
    private int markId;
    private String model;
    private int price;

    public Car() {
    }

    public Car(int id, int markId,
               String model, int price) {

        this.id = id;
        this.markId = markId;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return "Car{" +
                "id=" + id +
                ", markId=" + markId +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
