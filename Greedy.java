import java.util.Scanner;

public class CoinChange_Greedy {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Coin Size: ");
        int x = in.nextInt();
        System.out.println("Enter Coins: ");
        int coin[] = new int[x];
        int fcoin[] = new int[x];
        for(int i=0;i<x;i++){
            coin[i] = in.nextInt();
        }
        System.out.println("Enter Amount: ");
        int amount = in.nextInt();
        int sum=0,require=0;
        for(int i=0;i<x;i++){
            int count=0;
            while(sum<=amount){
                sum += coin[i];
                count++;
            }
            sum -= coin[i];
            count--;
            fcoin[i] = count;
            if(count != 0){
                require += 1;
            }
        }
        System.out.println("Coin Requires "+require);
        for(int i=0;i<x;i++){
            System.out.println(coin[i]+" Needs "+fcoin[i]+" ");
        }
    }
}
