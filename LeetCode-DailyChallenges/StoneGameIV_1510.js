/*

Alice and Bob take turns playing a game, with Alice starting first.

Initially, there are n stones in a pile. On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.

Also, if a player cannot make a move, he/she loses the game.

Given a positive integer n, return true if and only if Alice wins the game otherwise return false, assuming both players play optimally.

 

Example 1:

Input: n = 1
Output: true
Explanation: Alice can remove 1 stone winning the game because Bob doesn't have any moves.
Example 2:

Input: n = 2
Output: false
Explanation: Alice can only remove 1 stone, after that Bob removes the last one winning the game (2 -> 1 -> 0).
Example 3:

Input: n = 4
Output: true
Explanation: n is already a perfect square, Alice can win with one move, removing 4 stones (4 -> 0).

*/
/**
 * @param {number} n
 * @return {boolean}
 */
var winnerSquareGame = function(n) {
    return DP[n];
};

const DP = new Array(1e5 + 1).fill(0);

(function (n) {
  for(let i = 1; i <= n; i++) {
    for(let j = 1; j * j <= i && !DP[i]; j++) {
      DP[i] |= !DP[i - j * j];   
    }
  }
}(1e5));
