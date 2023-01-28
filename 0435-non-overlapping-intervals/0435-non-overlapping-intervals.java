import java.util.stream.Collectors;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 0;
        }
        
        List<List<Integer>> sortedArr = Arrays.stream(intervals).sorted((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        }).map(it -> Arrays.stream(it).boxed().collect(Collectors.toList())).collect(Collectors.toList());
        
        int left = sortedArr.get(0).get(0);
        int right = sortedArr.get(0).get(1);
        int result = 0;
        
        for (int i = 1; i < sortedArr.size(); i++) {
            if (sortedArr.get(i).get(0) < right) {
                result++;
                continue;
            }
            
            left = sortedArr.get(i).get(0);
            right = sortedArr.get(i).get(1);
        }
        
        return result;
    }
}