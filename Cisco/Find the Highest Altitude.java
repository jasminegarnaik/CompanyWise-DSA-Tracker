/* Approach
1.Initialize the variable currentAltitude to 0; this is the current altitude of the biker.
2.Initialize the variable highestPoint to currentAltitude, as the highest altitude we have seen is 0.
3.Iterate over the gain in altitude in the list gain and add the current gain altitudeGain to the variable currentAltitude.
4.Update the variable highestPoint as necessary.
5.Return highestPoint.

## Leetcode Link-
https://leetcode.com/problems/find-the-highest-altitude/description/
*/
//JAVA Code
class Solution {
    public int largestAltitude(int[] gain) {
        int currentAlt=0;
        int highestPoint=currentAlt;
        for(int altGain:gain){
            currentAlt+=altGain;
            highestPoint=Math.max(highestPoint,currentAlt);
        }
        return highestPoint;
    }
}
