import java.util.Deque;
import java.util.LinkedList;
import java.util.HashSet;
public class balancedTreeSum{
Deque<Node> queue = new LinkedList<Node>();
   public class Node{
        Node left;
        Node right;
        int data;
    }
    Node insertNode(Node root, int val){
        Node newNode = newNode(val);
        if(root == null){
            root = newNode;
            queue.add(root);
            return root;
        }
        
       else{
           Node node;
           node=queue.remove();
          if(node.left == null){
              node.left=newNode;
              queue.add(node.left);
              queue.addFirst(node);
              return root;
          }
          else if(node.right == null){
              node.right=newNode;
              queue.add(node.right);
              return root;
          }
       }
       return root;
    }

    public Node newNode(int k){
        Node temp= new Node();
        temp.data = k;
        temp.left = null;
        temp.right = null;
        return temp;
    }
//searchPair is used to check if the values in the set fit the given sum by reducing it from the tree
    public boolean searchPair(Node root,int sum, HashSet<Integer> set){
 
        if(root == null){
            return false;
                }
                if(searchPair(root.left,sum,set))
                return true;
                if(set.contains(sum - root.data)){
                    System.out.println("pair found ( "+(sum - root.data) +","+root.data+" )");
                    return true;
                }
                else
                set.add(root.data);
                return searchPair(root.right,sum,set);
            }
// searchPairSum alerts if the pair is not present
    public void searchPairSum(Node root,int sum){
        HashSet<Integer> set = new HashSet<Integer>();
        if(!searchPair(root,sum,set))
        System.out.println("Pair does not exist");
    }
    public static void main(String[] args) {
        Node root = null;
        //object of the class to call functions
        balancedTreeSum getSum = new balancedTreeSum();
        root = getSum.insertNode(root,40);
        root = getSum.insertNode(root,20);
        root = getSum.insertNode(root,60);
        root = getSum.insertNode(root,10);
        root = getSum.insertNode(root,30);
        root = getSum.insertNode(root,50);
        root = getSum.insertNode(root,70);
        int sum= 100;
        int sum2 =130;
        int sum3 =150;
        int sum4 =120;
        getSum.searchPairSum(root,sum);
        getSum.searchPairSum(root,sum2);
        getSum.searchPairSum(root,sum3);
        getSum.searchPairSum(root,sum4);
    }
}