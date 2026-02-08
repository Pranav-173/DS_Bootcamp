import java.util.*;

public class Main {
    static class Node {
        int data;
        Node left, right;
        Node(int d) { data = d; left = right = null; }
    }

    static class BST {
        Node root;
        int size;
        BST() { root = null; size = 0; }

        public boolean isEmpty() { return size == 0; }
        public int size() { return size; }

        public void insert(int key) {
            Node n = new Node(key);
            if (root == null) { root = n; size++; return; }
            Node cur = root;
            Node parent = null;
            while (cur != null) {
                parent = cur;
                if (key < cur.data) cur = cur.left;
                else if (key > cur.data) cur = cur.right;
                else return;
            }
            if (key < parent.data) parent.left = n;
            else parent.right = n;
            size++;
        }

        /*
        public void insert(int key) {
            root = insertRec(root, key);
        }
        private Node insertRec(Node node, int key) {
            if (node == null) { size++; return new Node(key); }
            if (key < node.data) node.left = insertRec(node.left, key);
            else if (key > node.data) node.right = insertRec(node.right, key);
            return node;
        }
        */

        public boolean contains(int key) { return searchNode(key) != null; }

        private Node searchNode(int key) {
            Node cur = root;
            while (cur != null) {
                if (key == cur.data) return cur;
                if (key < cur.data) cur = cur.left;
                else cur = cur.right;
            }
            return null;
        }

        public void inorder(Node node) {
            if (node == null) return;
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }

        public void preorder(Node node) {
            if (node == null) return;
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }

        public void postorder(Node node) {
            if (node == null) return;
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }

        public List<Integer> levelOrder() {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Queue<Node> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node t = q.poll();
                res.add(t.data);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
            return res;
        }

        public Integer findMin() {
            if (root == null) return null;
            Node cur = root;
            while (cur.left != null) cur = cur.left;
            return cur.data;
        }

        public Integer findMax() {
            if (root == null) return null;
            Node cur = root;
            while (cur.right != null) cur = cur.right;
            return cur.data;
        }

        public int height() { return heightRec(root); }
        private int heightRec(Node node) {
            if (node == null) return -1;
            return 1 + Math.max(heightRec(node.left), heightRec(node.right));
        }

        public Integer successor(int key) {
            Node node = searchNode(key);
            if (node == null) return null;
            if (node.right != null) {
                Node t = node.right;
                while (t.left != null) t = t.left;
                return t.data;
            } else {
                Node cur = root;
                Integer succ = null;
                while (cur != null) {
                    if (key < cur.data) { succ = cur.data; cur = cur.left; }
                    else if (key > cur.data) cur = cur.right;
                    else break;
                }
                return succ;
            }
        }

        public Integer predecessor(int key) {
            Node node = searchNode(key);
            if (node == null) return null;
            if (node.left != null) {
                Node t = node.left;
                while (t.right != null) t = t.right;
                return t.data;
            } else {
                Node cur = root;
                Integer pred = null;
                while (cur != null) {
                    if (key > cur.data) { pred = cur.data; cur = cur.right; }
                    else if (key < cur.data) cur = cur.left;
                    else break;
                }
                return pred;
            }
        }

        public void clear() { root = null; size = 0; }

        public void delete(int key) {
            root = deleteRec(root, key);
        }

        private Node deleteRec(Node node, int key) {
            if (node == null) return null;
            if (key < node.data) node.left = deleteRec(node.left, key);
            else if (key > node.data) node.right = deleteRec(node.right, key);
            else {
                if (node.left == null && node.right == null) {
                    size--; return null;
                } else if (node.left == null) {
                    size--; return node.right;
                } else if (node.right == null) {
                    size--; return node.left;
                } else {
                    Node succ = node.right;
                    while (succ.left != null) succ = succ.left;
                    node.data = succ.data;
                    node.right = deleteRec(node.right, succ.data);
                }
            }
            return node;
        }

        /*
        public void delete(int key) {
            Node cur = root;
            Node parent = null;
            while (cur != null && cur.data != key) {
                parent = cur;
                if (key < cur.data) cur = cur.left;
                else cur = cur.right;
            }
            if (cur == null) return;
            if (cur.left == null && cur.right == null) {
                if (parent == null) root = null;
                else if (parent.left == cur) parent.left = null;
                else parent.right = null;
                size--;
            } else if (cur.left == null || cur.right == null) {
                Node child = cur.left != null ? cur.left : cur.right;
                if (parent == null) root = child;
                else if (parent.left == cur) parent.left = child;
                else parent.right = child;
                size--;
            } else {
                Node succParent = cur;
                Node succ = cur.right;
                while (succ.left != null) { succParent = succ; succ = succ.left; }
                cur.data = succ.data;
                if (succParent.left == succ) succParent.left = succ.right;
                else succParent.right = succ.right;
                size--;
            }
        }
        */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST tree = new BST();
        int choice = 0;
        while (choice != 16) {
            System.out.println("1 Insert 2 Delete 3 Search 4 Inorder 5 Preorder 6 Postorder 7 LevelOrder 8 Min 9 Max 10 Successor 11 Predecessor 12 Clear 13 Size 14 Height 15 IsEmpty 16 Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int v1 = sc.nextInt();
                    tree.insert(v1);
                    break;
                case 2:
                    int v2 = sc.nextInt();
                    tree.delete(v2);
                    break;
                case 3:
                    int v3 = sc.nextInt();
                    System.out.println(tree.contains(v3) ? "Found" : "Not Found");
                    break;
                case 4:
                    tree.inorder(tree.root);
                    System.out.println();
                    break;
                case 5:
                    tree.preorder(tree.root);
                    System.out.println();
                    break;
                case 6:
                    tree.postorder(tree.root);
                    System.out.println();
                    break;
                case 7:
                    System.out.println(tree.levelOrder());
                    break;
                case 8:
                    System.out.println(tree.findMin());
                    break;
                case 9:
                    System.out.println(tree.findMax());
                    break;
                case 10:
                    int v10 = sc.nextInt();
                    System.out.println(tree.successor(v10));
                    break;
                case 11:
                    int v11 = sc.nextInt();
                    System.out.println(tree.predecessor(v11));
                    break;
                case 12:
                    tree.clear();
                    break;
                case 13:
                    System.out.println(tree.size());
                    break;
                case 14:
                    System.out.println(tree.height());
                    break;
                case 15:
                    System.out.println(tree.isEmpty());
                    break;
                case 16:
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
        sc.close();
    }
}
