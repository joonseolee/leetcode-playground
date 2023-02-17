func isIsomorphic(s string, t string) bool {
    sArray := make([]int, 255)
    tArray := make([]int, 255)
    
    for i := 0; i < len(s); i++ {
        if sArray[s[i]] != tArray[t[i]] {
            return false
        }
        
        sArray[s[i]] = i + 1
        tArray[t[i]] = i + 1
    }
    
    return true
}