public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String lower = "";
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch >= 65 && ch <= 90) {
                lower += (char) (ch + 32);
            }
            else {
                lower += ch;
            }
        }
        return lower;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        if (str1.length() == 0) {
            System.out.println("flag1");
            return false;
        }
        if (str2.length() == 0) {
            System.out.println("flag2");
            return true;
        }
        int firstIteration = str1.indexOf(str2.charAt(0));
        if (firstIteration == -1) {
            System.out.println("flag3");
            return false;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != str1.charAt(firstIteration + i)) {
                return false;
            }
        }
        return true;
    }
}
