package solutions;
import java.io.*;
import java.util.*;

public class HackerRank {
    static int avgdigits=2;
    
    static int functionMod(int raw){
        return raw%((int) Math.pow(10,9)+7);
    }

    public static void main(String[] args) throws FileNotFoundException {
        @SuppressWarnings("resource")
		Scanner stdin = new Scanner(new File("input.txt"));
        if(!stdin.hasNextLine())
        {
            return;
        }
        int t = stdin.nextInt();
        if(!stdin.hasNextLine())
        {
            return;
        }
        int N,M,result;
        for (int i = 0; i < t; i++)
        {
            N=stdin.nextInt();
            M=stdin.nextInt();
            result=M*(M-1);
            if (N < 1){System.out.println(functionMod(1));}
            else if (N == 1){System.out.println(functionMod(M));}
            else if (N == 2){
                System.out.println(functionMod(result));
            }else{
                result=result*((int) Math.pow((M-2),(N-2)));
                System.out.println(functionMod(result));
            }
        }
    }
}
