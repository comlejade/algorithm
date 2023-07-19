package leetcode.lc804;

import java.util.TreeSet;

/**
 * 唯一摩斯密码，
 * 使用 TreeSet，基于红黑树实现的 set
 * 时间复杂度 O(logn)
 */
public class Soultion {
  public int uniqueMorseRepresentations(String[] words) {
    // 26个英文字母对应的摩斯码
    String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    TreeSet<String> set = new TreeSet<>();

    for (String word : words) {
      StringBuilder res = new StringBuilder();
      
      for (int i = 0; i < word.length(); i++) {
        res.append(codes[word.charAt(i) - 'a']);
      }

      set.add(res.toString());
    }

    return set.size();
  }

  public static void main(String[] args) {
    
  }
}
