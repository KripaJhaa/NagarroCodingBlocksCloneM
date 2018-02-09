
				//~~~~~~~~~~~~~~~~~~~~~~~@@@@@@@@@@@@@@@_____________K_____S_____J__________@@@@@@@@@@@@@@@@@@@@@@@@@@@@~~~~~~~~~~~~~~~~~~~~~~~~~~  2222200000001111111888888888
		//Date:00/00/18
		//-------------


import java.util.*;
import java.io.*;

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

 class ksj_force{
	
	  static Parser sc=new Parser(System.in);
	  static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	  static int conVBit(char arr[]){

	  	  int base=1,dec=0,len=arr.length();

	  	  for (int i=len-1;i>=0;i--) {

	  	  	if(arr[i]!='0'){
	  	  		dec+=base;
	  	  	}
	  	  	base*=2;
	  	  }

	  	  return dec;

	  }

	  static int bitArr[]=new int[100001];

	public static void main(String[] args) throws IOException {
		// use ((((((( sc ............... for input


			int n=sc.nextInt();

			long count=0;

			

			for(int i=0;i<n;i++){

				String str=sc.nextLine();

				int arr[]=new int[10];

				for(int j=0;j<str.length();j++){
					arr[str.charAt(j)-'0']++;
				}
				char check[]=new char[10];
				Arrays.fill(check,'1');

				for(int j=0;j<10;j++){

					if(arr[j]>0){
						check[j]='0';
					}
				}

				 bitArr[conVBit(check)]++;


               }
			

			for(int i=0;i<1025;i++){
				for(int j=i;j<1025;j++){

					if((i&j)==0 && i==0 && j==0 && bitArr[0]>0)
						count+=((bitArr[i]*(bitArr[j]-1))/2);

					else if((i&j)==0 && bitArr[i]>0 && bitArr[j]>0) 
						count+=(bitArr[i]*bitArr[j]);

				}
			}

			System.out.println(count);
				


           
			out.close();		
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
