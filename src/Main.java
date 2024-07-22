import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*

    class Node
    	int data;
    	Node left;
    	Node right;
	*/

    public static void levelOrder(Node root) {
        HashMap<Integer,HashMap<Integer,Node>> hm = new HashMap();
        hm.put(0,new HashMap());
        //esquerda
        HashMap<Integer, Node> hmcurr = new HashMap();
        int altura = 1;
        Node curr = root;
        hmcurr.put(0, curr);
        hm.put(altura, hmcurr);
        while (hm.get(altura).size() > 0) {
            hmcurr = new HashMap();
            for (int i = 0; i < hm.get(altura).size(); i++) {
                curr = hm.get(altura).get(i);
                if(curr == null){
                    continue;
                }

                if (curr.left != null) {
                    hmcurr.put(i, curr.left);
                }
                if (curr.right != null) {
                    hmcurr.put(i * 2 + 1, curr.right);
                }
            }
            altura++;
            hm.put(altura, hmcurr);
        }
        for (int i = 0; i < hm.size(); i++) {
            for (int j = 0; j < hm.get(i).size(); j++) {
                Node node = hm.get(i).get(j);
                if (node != null) {
                    System.out.print(node.data + " ");
                }
            }
        }

    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}