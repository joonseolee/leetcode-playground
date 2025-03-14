import java.util.*;

class Solution {
    Map<String, Integer> combinationCount;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        for (int c : course) {
            combinationCount = new HashMap<>();
            int maxCount = 0;
            
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                findCombinations(new String(arr), "", 0, c);
            }
            
            
            for (int count : combinationCount.values()) {
                maxCount = Math.max(maxCount, count);
            }
            
            // 주문횟수 2회 이상 값
            for (Map.Entry<String, Integer> entry : combinationCount.entrySet()) {
                if (entry.getValue() == maxCount && maxCount > 1) {
                    result.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    
    private void findCombinations(String order, String current, int index, int length) {
        if (current.length() == length) {
            combinationCount.put(current, combinationCount.getOrDefault(current, 0) + 1);
            return;
        }
        
        for (int i = index; i < order.length(); i++) {
            findCombinations(order, current + order.charAt(i), i + 1, length);
        }
    }
}