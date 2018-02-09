import java.util.*;

class Main{

	 static class Node{
		int data;
		Node next;

		public Node(int data){
			this.data=data;
			this.next=null;
		}
	}

 static class LinkedListClass{
		static Node head=null;
		Node cur=null;



		public void insert(int data){
			
			Node newNode=new Node(data);

			if(head==null){
				head=newNode;
				cur=head;
			}
			else{
				cur.next=newNode;
				cur=cur.next;
			}
		}

		public void Display(Node copy){
			Node displayNode=copy;
			while(displayNode!=null){
				System.out.print(displayNode.data+" ");
				displayNode=displayNode.next;
			}
			System.out.println();
		}

		public Node  sort(Node left ,Node right){

			Node result=null;

			if(left==null) return right;
			else if(right==null) return left;

			if(left.data<=right.data){
				result=left; 
				result.next=sort(left.next,right);
			}
			else{
				result=right;
				result.next=sort(left,right.next);
			}
			
			return result;
		}

		public Node merge(Node h){

			if(h==null|| h.next==null){
				return h;
			}

			Node getMiddleNode=getMiddle(h);
			
			Node rightPart=getMiddleNode.next;

			getMiddleNode.next=null;

			// head is now diconnected to left half part 
			// as I have set next of getMiddle to null  After 
			// saving the next pointer to right part

			// Display(h);
			// System.out.print("\t");
			// Display(rightPart);

			Node left=merge(h);
			Node right=merge(rightPart);

			Node sortedPart=sort(left,right);

			return sortedPart;
		}

		public Node getMiddle(Node node){

			
			if (node == null)
            return node;

          Node fastptr = node.next;
          Node slowptr = node;
         
        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (fastptr != null)
        {
            fastptr = fastptr.next;
            if(fastptr!=null)
            {
                slowptr = slowptr.next;
                fastptr=fastptr.next;
            }
        }
        return slowptr;
		

	}
	Node h1;
	
	public Node reverse(Node prev,Node r){

			if(r.next==null){
				h1=r;
				h1.next=prev;
				return null;
			}

			Node save=r.next;

			r.next=prev;

			reverse(r,save);
			return h1;
		}


	public Node reverseK(Node head, int k)
    {
       Node current = head;
       Node next = null;
       Node prev = null;
        
       int count = 0;
 		
 	if((size-T)>=k){

       while (count < k && current != null) 
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
           T++;
       }

   }
   else{

   	return head;
   }
 
       if (next != null) 
          head.next = reverseK(next, k);
 
       return prev;
    }
		
		
	
	
}

static int size=0,T=0;

	public static  void main(String args[]){

			Scanner sc=new Scanner(System.in);

			LinkedListClass Refhead=new LinkedListClass();

			int t=sc.nextInt();

			while(t-->0){
			              int val=sc.nextInt();

			              Refhead.insert(val);

			             } 

			             //Refhead.Display(Refhead.head);

			             int k=sc.nextInt();

			             Node copy=Refhead.head;

			             while(copy!=null){
			             	copy=copy.next;
			             	size++;
			             }

			            Refhead.head=Refhead.reverseK(Refhead.head,k); 

			            // Refhead.head=Refhead.merge(Refhead.head);

			             //Refhead.Display(Refhead.head);

			             //Refhead.head=Refhead.reverse(null,Refhead.head);

			             Refhead.Display(Refhead.head);
	}
}