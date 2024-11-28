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
        System.out.println(contains("We need to leverage our core competencies", "competencies")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String lower = "";
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            lower += (ch >= 65 && ch <= 90) ? (char) (ch + 32) : ch;
        }
        return lower;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        //If str1 is longer, automatic false. Also, this ensures the function will work if given an empty string for str1.
        if (str2.length() > str1.length()) {
            return false;
        }
        if (str2.length() == 0) {
            return true;
        }

        char fStr2 = str2.charAt(0);
        int indexFirstCh = str1.indexOf(fStr2);
        str1 = str1.substring(Math.max(indexFirstCh, 0), str1.length());
        //System.out.println(str1);
        while (str1.length() >= str2.length() && indexFirstCh != -1) {
            boolean check = true;
            for (int i = 0; i < str2.length() && check; i++) {
                if (str1.charAt(i) != str2.charAt(i))
                check = false;
            }
            if (check) {
                return true;
            }
            str1 = str1.substring(1, str1.length());
            indexFirstCh = str1.indexOf(fStr2);
            str1 = str1.substring(Math.max(indexFirstCh, 0), str1.length());
        }
        return false;
    }
}
