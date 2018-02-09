import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static String Str[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
 
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
 
		Scanner sc=new Scanner(System.in);
 
		int n=4;
 
 
 
		// while(n%(10*4)==0){
 
		// 	n/=10;
 
		// }
 
		// 

		int arr[][]=new int[n][n];
		
		int count=5;

		Random rand=new Random();

		for(int i=0;i<n;i++){
		
			for(int j=0;j<n;j++){

				arr[i][j]=0;
			}
		}

		for(int i=1;i<=count;i++){
			arr[rand.nextInt(50)][rand.nextInt(50)]=i;
		}


		for(int i=0;i<n;i++){

			for(int j=0;j<n;j++){
				System.print(arr[i][j]+" ");
			}
			System.out.println();
		}

//------------------------------------------ 
		// char arr[][]=new char[n][n];

		// for(int i=0;i<n;i++){
		// 	Arrays.fill(arr[i],'X');
		// }

		// nQueen(arr,0,n);

		// for(int i=0;i<n;i++){
		// 	for(int j=0;j<n;j++){
		// 		System.out.print(arr[i][j]+" ");
		// 	}

		// 	System.out.println();
		// }
//-----------------------------------------------

		//ToH(3,'A','B','C');
 
//------------------------------------------------- 
		//print(n);
		//funcF(n);
		//System.out.println();
		//funcB(n);
	}
 
 
	static void print(int n){
 
		if(n<=0)return;
 
		print(n/10);
		//System.out.println("<>"+n);
		System.out.println(Str[n%10]);
 
	}
 
 
	static void bubble_Sort(int arr[],int be,int en){
		if(en<=be)return;
 
	       bubble_Sort(arr,be+1,en);	
 
	       if(arr[be]>arr[be+1]){
 
			arr[be]^=arr[be+1];
			arr[be+1]^=arr[be];
			arr[be]^=arr[be+1];
	 
	       bubble_Sort(arr,be+1,en);	
 
 
	       }
 
	}
 
 
	static void ToH( int n,char src,char des,char aux){
 
		if(n==0){
		    return;
		}
		ToH(n-1,src,aux,des);
		System.out.println("move Disc "+n+"-- from "+src+" to "+des);
		ToH(n-1,aux,des,src);
	}

	//   2^n -1 
 
static boolean checkCondition(int arr[][],int i,int j,int no,int n){

		//check 9

		 //i-i%3
		//j-j%3
		//j-j%root(n)
		
		int rootN=(int)Math.sqrt(n);
		int lx=i- i%rootN;
		int ly=j- j%rootN;

		for(int x=lx;x<lx+rootN;x++){
			for(int y=ly;y<ly+rootN;y++){
				if(arr[i][j]==no){
					return false;
				}
			}
		}

		for(int x=0;x<n;x++){
			if(arr[i][x]==no) return false;
			if(arr[x][j]==no) return false;
		}

		return true;
} 

static boolean  solveSuduko(int arr[][],int r,int c,int n){

	if(r>=n)return true;

	if(c>=n) return solveSuduko(arr,r+1,0,n);

	if(arr[r][c]!=0){
		return solveSuduko(arr,r,c+1,n);
	}

			for(int no=1;no<10;no++){

				if(checkCondition(arr,r,c,no,n)==true){
					arr[r][c]=no;

					boolean ans=solveSuduko(arr,r,c+1,n);

					if(ans==true){
						return true;
					}

					arr[r][c]=0;
				}

			}

		return false;
}



 
 
 static boolean checkIf(char arr[][],int i,int j,int n){
//checkForRow

 	for(int k=j;k<n;k++){
 			if(arr[i][k]=='Q')return false;
 			if(arr[k][j]=='Q')return false;
 	}


 	int rowDir[]={-1,-1,1,1};
 	int colDir[]={-1,1,1,-1};

 	for(int dir=0;dir<4;dir++){

 		for(int dist=0;dist<n;dist++){

 			int r=i+rowDir[dir]*dist;
 			int c=j+colDir[dir]*dist;

 			if(r>0 && c>0 && r<n && c<n && arr[r][c]=='Q'){
 				return false;
 			}
 		}
 	}


 	return true;
 }



 	static boolean nQueen(char arr[][],int i,int n){

 		if(n==i)return true;

	 		for(int j=0;j<n;j++){

	 			if(checkIf(arr,i,j,n)==true){

	 				arr[i][j]='Q';

	 				boolean isSucess=nQueen(arr,i+1,n);

	 				if(isSucess==true){
	 					return true;
	 				}

	 				arr[i][j]='X';

	 			}		
	 		}

	 		return false;
 	}
 
 
 
 
 
 
	static void bubble(int arr[],int n){
 
		if(n<=0)return;
 
		for(int i=0;i<n;i++){
 
			if(arr[i]<arr[i+1]){
 
				arr[i]^=arr[i+1];
				arr[i+1]^=arr[i];
				arr[i]^=arr[i+1];
 
 
			}
		}
 
 
		bubble(arr,n-1);
	}
 




 
 
	static void funcF(int n){
		if(n<=0)return;
 
		funcF(n-1);
		System.out.print(n+" ");
 
	}
 
 
	static void funcB(int n){
		if(n<=0)return;
 
		System.out.print(n+" ");
		funcB(n-1);
	}
}