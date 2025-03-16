import java.util.*;

class Solution {
    int maxSheep = 0;
    Map<Integer, List<Integer>> tree = new HashMap<>();
    int[] info;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        
        // 트리 구성
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            
            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
        }
        
        // DFS 탐색 시작
        List<Integer> possibleNodes = new ArrayList<>();
        possibleNodes.add(0);
        dfs(0, 1, 0, possibleNodes);
        
        return maxSheep;
    }
    
    void dfs(int node, int sheep, int wolf, List<Integer> possibleNodes) {
        if (wolf >= sheep) return; // 늑대가 같거나 많아지면 종료
        maxSheep = Math.max(maxSheep, sheep); // 최대 양 갱신
        
        // 탐색 가능한 노드 리스트 갱신
        List<Integer> nextNodes = new ArrayList<>(possibleNodes);
        nextNodes.remove(Integer.valueOf(node)); // 현재 노드 제거
        
        if (tree.containsKey(node)) {
            nextNodes.addAll(tree.get(node)); // 자식 노드 추가
        }
        
        // 다음 노드로 이동 (백트래킹)
        for (int next : nextNodes) {
            dfs(next, sheep + (info[next] == 0 ? 1 : 0), wolf + (info[next] == 1 ? 1 : 0), nextNodes);
        }
    }
}