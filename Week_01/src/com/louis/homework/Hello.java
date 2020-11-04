package src.com.louis.homework;

import java.util.ArrayList;
import java.util.List;

public class Hello {
    public void hello() {
        System.out.println("my hello");
    }

    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 130;
        int num3 = num1 + num2;
        int num4 = num2 - num1;
        int num5 = num1 * num2;
        int num6 = num2 / num1;

        final int num7 = 5;
        Integer num88 = 6;

        if (num88 == 0) {
            System.out.println(num1);
        }

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);

        for (int num : nums) {
            System.out.println(num);
        }

        if (nums.size() == num2) {
            System.out.println(num2);
        }
    }
}