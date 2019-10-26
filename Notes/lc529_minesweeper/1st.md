## Solution1 - DFS

#### complexity

| time | space |
| ---- | ----- |
| O()  | O()   |



---

#### note

* 'E': empty 还未点击
* 'M': 地雷 点击 改成x 游戏结束 
* 'B': 点击了 不是雷 以自己为中心 周围8个格子没有雷
* '#'：点击过 周围有雷， 改为显示周围雷的数量

---



#### code

```java
class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = board.length;
        int col = board[0].length;
        int x = click[0];
        int y = click[1];
        
        if(board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        
        int count = 0;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(newX >= 0 && newX < row && newY >= 0 && newY < col){
                if(board[newX][newY] == 'M'){
                    count++;
                }
            }
        }
        if(count > 0) {
            board[x][y] = (char)(count + '0');
            return board;
        }
        board[x][y] = 'B';
        for (int[] dir : dirs) {
        int newX = x + dir[0];
        int newY = y + dir[1];
            if(newX >= 0 && newX < row && newY >= 0 && newY < col){
                if(board[newX][newY] == 'E'){
                    updateBoard(board, new int[]{newX, newY});
                }
            }
        }
        return board;
        
    }
}
```

#### panel-generator

 ```java
    public static int[][] panelGenerator(int H, int W, int M) {
        int x = (int) (Math.random() * H);
        int y = (int) (Math.random() * W);
        int[][] grid = new int[H][W];
        while (M > 0) {
            while (grid[x][y] == -1) {
                x = (int) (Math.random() * H);
                y = (int) (Math.random() * W);
            }
            grid[x][y] = -1;
            M--;
        }
        return grid;
    }

//output
0 -1 0
0  0 -1
0  0  0
 ```

