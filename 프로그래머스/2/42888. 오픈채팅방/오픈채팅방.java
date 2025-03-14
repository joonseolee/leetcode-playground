import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> names = new HashMap<>();
        for (String text : record) {
            if (text.charAt(0) != 'L') {
                String[] words = text.split(" ");
                names.put(words[1], words[2]);
            }
        }
        
        return Arrays.stream(record)
            .filter(it -> it.charAt(0) != 'C')
            .map(it -> {
               String[] words = it.split(" ");
                if (it.charAt(0) == 'E') {
                    return names.get(words[1]) + "님이 들어왔습니다.";
                }
                
                return names.get(words[1]) + "님이 나갔습니다.";
            })
            .toArray(String[]::new);
    }
}