/*
On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.
Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

Constraints:

1 <= instructions.length <= 100
instructions[i] is 'G', 'L' or, 'R'.
 
 */

class Solution {
    public boolean isRobotBounded(String instructions) {
      
      // we know that robot can move in 4 direction's
        // Up, left, down, right
        int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}};
        int i = 0; // we have to keep tracking those cases where it's not rotating.
        // if in the end of execution, we see it's not rotating we will gonna return false;
       
        // it's origin
        int x = 0;
        int y = 0;
      
      // let's write an for loop & iterate through the instructions. So, we keep 1 instructions at a time. 
// And we will keep checking the position of the robot after executing particular instruction.
        for(int s = 0; s < instructions.length(); s++){
            // Now, we are checking is it a rotation
            if(instructions.charAt(s) == 'L'){ // If it's left then update it's head rotation
                i = (i + 1) % 4; // since we are increment "i". To avoid array out of bound exception, we are moduling by 4
            }
            else if(instructions.charAt(s) == 'R'){ // If it's right then update it's head rotation
                i = (i + 3) % 4;
            }
            // We are checking it's direction
            else{
                x = x + dir[i][0];
                y = y + dir[i][1];
            }
        }
      // If the robot perform 1 circle, then it mean's it will gauranteed that it will come back to the origin.
        // If i is  0 at the end, it mean's robot is moving straight, hence there is no cycle. It will never come back to origin. 
		// But if it's not equal to 0, then it's in a circle
        return x == 0 && y == 0 || i != 0;
      
    }
}
