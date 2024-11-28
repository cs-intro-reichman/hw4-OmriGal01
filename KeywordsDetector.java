public class KeywordsDetector {
    public static void main(String[] args) {        

        String[] sentences = {
            "Our product will transform the market", //bs
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies", //bs
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry", //bs
            "The team showed great Synergy in the last project", //bs
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift", //bs
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        String[] oneSentence;
        boolean bs;
        for (int i = 0; i < sentences.length; i++) {
            bs = false;
            oneSentence = stringToStringArray(sentences[i]);
            for (int j = 0; (j < keywords.length) && (!bs); j++) {
                if (stringAppearsInArray(oneSentence, keywords[j])) {
                    bs = true;
                    System.out.println(sentences[i]);
                }
            }
        }
    }

    /*Checks if two Strings are identical */
    public static boolean stringsAreEqual(String str1, String str2) {
        char chStr1;
        char chStr2;
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            chStr1 = convertToLowerCase(str1.charAt(i));
            chStr2 = convertToLowerCase(str2.charAt(i));
            if (chStr1 != chStr2) {
                return false;
            }
        }
        return true;
    }

    public static char convertToLowerCase(char ch) {
        return (ch >= 65 && ch <= 90) ? (char) (ch + 32) : ch;
    }

    /*Checks if a given string appears in an array of string */
    public static boolean stringAppearsInArray(String[] arr, String str) {
        for (int i = 0; i < arr.length; i++) {
            if (stringsAreEqual(arr[i], str)) {
                return true;
            }
        }
        return false;
    }

    /* Splits a given String into an array of lower-case strings, differentiated by spaces. */
    public static String[] stringToStringArray(String str) {
        String preProcess = "";
        int spacesCount = 0;
        char ch;
        int spaceIndex;
        
        //Count number of spaces in String to know how many words it has.
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spacesCount++;
            }
        }

        //Remove punctuation and all non-letter characters.
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch >= 65 && ch <= 90) {
                preProcess += (char) (ch + 32);
            }
            else if ((ch >= 97 && ch <= 122) || ch == 32) {
                preProcess += ch;
            }
        }

        String stringArray[] = new String[spacesCount + 1];

        //Process the sentence into a String array.
        for (int i = 0; i < spacesCount + 1; i++) {
            spaceIndex = preProcess.indexOf(' ');
            stringArray[i] = preProcess.substring(0, (spaceIndex != -1) ? spaceIndex : preProcess.length());
            preProcess = preProcess.substring(spaceIndex + 1, preProcess.length());
        }

        return stringArray;
    }
}
