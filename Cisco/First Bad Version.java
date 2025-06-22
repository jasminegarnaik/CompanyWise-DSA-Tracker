/*
Approach
1.Set left = 1, right = n.
2.While left < right:
   *Find mid = left + (right - left) / 2.
   *If mid is bad, the first bad is at or before mid → move right = mid.
   *If mid is good, the first bad is after → move left = mid + 1.
3.When loop ends, left == right → that’s the first bad version.

Leetcode Link-
https://leetcode.com/problems/first-bad-version/
*/
//Java Code
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left=1,right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(isBadVersion(mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}
