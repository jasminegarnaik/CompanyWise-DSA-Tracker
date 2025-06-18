/* Approach
We group words that are anagrams by using a HashMap.
1. For each string in the input array:
   - Convert the string to a character array.
   - Sort the array to get a unique key for all anagrams (e.g., "eat" → "aet").
   - Use this sorted string as the key in a HashMap.
   - Add the original string to the list corresponding to that key.
2. Finally, return all values (lists of grouped anagrams) from the HashMap.

 Leetcode Link
https://leetcode.com/problems/group-anagrams/description/
*/
// JAVA Code
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] charArray=str.toCharArray();
            Arrays.sort(charArray);
            String sortedString=new String(charArray);
            if(!map.containsKey(sortedString)){
                map.put(sortedString,new ArrayList<>());
            }
            map.get(sortedString).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
