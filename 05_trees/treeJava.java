
				//~~~~~~~~~~~~~~~~~~~~~~~@@@@@@@@@@@@@@@_____________K_____S_____J__________@@@@@@@@@@@@@@@@@@@@@@@@@@@@~~~~~~~~~~~~~~~~~~~~~~~~~~  2222200000001111111888888888
		//Date:00/00/18
		//-------------


import java.util.*;
import java.io.*;
import java.util.Collections.*;

/*

    [[[[[[[[[[[[[[[      ]]]]]]]]]]]]]]]
    [::::::::::::::      ::::::::::::::]
    [::::::::::::::      ::::::::::::::]
    [::::::[[[[[[[:      :]]]]]]]::::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[    CODE YOUR LIFE    ]:::::]
    [:::::[   Kripa Shankar jha  ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [::::::[[[[[[[:      :]]]]]]]::::::]
    [::::::::::::::      ::::::::::::::]
    [::::::::::::::      ::::::::::::::]
    [[[[[[[[[[[[[[[      ]]]]]]]]]]]]]]]
*/

 class treeJava{
	
	  static Parser sc=new Parser(System.in);
	  static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	static int arr[]=new int[100001];
	static ArrayList<Integer> al1=new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		// use ((((((( sc ............... for input




		Scanner sc=new Scanner(System.in);

		int t=sc.nextInt();

		while(t-->0){

		Node root=null;
		k=0;
		int n=sc.nextInt();
		

		// for(int i=0;i<n;i++){
		// 	arr[i]=sc.nextInt();
		// }


		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		for(int i=0;i<n;i++){	
			root=insert(root,arr[i]);
		}

		preOrder(root);

		int sum=0;
		int brr[]=new int[n];

		for(int i=0;i<n;i++){
			sum=0;
			for(int j=0;j<n;j++){

				
					if(arr[i]<=arr[j]){
						sum+=arr[j];
				
				}
			}
			brr[i]=sum;
			sum=0;
		}

		System.out.println();		
		for(int i=0;i<n;i++)System.out.print(brr[i]+" ");

		System.out.println();
		

	//	int l=sc.nextInt(),r=sc.nextInt();



		//root=put(0,n-1);
        
        // System.out.print("# Preorder : ");    
        // preOrder(root,l,r);
        // System.out.println();

        // System.out.print("# Nodes within range are : ");        
        
        // Collections.sort(al1);
        // for(int i=0;i<al1.size();i++){
        //     System.out.print(al1.get(i)+" ");    
        // }	
        // al1.clear();
        System.out.println();
		
		    
		}
			
			out.close();		
	}

static int k=0;
	public static Node put(int l,int b){

			if(l>b)return null;

			int mid=(b+l)/2;

			Node root=new Node(arr[mid]);

				root.left=put(l,mid-1);
				root.right=put(mid+1,b);

		return root;
	}

	
	public static void preOrder(Node root){

		if(root!=null){
		
			// if(root.val>=l && root.val<=r){
			//   al1.add(root.val);
			
			System.out.print(root.val+" ");
			arr[k++]=root.val;
			preOrder(root.left);
			preOrder(root.right);
		}
	}



	public static Node insert(Node root,int val){
		Node newNode=new Node(val);
		if(root==null){
			root=newNode;
		}
		else{
				if(val<root.val)
			     root.left=insert(root.left,val);
			 	else if(val>root.val) 
			     root.right=insert(root.right,val);	
			}

		return root;
	}

	public static Node remove(Node root ,int val){

		if(root==null) return null;

		if(root.val<val){
			root.right=remove(root.right,val);
		}
		else{
			root.left=remove(root.left,val);
		}


		if(root.left==null){
			return root.right;
		}
		else if(root.right==null){
			return root.left;
		}


		root.val=minVal(root,val);

		root.right=remove(root.right,root.val);

		return root;
	}


	public static int minVal(Node root,int val){

		int minVal=root.right.val;
		while(root.left!=null){
			root=root.left;
			minVal=root.val;
		}
		return minVal;
	}


	static class Node{
		int val;
		Node left,right;

		Node(int no){
			this.val=no;
			this.left=null;
			this.right=null;
		}
	}









static void permutingArray(java.util.List<Node> arrayList, int element){
        for(int i = element; i < arrayList.size(); i++){
            java.util.Collections.swap(arrayList, i, element);
            permutingArray(arrayList, element+1);
            java.util.Collections.swap(arrayList,element, i);
        }
        if (element == arrayList.size() -1){
            // fun();
        }
    }


public static long power(long x, long y, long p)
{
    long res = 1L;      
 
    x = x % p;  
                
    while (y > 0L)
    {
        if ((y & 1L)==1)
            res = (res*x) % p;
 
        y = y>>1L; // y = y/2
        x = (x*x) % p;  
    }
    return res;
}



	//___________________________Fast-Input_Output-------------------******************* 
	

	static class Parser {
        final private int BUFFER_SIZE = 1 << 26;  // 2^16, a good compromise for some problems
        private InputStream din;    // Underlying input stream
        private byte[] buffer;      // Self-maintained buffer
        private int bufferPointer;  // Current read position in the buffer
        private int bytesRead;      // Effective bytes in the buffer read from the input stream
        private SpaceCharFilter filter;
        public Parser(InputStream in) {
            din = in;
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;

        }

        /**
         * Read the next integer from the input stream.
         * @return The next integer.
         * @throws IOException
         */
        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
				while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
			if (neg) return -result;
            	return result;
        }

        public long nextLong() throws IOException {
            long result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
				while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
			if (neg) return -result;
            	return result;
        }

        public String nextLine()throws IOException {
				int c = read();
				while (isSpaceChar(c))
					c = read();
				StringBuilder res = new StringBuilder();
				do {
					res.appendCodePoint(c);
					c = read();
				} while (!isEndOfLine(c)==true);
				return res.toString();
			}

			public boolean isSpaceChar(int c) {
				if (filter != null)
					return filter.isSpaceChar(c);
				return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
			}
	 
			private boolean isEndOfLine(int c) {
				return c == '\n' || c == '\r' || c == -1;
			}
			public interface SpaceCharFilter {
				public boolean isSpaceChar(int ch);
			}


        /**
         * Read the next byte of data from the input stream.
         * @return the next byte of data, or -1 if the end of the stream is reached.
         * @throws IOException if an I/O error occurs.
         */
        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        /**
         * Read data from the input stream into the buffer
         * @throws IOException if an I/O error occurs.
         */
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }
}
			