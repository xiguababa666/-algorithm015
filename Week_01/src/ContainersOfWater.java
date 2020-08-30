
public class ContainersOfWater {


    public int maxArea(int[] height) {

//        if (height.length < 2) {
//            return 0;
//        }
//        int l = 0;
//        int r = height.length - 1;
//        int ret = 0;
//        while (l != r) {
//            int len = r - l;
//            int he = Math.min(height[r], height[l]);
//            int s = len * he;
//            if (s > ret) {
//                ret = s;
//            }
//            if (height[l] < height[r]) {
//                l++;
//            } else {
//                r--;
//            }
//        }
//        return ret;


        // left index    left to right
        int l = 0;
        // right index   right to left
        int r = height.length - 1;
        int ret = 0;
        while (l < r) {
            int len = r - l;
            int he = Math.min(height[r], height[l]);
            int s = len * he;
            if (s > ret) {
                ret = s;
            }
            if (height[l] < height[r]) {
                // 比当前小的直接跳过
                int tmpL = height[l];
                while (height[++l] < tmpL);
            } else {
                // 比当前小的直接跳过
                int tmpR = height[r];
                while (height[--r] < tmpR);
            }
        }
        return ret;
    }



    public static void main(String[] args) {
        int[] arr = new int[] {1,8,6,2,5,4,8,3,7};

        System.out.println(new ContainersOfWater().maxArea(arr));
    }

}
