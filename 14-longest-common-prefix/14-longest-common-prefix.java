class Solution {
    public String longestCommonPrefix(String[] strs) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(strs[0].split("")));
        String prefix = "";

        if (strs.length == 1) {
            return strs[0];
        }

        while (!queue.isEmpty()) {

            prefix = prefix + queue.poll();
            
            for (int i = 1 ; i < strs.length ; i++) {
                if (strs[i].indexOf(prefix) != 0) {
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
        }

        return prefix;
    }
}