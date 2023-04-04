func findDuplicate(nums []int) int {
    visit := make([]bool, 100001)
    for _, num := range nums {
        if visit[num] {
            return num
        }
        
        visit[num] = true
    }
    
    return -1
}