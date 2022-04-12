/*

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

 

Example 1:


Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

*/

class Solution {
    
    private static final int[][] DIRS = {{-1, -1}, // top-left
 									 {-1, 0},  // top
									 {-1, 1},  // top-right
									 {0, -1},  // left
									 {0, 1},   // right
									 {1, -1},  // bottom-left
									 {1, 0},   // bottom
									 {1, 1}};  // bottom-right

public void gameOfLife(int[][] board) {
	var rows = board.length;
	var cols = board[0].length;
	playGame(board, rows, cols);
	updateBoard(board, rows, cols);
}

private void playGame(int[][] board, int rows, int cols) {
	for (var i = 0; i < rows; i++)
		for (var j = 0; j < cols; j++) {
			var alive = aliveNeighbors(board, rows, cols, i, j);
			// Dead cell with 3 live neighbors becomes alive
			if (board[i][j] == 0 && alive == 3) // board[i][j] = 00
				board[i][j] = 2; // board[i][j] = 10
			// Live cell with 2 or 3 live neighbors lives on
			else if (board[i][j] == 1 && (alive == 2 || alive == 3)) // board[i][j] = 01
				board[i][j] = 3; // board[i][j] = 11
		}
}

private int aliveNeighbors(int[][] board, int rows, int cols, int i, int j) {
	var alive = 0;
	for (var dir : DIRS) {
		var neighborX = i + dir[0];
		var neighborY = j + dir[1];
		if (!isOutOfBounds(rows, cols, neighborX, neighborY))
			alive += board[neighborX][neighborY] & 1;
	}
	return alive;
}

private boolean isOutOfBounds(int rows, int cols, int x, int y) {
	return x < 0 || x >= rows || y < 0 || y >= cols;
}

private void updateBoard(int[][] board, int rows, int cols) {
	for (var i = 0; i < rows; i++)
		for (var j = 0; j < cols; j++)
			board[i][j] >>= 1; // right shift 1 bit to replace old state with new state
}
}
