import java.util.Arrays;
import java.util.Scanner;
public class Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int start=0;
        int stop=0;
        int max=-1;
        int sum=0;
        for (int i = 0; i < n-1; i++) {
            if(arr[i]==0) sum=-1;
            else sum=1;
            for(int j=i+1;j<n;j++){
                if(arr[j]==0) sum=sum-1;
                else sum=sum+1;
                if(sum==0 && j-i+1>max){
                    max=j-i+1;
                    start=i;
                    //stop=j;
                }
                }
        }
        stop=start+max-1;
        if(max==-1){
            System.out.println("No sub-array found");
        }
        else{
            System.out.println("start:"+start+"   stop:"+stop);
        }
    }
}
