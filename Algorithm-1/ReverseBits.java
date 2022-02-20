/*

Reverse bits of a given 32 bits unsigned integer.

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 

Example 1:

Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:

Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.

*/

public class Solution {
         // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int res =0;   // initialize reverse res as zero (no bit is set)
        int j = 0;    // j pointing to MSB (most significant bit) of res
        
        // Traverse n which is of 32 bit from end and check if ith's ith bit set or not
        for(int i = 31; i>=0 ;i--)
        {   
            // the mask is used to move 1 to left each time when i move to left
            int mask = 1<<i;
            
            // if n & mask results in non - zero number then it means bit is set at ith place hence set the bit in res at jth place also
            if((n & mask) != 0) // & operator is used to check if bit is 1 or 0 i.e set or unset
            {   
                // In order to set bit at jth place we need setmask which would have 1 (set bit) at jth position only
                int smask = 1<<j;
                res = res | smask;  // | (or) operator is used to set bit 
                j++;  // don't forget to move j pointer too, as it is helpful in setting res 
            }
            // if n & mask results in  zero number then it means bit is unset at ith place hence no need to set the bit in res at jth place , just move j to next
            else
                j++;
            
        } return res;
    }
}
