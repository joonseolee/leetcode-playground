class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : Arrays.stream(nums1).distinct().toArray()) {
            int value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
        }
        
        for (int num : Arrays.stream(nums2).distinct().toArray()) {
            int value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.stream(nums1).distinct().filter(i -> map.get(i) == 1).boxed().toList());
        result.add(Arrays.stream(nums2).distinct().filter(i -> map.get(i) == 1).boxed().toList());
        
        return result;
    }
}