package leetcode.company.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NewLC621TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = new char[] {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    private static int leastInterval(char[] tasks, int n) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);

        int[] freq=new int[26];
        for(int i=0 ; i<tasks.length; i++){
            freq[tasks[i]-'A']++;
        }

        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                pq.offer(freq[i]);
            }
        }
        int time=0;
        while(!pq.isEmpty()){
            int cycle=n+1;
            List<Integer> list=new ArrayList<>();

            while(cycle!=0 && !pq.isEmpty()){
                int frequency=pq.poll();
                frequency--;
                list.add(frequency);

                cycle--;
            }

            for(int i=0;i<list.size();i++){
                if(list.get(i)>0){
                    pq.offer(list.get(i));
                }
            }

            if(pq.isEmpty()){
                time=time+list.size();
            } else{
                time=time+(n+1);
            }
        }
        return time;
    }
}
