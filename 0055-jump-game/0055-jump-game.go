func canJump(nums []int) bool {
    lastIndex := len(nums) - 1
    
    for i := lastIndex; i >= 0; i-- {
        if i + nums[i] >= lastIndex {
            lastIndex = i
        }
    }
    
    if lastIndex == 0 {
        return true
    }
    
    return false
}