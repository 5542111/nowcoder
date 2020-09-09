public class isRobotBounded1041 {
    public boolean isRobotBounded(String instructions) {
        int direction, i;
        int[] counts;

        direction = 0;
        counts = new int[4];
        for(i = 0; i < instructions.length(); i++)
            if(instructions.charAt(i) == 'G')
                counts[direction]++;
            else if(instructions.charAt(i) == 'L'){
                if(direction == 3)
                    direction = 0;
                else
                    direction++;
            }else{
                if(direction == 0)
                    direction = 3;
                else
                    direction--;
            }
        if(direction == 0)
            return counts[0] == counts[2] && counts[1] == counts[3];
        return true;

    }
}
