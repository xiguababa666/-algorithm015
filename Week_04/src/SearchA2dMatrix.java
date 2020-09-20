/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 *
 * @author xyx
 * @date 2020/9/19 12:24
 */
public class SearchA2dMatrix {


    public static void main(String[] args) {
        System.out.println(new SearchA2dMatrix().searchMatrix(
                new int[][]{
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11,12,13,14,15},
                        {16,17,18,19,21}},
                10));

        //System.out.println(new SearchA2dMatrix().searchMatrix(
        //        new int[][]{
        //                {20}},
        //        20));

    }


    /**
     *
     * 自己写的，ugly
     * */
    public boolean searchMatrix1(int[][] matrix, int target) {

        // 二分法
        return binarySearch(findSubArray(matrix, target), target) >= 0;

    }
    public int binarySearch(int[] arr, int target) {
        if (arr.length == 0
                || arr[0] > target
                || arr[arr.length - 1] < target) return -1;

        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return arr[l] == target ? l : -1;
    }
    public int[] findSubArray(int[][] matrix, int target) {
        if (matrix.length == 0) return new int[0];
        int column = matrix[0].length - 1;
        int s = 0, e = matrix.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (matrix[mid][0] > target) {
                e = mid - 1;
            } else if (matrix[mid][column] >= target) {
                return matrix[mid];
            } else {
                s = mid + 1;
            }
        }
        return matrix[s];
    }






    /**
     * 另一种二分
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        if (n == 0) return false;
        int l = 0, r = m * n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return matrix[l / n][l % n] == target;
    }

}
