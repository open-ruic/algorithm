package me.arui.leetcode.nine;

/**
 * 944. Delete Columns to Make Sorted
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 */
public class DeleteColumns944 {

    public int minDeletionSize(String[] A) {
        int ans = 0;
        for(int i = 0; i < A[0].length(); i++) {
            for(int j = 1; j < A.length ; j++) {
                if(A[j].charAt(i) < A[j-1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void test(String[] A) {
        DeleteColumns944 test = new DeleteColumns944();
        int result = test.minDeletionSize(A);
        System.out.println("执行结果：" + result);
    }

    public static void main(String[] args) {
        test(new String[]{"cba","daf","ghi"});
    }

}
