import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.Stack;

import java.util.Arrays;

import java.util.Collections;

public class AlgoMapSolution {

    // https://algomap.io/

    // 1 findClosestNumber ///////////////////////////////////////////
    public int findClosestNumber(int[] nums){
        int closest = nums[0];

        for(int x: nums){
            if(Math.abs(x)<Math.abs(closest)){
                closest = x;
            }
        }

        if(closest<0 && contains(nums, Math.abs(closest))){
            return Math.abs(closest);
        } else {
            return closest;
        }
    }

    private boolean contains(int[]nums, int value){
        for(int num: nums){
            if(num==value){
                return true;
            }
        }
        return false;
    }


    // 6 longestCommonPrefix ///////////////////////////////////////////

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minLength) {
                minLength = s.length();
            }
        }

        int i = 0;
        while (i < minLength) {
            for (String s : strs) {
                if (s.charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }

        return strs[0].substring(0, i);
    }

    // 16 Maximum number of Balloons  ///////////////////////////////////////////

    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
        String balloon = "balloon";

        for (char c : text.toCharArray()) {
            if (balloon.indexOf(c) != -1) {
                counter.put(c, counter.getOrDefault(c, 0) + 1);
            }
        }

        if (!counter.containsKey('b') ||
                !counter.containsKey('a') ||
                !counter.containsKey('l') ||
                !counter.containsKey('o') ||
                !counter.containsKey('n')) {
            return 0;
        } else {
            return Math.min(Math.min(counter.get('b'), counter.get('a')),
                    Math.min(counter.get('l') / 2,
                            Math.min(counter.get('o') / 2, counter.get('n'))));
        }
    }



    // 18 Valid Sudoku ///////////////////////////////////////////

    public boolean isValidSudoku(char[][] board) {
        // Validate Rows
        for (int i = 0; i < 9; i++) {
            // Set<Character> set = new HashSet<>();
            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                char item = board[i][j];
                if (item != '.' && !set.add(item)) {
                    return false;
                }
            }
        }

        // Validate Columns
        for (int i = 0; i < 9; i++) {
            // Set<Character> set = new HashSet<>();
            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                char item = board[j][i];
                if (item != '.' && !set.add(item)) {
                    return false;
                }
            }
        }

        // Validate 3x3 Sub-grids
        int[][] starts = {{0, 0}, {0, 3}, {0, 6},
                {3, 0}, {3, 3}, {3, 6},
                {6, 0}, {6, 3}, {6, 6}};

        for (int[] start : starts) {
            // Set<Character> set = new HashSet<>();
            HashSet<Character> set = new HashSet<Character>();
            for (int row = start[0]; row < start[0] + 3; row++) {
                for (int col = start[1]; col < start[1] + 3; col++) {
                    char item = board[row][col];
                    if (item != '.' && !set.add(item)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // 19 groupAnagrams ///////////////////////////////////////////

    public List<List<String>> groupAnagrams(String[] strs) {
        // Map<String, List<String>> anagramsMap = new HashMap<>();
        HashMap<String, List<String>> anagramsMap = new HashMap<String, List<String>>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int num : count) {
                key.append('#').append(num);
            }
            String keyStr = key.toString();
            anagramsMap.computeIfAbsent(keyStr, k -> new ArrayList<>()).add(s);
        }

        System.out.println("anagramsMap = "+ anagramsMap);
        // anagramsMap = {#1#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#1#0#0#0#0#0#0=[bat],
        // #1#0#0#0#0#0#0#0#0#0#0#0#0#1#0#0#0#0#0#1#0#0#0#0#0#0=[tan, nat],
        // #1#0#0#0#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#1#0#0#0#0#0#0=[eat, tea, ate]}


        return new ArrayList<>(anagramsMap.values());
    }

    // 20 majorityElement ///////////////////////////////////////////

    public int majorityElement(int[] nums) {
        int candidate = nums[0]; // first element
        int count = 0;

        System.out.println("candidate = "+candidate);

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }

        return candidate;
    }



    // 21 longestConsecutive ///////////////////////////////////////////

    public int longestConsecutive(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 1;
                int nextNum = num + 1;
                while (set.contains(nextNum)) {
                    length++;
                    nextNum++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }


    // 22 sortedSquares ///////////////////////////////////////////

    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index--] = nums[left] * nums[left];
                left++;
            } else {
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }

        // https://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array

        System.out.println(Arrays.toString(result));

        return result;
    }


    // 24 twoSum ///////////////////////////////////////////

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        // int[] numbers = {2,7, 11,15}; // already sorted in ascending orders

        while (left < right) {
            int sum = numbers[left] + numbers[right]; //
            System.out.println("sum = " + sum); // 17, 13, 9
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    // 24 twoSum1 ///////////////////////////////////////////

    public int[] twoSum(int[] nums, int target) {
        // Map<Integer, Integer> h = new HashMap<>();
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            h.put(nums[i], i);// key, value
        }

//        int[] numbers1 = {2,7,3, 6, 11,15}; // NOT sorted in ascending order
//        int target1 = 9;

        for (int i: h.keySet()){
            System.out.println("key = "+ i + " value = "+h.get(i));
//            key = 2 value = 0
//            key = 3 value = 2
//            key = 6 value = 3
//            key = 7 value = 1
//            key = 11 value = 4
//            key = 15 value = 5
        }

        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i]; // 7 = 9 - 2; y = 7; i = 0; nums[0]=2
            if (h.containsKey(y) && h.get(y) != i) { // h.get(7) = 1; i = 0; h.get(y) != i, not referring to the same number; not of the same index
                return new int[] {i, h.get(y)}; // h.get(y) is actually the position index rather than the value
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }



    // 25 isPalindrome ///////////////////////////////////////////

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 26 threeSum ///////////////////////////////////////////

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        int n = nums.length;

        // Build the index map
        for (int i = 0; i < n; i++) {
            indexMap.put(nums[i], i);
        }

        // Iterate over each pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int desired = -nums[i] - nums[j];
                if (indexMap.containsKey(desired) && indexMap.get(desired) != i && indexMap.get(desired) != j) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], desired);
                    Collections.sort(triplet);
                    result.add(triplet);
                }
            }
        }

        return new ArrayList<>(result);
    }


    // 26 threeSumUpdated //////////////

    // public List<List<Integer>> threeSumUpdated(int[] nums) {
    public ArrayList<ArrayList<Integer>> threeSumUpdated(int[] nums) {
        // Set<List<Integer>> result = new HashSet<>();
        HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        // Map<Integer, Integer> indexMap = new HashMap<>();
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int n = nums.length;

        // Build the index map
        for (int i = 0; i < n; i++) {
            indexMap.put(nums[i], i);
        }

        // Iterate over each pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int desired = -nums[i] - nums[j];
                if (indexMap.containsKey(desired) && indexMap.get(desired) != i && indexMap.get(desired) != j) {
                    // List<Integer> triplet = Arrays.asList(nums[i], nums[j], desired);
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(desired);
                    Collections.sort(triplet);
                    result.add(triplet);
                }
            }
        }

        return new ArrayList<>(result);

    }


    // 26 threeSumTwoPointers ///////////////////////////////////////////

    public List<List<Integer>> threeSumTwoPointers(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    answer.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }

        return answer;
    }

    // 26 threeSumTwoPointersUpdated ///////////////////////////////////////////

    // public List<List<Integer>> threeSumTwoPointersUpdated(int[] nums) {
    public ArrayList<ArrayList<Integer>> threeSumTwoPointersUpdated(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // List<List<Integer>> answer = new ArrayList<>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    // answer.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[lo]);
                    triplet.add(nums[hi]);
                    answer.add(triplet);
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }

        return answer;
    }


    // 27 maxArea ///////////////////////////////////////////

    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int a = w * h;
            maxArea = Math.max(maxArea, a);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }


    // 28 Trapping rain water ///////////////////////////////////////////

    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        int leftWall = 0, rightWall = 0;

        for (int i = 0; i < n; i++) {
            int j = n - i - 1;
            maxLeft[i] = leftWall;
            maxRight[j] = rightWall;
            leftWall = Math.max(leftWall, height[i]);
            rightWall = Math.max(rightWall, height[j]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int pot = Math.min(maxLeft[i], maxRight[i]);
            sum += Math.max(0, pot - height[i]);
        }

        return sum;
    }


    // 29 Baseball Game ///////////////////////////////////////////

    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    // 29 Baseball Game Updated ///////////////////////////////////////////

    // public int calPoints(String[] operations) {
    public int calPointsUpdated(String[] operations) {
        // Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack = new Stack<Integer>();

        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    // 30 Valid Parentheses ///////////////////////////////////////////

    public boolean isValid(String s) {
        java.util.Map<Character, Character> hashmap = new java.util.HashMap<>();
        hashmap.put(')', '(');
        hashmap.put('}', '{');
        hashmap.put(']', '[');

        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!hashmap.containsKey(c)) {
                stk.push(c);
            } else {
                if (stk.isEmpty() || stk.pop() != hashmap.get(c)) {
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }

    // 30 Valid Parentheses Updated ///////////////////////////////////////////

    public boolean isValidUpdated(String s) {
        // java.util.Map<Character, Character> hashmap = new java.util.HashMap<>();
        HashMap<Character, Character> hashmap = new HashMap<Character, Character>();
        hashmap.put(')', '(');
        hashmap.put('}', '{');
        hashmap.put(']', '[');

        // Stack<Character> stk = new Stack<>();
        Stack<Character> stk = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (!hashmap.containsKey(c)) {
                stk.push(c);
            } else {
                if (stk.isEmpty() || stk.pop() != hashmap.get(c)) {
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }

    // 31 Evaluate Reverse Polish Notation (RPN) ///////////////////////////////////////////

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        double division = (double) a / b;
                        stack.push(division < 0 ? (int) Math.ceil(division) : (int) Math.floor(division));
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    // 31 Evaluate Reverse Polish Notation (RPN) Updated///////////////////////////////////////////

    public int evalRPNUpdated(String[] tokens) {
        // Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack = new Stack<Integer>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        double division = (double) a / b;
                        stack.push(division < 0 ? (int) Math.ceil(division) : (int) Math.floor(division));
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    // 32 dailyTemperatures ///////////////////////////////////////////

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < temp) {
                int[] prev = stack.pop();
                answer[prev[1]] = i - prev[1];
            }
            stack.push(new int[]{temp, i});
        }
        return answer;
    }

    // 32 dailyTemperatures Updated ///////////////////////////////////////////

    public int[] dailyTemperaturesUpdated(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        // Stack<int[]> stack = new Stack<>();
        Stack<int[]> stack = new Stack<int[]>();

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < temp) {
                int[] prev = stack.pop();
                answer[prev[1]] = i - prev[1];
            }
            stack.push(new int[]{temp, i});
        }
        return answer;
    }




    // 34 Remove Duplicates from Sorted List ///////////////////////////////////////////

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicatesUpdated(int[] nodeList) {

        int n = nodeList.length;


        ListNode head = new ListNode(nodeList[n-1],null);
        for(int i=n-2;i>=0;i--){
            head = new ListNode(nodeList[i],head);
        }

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public void printListNode(ListNode head) {
        ListNode cur = head;

        ArrayList<Integer> resultList = new ArrayList<Integer>();

        while (cur != null) {
            // System.out.println(cur.val);
            resultList.add(cur.val);
            cur = cur.next;
        }

        System.out.println(resultList);
    }

    // 35 Reverse Linked List ///////////////////////////////////////////

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }


    // 36 Merged Two Sorted Lists ///////////////////////////////////////////


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0, null);
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = list1; // alternative to below: cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = list2; // alternative to below: cur = cur.next;
                list2 = list2.next;
            }
            // cur = cur.next;
        }

        cur.next = list1 != null ? list1 : list2;

        return dummy.next;
    }


    // 37 Linked List Cycle ///////////////////////////////////////////

    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode(0, null);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }


    // 38 Middle of the linked list ///////////////////////////////////////////

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    // 38 Middle of the linked list Updated///////////////////////////////////////////

    public int middleNodeUpdated(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.val;
    }


    // 39 removeNthFromEnd ///////////////////////////////////////////

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, null);
        dummy.next = head;
        ListNode behind = dummy;
        ListNode ahead = dummy;

        for (int i = 0; i <= n; i++) {
            ahead = ahead.next;
        }

        while (ahead != null) {
            behind = behind.next;
            ahead = ahead.next;
        }

        behind.next = behind.next.next;

        return dummy.next;
    }


    // 39 removeNthFromEnd Updated ///////////////////////////////////////////

    public int removeNthFromEndUpdated(ListNode head, int n) {
        ListNode dummy = new ListNode(0, null);
        dummy.next = head;
        ListNode behind = dummy;
        ListNode ahead = dummy;

        for (int i = 0; i <= n; i++) {
            ahead = ahead.next;
        }

        while (ahead != null) {
            behind = behind.next;
            ahead = ahead.next;
        }

//        behind.next = behind.next.next;
//
//        return dummy.next;

        return behind.next.val;
    }

    // 40 Copy List with Random Pointer ///////////////////////////////////////////

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> oldToNew = new HashMap<>();
        Node curr = head;

        // First pass: create all nodes and put them in the map
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: set next and random pointers
        curr = head;
        while (curr != null) {
            Node newNode = oldToNew.get(curr);
            newNode.next = oldToNew.get(curr.next);
            newNode.random = oldToNew.get(curr.random);
            curr = curr.next;
        }

        return oldToNew.get(head);
    }

    // 40 Copy List with Random Pointer Updated///////////////////////////////////////////

    // public Node copyRandomList(Node head) {
    public Node copyRandomListUpdated(Node head) {
        if (head == null) return null;

        // Map<Node, Node> oldToNew = new HashMap<>();
        HashMap<Node, Node> oldToNew = new HashMap<Node, Node>();
        Node curr = head;

        // First pass: create all nodes and put them in the map
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: set next and random pointers
        curr = head;
        while (curr != null) {
            Node newNode = oldToNew.get(curr);
            newNode.next = oldToNew.get(curr.next);
            newNode.random = oldToNew.get(curr.random);
            curr = curr.next;
        }

        return oldToNew.get(head);
    }






    // xx xxxxxxxxxxxxxxxxxxxxxxxxx ///////////////////////////////////////////
















}
