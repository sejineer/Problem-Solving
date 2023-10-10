import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        int[] arr1 = new int[10000];
        for (int i = 1; i<10; i++){
            arr[i-1] = d1(i);
        }
        for (int j = 10; j<100;j++){
            arr[j-1] = d2(j);
        }
        for (int k = 100; k<1000;k++){
            arr[k-1] = d3(k);
        }
        for(int l = 1000; l<10000; l++){
            arr[l-1] = d4(l);
        }
        Arrays.sort(arr);
        for (int m = 0; m<arr1.length; m++){
            arr1[m] = m;
        }
        for(int x=0; x<arr.length; x++){
            for(int y=0; y<arr.length;y++){
                if(arr[x] == arr1[y]){
                    arr1[y] = 0;
                }
            }
        }
        Arrays.sort(arr1);
        for(int z=0 ;z<arr1.length;z++){
            if(arr1[z]==0){
            }else
            System.out.println(arr1[z]);
        }
    }

    public static int d1 (int num){
        int result = 0;
        result = num + num;
        return result;
    }
    public static int d2(int num){
        int a=0 , b = 0;
        a = num / 10;
        b = num - a*10;
        return num + a + b;
    }
    public static int d3(int num){
        int a=0,b=0,c=0;
        a = num / 100;
        b = (num - 100*a)/10;
        c= num - 100*a - 10*b;
        return num + a + b + c;
    }
    public static int d4(int num){
        int a=0,b=0,c=0,d=0;
        a = num / 1000;
        b= (num - 1000*a)/100;
        c = (num - 1000*a - 100*b)/10;
        d = num - 1000*a - 100*b - 10*c;
        return num+ a+b+c+d;
    }
}