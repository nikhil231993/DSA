package leetcode.math.medium;

public class LC1344AngleBetweenHandsClock {

    public static void main(String[] args) {

        int hour=12, minutes=30;
        
        //Approach 1
        System.out.println(angleClock(hour,minutes));

        //Approach 2
        System.out.println(angleClockSame(hour,minutes));
    }

    private static double angleClockSame(int hour, int minutes) {

        double min_degree=minutes*6;
        double hour_degree=(((hour+(double)minutes/60)/12)*360);  //https://www.youtube.com/watch?v=38pOVOeEB4Y&ab_channel=NareshGupta
        return Math.min(Math.abs(hour_degree-min_degree), 360-Math.abs(hour_degree-min_degree));
    }

    //No need to learn this
    public static double angleClock(int hour, int minutes) {

        //https://leetcode.com/problems/angle-between-hands-of-a-clock/discuss/502738/JavaPythonC%2B%2B-Simple-Math-on-Clock-angles
        double min_degree=minutes*6;
        double hour_degree=(hour%12)*30+((double)minutes/60)*30; // it will work without %12 also
        return Math.min(Math.abs(hour_degree-min_degree), 360-Math.abs(hour_degree-min_degree));

        //TC:O(1)
        //SC:O(1)
    }
}
