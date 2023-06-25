package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 此处设计的二分搜索树不包含重复元素
 */
public class BinarySearchTree<E extends Comparable<E>> {

  private class Node {
    public E e;
    public Node left, right;
    
    public Node(E e) {
      this.e = e;
      this.left = null;
      this.right = null;
    }
  }

  private Node root;
  private int size;

  public BinarySearchTree() {
    this.root = null;
    this.size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  // 非递归写法
  public void add1(E e) {
    if (root == null) {
      root = new Node(e);
      size++;
      return;
    }

    Node p = root;

    while (p != null) {
      if (e.compareTo(p.e) < 0) {
        if (p.left == null) {
          p.left = new Node(e);
          size ++;
          return;
        } else {
          p = p.left;
        }
      } else if (e.compareTo(p.e) > 0) {
        if (p.right == null) {
          p.right = new Node(e);
          size++;
          return;
        } else {
          p = p.right;
        }
      } else {
        return;
      }
    }
  }

  // 向二分搜索树中添加一个元素
  public void add(E e) {
    // if (root == null) {
    //   root = new Node(e);
    //   size++;
    // } else {
    //   add(root, e);
    // }

    root = add(root, e);
  }

  // 向以node为根的二分搜索树中删除一个元素E，递归算法
  // 插入时，要不断地比较要插入的元素和子树中根元素的大小，
  // 以判断插入到左边还是右边
  private Node add(Node node, E e) {
    if (node == null) {
      size++;
      return new Node(e);
    }

    // 比较e和跟子树的根元素大小，来判断插入到左边还是右边
    // 比较后，改变子树根元素的值，然后继续递归
    if (e.compareTo(node.e) < 0) {
      node.left = add(node.left, e);
    } else if (e.compareTo(node.e) > 0) {
      node.right = add(node.right, e);
    }
    // 最后等于0不做任何操作


    return node;
    // if (e.equals(node.e)) {
    //   return;
    // } else if (e.compareTo(node.e) < 0 && node.left == null) {
    //   node.left = new Node(e);
    //   size++;
    //   return;
    // } else if (e.compareTo(node.e) > 0 && node.right == null) {
    //   node.right = new Node(e);
    //   size++;
    //   return;
    // }

    // if (e.compareTo(node.e) < 0) {
    //   add(node.left, e);
    // } else {
    //   add(node.right, e);
    // }
  }


  public boolean contains(E e) {
    return contains(root, e);
  }

  private boolean contains(Node node, E e) {
    if (node == null) {
      return false;
    }

    if (e.compareTo(node.e) == 0) {
      return true;
    } else if (e.compareTo(node.e) < 0) {
      return contains(node.left, e);
    } else {
      return contains(node.right, e);
    }
  }

  // 二分搜索树非递归实现前序遍历
  public void preOrderNR() {
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    
    while(!stack.isEmpty()) {
      Node cur = stack.pop();
      System.out.println(cur.e);

      // 右子树先入栈
      if (cur.right != null) {
        stack.push(cur.right);
      }

      // 左子树后入栈
      if (cur.left != null) {
        stack.push(cur.left);
      }

    }
  }

  // 二分搜索树的前序遍历
  public void preOrder() {
    preOrder(root);
  }

  private void preOrder(Node node) {
    if (node == null) {
      return;
    }

    System.out.println(node.e);
    preOrder(node.left);
    preOrder(node.right);
  }

  // 二分搜索树的中序遍历
  public void inOrder() {
    inOrder(root);
  }

  private void inOrder(Node node) {
    if (node == null) {
      return;
    }

    inOrder(node.left);
    System.out.println(node.e);
    inOrder(node.right);
  }

  // 二分搜索树的后序遍历
  public void postOrder() {
    postOrder(root);
  }

  private void postOrder(Node node) {
    if (node == null) {
      return;
    }

    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.e);
  }

  // 二分搜索树的层次遍历
  public void levelOrder() {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node cur = queue.remove();
      System.out.println(cur.e);
      
      if (cur.left != null) {
        queue.add(cur.left);
      }

      if (cur.right != null) {
        queue.add(cur.right);
      }
    }
  }

  // 寻找二分搜索树的最小值
  public E minimum() {
    if (size == 0) {
      throw new IllegalArgumentException("BST is empty");
    }

    return minimum(root).e;
  }

  private Node minimum(Node node) {
    if (node.left == null) {
      return node;
    }

    return minimum(node.left);
  }

  // 寻找二分搜索树的最大值
  public E maximum() {
    if (size == 0) {
      throw new IllegalArgumentException("BST is empty");
    }

    return maximum(root).e;
  }

  private Node maximum(Node node) {
    if (node.right == null) {
      return node;
    }

    return maximum(node);
  }

  // 删除二分搜索树的最小值
  public E removeMin() {
    if (size == 0) {
      throw new IllegalArgumentException("BST is empty");
    }
    
    E ret = minimum();



    return ret;
  }

  // 删除以node为根的二分搜索树的最小节点
  // 返回删除节点后新的二分搜索树的根
  private Node removeMin(Node node) {
    
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    generateBSTString(root, 0, sb);
    return sb.toString();
  }

  // 生成以node为根节点，深度为depth的描述二叉树的字符串
  private void generateBSTString(Node node, int depth, StringBuilder sb) {
    if (node == null) {
      sb.append(generateDepthString(depth) + "null\n");
      return;
    }

    sb.append(generateDepthString(depth) + node.e + "\n");
    generateBSTString(node.left, depth + 1, sb);
    generateBSTString(node.right, depth + 1, sb);
  }

  private String generateDepthString(int depth) {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < depth; i++) {
      res.append("--");
    }
    return res.toString();
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
    int[] nums = {5, 3, 6, 8, 4, 2};
    for (int i : nums) {
      tree.add(i);
    }

    // tree.preOrder();
    // System.out.println();
    // tree.preOrderNR();

    // tree.inOrder();
    // System.out.println();
    
    // tree.postOrder();
    // System.out.println();

    // tree.levelOrder();


    // System.out.println(tree.toString());
  }
}
