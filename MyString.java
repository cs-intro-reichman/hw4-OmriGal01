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
        str1 = lowerCase(str1);
        str2 = lowerCase(str2);
        char firstOfStr2 = str2.charAt(0);
        int indexOfFirst = str1.indexOf(firstOfStr2);

        while (indexOfFirst != -1) {
            str1 = str1.substring(indexOfFirst, str1.length());
            if (stringBeginningsAreEqual(str1, str2)) {
                return true;
            }
            if (str1.length() <= 1) {
                return false;
            }
            str1 = str1.substring(1, str1.length());
            indexOfFirst = str1.indexOf(firstOfStr2);
        }

        return false;        
    }

    /*Checks if str1 == str2 + x, where x is another String. */
    public static boolean stringBeginningsAreEqual(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return false;
        }
        char chStr1;
        char chStr2;
        for (int i = 0; i < str2.length(); i++) {
            chStr1 = convertCharToLowerCase(str1.charAt(i));
            chStr2 = convertCharToLowerCase(str2.charAt(i));
            if (chStr1 != chStr2) {
                return false;
            }
        }
        return true;
    }

    public static char convertCharToLowerCase(char ch) {
        return (ch >= 65 && ch <= 90) ? (char) (ch + 32) : ch;
    }
}
