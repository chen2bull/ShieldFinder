import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by Administrator on 2016/10/21.
 */
public class TestReg {
    public static void main(String[] args) {
        // 中文内容也匹配
        String pattString = "([\\u4e00-\\u9fa5\\ufe30-\\uffa0]+)";
        Pattern p = Pattern.compile(pattString);
        Matcher m = p.matcher("gooh哈哈djob里面有中文呢");
        System.out.println("中文index:" + (m.find() ? m.group(1) : "nothing"));

        // 测试标点
        m = p.matcher("good。job还有标点！");
        System.out.println("标点index:" + (m.find() ? m.group(1) : "nothing"));
        String str = "。、，｡､";
        for (int j = 0; j < str.length(); j++) {
            int i = str.charAt(j);
            System.out.println(Integer.toHexString(i));
        }

        // 正则匹配中文字符时,有部分标点符号没法匹配(比如，用搜狗拼音输入的中文句号。和顿号、)
        // 所以可以用([\\u4e00-\\u9fa5\ufe30-\\uffa0\\u3000-\\u3040]+)这个
        for (char c = 0x3000; c < 0x3040; c++) {
            System.out.println(c);
        }
//        for (char c = 0xff00; c < 0xffff; c++) {
//            System.out.println(c);
//        }
}
}
