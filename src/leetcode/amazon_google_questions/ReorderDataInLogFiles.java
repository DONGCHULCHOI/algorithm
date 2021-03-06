package leetcode.amazon_google_questions;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {
    // T.C: O(n log n), where N is the total content of logs
    // S.C: O(n) because Collections.sort() uses merge sort
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>(){
            public int compare(String log1, String log2)  // *****
            {
                String[] split1 = log1.split(" ", 2); // split the logs based on identifier // the grammer of split // ***
                String[] split2 = log2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0)); // go over whether digit log or letter log // *****
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if (!isDigit1 && !isDigit2) { // isDigit1 is false, isDigit2 is false == both are letter log // *****
                    int cmp = split1[1].compareTo(split2[1]); // The letter-logs are ordered lexicographically ignoring identifier
                    if (cmp != 0)
                        return cmp;
                    else // with the identifier used in case of ties
                        return split1[0].compareTo(split2[0]);
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1; // *1) // *****
            }
        });
        return logs;
    }
    // 1)
    // isDigit1 is true, isDigit2 is true -> 0, The digit-logs should be put in their original order
    // isDigit1 is true, isDigit2 is false -> 1, The letter logs comes in front of the digit logs
    // isDigit1 is false, isDigit2 is true -> -1, The digit-logs should be put in their original order
    // isDigit1 is false, isDigit2 is false -> dealt with the before
}

