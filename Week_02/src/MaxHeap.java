/**
 * description
 *
 * @author xyx
 * @date 2020/9/1 15:16
 */
public class MaxHeap {

    private int[] heap;

    private int size;

    private int capacity;

    public int size() {
        return size;
    }

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        this.capacity = capacity;
    }

    public void push(Integer e) {
        if (size >= capacity) {
            // todo 扩容？
            return;
        }
        heap[size++] = e;
        heapifyUp();
    }


    private void heapifyUp() {

        // 与父节点比较，比父节点大则交换，否则return
        int current = size - 1;
        if (current == 0) return;
        // 二叉堆 父节点为 i/2 (i为当前节点位置)
        int parent = (current - 1) / 2;
        int tmp = heap[current];
        while (current > 0 && tmp > heap[parent]) {
            heap[current] = heap[parent];
            current = parent;
            parent = (current - 1) / 2;
        }
        heap[current] = tmp;
    }


    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = heap[0];
        heapifyDown();
        size--;
        return ret;
    }

    private void heapifyDown() {

        int parent = 0;
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        while (left < size) {
            int replace = right < size && heap[right] >= heap[left] ? right : left;
            heap[parent] = heap[replace];
            parent = replace;
            left = parent * 2 + 1;
            right = parent * 2 + 2;
        }

    }





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(heap[i]).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(10);
        h.push(1);
        h.push(7);
        h.push(10);
        h.push(3);
        h.push(6);
        h.push(4);
        h.push(2);
        h.push(8);
        h.push(5);
        h.push(9);
        System.out.println(h.toString());


        //                 10
        //         9                7
        //     6       8       4          2
        //   1   5   3


        Integer a = h.poll();
        System.out.println(a);
        System.out.println(h.toString());


        //                 9
        //         8                7
        //     6       3       4          2
        //   1   5   -

    }
}
