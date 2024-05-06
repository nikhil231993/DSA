package leetcode.binarysearch.easy;

public class LC744SmallestLetterGreaterThanTarget {

    public static void main(String[] args) {

        char[] letters =new char[] {'c','f','j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters,target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int low=0;
        int high=letters.length-1;
        char ans=letters[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(letters[mid]-'a'>(target-'a')){
                ans=letters[mid];
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
        
        //TC:O(nlogn)
        //S:O(1)
    }
}
