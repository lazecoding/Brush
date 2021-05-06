package brush.leetcode.search.Backtracking;

/**
 * @author: lazecoding
 * @date: 2021/1/7 20:56
 * @description:
 */
public class Q79 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C'}, {'D', 'A', 'C'}, {'R', 'S', 'S'}
        };
        String word = "BAS";
        boolean ans = new Solution().exist(board, word);
        System.out.println(ans);
    }

}

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * <p>
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        // visited 数组用于标识每个位置是否被访问过，每次遍历相邻位置时，需要跳过已经被访问的位置。
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * check(i,j,k) 判断以网格的 (i, j)(i,j) 位置出发，能否搜索到单词 word[k..]，
     * 其中 word[k..] 表示字符串 word 从第 k 个字符开始的后缀子串。如果能搜索到，则返回 true，反之返回 false。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/word-search/solution/dan-ci-sou-suo-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            // 1. 如果 != ，当前字符不匹配，直接返回 false。
            return false;
        } else if (k == word.length() - 1) {
            // 2. 如果当前已经访问到字符串的末尾，且对应字符依然匹配，此时直接返回 true。
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        // 3.遍历当前位置的所有相邻位置。如果从某个相邻位置出发，能够搜索到子串 word[k+1..]，则返回 true，否则返回 false。
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, word, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}

