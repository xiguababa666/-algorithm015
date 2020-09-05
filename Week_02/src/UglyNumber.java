import java.util.PriorityQueue;

public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new UglyNumber().nthUglyNumber(1365));
    }


    /**
     * 结合第二周学习内容，出这题大概率是：hash 树 堆 中找解决办法
     * 小顶堆
     * */
    public int nthUglyNumber1(int n) {

        if (n <= 0) return 0;

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add(1L);
        long[] base = new long[] {2L, 3L, 5L};
        // 这里好像也可以只记最后放入数组那个数~~
        long[] ret = new long[n];
        int i = 0;
        while (i < n) {
            long k = minHeap.poll();
            ret[i++] = k;
            for (long a : base) {
                long in = a * k;
                if (!minHeap.contains(in)) minHeap.add(in);
            }
        }
        return (int) ret[n - 1];
    }



    /**
     * 三指针，动态规划 （这个真心想不到~~~）
     *
     * todo
     * */
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1; i < n; i++) {
            int p2a = ret[p2] * 2;
            int p3a = ret[p3] * 3;
            int p5a = ret[p5] * 5;
            int a = Math.min(p2a, Math.min(p3a ,p5a));
            if (a == p2a) p2++;
            if (a == p3a) p3++;
            if (a == p5a) p5++;
            ret[i] = a;
        }
        return ret[n - 1];
    }

}
