package me.arui.leetcode.nine;


import java.util.*;

/**
 * 937. Reorder Log Files
 * https://leetcode.com/problems/reorder-log-files/
 */
public class ReorderLogFiles937 {

    public String[] reorderLogFiles(String[] logs) {
        List<Log> digitList = new ArrayList<>();
        Set<Log> sort = new TreeSet<>();
        for(int i = 0; i < logs.length; i++) {
            Log log = new Log(i, logs[i]);
            if(log.isDigit()) {
                digitList.add(log);
            } else {
                sort.add(log);
            }
        }

        String[] result = new String[logs.length];
        Iterator<Log> it = sort.iterator();
        int i = 0;
        while (it.hasNext()) {
            result[i] = logs[it.next().index];
            i++;
        }

        for(Log log : digitList) {
            result[i] = logs[log.index];
            i++;
        }
        return result;
    }

    private class Log implements Comparable<Log> {

        public int index;
        public String order;

        public Log(int index, String log) {
            this.index = index;
            this.order = log.substring(log.indexOf(" ") + 1);
        }

        public boolean isDigit() {
            char ch = this.order.charAt(0);
            if(ch >= '0'  && ch <= '9') {
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Log o) {
            return order.compareTo(o.order);
        }
    }


    public static void test(String[] S) {
        ReorderLogFiles937 test = new ReorderLogFiles937();
        String[] result = test.reorderLogFiles(S);
        System.out.println("执行结果：");
        for (String num : result) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(new String[]{"6p tzwmh ige mc", "ns 566543603829", "ubd cujg j d yf", "ha6 1 938 376 5", "3yx 97 666 56 5", "d 84 34353 2249", "0 tllgmf qp znc", "s 1088746413789", "ys0 splqqxoflgx", "uhb rfrwt qzx r", "u lrvmdt ykmox", "ah4 4209164350", "rap 7729 8 125", "4 nivgc qo z i", "apx 814023338 8"});
//        test(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
//        ["ubd cujg j d yf","u lrvmdt ykmox","4 nivgc qo z i","uhb rfrwt qzx r","ys0 splqqxoflgx","0 tllgmf qp znc","6p tzwmh ige mc","ns 566543603829","ha6 1 938 376 5","3yx 97 666 56 5","d 84 34353 2249","s 1088746413789","ah4 4209164350","rap 7729 8 125","apx 814023338 8"]
    }

}
