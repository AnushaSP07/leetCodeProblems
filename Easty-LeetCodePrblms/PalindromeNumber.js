/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    let num = x;
    
    if(x < 0){
      return false
    }
   
  let sum = 0;
  while(num){
    sum * = 10;
    sum + = num%10;
    num = Math.floor(num/10);
  }
  return x===sum;
};
