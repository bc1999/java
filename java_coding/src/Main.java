import java.util.HashMap;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
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



    }
}