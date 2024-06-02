import java.util.*;

class Solution {
    static class Node {
        int val;
        List<Integer> paths;
        Node(int val) {
            this.val =  val;
            paths = new ArrayList<>();
            paths.add(0);
        }
        Node(int val, List<Integer> paths) {
            this.val = val;
            this.paths = paths;
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        final int endPoint = graph.length - 1;
        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0));

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(int i = 0; i < graph[cur.val].length; i++) {
                int nxt = graph[cur.val][i];
                if(nxt == endPoint) {
                    List<Integer> newPaths = new ArrayList(cur.paths);
                    newPaths.add(nxt);
                    result.add(newPaths);
                }
                Node newNode = new Node(nxt, new ArrayList(cur.paths));
                newNode.paths.add(nxt);
                queue.add(newNode);
            }
        }
        return result;
    }
}