import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0){
        
            int n=sc.nextInt(),k=sc.nextInt();
            
            long l=0,r=(long)1E12;
            


            while((r-l)!=1){
                
                long mid=(l+r)/2;
                
                if(fun(mid,k,n)==true){
                    l=mid;        
                }
                else{
                    r=mid;
                }

            }

            System.out.println(l);

        
        }
    }


public static boolean fun(long mid,long k,long n){

    if(Math.pow(mid,k)<=n){
        return  true;
    }
    else{
        return false;
    }
}


}
