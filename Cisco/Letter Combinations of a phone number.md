#Approach
1. Each digit (2–9) maps to a set of letters (like on a phone keypad).
2. We build all possible letter combinations by trying all mapped letters for each digit.
3. At each digit position, we try every possible letter → recursively move to the next digit.
4. Once we have a combination of the same length as the input, we add it to the result list.
    *Backtracking*
- Choose: Pick one letter from the current digit's mapping.
- Explore: Recurse to build the rest of the string.
- Unchoose (Backtrack): Remove the last letter and try the next one.

##Leetcode Link-https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

# JAVA Code
class Solution {
    List<String> result=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return result;
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
       backtrack(0,digits,new StringBuilder(),map);
       return result;
    }
    public void backtrack(int idx,String digits,StringBuilder temp,Map<Character,String> map){
   if(idx>=digits.length()){
    result.add(temp.toString());
    return;
   }
   char ch=digits.charAt(idx);
   String str=map.get(ch);
   for(int i=0;i<str.length();i++){
    temp.append(str.charAt(i));
    backtrack(idx+1,digits,temp,map);
    temp.deleteCharAt(temp.length()-1);
   }
    }
}
