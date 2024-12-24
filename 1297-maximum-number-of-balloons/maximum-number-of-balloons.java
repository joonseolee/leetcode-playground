class Solution {
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        
        char[] balloons = "balloon".toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char value : text.toCharArray()) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        
        int result = 0;
        
        while (true) {
            for (char balloon : balloons) {
                Integer count = map.getOrDefault(balloon, 0);
                if (count == 0) {
                    return result;
                }

                map.put(balloon, count - 1);
            }

            result++;
        }
    }
}