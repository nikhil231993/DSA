package leetcode.designPatterns.creational.prototype.product;

public class ProdcutPrototype extends Prototype {

    private String name;
    private String  description;
    private int price;

    public ProdcutPrototype(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public Prototype clonePrototype() {
        return new ProdcutPrototype(name, description,price);
    }

    @Override
    public void update(int price) {
        this.price=price;
    }

    @Override
    public void display() {
        System.out.println("ProdcutPrototype{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}');
    }
}
