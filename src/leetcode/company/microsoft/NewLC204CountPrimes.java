package leetcode.company.microsoft;

public class NewLC204CountPrimes {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }

    private static int countPrimes(int n) {
        int[] arr=new int[n];
        for(int i=2;i<n;i++){
            arr[i]=1;
        }


        for(int i=2;i<n;i++){
            if(arr[i]==1){
                for(int j=2*i;j<n;j+=i){
                    arr[j]=0;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(arr[i]==1)
                count++;
        }
        return count;
    }
}
