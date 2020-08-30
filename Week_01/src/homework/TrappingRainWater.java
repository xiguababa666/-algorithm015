package homework;


import java.util.Stack;

public class TrappingRainWater {


    public static int trap(int[] height) {
        int s = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int h = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int top = stack.peek();
                s += (Math.min(height[top], height[i]) - height[h]) * (i - top - 1);
            }
            stack.push(i);
        }
        return s;
    }


    public static void main(String[] args) {

        trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});

    }
}
