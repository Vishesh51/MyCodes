import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class chess {
    
	
    static class Node{
		int x,y;
		int dist;
	}//2,1 //5,6
    static int val1=0;
	static int val2=0;
	public  static  boolean isValid(int row,int col){
	if(row<0||col<0||row>=8||col>=8) return false;
	return true;
	}
    public static int bfs(int board[][],int row, int col){
		boolean visited[][]=new boolean[8][8];
		int s1[]={-2,-1,1,2,-2,-1,1,2};
		int s2[] = {-1, -2, -2, -1, 1, 2, 2, 1};
		ArrayDeque<Node> ad=new ArrayDeque<Node>();
		Node n=new Node(); n.x=row; n.y=col; n.dist=0;
		ad.addLast(n);int val=0;
		while(!ad.isEmpty()){
			 Node temp=ad.removeFirst();
			if(temp.x==val1&&temp.y==val2){
				val=temp.dist;
				break;
			}
			for(int i=0;i<8;i++){
				Node t=new Node();
				t.x=temp.x+s1[i];
				t.y=temp.y+s2[i];
				t.dist=temp.dist+1;
				if(isValid(t.x,t.y)&&!visited[t.x][t.y]){
				ad.addLast(t);
				visited[t.x][t.y]=true;
				}
			}
		}
		return val;
	}

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		//Solution s=new Solution();
        int board[][]=new int[8][8];
        int x1=sc.nextInt();
		int y1=sc.nextInt();
		int row=8-y1;
		int col=x1-1;
		int x2=sc.nextInt();
		int y2=sc.nextInt();
		val1=8-y2;
		val2=x2-1;
		int val=bfs(board,row,col);
		System.out.println(val);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}