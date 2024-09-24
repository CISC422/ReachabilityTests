/* CISC/CMPE 422/835
 * Stress testing IntelliJ's built-in static (reachability) analysis
 */
package mase.cs.queensu.ca;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");
        // test 1: using ints
        int x=0;
        int y=x+1;
        int z=y+1;
        if (z==0) {
            System.out.println("unreachable");
        }

        // test 2: using array
        int[] A = {0,0,0,0,0};
        A[1]=A[0]+1;
        A[2]=A[1];
        if (A[2]==0) {
            System.out.println("unreachable");
        }

        // test 3: using objects
        class Node {
            final int a=1;
        }
        Node n0 = new Node();
        // n0.a++;
        if (n0.a==0) {
            System.out.println("unreachable");
        }

        // test 4: using functions ('functional interfaces' and 'lambda expressions')
        interface FuncI {
            int f(int x);
        }
        FuncI funcObj = (int n)->{return 2*n;};
        int b1 = funcObj.f(1);
        if (b1!=2) {
            System.out.println("unreachable");
        }
        int b2 = funcObj.f(funcObj.f(1));
        if (b2!=4) {
            System.out.println("unreachable");
        }

        // test 5: using loops
        int up=0;
        int down=9;
        while (up!=down) {
            up++;
            down--;
        }

        System.out.println("End");
    }
}