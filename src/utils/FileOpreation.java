package utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOpreation {
  // 读取文件名为filename的文件内容，并把其中所包含的所有词语放进words中
  public static boolean readFile(String filename, ArrayList<String> words) {

    if (filename == null || words == null) {
      System.out.println("filename is null or words is null");
      return false;
    }

    // 读取文件
    Scanner scanner;
    
    try {
      File file = new File(filename);
      if (file.exists()) {
        FileInputStream fis = new FileInputStream(file);
        scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
        scanner.useLocale(Locale.ENGLISH);
      } else {
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

    // 简单分词
    if (scanner.hasNextLine()) {
      String contents = scanner.useDelimiter("\\A").next();
      int start = firstCharacterIndex(contents, 0);
      for (int i = start + 1; i <= contents.length();) {
        if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
          String word = contents.substring(start, i).toLowerCase();
          words.add(word);
          start = firstCharacterIndex(contents, i);
          i = start + 1;
        } else {
          i++;
        }
      }
    }

    return true;
  }

  // 寻找字符串中，从 start 位置开始的第一个字母字符的位置
  private static int firstCharacterIndex(String s, int start) {
    for (int i = start; i < s.length(); i++) {
      if (Character.isLetter(s.charAt(i))) {
        return i;
      }
    }
    return s.length();
  }
}
