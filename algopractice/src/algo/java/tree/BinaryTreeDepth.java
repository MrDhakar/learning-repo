package algo.java.tree;

public class BinaryTreeDepth {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		/*
		 * tree.node.left = new Node(2); tree.node.right = new Node(3);
		 * tree.node.left.left = new Node(4); tree.node.left.right = new Node(5);
		 */
		Node root=null ;
		root=tree.insert(root,9 );
		tree.insert(root, 4);
		tree.insert(root,2 );
		tree.insert(root, 1);
		tree.insert(root,3 );
		tree.insert(root, 8);
		tree.insert(root, 6);
		tree.insert(root, 5);
		tree.insert(root, 7);
		tree.insert(root, 15);
		tree.insert(root,12 );
		tree.insert(root, 11);
		tree.insert(root, 14);
		tree.insert(root, 13);
		tree.insert(root, 19);
		tree.insert(root, 17);
		tree.insert(root,20 );
		tree.insert(root, 16);
		tree.insert(root, 18);
		tree.insert(root, 22);
		tree.insert(root, 21);
		tree.insert(root, 23);
		System.out.println("deptOftree :" + deptOftree(root));
		/* System.out.println("inorder traversal : " + tree.inorder(root)); */
		/*
		 * tree.inorder(root); System.out.println();
		 */
		tree.preorder(root);
		System.out.println();
		/* tree.postorder(root); */
		tree.delete(root, 19);
		tree.preorder(root);
		System.out.println("\nnode num"+ tree.findLCA(root,13, 21).num);
		System.out.println("\nleval num"+ tree.findLevel(root,13,0));
		System.out.println("\nleval num"+ tree.findLevel(root,21,0));
		System.out.println("\nleval num"+ tree.findLevel(root,tree.findLCA(root,13, 21).num,0));
		
		System.out.println("\nkth largest "+ tree.kthLargest(root, 2).num);
		System.out.println();
	}

	private static int deptOftree(Node node) {
		// TODO Auto-generated method stub
		if (node == null)
			return 0;
		else if (node.left == null && node.right == null)
			return 1;
		int leftHight = deptOftree(node.left);
		int rightHight = deptOftree(node.right);
		if (leftHight > rightHight)
			return leftHight + 1;
		else
			return rightHight + 1;
	}

}

class BinaryTree {
	Node node;

	BinaryTree() {
		this.node = null;
	}
    
	Node findLCA(int a,int b) {
		
		
		return findLCA(node,a,b);
		
	}
	 Node findLCA(Node node, int a, int b) {
		
		if(node == null) return node;
		
		if(node.num==a || node.num ==b) return node;
		
		Node left=findLCA(node.left, a, b);
		Node right=findLCA(node.right, a, b);
		
		if(left !=null && right !=null) return node;
		
		if(left !=null) return left;
		return right;
	}
	 
	 int findLevel(Node node, int num,int level){
		 if(node == null) return -1;
		 
		 if(node.num== num) {
			 System.out.println("level:"+level+"node.num :" +node.num);
			 return level;
		  }
		 int l = findLevel(node.left, num,level+1);
		 int r = findLevel(node.right, num,level+1);
		 //System.out.println("level:"+level+"node.num :" +node.num);
		 if(l != -1) return l;
		 else return r;
		 
	 }

	/*
	 * BinaryTree(Node node){ this.node= node; }
	 */
	Node insert(Node node, int num) {

		if (node == null) {
			node = new Node(num);
		}

		if (node.num < num) {
			node.right=insert(node.right, num);
		} else if (node.num > num)
			node.left=insert(node.left, num);

		return node;

	}

	Node search(Node node, int num) {
		if (node == null || node.num == num)
			return node;

		if (node.num < num) {
			return search(node.right, num);
		}
		return search(node.left, num);

	}
	
	Node delete(Node node, int num) {
		// if root itself is null
		if (node == null) return node;
		
		if(node.num<num) { // if element is in right tree
			delete(node.right,num);
		}else if (node.num>num) { // if element in left tree
			delete(node.left,num);
		}else { // if element is found
			if(node.left == null) return node.right; // if left child does not exist then replace with right child
			else if (node.right ==null) return node.left; // if right child does not exist then replace with left child
			else { // if both child exist then find the minimum value node in right child;
				Node temp = minValueNode(node.right);
				node.num= temp.num;
				node.right= delete(node.right, temp.num);
			}
		}
		return node;
		
	}

	private Node minValueNode(Node node) {
		Node current = node;

       
        while (current != null && current.left != null)
            current = current.left;

        return current;
	}
	
	Node kthLargest(Node node, int k) {
		int count=0;
		Node curr= node;
		Node kthLargest = node;
		while(curr !=null) {
			if(curr.right == null) {
				count++;
				if(count==k) return curr;
				else curr= curr.left;
			}
			else {
				Node succ = node.right;
				
			}
		}
		return kthLargest;
		
	}
	
	 void inorder(Node node)
    {
        if (node != null) {
            inorder(node.left);
            System.out.print(" " + node.num);
            inorder(node.right);
        }
    }
	 void preorder(Node node)
    {
        if (node != null) {
        	System.out.print(" " + node.num);
        	preorder(node.left);
            preorder(node.right);
        }
    }
	 void postorder(Node node)
    {
        if (node != null) {	
        	postorder(node.left);
        	postorder(node.right);
        	System.out.print(" " + node.num);
        }
    }
}

class Node {

	int num;
	Node left, right;

	Node(int num) {
		this.num = num;
		left = right = null;

	}
}

