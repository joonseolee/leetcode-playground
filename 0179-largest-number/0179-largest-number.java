import java.math.BigInteger;

class Solution {
    public String largestNumber(int[] nums) {
        List<String> numbers = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
        
        numbers.sort((o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            
            return b.compareTo(a);
        });
        
        if (numbers.get(0).equals("0")) {
            return "0";
        }
        
        return String.join("", numbers);
    }
}