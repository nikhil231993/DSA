package leetcode.designPatterns.creational.prototype.product;

public class ProductPrototype implements PrototypeInterface {

    private String name;
    private String  description;
    private int price;

    public ProductPrototype(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public leetcode.designPatterns.creational.prototype.product.PrototypeInterface clonePrototype() {
        return new ProductPrototype(name, description, price);
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
