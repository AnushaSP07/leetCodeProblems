/*

1220. Count Vowels Permutation
Hard

1835

130

Add to List

Share
Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
Example 2:

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
Example 3: 

Input: n = 5
Output: 68

*/

class Solution {
    public int countVowelPermutation(int n) {
        long[] vowels = new long[5];
        Arrays.fill(vowels, 1);
        int mod = (int) (Math.pow(10, 9) + 7);
        while (n > 1) {
            long[] temp = new long[5];
            temp[0] = (vowels[1] + vowels[2] + vowels[4]) % mod;
            temp[1] = vowels[0] + vowels[2] % mod;
            temp[2] = vowels[1] + vowels[3] % mod;
            temp[3] = vowels[2] % mod;
            temp[4] = vowels[2] + vowels[3] % mod;
            vowels = temp;
            n--;
        }
        return (int) ((vowels[0] + vowels[1] + vowels[2] + vowels[3] + vowels[4]) % mod);
    }
}
