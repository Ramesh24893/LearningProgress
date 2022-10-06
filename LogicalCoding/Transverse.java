import java.util.Scanner;
public class Transverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int max=-1;
            int c=0;
            for(int j=i+1;j<n;j++){
               if(c==0){
                   if(arr[j]>arr[i]){
                       max=arr[j];
                       c++;
                    }
                    }
               else{
                   if(arr[j]<max && arr[j]>arr[i] ){
                   max=arr[j];
                   }
            }}
            System.out.println(max);
        }
    }
}

//2 5 7 ---> 5 7 -1
//2 4 8 90 77 54 --> 4 8 54 -1 -1 -1
// 2 -1 0 -1 3 ---> 3 0 3 3 -1






















/*
        for(int i=0;i<n-1;i++){
        int small=arr[i+1];
        int num=arr[i];
        for(int k=i+1;k<n;k++){
        if(arr[k]>num){
        small=arr[k];
        break;
        }
        }
        for(int j=i+2;j<n;j++){

        if(arr[j]<small ){
        small=arr[j];
        }
        }

        }
        System.out.println(-1);

 */