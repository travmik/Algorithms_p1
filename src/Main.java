import com.travmik.unionfind.QuickFindUF;
import com.travmik.unionfind.MyWeightedQuickUnionUF;

public class Main {

    public static void main(String[] args) {
//        Main test = new Main();
//        test.quickFindTest();
//        test.quickUnionTest1();
        test();
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
        MyWeightedQuickUnionUF quickUnion = new MyWeightedQuickUnionUF(10);
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
}
