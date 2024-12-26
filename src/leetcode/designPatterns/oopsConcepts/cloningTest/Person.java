package leetcode.designPatterns.oopsConcepts.cloningTest;

class Person implements Prototype {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow Clone
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    // Deep Clone
    public Person deepClone() {
        Address clonedAddress = new Address(this.address.city, this.address.state);
        return new Person(this.name, clonedAddress);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", address=" + address + '}';
    }
}

