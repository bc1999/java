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
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);

        num1 = 22;

        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> map3 = new HashMap<>();

        map1.put("value", 11);
        map2 = map1;
        System.out.println("map1 : "+map1); // 11
        System.out.println("map2 : "+map2); // 11

        /////////////////////////////////
        map1.put("value", 22);
        System.out.println("map1 : "+map1); // 22
        System.out.println("map2 : "+map2); // 22
        /////////////////////////////////

        map3.put("value", 57);
        map2 = map3;
        System.out.println("map1 : "+map1); // 22
        System.out.println("map2 : "+map2); // 57
        System.out.println("map3 : "+map3); // 57


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
    }
}