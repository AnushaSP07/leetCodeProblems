/*

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

*/

/**
 * @param {number} low
 * @param {number} high
 * @return {number[]}
 */
var sequentialDigits = function(low, high) {
     const minLen = low.toString().length;
    const maxLen = high.toString().length;
    const res = [];
    
    for(let i = minLen; i <= maxLen; i++) {
        
        for(let j = 1; j <= 10 - i; j++) {
            let len = i, num = '', delta = j;
            
            while(len--) {
                num += delta;
                delta++;
            }
            num = +num;
            if(num >= low && num <= high) res.push(num);
        }
    }
    return res;
};
