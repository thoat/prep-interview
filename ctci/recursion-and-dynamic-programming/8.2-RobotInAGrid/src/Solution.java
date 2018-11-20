import java.util.ArrayList;
public class Solution {

    public static void main(String[] args) {
        boolean[][] grid1 = new boolean[3][4];
        grid1[0][2] = true; // true means "off limits"
        grid1[1][1] = true; // true means "off limits"
        grid1[1][2] = true; // true means "off limits"
        System.out.println("Path for grid1 is " + findPath(grid1));

        boolean[][] grid2 = new boolean[7][5];
        grid2[0][4] = true; // true means "off limits"
        grid2[2][3] = true; // true means "off limits"
        grid2[3][4] = true; // true means "off limits"
        grid2[4][1] = true; // true means "off limits"
        grid2[4][3] = true; // true means "off limits"
        grid2[5][2] = true; // true means "off limits"
        grid2[6][1] = true; // true means "off limits" -- change this to [6][0] will unblock the path
        System.out.println("Path for grid2 is " + findPath(grid2));
    }

    private static ArrayList<Point> findPath(boolean[][] grid) {
        if (grid == null || grid.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        path.add(new Point(0, 0));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        boolean pathFound = dfs(grid, grid.length, grid[0].length, path, visited, 0, 0);
        if (!pathFound) return null;
        return path;
    }

    private static boolean dfs(boolean[][] grid, int rows, int cols, ArrayList<Point> path, boolean[][] visited, int i, int j) {
        while (i < rows - 1 || j < cols - 1) {
            // try going right first
            if (j + 1 < cols && !visited[i][j + 1] && !grid[i][j + 1]) {
                j += 1;
                Point p = new Point(i, j);
                visited[i][j] = true;
                path.add(p);
            }
            // then try going down
            else if (i + 1 < rows && !visited[i + 1][j] && !grid[i + 1][j]) {
                i += 1;
                Point p = new Point(i, j);
                visited[i][j] = true;
                path.add(p);
            }
            // invalid move. backtrack.
            else {
                path.remove(path.size() - 1); // remove the last entry
                if (path.size() == 0) // no more path to try. Correct path doesn't exist
                    return false;
                Point lastValid = path.get(path.size() - 1);
                i = lastValid.row;
                j = lastValid.col;
            }
        }
        return true;
    }

    static class Point {
        int row;
        int col;
        public Point(int r, int c) { this.row = r; this.col = c; }
        public String toString() {
            return "p[" + row + "," + col + "]";
        }
    }
}
