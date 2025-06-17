## Approach
We use a stack to track expected closing brackets
1. Traverse the input string character by character.
2. For every opening bracket:
   - Push its matching closing bracket onto the stack.
     e.g., for '(', push ')'
3. For every closing bracket:
   - If the stack is empty → invalid (no matching opening)
   - If the top of the stack is not equal to the current closing bracket → invalid (wrong order)
4. After processing all characters, the stack should be empty for the string to be valid.

## Leetcode link-
https://leetcode.com/problems/valid-parentheses/

##  JAVA Code
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.push(')');
            }
            else if(ch=='{'){
                stack.push('}');
           }
            else if(ch=='['){
             stack.push(']');
            }
           else if(stack.isEmpty() || stack.pop()!=ch){
            return false;
           }
        }
        return stack.isEmpty();
    }
}
