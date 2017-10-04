public class FindMiddleAndDeleteMiddleElement {
	
	public class Node {
			
			String data;
			Node next;
			
			public Node(String str){
				this.data = str;
			}
	}

	public static void main(String arg[])
  {
		FindMiddleAndDeleteMiddleElement fme = new FindMiddleAndDeleteMiddleElement();
		
		Node root = null;
		
		root = fme.createNode("a",root);
		root = fme.createNode("b",root);
		root = fme.createNode("k", root);
		root = fme.createNode("c",root);
		root = fme.createNode("d",root);
		root = fme.createNode("e",root);
		root = fme.createNode("f",root);
		
		fme.findDeleteMid(root);
		
		System.out.println(root);
	}


	public void findDeleteMid(Node hd)
  {	
		Node p1 = hd;
		Node p2 = hd;
		
		while(p2 != null && p2.next != null && p2.next.next != null)
    {
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		p1.data = p1.next.data;
		p1.next = p1.next.next;

	}

		public Node createNode(String str, Node rt)
    {
			Node root = rt;
			
			Node nd = new Node(str);
			
			if(root == null) {
				root = nd;	
				return root;
			}
			
			while(root.next != null) {
				root = root.next;
			}
			
			root.next = nd;
			return rt;
		}
}
