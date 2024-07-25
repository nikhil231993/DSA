package leetcode.principles.Immutable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public final class Driver {

    private final int a;
    private final String name;
    private final Set<Integer> set;
    private final Date d;

    public Driver(int a, String name, Set<Integer> set, Date d) {
        this.d=new Date(d.getTime());
        this.a = a;
        this.name=name;
        this.set=new HashSet<>(set); // deep copy
    }

    public int getA() {
        return a;
    }

    public String getName() {
        return name;
    }

    public Set<Integer> getSet(){
        //return set;
        return new HashSet<>(set); // deep copy
    }

    public Date getD() {
        return new Date(d.getTime());
    }
}
