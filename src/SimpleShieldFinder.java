import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Created by Administrator on 2016/10/23.
 */
public class SimpleShieldFinder implements ShieldFinder {
    private ArrayList<String> stringTable;
    public SimpleShieldFinder(String fileName) throws IOException {
        stringTable = new ArrayList<String>();
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            stringTable.add(str);
        }
    }

    public void printAllString() {
        for(String str : stringTable) {
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
        ShieldFinder shieldFinder = new SimpleShieldFinder(fileName);
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