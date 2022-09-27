import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        String[] characters = s.split("");
        for (int i = 0 ; i < characters.length ; i++) {
            String curCharacter = characters[i];
            if ("(".equals(curCharacter) || "{".equals(curCharacter) || "[".equals(curCharacter)) {
                stack.add(curCharacter);
                continue;
            }
            
            if (stack.isEmpty()) {
                return false;
            }
            
            String prevCharacter = stack.pop();
            if ("(".equals(prevCharacter) && ")".equals(curCharacter)) {
                continue;
            }
            if ("{".equals(prevCharacter) && "}".equals(curCharacter)) {
                continue;
            }
            if ("[".equals(prevCharacter) && "]".equals(curCharacter)) {
                continue;
            }
            stack.add(prevCharacter);
            stack.add(curCharacter);
        }
        return stack.isEmpty();
    }
}