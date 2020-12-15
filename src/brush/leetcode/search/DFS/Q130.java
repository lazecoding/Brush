package brush.leetcode.search.DFS;

/**
 * @author: lazecoding
 * @date: 2020/12/15 21:56
 * @description:
 */
public class Q130 {
    public static void main(String[] args) {

    }

    /**
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * <p>
     * 示例:
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * 运行你的函数后，矩阵变为：
     * <p>
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * 解释:
     * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
     * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/surrounded-regions
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 从边界出发吧，先把边界上和 O 连通点找到, 把这些变成 B,然后遍历整个 board 把 O 变成 X, 把 B 变成 O
         *
         * @param board
         */
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
            int row = board.length;
            int col = board[0].length;
            for (int j = 0; j < col; j++) {
                // 第一行
                if (board[0][j] == 'O') {
                    dfs(0, j, board, row, col);
                }
                // 最后一行
                if (board[row - 1][j] == 'O') {
                    dfs(row - 1, j, board, row, col);
                }
            }

            for (int i = 0; i < row; i++) {
                // 第一列
                if (board[i][0] == 'O') {
                    dfs(i, 0, board, row, col);
                }
                // 最后一列
                if (board[i][col - 1] == 'O') {
                    dfs(i, col - 1, board, row, col);
                }
            }

            // 转变
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == 'B') board[i][j] = 'O';
                }
            }
        }

        private void dfs(int i, int j, char[][] board, int row, int col) {
            board[i][j] = 'B';
            for (int[] dir : dirs) {
                int tmp_i = dir[0] + i;
                int tmp_j = dir[1] + j;
                if (tmp_i < 0 || tmp_i >= row || tmp_j < 0 || tmp_j >= col || board[tmp_i][tmp_j] != 'O') {
                    continue;
                }
                dfs(tmp_i, tmp_j, board, row, col);
            }
        }
    }
}
