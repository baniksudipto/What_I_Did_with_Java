package codinggame;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<BigInteger> nums = new ArrayList<>();
        for (int i = 0; i <n ; i++){
            nums.add(new BigInteger(in.nextLine()));
        }
        Collections.sort(nums);
        for(BigInteger b : nums){
            System.out.println(b);
        }
    }
}
