func sequentialDigits(low int, high int) []int {
    startDigit := toDigit(low)
    endDigit := toDigit(high)
    results := make([]int, 0)
    
    for i := startDigit; i <= endDigit; i++ {
        for j := 1; j < 9; j++ {
            if i + j > 10 {
                continue
            }
            
            value := toSequential(i, j)
            if low > value || value > high {
                continue
            }
            
            results = append(results, value)
        }
    }
    
    return results;
}

func toDigit(value int) int {
    result := 1
    for value > 9 {
        value = value / 10
        result++
    }
    
    return result
}

func toSequential(size int, startValue int) int {
    result := startValue
    for size > 1 {
        startValue++
        result = result * 10 + startValue
        size--
    }
    
    return result
}
