package leetcode.principles.openAndClosed;

class Application {

    public double
    get_total_volume(Geo_objects[] geo_objects)
    {
        // Initially initializing sum to zero
        double vol_sum = 0;

        // Iterating using for each loop
        for (Geo_objects geo_obj : geo_objects) {
            vol_sum += geo_obj.get_volume();
        }

        return vol_sum;
    }
}
