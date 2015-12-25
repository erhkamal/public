import java.io.*;
import java.util.*;
//matrixRotateBugfree
public class Solution {

	public static void main(String[] args) throws IOException {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
   	    int R = in.nextInt();
		int C = in.nextInt();
		int N = in.nextInt();
		//ArrayList <int> buffer = new ArrayList <int> ();
		int [][] matrix = new int[R][C];
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				matrix[i][j] = in.nextInt();
			}
		}
		int iterations = Math.min(R,C)/2;
		int RC = R*C;
		int RplusC = R+C;
		int optimizedN = N;
		for(int i = 0; i<iterations; i++){
				optimizedN = N % (2*(RplusC - 4*i - 2));   
			matrix = rotateRing(matrix,optimizedN,R,C,i);
			R--; C--;
		}

		for(int i = 0;i<matrix.length;i++){
			for(int j = 0; j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int [][] rotateRing(int matrix[][], int optimizedN, int Rarg, int Carg, int iarg){
		for(int n = 0; n<optimizedN; n++){
			int r = matrix.length-Rarg, c= matrix[0].length - Carg, cur, prev;
			int R = Rarg; 
			int C = Carg;
			while(r<R && c<C){
				prev = matrix[r][c+1];
				//left col
				for(int i = r; i<R; i++){
					cur = matrix[i][c];
					matrix[i][c] = prev;
					prev = cur;
				}
				c++;

				//bottom row
				for(int i = c; i<C; i++){
					cur = matrix[R-1][i];
					matrix[R-1][i] = prev;
					prev = cur;
				}
				R--;

                if(c<C){
					//right col
					for(int i = R-1; i>=r; i--){
						cur = matrix[i][C-1];
						matrix[i][C-1] = prev;
						prev = cur;
					}

				}
				C--;

				if(r<R){
					//top row
					for(int i = C-1; i>=c; i--){
						cur = matrix[r][i];
						matrix[r][i] = prev;
						prev = cur;
					}
				}
				r++;
				break;
			}

		}

		return matrix;
	}
}
