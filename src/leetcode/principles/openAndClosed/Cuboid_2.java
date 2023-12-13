package leetcode.principles.openAndClosed;

class Cuboid_2 extends Geo_objects {

    // used to store length, breadth and height of a cuboid

    public double length;
    public double breadth;
    public double height;

    // overrided function to calculate
    // the volume of a cuboid
    // @Override
    public double get_volume()
    {
        return length * breadth * height;
    }
}
