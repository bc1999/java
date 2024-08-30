public class pk1SlidingWindow {
    // "static void main" must be defined in a public class.

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static int lengthOfLongestSubstringWithoutRepeating(String s) {
        int[] map = new int[256];
        // System.out.println(map);
        // [I@7adf9f5f

        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            map[s.charAt(i)]++; // update state using s[i]

             // System.out.println(s.charAt(i));
              // a
             // System.out.println(map[s.charAt(i)]);
             // 1

            // for (; map[s.charAt(i)] > 1; j++) {
            for (; map[s.charAt(i)] > 1; ) {
                map[s.charAt(j)]--; // shrink the left edge using s[j]
                // System.out.println(s.charAt(j));
                // a
                j++;
            }
            max = Math.max(max, i - j + 1); // longest window so far
        }
        return max; // longest window
    }

    // https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int cnt = 0, max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c]++;
            if (map[c] == 1) cnt++; // update state using s[i]
            for (; cnt > k; j++) { // shrink the left edge while invalid
                c = s.charAt(j);
                map[c]--;
                if (map[c] == 0) cnt--; // update state using s[j]
            }
            max = Math.max(max, i - j + 1); // longest window so far
        }
        return max; // longest window
    }

}
