import java.util.Arrays;
import java.util.Scanner;
public class longesthappypreefix {
    public static int[] ans(String s, int [] lps){
        char []arr =s.toCharArray();
        int len=0;
        int i=1;
        //int lp[] =new int[arr.length];
        while(i<arr.length){
            if(arr[i]==arr[len]){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
        
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.nextLine();
        String pat =sc.nextLine();
        
        int m=pat.length();
        int n=s.length();
        int i=0; 
        int j=0;
        int lps[] = new int [m];
        ans(pat,lps);
        System.out.println(Arrays.toString(lps));
        while((n-i)>=(m-j)){
            if(pat.charAt(j)==s.charAt(i)){
                i++;
                j++;
            }
            if(j==m){
                System.out.println("Pattern found");
                System.out.println("From index "+(i-j)+" till "+ (i-1));
                j=lps[j-1];

            }
            else if(i<n && pat.charAt(j) !=  s.charAt(i)){
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    i=i+1;
                }
            }
        }
    }
}