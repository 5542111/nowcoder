import java.util.*;

public class a0402removeKdigits {


    public String removeKdigits(String num, int k) {
        if (num.replaceAll("0", "").length() == 0 || k >= num.length()) return "0";
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            Character digit = num.charAt(i);
            while (!deque.isEmpty() && deque.peekLast() > digit && k > 0) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        while (k-- > 0) {
            deque.pollLast();
        }

        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty() && deque.peekFirst() == '0'){
            deque.pollFirst();
        }
        while (!deque.isEmpty()) {
            res.append(deque.pollFirst());
        }
        return res.length() == 0 ? "0" : res.toString();
    }


}
