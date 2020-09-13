import java.util.*;

public class TopKFrequentElements {


    public static void main(String[] args) {
//        new TopKFrequentElements().topKFrequent(new int[]{3,4,1,2,2,3,5,8,9,4,2,3,3,5,4,4,2,1}, 3);
        new TopKFrequentElements().topKFrequent(new int[]{6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0}, 6);


    }



    /**
     * 1.首先得统计个数，借助HashMap
     * */
    public int[] topKFrequent1(int[] nums, int k) {

        if (k <= 0 || nums == null || nums.length < k) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, (map.getOrDefault(n, 0) + 1));
        }

        int pos = 0;
        int[] arr = new int[k];
        for (int a : map.keySet()) {
            if (pos < k) {
                arr[pos++] = a;
                if (pos == k) {
                    buildHeap(arr, map);
                }
            } else {
                int count = map.getOrDefault(a, 0);
                if (count <= map.getOrDefault(arr[0], 0)) continue;
                arr[0] = a;
                heapify(arr, 0, map);
                pos++;
            }
        }

        return arr;
    }

    private void buildHeap(int[] arr, Map<Integer, Integer> map) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, map);
        }
    }

    private void heapify(int[] arr, int pos, Map<Integer, Integer> map) {
        int parent = pos;
        int tmp = arr[parent];
        while (parent < arr.length - 1) {
            int left = left(parent);
            if (left > arr.length - 1) break;
            int right = right(parent);
            int smaller;
            if (right > arr.length - 1) {
                smaller = left;
            } else {
                int lcount = map.getOrDefault(arr[left], 0);
                int rcount = map.getOrDefault(arr[right], 0);
                smaller = lcount <= rcount ? left : right;
            }
            if (map.getOrDefault(tmp, 0) <= map.getOrDefault(arr[smaller], 0))
                break;
            arr[parent] = arr[smaller];
            parent = smaller;

        }
        arr[parent] = tmp;
    }

    private int left(int pos) {
        return pos * 2 + 1;
    }

    private int right(int pos) {
        return pos * 2 + 2;
    }







    /**
     * 计数
     * */
    public int[] topKFrequent(int[] nums, int k) {

        if (k <= 0 || nums == null || nums.length < k) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, (map.getOrDefault(n, 0) + 1));
        }

        List<List<Integer>> list = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            list.add(new LinkedList<>());
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            List<Integer> l = list.get(e.getValue());
            l.add(e.getKey());
        }

        int[] ret = new int[k];
        int i = 0;
        for (int j = list.size() - 1; j >= 0; j--) {
            if (list.get(j).size() == 0) continue;
            for (int a : list.get(j)) {
                ret[i++] = a;
                if (i >= k) return ret;
            }
        }
        return ret;

    }


}
