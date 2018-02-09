
				//~~~~~~~~~~~~~~~~~~~~~~~@@@@@@@@@@@@@@@_____________K_____S_____J__________@@@@@@@@@@@@@@@@@@@@@@@@@@@@~~~~~~~~~~~~~~~~~~~~~~~~~~  2222200000001111111888888888
		//Date:00/00/18
		//-------------


import java.util.*;
import java.io.*;

/*

    [[[[[[[[[[[[[[[        ]]]]]]]]]]]]]]]
    [::::::::::::::        ::::::::::::::]
    [::::::::::::::        ::::::::::::::]
    [::::::[[[[[[[:        :]]]]]]]::::::]
    [:::::[                        ]:::::]
    [:::::[                        ]:::::]
    [:::::[    Don't Learn to Hack
    			Hack To Learn      ]:::::]
    [:::::[   Kripa Shankar jha    ]:::::]
    [:::::[                        ]:::::]
    [:::::[                        ]:::::]
    [::::::[[[[[[[:        :]]]]]]]::::::]
    [::::::::::::::        ::::::::::::::]
    [::::::::::::::        ::::::::::::::]
    [[[[[[[[[[[[[[[        ]]]]]]]]]]]]]]]
*/

 class ksj_force{
	
	  static Parser sc=new Parser(System.in);
	  static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	 static int arr[][]=new int[1001][1001];

	public static void main(String[] args) throws IOException {
		// use ((((((( sc ............... for input

			// int n=8;
			// if(solveNightProblem(0,0,arr,n,1)){
			// 	System.out.println("Exist");

			// 	for(int i=0;i<n;i++){
			// 		for(int j=0;j<n;j++){
			// 			System.out.print(arr[i][j]+" ");
			// 		}
			// 		System.out.println();
			// 	}

			// }
			// else{
			// 	System.out.println("Solution Doesnt exist");
			// }
         
         int arr[]={1,2,2,3,4};

         int key=2;



         // int index = binarySearch(arr,key,0,arr.length);
         
         // if(index>0 && index<arr.length && arr[index]==key);
         //   System.out.println("Index found at "+ index);
         // else
         // 	System.out.println("No index found");
         

         // System.out.println(" Answer : "+merge(arr,0,4));

         // for(int i=0;i<arr.length;i++){
         // 	System.out.print(arr[i]+" ");
         // }

         int arr[]={8,4,3,7};

         Arrays.sort(arr);

     
         System.out.println("Nahi "+root1(9.0));

			out.close();		
	}



//   

	 // 3 , 4 , 7 , 8
	// 3 , 23
   //  lowestE , sumNo


/*
	8 ,4 3, 7

	8+4 , 3 , 7  == 12

	8 , 3+4 , 7  =8

	8, 3, 4+7   =11

	8+7 , 3 ,4  =15


*/


	public static double root1(double num){

			double be=0;
			double en=num;
			double EPS= 1e6;

			while(be<en){

				double root=(be+en)/2;

				if(Math.abs(root*root-ans)<EPS){
					return root;
				}

				else if(root*root<ans){
					be=root+1;
				}
				else{
					end=root+1;
				}

			}

			return -1;
	}


	


public static int binarySearch(int arr[],int lw,int up){

		while(lw<up){

			int mid=lw+(up-lw)/2;

			if(func(mid1,arr)==true){
				up=mid;
			}
			else{
				lw=mid+1;
			}
		}

		return up;
	}

public static boolean func(int mid,int arr[]){
	
	

	return false;
}









	public static int sort(int arr[],int l,int r,int mid){

		int n1=mid-l+1;
		int n2=r-mid;

		int L[]=new int[n1];
		int R[]=new int[n2];

		for(int i=0;i<n1;i++) { L[i]=arr[l+i]; }
		for(int i=0;i<n2;i++) { R[i]=arr[mid+i+1]; }

		int i=0,j=0,k=l,count=0;

		while(i<n1 && j<n2){

			if(L[i]<R[j]){
				arr[k]=L[i];
				i++;
			}
			else{
				arr[k]=R[j];
				j++;
				count+=((n1-1)-i);
			}
			k++;
		}


		while(i<n1){
			arr[k]=L[i];
			i++;
			k++;
		}	
		while(j<n2){
			arr[k]=R[j];
			j++;
			k++;
		}

		return count;
	}

	static int sum=0;

	public static  int merge(int arr[],int l,int r){

			if(l<r){

			        int mid=(l+r)/2;

			        int LInv=merge(arr,l,mid);
			        int RInv=merge(arr,mid+1,r);
			         sum+=sort(arr,l,r,mid);
			}

			return sum;
	}









	static int dirX[]={-2,-2,-1, 1,2, 2, 1,-1};
	static int dirY[]={-1, 1, 2, 2,1,-1,-2, 2};



	static boolean solveNightProblem(int curI,int curJ,int arr[][],int nSize,int count){

		if(count==(nSize*nSize)+1)
			return true;

		if(curI>=nSize || curJ>=nSize || curI<0 || curJ<0 ||arr[curI][curJ]!=0){
			return false;
		}

		arr[curI][curJ]=count;


		for(int i=0;i<8;i++){
			int nextR= curI+dirY[i];
			int nextC= curJ+dirX[i];

			if(solveNightProblem(nextR,nextC,arr,nSize,count+1)==true){
				return true;
			}
		}

		arr[curI][curJ]=0;

		return false;
	}




static class Node{
  int ii,jj;
  Node(int ii,int jj){
    this.ii=ii;
    this.jj=jj;
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
			