class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        // digits, list, appended string
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));
        List<String> result = new ArrayList<>();
        doLogic(digits, map, result, "");
        return result;
    }
    
    private void doLogic(String digits, Map<Character, List<String>> map, List<String> result, String appended) {
        if (digits.length() == appended.length()) {
            result.add(appended);
            return;
        }
        
        char currentCharacter = digits.charAt(appended.length());
        map.get(currentCharacter).forEach(it -> {
            doLogic(digits, map, result, appended + it);
        });
    }
}