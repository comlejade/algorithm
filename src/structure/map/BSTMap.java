package structure.map;

import java.util.ArrayList;

import utils.FileOpreation;

/**
 * 和集合非常像
 * 平均时间复杂度是O(logn)
 * 只有左子树或只有右子树时会退化成O(n)
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
  private class Node {
    public K key;
    public V value;
    public Node left, right;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      left = null;
      right = null;
    }
  }

  private Node root;
  private int size;

  public BSTMap() {
    root = null;
    size = 0;
  }

  // 向以node为根的二分搜索树中插入元素(key, value)
  // 返回插入新节点后的二分搜索树的根
  private Node add(Node node, K key, V value) {
    if (node == null) {
      size++;
      return new Node(key, value);
    }
    
    if (node.key.compareTo(key) < 0) {
      node.right = add(node.right, key, value);
    } else if (node.key.compareTo(key) > 0){
      node.left = add(node.left, key, value);
    } else {
      node.value = value;
    }

    return node;
  }

  @Override
  public void add(K key, V value) {
    root = add(root, key, value);
  }

  private Node minimum(Node node) {
    if (node.left == null) {
      return node;
    }

    return minimum(node.left);
  }

  // 删除以node为根的二分搜索树的最小节点
  // 返回删除节点后新的二分搜索树的根
  private Node removeMin(Node node) {
    if (node.left == null) {
      Node rightNode = node.right;
      size--;
      return rightNode;
    }
    node.left = removeMin(node.left);
    return node;
  }

  public Node remove(Node node, K key) {
    if (node == null) {
      return null;
    }

    if (key.compareTo(node.key) < 0) {
      node.left = remove(node.left, key);
      return node;
    } else if (key.compareTo(node.key) > 0) {
      node.right = remove(node.right, key);
      return node;
    } else {
      if (node.left == null) {
        Node rightNode = node.right;
        node.right = null;
        size--;
        return rightNode;
      }
  
      if (node.right == null) {
        Node leftNode = node.left;
        node.left = null;
        size--;
        return leftNode;
      }

      // 待删除节点左右子树都不为空
      // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
      // 用这个节点顶替待删除节点的位置
      Node successor = minimum(node.right);
      // removeMin 在子树中找到最小值并删除
      // 将右子树大小最接近要删除的元素的右子树指向 删除最新值后的node.right
      successor.right = removeMin(node.right);
      // size++;

      // 将要删除的节点的右子树挂到 successor 上
      successor.left = node.left;
      // 将要删除的节点的左右子树删除
      node.left = node.right = null;
      // size--;
      // 返回node被替代后新的节点
      return successor;
    }


    
  }

  

  @Override
  public V remove(K key) {
    Node node = getNode(root, key);
    if (node != null) {
      root = remove(root, key);
      return node.value;
    }
    return null;
  }

  public Node getNode(Node node, K key) {
    if (node == null) {
      return null;
    }

    if (node.key.compareTo(key) < 0) {
      return getNode(node.right, key);
    } else if (node.key.compareTo(key) > 0) {
      return getNode(node.left, key);
    } else {
      return node;
    }
  }

  @Override
  public boolean contains(K key) {
    return getNode(root, key) != null;
  }

  @Override
  public V get(K key) {
    Node node = getNode(root, key);
    
    return node == null ? null : node.value;
  }

  @Override
  public void set(K key, V value) {
    Node node = getNode(root, key);
    if (node == null) {
      throw new IllegalArgumentException(key + " doesn't exists. ");
    }
    node.value = value;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  public static void main(String[] args) {
    System.out.println("双城记");

    ArrayList<String> words = new ArrayList<>();
    FileOpreation.readFile("src/utils/shuang.txt", words);
    System.out.println("total words: " + words.size());

    BSTMap<String, Integer> map = new BSTMap<>();

    for (String word : words) {
      if (map.contains(word)) {
        map.set(word, map.get(word) + 1);
      } else {
        map.add(word, 1);
      }
    }

    System.out.println(map.getSize());
  }
}
