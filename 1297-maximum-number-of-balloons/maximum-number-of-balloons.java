class Solution {
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);

        for (char c : text.toCharArray()) {
            int count = map.getOrDefault(c, -1);
            if (count > -1) {
                map.put(c, count + 1);
            }
        }

        map.put('l', map.get('l') / 2);
        map.put('o', map.get('o') / 2);

        int min = Integer.MAX_VALUE;
        for (Integer value : map.values()) {
            if (value == 0) {
                return 0;
            }
            
            min = Math.min(min, value);
        }

        return min;
    }
}