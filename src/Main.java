import com.travmik.elementarysort.InsertionSort;
import com.travmik.elementarysort.SelectionSort;
import com.travmik.elementarysort.ShellSort;
import com.travmik.unionfind.QuickFindUF;
import com.travmik.unionfind.WeightedQuickUnionUF;

public class Main {

    public static void main(String[] args) {
//        Main test = new Main();
//        test.quickFindTest();
//        test.quickUnionTest1();
        insertionSort();
//        shellSort();
    }


    private void quickFindTest() {
        QuickFindUF find = new QuickFindUF(10);
        find.union(3, 5);
        find.union(5, 7);
        find.union(7, 8);
        find.union(7, 9);
        find.union(9, 0);
        find.union(7, 2);

        System.out.println(find.getFormattedArray());
    }

    private void quickUnionTest1() {
        WeightedQuickUnionUF quickUnion = new WeightedQuickUnionUF(10);
        quickUnion.union(1, 9);
        quickUnion.union(2, 4);
        quickUnion.union(4, 0);
        quickUnion.union(5, 6);
        quickUnion.union(6, 9);
        quickUnion.union(0, 7);
        quickUnion.union(4, 3);
        quickUnion.union(5, 4);
        quickUnion.union(5, 8);

        System.out.println(quickUnion.getFormattedArray());
    }

    private static void test() {
        int realIndex = 9;
        int numSites = 3;
        if (realIndex % numSites != 1) {
            System.out.println("left");
        }
        //check if there is upper neighbour
        if ((double) realIndex / numSites > 1) {
            System.out.println("top");
        }
        //check if there is right neighbour
        if (realIndex % numSites != 0) {
            System.out.println("right");
        }

        //check if there is upper neighbour
        if ((double) realIndex / numSites <= numSites - 1) {
            System.out.println("bottom");
        }
    }

    private static void selectionSort() {
        Integer[] a = {64, 81, 75, 18, 29, 85, 39, 47, 15, 63};
        SelectionSort instance = new SelectionSort(a);
        instance.sort();
    }

    private static void insertionSort() {
        Integer[] a = {11, 14, 27, 79, 98, 59, 13, 72, 52, 99};
        InsertionSort instance = new InsertionSort(a);
        instance.sort();
    }

    private static void shellSort() {
        Integer[] a = {68, 83, 58, 53, 19, 30, 77, 47, 90, 24};
        ShellSort instance = new ShellSort(a);
        instance.sort();
    }
}
