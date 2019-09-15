/* kelas buat input */
package components;
import java.util.*;
public class angka {
    int M; //panjang baris
    int N; //panjang kolom
    //int a; //koefisien variabel
    //int b; // sama dengan persamaan(?)

    // method
    angka(){    
    }
    public void inputangka() {
        Scanner in = new Scanner (System. in);
        System.out.println("Masukan data Matriksnya yah...");
        System.out.print("M: ");
        int M = in.nextInt();

        System.out.print("N: ");
        int N = in.nextInt();
        
        this.M = M;
        this.N = N;
        in.close();      


    }
    public void tulisangka() {
        System.out.println();
        System.out.println("M= " + this.M);
        System.out.println("N= " + this.N);
    }
}