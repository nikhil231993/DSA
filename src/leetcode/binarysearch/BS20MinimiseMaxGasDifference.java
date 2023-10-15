package leetcode.binarysearch;

import java.util.PriorityQueue;
class Node{

    double first;
    int second;

    public Node(double first, int second){
        this.first=first;
        this.second=second;
    }
}
public class BS20MinimiseMaxGasDifference {

    public static void main(String[] args) {

        int n=5,k=6;
        int[] arr=new int[]{1,2,3,4,5,6,7};

        //Approach 1
        System.out.println(minimiseMaxDistance(arr,k));

        //Approach 2
        System.out.println(minimiseMaxDistancePriorityQueue(arr,k));

        //Approach 3
        System.out.println(minimiseMaxDistanceUsingBinarySearch(arr,k));
    }

    private static double minimiseMaxDistancePriorityQueue(int[] arr, int k) {
        int[] howMany=new int[arr.length-1];
        PriorityQueue<Node> pq=new PriorityQueue<>((a, b)->Double.compare(b.first, a.first));

        for(int i=0;i< arr.length-1;i++){
            pq.offer(new Node(arr[i+1]-arr[i], i));
        }
        for(int gas=1;gas<=k;gas++){
            Node n=pq.poll();
            int index=n.second;
            howMany[index]++;
            double newSectionLength=(double)(arr[index+1]-arr[index])/(double)(howMany[index]+1);
            pq.offer(new Node(newSectionLength,index));
        }
        return pq.peek().first;
        //TC:O(n logn)+O(k log (n-1))
        //SC:O(n-1)
    }

    public static double minimiseMaxDistance(int []arr, int k){
        int[] howMany=new int[arr.length-1];
        for(int gas=1;gas<=k;gas++){
            double maxDiff=Integer.MIN_VALUE;
            int maxIndex=Integer.MIN_VALUE;

            for(int i=0;i<arr.length-1;i++){
                double difference=arr[i+1]-arr[i];
                double sectionLength=difference/(howMany[i]+1);
                if(sectionLength> maxDiff){
                    maxDiff=sectionLength;
                    maxIndex=i;
                }
            }
            howMany[maxIndex]++;
        }

        double max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++){
            double diff=arr[i+1]-arr[i];
            double ans=diff/(double)(howMany[i]+1);
            max=Math.max(max, ans);
        }
        return max;
        //TC:O(k * n)+ O(k)
        //SC:O(1)
    }

    public static double minimiseMaxDistanceUsingBinarySearch(int []arr, int K){
        double low=0;
        double high=maxValue(arr);
        double ans=0;
        double diff=1e-6;
        while(high-low > diff){
            double mid=low+(high-low)/2.0;
            int count=isPossible(mid, arr, K);
            if(count>K){
                low=mid;
            }else{
                ans=mid;
                high=mid;
            }
        }
        return ans;

        //TC:O( nlog n)+O(n)
        //SC:O(1)
    }

    public static int isPossible(double mid, int[] arr, int K){
        int count=0;
        for(int i=0;i<arr.length-1;i++){
            int no=(int)((arr[i+1]-arr[i])/mid);
            if((arr[i+1]-arr[i]) == no*mid){
                no--;
            }
            count+=no;
        }
        return count;
    }

    public static double maxValue(int[] arr){

        double max=0.0;
        for(int i=0;i<arr.length-1;i++){
            max=Math.max(max,(double)(arr[i+1]-arr[i]));
        }
        return max;
    }
}
