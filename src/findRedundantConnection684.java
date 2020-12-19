import java.util.HashSet;
import java.util.Set;

public class findRedundantConnection684 {
    public static void main(String[] args) {
        //new findRedundantConnection684().findRedundantConnection(new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}});
        new findRedundantConnection684().findRedundantConnection(new int[][]{{1, 2}, {1, 3}});
    }

    public int[] findRedundantConnection(int[][] edges) {

        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            hs.add(edges[i][0]);
            hs.add(edges[i][1]);
        }
        int[] parent = new int[hs.size()];
        int i = 0;
        for (; i < edges.length; i++) {
            int x = edges[i][0] - 1; //取index
            int y = edges[i][1] - 1;

            if (!unionVertices(x, y, parent)) {
                System.out.println("Cycled!");
                return edges[i];
            }
        }
        System.out.println("No cycle");
        return new int[]{};

    }

    public int findRoot(int root, int[] parent) {
        int xRoot = root;
        while (parent[xRoot] != 0) {
            xRoot = parent[xRoot];
        }
        return xRoot;
    }

    public boolean unionVertices(int x, int y, int[] parent) {
        int xRoot = findRoot(x, parent);
        int yRoot = findRoot(y, parent);
        if (xRoot == yRoot) {
            return false;
        } else {
            parent[xRoot] = yRoot;
            return true;
        }
    }


}
