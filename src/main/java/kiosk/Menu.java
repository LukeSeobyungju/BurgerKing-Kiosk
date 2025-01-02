package kiosk;

public class Menu {
    private String type;
    private String name;
    private int price;
    private int count;

    public Menu(String type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
        count=1;
    }

    public void set(String type, String name, int price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
