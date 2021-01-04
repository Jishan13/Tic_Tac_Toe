package ticTacToe;

import java.util.*;
public class ticTacToe {
  
    
	public static void main(String[] args) {
	
		boolean isWinner=false;
		int row,col;
		int counter =0;
		boolean isComp=false;
	    Scanner sc =  new Scanner(System.in);
		
		char[][]board=new char[3][3];
		for(int i=0;i<board.length;i++) {
			for(int j =0; j<board[0].length;j++) {
				board[i][j]='-';
			}
		}
		
		System.out.println("Are you playing against a computer ? ");
		String ans = sc.next().toUpperCase();
		
		System.out.println(ans);
		System.out.println(!(ans.equals("YES")&&ans.equals("NO")));
		while(!(ans.equals("YES")||ans.equals("NO"))) {
			System.out.println("Invalid answer. Try again ");
			ans=sc.next().toUpperCase();
		
		}
		int toss=(int)(Math.random()*2);
		if(toss==0) {
			isComp=true;
			while(!isWinner|| counter!=9) {
			   
				int r= (int)(Math.random()*3);
				int c = (int)(Math.random()*3);
				while((board[r][c]=='x'|| board[r][c]=='o')) {
					r=(int)(Math.random()*3);
					c=(int)(Math.random()*3);
				}
				board[r][c]='x';
				printBoard(board);
				counter++;
				if(winner(board)) {
					System.out.println("Computer is the winner");
					break;
				}
			System.out.println(" Computer made its move! ");
		     if(counter==9) {
		    	 System.out.println("It is a tie! ");
		    	 break;
		     }
		       isComp=false;
			 System.out.println("Enter a row : ");
			 row = sc.nextInt();
			 System.out.println("Enter a col:");
			 col = sc.nextInt();
			 while((board[row][col]=='x'|| board[row][col]=='o')|| (row<0 || row>2)|| (col<0 || col>2)) {
				 System.out.println("Renter the row");
				 row = sc.nextInt();
				 System.out.println("Reenter the col ");
				 col= sc.nextInt();
			 }
 			 board[row][col]='o';
			 counter++;
			 if(winner(board)) {
					System.out.println("User is the winner");
					break;
				}
			 printBoard(board);
			
			 
			}
			 
		}
		

	}
	public static char [][] boardReset(char[][]arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j]='-';
			}
		}
		return arr;
	}
	public static void printBoard(char[][]arr) {
		System.out.println("        0     1     2");
		System.out.println("      __________________");
		for(int i=0;i<arr.length;i++) {
			System.out.print(" "+i+" ");
			for(int j=0;j<arr[0].length;j++) {
				if(j==2) {
				System.out.print("  |  "+arr[i][j] + "   | ");
				}
				else
				System.out.print("  |  " + arr[i][j]);
				
			}
			System.out.println();
		}
		System.out.println("      __________________");
	}
	public static boolean winner(char[][] arr){
		if((arr[0][0]==arr[0][1]&&arr[0][0]==arr[0][2] && arr[0][0]!='-')||(arr[1][0]==arr[1][1]&&arr[1][0]==arr[1][2] && arr[1][0]!='-')||(arr[2][0]==arr[2][1]&&arr[2][0]==arr[2][2]&& arr[2][0]!='-')||(arr[0][0]==arr[1][0]&&arr[1][0]==arr[2][0]&& arr[0][0]!='-')
				||(arr[0][2]==arr[1][2]&&arr[0][1]==arr[2][2]&& arr[0][2]!='-')||(arr[0][0]==arr[1][1]&&arr[0][0]==arr[2][2]&& arr[0][0]!='-')||(arr[2][2]==arr[1][1]&&arr[2][2]==arr[0][2]&& arr[2][2]!='-')) {
			return true;
		}
		return false;
	}
		
	

}

