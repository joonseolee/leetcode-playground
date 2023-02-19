func maxProfit(prices []int) int {
    min := 10000
    result := 0 
    for _, v := range prices {
        if v < min {
            min = v
        }
        
        if result < v - min {
            result = v - min
        }
    }
    
    return result
}