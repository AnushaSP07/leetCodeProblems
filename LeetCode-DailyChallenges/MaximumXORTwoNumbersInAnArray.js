/*

Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127

*/

const invert = ch => {
  return ch === '0' ? '1' : '0'
}

class Trie {
  constructor() {
    this.nodes = new Map()
  }
  
  add(num) {
    let nodes = this.nodes
    for (const ch of num) {
      const next = nodes.get(ch) ?? new Map()
      nodes.set(ch, next)
      nodes = next
    }
  }
  
  maxXor(num) {
    let ret = []
    let nodes = this.nodes
    for (const ch of num) {
      const key = nodes.has(invert(ch)) ? invert(ch) : ch
      ret.push(key)
      nodes = nodes.get(key)
    }
    ret = ret.join('')
    ret = parseInt(ret, 2)
    num = parseInt(num, 2)
    return ret ^ num
  }
  
}

const findMaximumXOR = nums => {
  let ret = 0
  const len = Math.max(...nums).toString(2).length
  let trie = new Trie()
  for (let i = 0; i < nums.length; i++) {
    nums[i] = nums[i].toString(2).padStart(len, 0)
    trie.add(nums[i])
  }
  for (const num of nums) {
    ret = Math.max(trie.maxXor(num), ret)
  }  
  return ret
}
