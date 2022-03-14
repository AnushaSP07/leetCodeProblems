/*

Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

 

Example 1:

Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 

Constraints:

1 <= path.length <= 3000
path consists of English letters, digits, period '.', slash '/' or '_'.
path is a valid absolute Unix path.

*/

// Solution

/*

How's going Ladies - n - GentleMen, today we are going to solve another coolest problem i.e. Simplify Path

Alright, so let's understand this problem with an example :-

Input: path = "/a/./b/../../c/"
Output: "/c"

Let's understand what this mean's, so basically this seems like you a path of your folder, so generically we use this kind of command's in terminal. I hope u know a bit about that. Anyway's let's move further on.

okay, so the first command /a/ means get into the folder /a/

The next command is /./ means stay over there

The next command is /b/ means get into the folder /b/

The next command is /../ means come out from the folder /b/

The next command is /../ means come out from the folder /a/

Now we are kind of in home directory

The next command is /c/ means get into the folder /c/

And in the output we return what command we left with.

Let's understand it a bit visually.

Going to /a/./b/
image
Coming out /../../
image
Going to /c/
image
So, basically what are we doing:-
Pushing and Popping directory names based on rules

And what are the rules :-

/.. come out from the directory
/nameOfDirectory going into directory
Now you say, Dude that's A-OK but which Data Structure do we use to solve this problem. Well. i had already gives you a hint if you remember Pushing and Popping. So where do we Generically used in Stack or Queue

We'll solve this problem using Stack. But if you want the solution of Queue as well, do lemmino (:

Alright, back to the problem - So, what we can do is by looking at the rules, split the directrory by the slash/ given and that will give us in the form of array e.g :- [a, ., b, .., .., c]

Let's understand it's working visually:-

image

But remeber when returning we have to go in the form of reverse order. Because Stack use LIFO order and the highest one will comes out. But we need the lowest once first. So, we need to append in the carefull manner.

I hope ladies and gentlemen approach is clear Let's code it up

*/

class Solution {
    public String simplifyPath(String path) {
        
          Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] p =path.split("/");
        
        for(int i=0;i<p.length;i++){
            if(!s.isEmpty()  && p[i].equals("..")) s.pop();
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                s.push(p[i]);
        }
        
        
        if(s.isEmpty()) return "/";
        while(!s.isEmpty()){
            res.insert(0,s.pop()).insert(0,"/");
        }
        
        return res.toString();
    }
}
