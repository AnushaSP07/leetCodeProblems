/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000 

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3. */

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        
        for(int i=0;i<s.length();i++){
            if(i<s.length()-1 && convertIntToRom(s.charAt(i)) < convertIntToRom(s.charAt(i+1))){
                result = result+convertIntToRom(s.charAt(i+1))-convertIntToRom(s.charAt(i));
                i++;
                continue;
            }
            result+=convertIntToRom(s.charAt(i));
        }   
        return result;
    }
    public int convertIntToRom(char c){
            switch(c){
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
            }
            return -1;
        }
}
