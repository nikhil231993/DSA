package leetcode.company.leetcode75Remaining;

import java.util.LinkedList;
import java.util.Queue;

public class LC649Dota2Senate {

    public static void main(String[] args) {
        String senate = "RD";
        System.out.println(predictPartyVictory(senate));
    }

    private static String predictPartyVictory(String senate) {
        int n=senate.length();
        Queue<Integer> radiant=new LinkedList<>();
        Queue<Integer> dire=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R')
                radiant.offer(i);
            else
                dire.offer(i);
        }

        while(!radiant.isEmpty() && !dire.isEmpty()){

            int radiant_id=radiant.poll();
            int dire_id=dire.poll();

            if(radiant_id<dire_id)
                radiant.offer(radiant_id+n);
            else
                dire.offer(dire_id+n);
        }
        if(radiant.size()!=0) return "Radiant";
        return "Dire";
    }
}
