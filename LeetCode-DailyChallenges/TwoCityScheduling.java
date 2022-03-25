/*


A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

 

Example 1:

Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
Example 2:

Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
Output: 1859
Example 3:

Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
Output: 3086


*/

/*

Solution 

What the problem statement is saying,

People have given choices to fly either to cityA OR to cityB. But they have to book their flight's by themself.
Now, everyone will choose that city which is cheapest to visit and they'll book the flight ticket according to that city.

Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.
So, let's understand this problem using an simple example:-

[[10,20], [30,200], [40,500], [30, 20]]
Just for sake in the starting assume that we are sending first half to cityA & Second half to cityB

[[10,20], [30,200], [40,500], [30,20]]
  A        A            B         B
And we calcualte the cost it'll be :-

Cost = 10 + 30 + 500 + 20 = 560

Now as we can see the cost is way higher, can we do this in better??

So, ya there will be 3 possiblities:-

If we go from cityA to cityB & there difference is equals. Means, there loss value is 0
If we go from cityA to cityB & cost of cityA > cityB. Means, going to cityB is a much better choice.
If we go from cityA to cityB & cost of cityA < cityB. Means, this will give a loss of -ve which means it's not loss it's profitable going to cityA
[[10,20], [30,200], [40,500], [30, 20]]

Cost = 10 + 30 + 500 + 20 = 560 

Loss = -10  -170  -460  10
Let's sort the list inorder , in which people are more profitable to going to cityA

Loss = -460  -170  -10  10
Now let's change their position :-

[[10,20], [30,200], [40,500], [30,20]]
     B     A         A            B
	 
	 
Cost = 10 + 30 + 500 + 20 = 560 

NewCost = 20 + 30 + 40 + 20 = 110
So, this is a better choice then 560, as wes have gonne to our min cost choice.

I hope so ladies - n - gentlemen approach is absolute clear, Let's code it up:

*/


class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        
        int price = 0;
        for(int i = 0; i < costs.length / 2; i++){
            price += costs[i][0];
        }
        for(int i = costs.length / 2; i < costs.length; i++){
            price += costs[i][1];
        }
        return price;
    }
}
