class Solution {
    public boolean isPalindrome(int x) {
      int num, sum = 0, temp = x;
      
      while(x>0){
        num = x%10;
        sum = (sum*10)+num;
        x = x/10;
      }
      if(temp == sum){
        return true;
      }else{
        return false;
      }
   }
