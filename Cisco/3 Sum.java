/*Approach
->Sort the array
->Fix one number(nums[i]) in the array.For each fixed number,use two pointers(i+1 to n-1) to find the remaining two numbers that sum up to (-nums[i]) 
->Two-Pointer Search (in twoSum method):
 *Use left (i) and right (j) pointers.
 *If the sum is too small, i++.
 *If the sum is too big, j--.
 *If the sum is perfect, record the triplet and move both pointers, skipping duplicates.
->Avoiding Duplicates:
 *Skip duplicate fixed elements (nums[i] == nums[i-1]).
 *After finding a valid pair, skip duplicates for both i and j within the twoSum function.

##Handle edge cases
->Array length < 3: Immediately return an empty list.
->Duplicates: Skipped using if(i != 0 && nums[i] == nums[i-1]) and while loops in twoSum.
->All elements 0: Will still return only one [0, 0, 0] due to duplicate checks.
->No valid triplet: Returns empty list if no combinations found.



##Leetcode link
https://leetcode.com/problems/3sum/description/
*/

//JAVA Code
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        if(n<3) return new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
          if(i!=0 && nums[i]==nums[i-1]){
            continue;
          }
          twoSum(nums,i+1,result,-nums[i]);
        }
        return result;
    }
    public void twoSum(int[] nums,int k,List<List<Integer>> result,int target){
        int i=k;
        int j=nums.length-1;
      while(i<j){
        if(nums[i]+nums[j]>target){
            j--;
        }
        else if(nums[i]+nums[j]<target){
            i++;
        }
        else{
            result.add(Arrays.asList(-target,nums[i],nums[j]));
            while(i<j && nums[i]==nums[i+1]){
                i++;
            }
            while(i<j && nums[j]==nums[j-1]){
                j--;
            }
            i++;
            j--;
        }
      }
    }
}

