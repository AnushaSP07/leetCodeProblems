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

/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    let map = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    let str = s.split('')
    var total = 0;
    for (let i = 0; i < str.length; i++) {
        if(map[str[i]] < map[str[i+1]]) {
            total += map[str[i+1]] - map[str[i]]; 
            i++;
        } else {
            total += map[str[i]];   
        }
    }
    return total;
};
