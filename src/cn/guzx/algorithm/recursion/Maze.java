package cn.guzx.algorithm.recursion;

public class Maze{

    static int count = 0;

    public static void main(String[] args) {
        int[][] maze = new int[7][8];
        System.out.println("迷宫初始：");
        printMaze(maze);
        maze(maze, 1, 1);
        System.out.println("成功的路径是：   一共走了：" + count + "步");
        for (int[] list : maze) {
            for (int value : list) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
        // 迷宫问题
    public static boolean maze(int[][] maze, int destX, int destY) {
        // 找路策略 右--下--左--上
        // 标志含义 0:可以走，但还没走 1:不能走 2:顺利通过 3:通过该路径无法达到最终目的地
        if (maze[5][6] == 2) {
            return true;
        } else {
            count++;
            if (destX == 4 && destY == 3) {
                System.out.println("这个走过了");
            }
            if (maze[destX][destY] == 0) {
                maze[destX][destY] = 2;
                if (maze(maze, destX + 1, destY)) {
                    return true;
                } else if (maze(maze, destX, destY + 1)) {
                    return true;
                } else if (maze(maze, destX - 1, destY)) {
                    return true;
                } else if (maze(maze, destX, destY - 1)) {
                    return true;
                } else {
                    maze[destX][destY] = 3;
                    return false;
                }
            } else {
                return false;
            }

        }
    }

    // 初始化迷宫
    public static void printMaze(int[][] maze) {
        // 左右两列
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = 1;
            maze[i][maze[0].length-1] = 1;
        }
        // 上下两排
        for (int i = 0; i < maze[0].length; i++) {
            maze[0][i] = 1;
            maze[maze.length-1][i] = 1;
        }
        // 随意的障碍点
        maze[2][1] = 1;
        maze[2][2] = 1;
        maze[5][4] = 1;
        for (int[] list : maze) {
            for (int value : list) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}