func reverse(x int) int {
    num := x
    result := 0
    if x < 0 {
        x = x * -1
    }
    
    for x > 0 {
        if result > 700000000 {
            return 0;
        }
        
        result = (result * 10) + (x % 10)
        x = x / 10
        
        if result < 0 {
            return 0
        }
    }
    
    if result > 2147483650 {
        return 0
    }
    
    if num < 0 {
        return -result
    }
    
    return result
}