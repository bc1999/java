import java.util.HashMap;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    public static void main(String[] args) {

        //------------
        int testInt = 5;
        int resultInt = testInt/2;
        System.out.println( "resultInt = "+ resultInt);//2
        //------------
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // System.out.printf("Hello and welcome!");

        //////////////////////////////////

//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
        /////////////////////////////////


        /////////////////////////////
        // https://stackoverflow.com/questions/1094872/is-there-a-difference-between-x-and-x-in-java
        int x = 5, y = 5;

        System.out.println("++x = "+ ++x); // outputs 6
        System.out.println("x = "+x); // outputs 6

        System.out.println("y++ = "+ y++); // outputs 5
        System.out.println("y = "+ y); // outputs 6

//        ++x = 6
//        x = 6
//        y++ = 5
//        y = 6

        /////////////////////////////
        int num1 = 11;
        int num2 = num1;
        System.out.println("num1 : " + num1); // num1 : 11
        System.out.println("num2 : " + num2); // num2 : 11

        num1 = 22;

        System.out.println("num1 : " + num1); // num1 : 22
        System.out.println("num2 : " + num2); // num2 : 11 , not a pointer

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> map3 = new HashMap<>();

        map1.put("value", 11);
        map2 = map1;
        System.out.println("map1 : "+map1); // map1 : {value=11}
        System.out.println("map2 : "+map2); // map2 : {value=11}

        /////////////////////////////////
        map1.put("value", 22);
        System.out.println("map1 : "+map1); // map1 : {value=22}
        System.out.println("map2 : "+map2); // map2 : {value=22}
        /////////////////////////////////

        map3.put("value", 57);
        map2 = map3;
        System.out.println("map1 : "+map1); // map1 : {value=22}
        System.out.println("map2 : "+map2); // map2 : {value=57}
        System.out.println("map3 : "+map3); // map3 : {value=57}
        map1 = map2;
        System.out.println("map1 : "+map1); // map1 : {value=57}


        /////////////////////////////////
        Gh_arr_str_1 gh_arr_str_1 = new Gh_arr_str_1();

        int[] intArr = new int[]{-4,-2,1,4,8};
        int ans_gh_arr_str_1 = gh_arr_str_1.findClosestNumber(intArr);
        System.out.println("ans_gh_arr_str_1: " + ans_gh_arr_str_1);
        /////////////////////////////////
        Gh_arr_str_2 gh_arr_str_2 = new Gh_arr_str_2();
        String word1 = "abc", word2 = "pqr";
        String ans_gh_arr_str_2 = gh_arr_str_2.mergeAlternately(word1, word2);
        System.out.println("ans_gh_arr_str_2: " + ans_gh_arr_str_2);
        /////////////////////////////////
        System.out.println("PK1 - Sliding Window");
        pk1SlidingWindow sw = new pk1SlidingWindow();

        String[] input1 = { "abcabcbb", "bbbbb", "pwwkew" };
        for (String input : input1) {
            System.out.println(
                    String.format(
                            "lengthOfLongestSubstringWithoutRepeating(\"%s\") = %d",
                            input,
                            sw.lengthOfLongestSubstringWithoutRepeating(input)));
        }

        System.out.println();

        String[] input2 = { "eceba", "aa" };
        for (String input : input2) {
            for (int k = 1; k <= input.length(); k++) {
                System.out.println(
                        String.format(
                                "lengthOfLongestSubstringKDistinct(\"%s\", %d) = %d",
                                input,
                                k,
                                sw.lengthOfLongestSubstringKDistinct(input, k)));
            }
        }
        /////////////////////////////////

        System.out.println("LongestSubArray");
        LongestSubArray lSArr = new LongestSubArray();

        int[] intArray = {1,1,0,1};
        int longestSubarrayValue = lSArr.longestSubarray(intArray);
        System.out.println("longestSubarrayValue = "+longestSubarrayValue);

        /////////////////////////////////
        System.out.println("getHead(), getTail(), getLength(), printList()");
        LinkedList myLinkedList1 = new LinkedList(4);// value of 4
        myLinkedList1.getHead();// Head: 4
        myLinkedList1.getTail(); // Tail: 4
        myLinkedList1.getLength(); // Length: 1
        myLinkedList1.printList(); // 4
        /////////////////////////////////
        System.out.println("removeLast()"); // pop()
        LinkedList myLinkedList2 = new LinkedList(1);
        myLinkedList2.append(2);
        myLinkedList2.printList();
        // (2) Items - Returns 2 Node
        System.out.println(myLinkedList2.removeLast().value);
        // (1) Items - Returns 1 Node
        System.out.println(myLinkedList2.removeLast().value);
        // (0) Items - Returns null
        System.out.println(myLinkedList2.removeLast());// java.lang.NullPointerException
        /////////////////////////////////
        System.out.println("prepend(1)");
        LinkedList myLinkedList3 = new LinkedList(2);
        myLinkedList3.append(3);
        myLinkedList3.prepend(1);
        myLinkedList3.printList();
        /////////////////////////////////
        System.out.println("removeFirst()");
        LinkedList myLinkedList4 = new LinkedList(2);
        myLinkedList4.append(1);
        myLinkedList4.printList();

        // (2) Items - Returns 2 Node
        System.out.println(myLinkedList4.removeFirst().value);
        // (1) Items - Returns 1 Node
        System.out.println(myLinkedList4.removeFirst().value);
        // (0) Items - Returns null
        System.out.println(myLinkedList4.removeFirst());// java.lang.NullPointerException

        /////////////////////////////////
        System.out.println("get()");
        LinkedList myLinkedList5 = new LinkedList(0);
        myLinkedList5.append(1);
        myLinkedList5.append(2);
        myLinkedList5.append(3);
        System.out.println(myLinkedList5.get(2).value + "\n"); // a line break
        myLinkedList5.printList();

        /////////////////////////////////
        System.out.println("set()");
        LinkedList myLinkedList6 = new LinkedList(11);
        myLinkedList6.append(3);
        myLinkedList6.append(23);
        myLinkedList6.append(7);
        myLinkedList6.printList();
        System.out.println(myLinkedList5.set(1, 4) + "\n"); // a line break
        myLinkedList6.printList();

        /////////////////////////////////

        System.out.println("insert(1,1)");
        LinkedList myLinkedList7 = new LinkedList(0);
        myLinkedList7.append(2);
        myLinkedList7.printList();
        System.out.println(myLinkedList7.insert(1,1) + "\n"); // a line break
        myLinkedList7.printList();

        /////////////////////////////////
        System.out.println("remove(2)");
        LinkedList myLinkedList8 = new LinkedList(11);
        myLinkedList8.append(3);
        myLinkedList8.append(23);
        myLinkedList8.append(7);
        myLinkedList8.printList();
        System.out.println(myLinkedList8.remove(2).value + "\n");
        myLinkedList8.printList();

        /////////////////////////////////
        System.out.println("reverse()");
        LinkedList myLinkedList9 = new LinkedList(1);
        myLinkedList9.append(2);
        myLinkedList9.append(3);
        myLinkedList9.append(4);
        myLinkedList9.printList();
        myLinkedList9.reverse();
        System.out.println("\n");
        myLinkedList9.printList();

        /////////////////////////////////
        System.out.println("partitionList(int x)");
        LinkedList myLinkedList10 = new LinkedList(3);
        myLinkedList10.append(5);
        myLinkedList10.append(8);
        myLinkedList10.append(10);
        myLinkedList10.append(2);
        myLinkedList10.append(1);
        myLinkedList10.printList();
        myLinkedList10.partitionList(5);
        System.out.println("\n");
        myLinkedList10.printList();

        System.out.println("\n");
        System.out.println("partitionList getHead() "+ myLinkedList10.getHead());
        System.out.println("partitionList getTail() "+ myLinkedList10.getTail());

        // 1 findClosestNumber ///////////////////////////////////////////

        AlgoMapSolution algoMapClass = new AlgoMapSolution();

        int[] integerArray = {-2,9,-3, 2, 4,6};
        System.out.println("findClosestNumber = "+ algoMapClass.findClosestNumber(integerArray));
        // findClosestNumber = 2


        // 18 Valid Sudoku ///////////////////////////////////////////

        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                            ,{'6','.','.','1','9','5','.','.','.'}
                            ,{'.','9','8','.','.','.','.','6','.'}
                            ,{'8','.','.','.','6','.','.','.','3'}
                            ,{'4','.','.','8','.','3','.','.','1'}
                            ,{'7','.','.','.','2','.','.','.','6'}
                            ,{'.','6','.','.','.','.','2','8','.'}
                            ,{'.','.','.','4','1','9','.','.','5'}
                            ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println("isValidSudoku = "+ algoMapClass.isValidSudoku(board));
        // isValidSudoku = true


        // 19 groupAnagrams ///////////////////////////////////////////
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("groupAnagrams = "+ algoMapClass.groupAnagrams(strs));
        // groupAnagrams = [[bat], [tan, nat], [eat, tea, ate]]


        // 20 majorityElement ///////////////////////////////////////////

        int[] nums = {2,2,1,1,1,2,2};

        System.out.println("majorityElement = "+ algoMapClass.majorityElement(nums));
        // majorityElement = 2


        // 21 longestConsecutive ///////////////////////////////////////////

        int[] nums2 = {100,4,200,1,3,2};

        System.out.println("longestConsecutive = "+ algoMapClass.longestConsecutive(nums2));

        // longestConsecutive = 4



        // 22 sortedSquares ///////////////////////////////////////////

        int[] nums3 = {-4,-1,0,3,10};

        System.out.println("sortedSquares = "+ Arrays.toString(algoMapClass.sortedSquares(nums3)));

        // sortedSquares = [0, 1, 9, 16, 100]


        // 24 twoSum2 ///////////////////////////////////////////

        int[] numbers = {2,7, 11,15};
        int target = 9;

        System.out.println("twoSum2 = "+ Arrays.toString(algoMapClass.twoSum2(numbers, target)));

        // twoSum2 = [1, 2]

        // 24 twoSum ///////////////////////////////////////////

        int[] numbers1 = {2,7,3, 6, 11,15};
        int target1 = 9;

        System.out.println("twoSum1 = "+ Arrays.toString(algoMapClass.twoSum(numbers1, target1)));

        // twoSum1 = [0, 1]

        // 25 isPalindrome ///////////////////////////////////////////
        String s = "A man, a plan, a canal: Panama";

        System.out.println("isPalindrome = "+ algoMapClass.isPalindrome(s));

        // isPalindrome = true

        // 26 threeSum ///////////////////////////////////////////

        int[] numsThreeSum = {-1,0,1,2,-1,-4};

        System.out.println("threeSum = "+ algoMapClass.threeSum(numsThreeSum));

        // threeSum = [[-1, -1, 2], [-1, 0, 1]]

        System.out.println("threeSumUpdated = "+ algoMapClass.threeSumUpdated(numsThreeSum));

        // threeSumUpdated = [[-1, -1, 2], [-1, 0, 1]]

        // 26 threeSumTwoPointers ///////////////////////////////////////////

        int[] numsThreeSumTwoPointers = {-1,0,1,2,-1,-4};

        System.out.println("threeSumTwoPointers = "+ algoMapClass.threeSumTwoPointers(numsThreeSumTwoPointers));

        // threeSumTwoPointers = [[-1, -1, 2], [-1, 0, 1]]

        System.out.println("threeSumTwoPointersUpdated = "+ algoMapClass.threeSumTwoPointersUpdated(numsThreeSumTwoPointers));

        // threeSumTwoPointersUpdated = [[-1, -1, 2], [-1, 0, 1]]


        // 27 Container with most water ///////////////////////////////////////////

        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println("maxArea = "+ algoMapClass.maxArea(height));

        // maxArea = 49

        // 28 Trapping Rain Water ///////////////////////////////////////////

        int[] heightTrapping = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println("trap = "+ algoMapClass.trap(heightTrapping));

        // trap = 6

        // 29 Baseball Game ///////////////////////////////////////////
        String[] ops = {"5","2","C","D","+"};
        System.out.println("calPoints = "+ algoMapClass.calPoints(ops));
        // calPoints = 30

        // 29 Baseball Game Updated ///////////////////////////////////////////

        String[] ops2 = {"5","2","C","D","+"};
        System.out.println("calPointsUpdated = "+ algoMapClass.calPointsUpdated(ops2));
        // calPointsUpdated = 30

        // 1 DSAClasses.Stack ///////////////////////////////////////////
        StackDSA myStack = new StackDSA(10);

        myStack.push('A');
        myStack.push('B');
        myStack.push('C');

        // Print initial stack
        System.out.print("Stack: ");
        myStack.printStack();

        System.out.println("Pop: " + myStack.pop());
        System.out.println("Peek: " + myStack.peek());
        System.out.println("isEmpty: " + myStack.isEmpty());
        System.out.println("Size: " + myStack.size());



        // 30 Valid Parentheses ///////////////////////////////////////////
        String sParentheses = "([])";
        System.out.println("isValid = "+ algoMapClass.isValid(sParentheses));
        // isValid = true

        // 30 Valid Parentheses Updated ///////////////////////////////////////////
        String sParenthesesUpdated = "([])";
        System.out.println("isValidUpdated = "+ algoMapClass.isValidUpdated(sParenthesesUpdated));
        // isValidUpdated = true


        // 31 Evaluate Reverse Polish Notation ///////////////////////////////////////////
        String[] tokens = {"2","1","+","3","*"};
        System.out.println("evalRPN = "+ algoMapClass.evalRPN(tokens));
        // evalRPN = 9


        // 31 Evaluate Reverse Polish NotationUpdated ///////////////////////////////////////////
        String[] tokensUpdated = {"2","1","+","3","*"};
        System.out.println("evalRPNUpdated = "+ algoMapClass.evalRPNUpdated(tokensUpdated));
        // evalRPNUpdated = 9


        // 32 dailyTemperatures ///////////////////////////////////////////
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println("dailyTemperatures = "+ Arrays.toString(algoMapClass.dailyTemperatures(temperatures)));
        // dailyTemperatures = [1, 1, 4, 2, 1, 1, 0, 0]


        // 32 dailyTemperaturesUpdated ///////////////////////////////////////////
        int[] temperaturesUpdated = {73,74,75,71,69,72,76,73};
        System.out.println("dailyTemperaturesUpdated = "+ Arrays.toString(algoMapClass.dailyTemperaturesUpdated(temperaturesUpdated)));
        // dailyTemperaturesUpdated = [1, 1, 4, 2, 1, 1, 0, 0]



        // 33 Min Stack ///////////////////////////////////////////
        String[] stringStack = {"MinStack","push","push","push","getMin","pop","top","getMin"};
        // [[],[-2],[0],[-3],[],[],[],[]]

        MinStack myMinStack = new MinStack();
        myMinStack.push(-2);
        myMinStack.push(0);
        myMinStack.push(-3);
        System.out.println("getMin = "+myMinStack.getMin());
        // getMin = -3
        myMinStack.pop();
        System.out.println("top = "+myMinStack.top());
        // top = 0
        System.out.println("getMin = "+myMinStack.getMin());
        // getMin = -2


        // 34 Remove Duplicates from Sorted List ///////////////////////////////////////////

        ListNode L5 = new ListNode(3, null);
        ListNode L4 = new ListNode(3, L5);
        ListNode L3 = new ListNode(2, L4);
        ListNode L2 = new ListNode(1, L3);
        ListNode L1 = new ListNode(1, L2);

        algoMapClass.printListNode(algoMapClass.deleteDuplicates(L1));

        int[] nodeList = {1,1,2,3,3};

        algoMapClass.printListNode(algoMapClass.deleteDuplicatesUpdated(nodeList));
        algoMapClass.printListNode(algoMapClass.deleteDuplicatesUpdated(new int[]{1,1,1,2,2,2,3,3,3,4,4,4}));

        // 35 Reverse Linked List ///////////////////////////////////////////

        int[] head = {1,2,3,4,5};

        ListNode LL5 = new ListNode(5, null);
        ListNode LL4 = new ListNode(4, LL5);
        ListNode LL3 = new ListNode(3, LL4);
        ListNode LL2 = new ListNode(2, LL3);
        ListNode LL1 = new ListNode(1, LL2);

        algoMapClass.printListNode(algoMapClass.reverseList(LL1));
        // [5, 4, 3, 2, 1]


        // 36 Merged Two Sorted Lists ///////////////////////////////////////////
        // list1 = [1,2,4], list2 = [1,3,4]

        ListNode LLL1_3 = new ListNode(4, null);
        ListNode LLL1_2 = new ListNode(2, LLL1_3);
        ListNode LLL1_1 = new ListNode(1, LLL1_2);

        ListNode LLL2_3 = new ListNode(4, null);
        ListNode LLL2_2 = new ListNode(3, LLL2_3);
        ListNode LLL2_1 = new ListNode(1, LLL2_2);

        algoMapClass.printListNode(algoMapClass.mergeTwoLists(LLL1_1, LLL2_1));
        // [1, 1, 2, 3, 4, 4]

        // 37 Linked List Cycle ///////////////////////////////////////////

        int[] headList = {3,2,0,-4};
        int pos = 1;

        ListNode LLLL_4 = new ListNode(-4, null);
        ListNode LLLL_3 = new ListNode(0, LLLL_4);
        ListNode LLLL_2 = new ListNode(2, LLLL_3);
        ListNode LLLL_1 = new ListNode(3, LLLL_2);

        LLLL_4.next = LLLL_2;

        System.out.println("hasCycle = "+algoMapClass.hasCycle(LLLL_1));
        // hasCycle = true


        // 38 Middle of the linked list ///////////////////////////////////////////

        ListNode L5_5 = new ListNode(5, null);
        ListNode L5_4 = new ListNode(4, L5_5);
        ListNode L5_3 = new ListNode(3, L5_4);
        ListNode L5_2 = new ListNode(2, L5_3);
        ListNode L5_1 = new ListNode(1, L5_2);

        algoMapClass.printListNode(algoMapClass.middleNode(L5_1));
        // [3, 4, 5]

        System.out.println(algoMapClass.middleNodeUpdated(L5_1));
        // 3

        ListNode L6_6 = new ListNode(6, null);
        ListNode L6_5 = new ListNode(5, L6_6);
        ListNode L6_4 = new ListNode(4, L6_5);
        ListNode L6_3 = new ListNode(3, L6_4);
        ListNode L6_2 = new ListNode(2, L6_3);
        ListNode L6_1 = new ListNode(1, L6_2);


        algoMapClass.printListNode(L6_1);
        // [1, 2, 3, 4, 5, 6]

        algoMapClass.printListNode(algoMapClass.middleNode(L6_1));
        // [4, 5, 6]

        algoMapClass.printListNode(L6_1);
        // [1, 2, 3, 4, 5, 6]

        System.out.println(algoMapClass.middleNodeUpdated(L6_1));
        // 4


        // 39 removeNthFromEnd ///////////////////////////////////////////
        // head = [1,2,3,4,5], n = 2

        ListNode L7_5 = new ListNode(5, null); // 1
        ListNode L7_4 = new ListNode(4, L7_5); // 2
        ListNode L7_3 = new ListNode(3, L7_4); // 3
        ListNode L7_2 = new ListNode(2, L7_3); // 4
        ListNode L7_1 = new ListNode(1, L7_2); // 5

        algoMapClass.printListNode(L7_1);
        // [1, 2, 3, 4, 5]

        algoMapClass.printListNode(algoMapClass.removeNthFromEnd(L7_1, 2));
        // [1, 2, 3, 5]

        algoMapClass.printListNode(L7_1);
        // [1, 2, 3, 5]

        System.out.println(algoMapClass.removeNthFromEndUpdated(L7_1, 2));
        // 3

        ListNode L8_5 = new ListNode(5, null); // 1
        ListNode L8_4 = new ListNode(4, L8_5); // 2
        ListNode L8_3 = new ListNode(3, L8_4); // 3
        ListNode L8_2 = new ListNode(2, L8_3); // 4
        ListNode L8_1 = new ListNode(1, L8_2); // 5

        algoMapClass.printListNode(L8_1);
        // [1, 2, 3, 4, 5]

        System.out.println(algoMapClass.removeNthFromEndUpdated(L8_1, 2));
        // 4







        // x xxxxxxxxxxxxxxx ///////////////////////////////////////////








    }
}