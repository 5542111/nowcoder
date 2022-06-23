import java.util.*;

public class a0841canVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>(rooms.get(0));
        boolean[] roomVisited = new boolean[rooms.size()];
        roomVisited[0] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (roomVisited[poll]) continue;
            roomVisited[poll] = true;
            for (Integer integer : rooms.get(poll)) {
                if (!roomVisited[integer]){
                    queue.add(integer);
                }
            }
        }

        for (boolean b : roomVisited) {
            if (!b) return false;
        }
        return true;
    }
}
