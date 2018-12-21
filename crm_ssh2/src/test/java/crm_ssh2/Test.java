package crm_ssh2;

import java.util.Scanner;

public class Test {

	 static void draw(int n) {
	        int i, j;
	        for (i = 1 - (n >> 1); i <= n; i++)
	            if (i > 0) {
	                for (j = 0; j < i; j++)
	                    System.out.print("  ");
	                for (j = 1; j <= 2 * (n - i) + 1; j++)
	                    if (j == 1 || j == 2 * (n - i) + 1)
	                        System.out.print(" *");
	                    else
	                        System.out.print("  ");
	                System.out.println("\n");
	            } else if (i == 0) {
	                System.out.print(" *");
	                for (j = 1; j < n; j++)
	                    System.out.print("  ");
	                System.out.print(" *");
	                for (j = 1; j < n; j++)
	                    System.out.print("  ");
	                System.out.print(" *\n");
	            } else {
	                for (j = i; j < 0; j++)
	                    System.out.print("  ");
	                for (j = 1; j <= n + 2 * i + 1; j++)
	                    if (i == 1 - (n >> 1))
	                        System.out.print(" *");
	                    else if (j == 1 || j == n + 2 * i + 1)
	                        System.out.print(" *");
	                    else
	                        System.out.print("  ");
	                for (j = 1; j <= -1 - 2 * i; j++)
	                    System.out.print("  ");
	                for (j = 1; j <= n + 2 * i + 1; j++)
	                    if (i == 1 - (n >> 1))
	                        System.out.print(" *");
	                    else if (j == 1 || j == n + 2 * i + 1)
	                        System.out.print(" *");
	                    else
	                        System.out.print("  ");
	                System.out.print("\n");
	            }
	    }
	 
	    public static void main(String[] args) {
	 
	        System.out.println("Please input the size (n>=4):");
	        Scanner sc = new Scanner(System.in);
	        int n = 10;
	        draw(n);
	 
	    }

}
