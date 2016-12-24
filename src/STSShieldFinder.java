import algs4.TST;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Created by Administrator on 2016/10/22.
 */
public class STSShieldFinder implements ShieldFinder {
    private TST<Integer> stringTable;
    public STSShieldFinder(String fileName) throws IOException {
        stringTable = new TST<Integer>();
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            stringTable.put(str, 1);
        }
    }

    public void printAllString() {
        for(String str : stringTable.keys()) {
            System.out.println(str);
        }
    }

    /**
     * 判断某个词是否为屏蔽词
     * @param string
     * @return boolean
     */
    public boolean isShield(String string) {
        return stringTable.contains(string);
    }

    public static void main(String[] args) throws IOException {
        String fileName = "src/屏蔽词.txt";
        ShieldFinder shieldFinder = new STSShieldFinder(fileName);
        int LOOPTIMES = 100000;
        long startTime = System.currentTimeMillis();
        ArrayList<Boolean> booleans = new ArrayList<Boolean>(LOOPTIMES*4);
        for (int i = 0; i < LOOPTIMES; i++) {
            booleans.add(shieldFinder.isShield("马克思"));
            booleans.add(shieldFinder.isShield("马克"));
            booleans.add(shieldFinder.isShield("克思"));
            booleans.add(shieldFinder.isShield("不是屏蔽词"));
        }
        System.out.println(booleans.get(0));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
