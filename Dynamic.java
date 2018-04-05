import java.util.Scanner;

public class CoinChange_Dynamic {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Coin Length: ");
        int x = in.nextInt();
        int coin[] = new int[x];
        System.out.print("Enter Coins: ");
        for (int i=0;i<x;i++){
            coin[i] = in.nextInt();
        }
        System.out.print("Enter Amount: ");
        int amount = in.nextInt();
        Coin(coin,amount);
    }
    public static void Coin(int coin[],int amount){
        int row = coin.length;
        int col = amount+1;
        int table[][] = new int[row][col];
        for (int i=0;i<row;i++){
            table[i][0] = 0;
        }
        for (int i=1;i<col;i++){
            table[0][i] = i/coin[0];
        }
        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                if(coin[i]>j){
                    table[i][j] = table[i-1][j];
                }else{
                    table[i][j] = Math.min(table[i-1][j],table[i][j-coin[i]]+1);
                }
            }
        }
//       Uncomment for show the table.

//        for(int i=0;i<row;i++){
//            for (int j=0;j<col;j++){
//                System.out.print(table[i][j]+" \t");
//            }
//            System.out.println();
//        }

        System.out.println("Total Coin Needed: "+table[row-1][col-1]);
        System.out.print("Coin Used: ");
        int i=row-1,j=col-1,count=0;
        while(i>0 && j>0){
            if(table[i][j] == table[i-1][j]){
                i--;
                continue;
            }
            System.out.print(coin[i]+" ");
            j -= coin[i];
            count++;
        }
        while (count != table[row-1][col-1] && j>=coin[0]){
            System.out.print(coin[0]+" ");
            j -= coin[0];
            count++;
        }
        if(j!=0){
            System.out.println("Problem");
        }
    }
}
