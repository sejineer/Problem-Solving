import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[][] feed = new int[15][15];
    static int[][] feedBoard = new int[15][15];
    static ArrayList<Tree> trees = new ArrayList<>();
    static ArrayList<Tree> deadTrees = new ArrayList<>();
    static class Tree {
        int x, y, age;
        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }
    static void spring() {
        ArrayList<Tree> tempTrees = new ArrayList<>();
        for(Tree tree : trees) {
            if(feedBoard[tree.x][tree.y] >= tree.age) {
                feedBoard[tree.x][tree.y] -= tree.age;
                tree.age++;
                tempTrees.add(tree);
            } else {
                deadTrees.add(tree);
            }
        }
        trees = tempTrees;
    }
    static void summer() {
        for(Tree tree : deadTrees) {
            feedBoard[tree.x][tree.y] += tree.age / 2;
        }
        deadTrees.clear();
    }
    static void autumn() {
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        ArrayList<Tree> tempTrees = new ArrayList<>();
        for(Tree tree : trees) {
            if(tree.age % 5 == 0) {
                for(int dir = 0; dir < 8; dir++) {
                    int nx = tree.x + dx[dir];
                    int ny = tree.y + dy[dir];
                    if(nx > n || nx < 1 || ny > n || ny < 1) continue;
                    tempTrees.add(new Tree(nx, ny, 1));
                }
            }
        }
        trees.addAll(tempTrees);
    }
    static void winter() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                feedBoard[i][j] += feed[i][j];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                feed[i][j] = Integer.parseInt(st.nextToken());
                feedBoard[i][j] = 5;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }
        
        while(k > 0){
            Collections.sort(trees, (t1, t2) -> Integer.compare(t1.age, t2.age));
            spring();
            summer();
            autumn();
            winter();
            k--;
        }

        System.out.println(trees.size());
    }
}