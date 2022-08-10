import java.util.Stack;

public class a0640solveEquation {
    public static void main(String[] args) {
        System.out.println(new a0640solveEquation().solveEquation("x+5-3+x=6+x-2"));
    }

    public String solveEquation(String equation) {
        int leftX = 0;
        int rightX = 0;
        int leftValue = 0;
        int rightValue = 0;
        boolean isChanged = false;

        String[] split = equation.split("=");
        String left = split[0];
        String right = split[1];
        StringBuilder sb = new StringBuilder();
        boolean isX = false;
        boolean positive = !(left.charAt(0) == '-');
        for (int i = 0; i < left.length(); i++) {
            char c = left.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == 'x') {
                if (sb.length() == 0) {
                    sb.append(1);
                }
                isX = true;
            } else {
                int num = 0;
                if (sb.length() != 0) {
                    num = Integer.parseInt(sb.toString());
                    if (!positive) {
                        num = -num;
                    }
                    sb = new StringBuilder();
                }
                if (isX) {
                    leftX += num;
                    isX = false;
                } else {
                    leftValue += num;
                }
                positive = c == '+';
            }
            if (i == left.length() - 1) {
                int num = 0;
                if (sb.length() != 0) {
                    num = Integer.parseInt(sb.toString());
                    if (!positive) {
                        num = -num;
                    }
                    sb = new StringBuilder();
                }
                if (isX) {
                    leftX += num;
                    isX = false;
                } else {
                    leftValue += num;
                }
            }
        }

        positive = !(right.charAt(0) == '-');
        for (int i = 0; i < right.length(); i++) {
            char c = right.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == 'x') {
                if (sb.length() == 0) {
                    sb.append(1);
                }
                isX = true;
            } else {
                int num = 0;
                if (sb.length() != 0) {
                    num = Integer.parseInt(sb.toString());
                    if (!positive) {
                        num = -num;
                    }
                    sb = new StringBuilder();
                }
                if (isX) {
                    rightX += num;
                    isX = false;
                } else {
                    rightValue += num;
                }
                positive = c == '+';
            }
            if (i == right.length() - 1) {
                int num = 0;
                if (sb.length() != 0) {
                    num = Integer.parseInt(sb.toString());
                    if (!positive) {
                        num = -num;
                    }
                    sb = new StringBuilder();
                }
                if (isX) {
                    rightX += num;
                } else {
                    rightValue += num;
                }
            }
        }
        if (leftX - rightX == 0) {
            return "Infinite solutions";
        } else {
            return "x=" + (rightValue - leftValue) / (leftX - rightX);
        }

    }
}
