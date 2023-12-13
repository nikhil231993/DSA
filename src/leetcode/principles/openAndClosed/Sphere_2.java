package leetcode.principles.openAndClosed;

import leetcode.principles.openAndClosed.Geo_objects;

class Sphere_2 extends Geo_objects {

    // To store radius of a sphere
    public double radius;

    // Overrided function to calculate
    //  the volume of a sphere

    //@Override
    public double get_volume()
    {
        return (4 / 3) * Math.PI * radius * radius * radius;
    }
}
