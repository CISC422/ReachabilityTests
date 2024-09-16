/* CISC/CMPE 422/835
 * Stress testing IntelliJ's built-in static (reachability) analysis
 */
package mase.cs.queensu.ca;

public class Main {
    public static void main(String[] args) {
        // using ints
        int x=0;
        int y=x+1;
        int z=y+1;
        if (z==0) {
            System.out.println("unreachable");
        }

        // using array
        int[] A = {0,0,0,0,0};
        A[1]=A[0]+1;
        A[2]=A[1];
        if (A[2]==0) {
            System.out.println("unreachable");
        }

        // using objects
        class Node {
            int a=1;
        }
        Node n0 = new Node();
        // n0.a++;
        if (n0.a==0) {
            System.out.println("unreachable");
        }

        // using functions ('functional interfaces' and 'lambda expressions')
        interface FuncI {
            int f(int x);
        }
        FuncI funcObj = (int c)->{return 2*c;};
        // int a=1;
        int b1 = funcObj.f(1);
        if (b1!=2) {
            System.out.println("unreachable");
        }
        int b2 = funcObj.f(funcObj.f(1));
        if (b2!=4) {
            System.out.println("unreachable");
        }

    }
}