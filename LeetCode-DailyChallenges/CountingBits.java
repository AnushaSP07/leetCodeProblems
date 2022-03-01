/*

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 
 
 */

Let's understand this problem using an example :-

Input: n = 5
Output: [0,1,1,2,1,2]
So, from 0 to n i.e. -> 0 to 5 how many numbers are present in b/w 0 & 5, we have to return no. of 1 present in thier binary representation in our array.

Wait this line is looking little bit confusing, let's understand it visually:-

image

Now, I hope you understand the problem. Now another question raise in your mind. But how do we get that??

Alright, wait let's see:-
To form 0 we want only 0
To form 1 we want only 1

By saying that i can say if you have any even no. let's say 4. So, you want the answer of 4. Whatever the answer of 4 is the answer of 2 as well. So, i can say that even = n / 2. Lemmi, show you:


2      0010 --> 1
3      0011
4      0100 --> 1
I hope you got the idea. It's simple to get even no. divide by 2
But what about for odd, so to get the value of odd. It's very simple as well. For odd = 1 + n / 2 let's say for 5, what ever the answer of 5 os the answer of 3 as well. Lemmi, show you:


3      0011 --> 2
4      0100
5      0101 --> 2
I hope you got the idea. It's simple to get odd no. divide by 2 + 1
Okay, now you got the idea & you can easily say that we will get our answer using recursively. Let's calculate for 15

image

We get kind of a recursive tree.

Let's code it:

class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n + 1]; // create one result array, 
        // & our array size is n + 1 because we have to cover 0 as well
        
        for(int i = 0; i <= n; i++){ // run a loop to store all the values we get from a solve function
            res[i] = solve(i);
        }
        return res;
    }
    public int solve(int n){
        // base condition
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        if(n % 2 == 0) return solve(n / 2); // handling even case
        else return 1 + solve(n / 2); // handling odd case
    }
}
