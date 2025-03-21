package leetcode.heap.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC703LeetcodeBruteSolution {

    List<Integer> stream;
    int k;

    public LC703LeetcodeBruteSolution(int k, int[] nums) {

        stream = new ArrayList<Integer>(nums.length);
        this.k = k;

        for (int num : nums) {
            stream.add(num);
        }

        Collections.sort(stream);
    }

    public int add(int val) {

        int index = getIndex(val);
        // Add val to correct position
        stream.add(index, val);
        return stream.get(stream.size() - k);
    }

    private int getIndex(int val) {

        int left = 0, right = stream.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midElement = stream.get(mid);
            if (midElement == val) return mid;
            if (midElement > val) {
                // Go to left half
                right = mid - 1;
            } else {
                // Go to right half
                left = mid + 1;
            }
        }
        return left;
    }

    //TC:O(N square +N.M)
    //The constructor involves creating a list stream from nums, which takes O(M) time. Then, sorting this list takes O(M⋅logM) time. Thus, the time complexity of the constructor is O(M⋅logM) time.
    //The add function involves running a binary search on stream. Because the total size of stream at the end would be O(M+N), each binary search is bounded by a time complexity of O(log(M+N)). Moreover, adding a number in stream can take worst-case O(M+N) time, as adding an element in the middle of a list can offset all the elements to its right. Then, the time complexity of a single add call would be O(M+N+log(M+N)). Because add is called N times, the time complexity of all the add calls would be O(N⋅(M+N+log(M+N))).
    //We see that after expanding the time complexity for the add function, the N⋅M and N square
    //terms dominate all the other log terms in our calculations, so the total time complexity is O(N square+N⋅M)

    //SC:O(M+N)
    //The maximum size for stream is M+N, so the total space complexity is O(M+N)
}
