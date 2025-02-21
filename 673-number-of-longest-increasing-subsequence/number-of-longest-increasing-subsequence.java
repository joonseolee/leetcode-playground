class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dpLen = new int[n];
        int[] dpCount = new int[n];
        dpLen[0] = 1;
        dpCount[0] = 1;
        int currLen = 1;
        int currCount = 1;
        int overallLen = 1;
        int res = 1;


        for(int i = 1; i < n; i++){
            currLen = 1;
            currCount = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    if(dpLen[j] + 1 == currLen){
                        currCount += dpCount[j];
                    }else if(dpLen[j] + 1 > currLen){
                        currLen = dpLen[j] + 1;
                        currCount = dpCount[j];
                    }
                }
            }

            dpLen[i] = currLen;
            dpCount[i] = currCount;

            if(currLen == overallLen){
                res += currCount;
            }else if(currLen > overallLen){
                res = currCount;
                overallLen = currLen;
            }
        }

        return res;
    }

    private int recursive(int[] nums, int prevIndex, int targetIndex, int maxSize) {
        if (nums.length - 1 < targetIndex) {
            return maxSize;
        }

        if (nums[prevIndex] < nums[targetIndex]) {
            return recursive(nums, targetIndex, targetIndex + 1,maxSize + 1);
        }

        return recursive(nums, prevIndex, targetIndex + 1, maxSize);
    }
}