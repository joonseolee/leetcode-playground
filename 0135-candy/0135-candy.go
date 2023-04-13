func candy(ratings []int) int {
    length := len(ratings)
    candies := make([]int, length)
    for i := range candies {
        candies[i] = 1
    }
    
    for i := 1; i < length; i++ {
        if ratings[i] > ratings[i - 1] {
            candies[i] = candies[i - 1] + 1
        }
    }
    
    for i := length - 2; i > -1; i-- {
        if ratings[i] > ratings[i + 1] {
            candies[i] = max(candies[i], candies[i + 1] + 1)
        }
    }
    
    result := 0
    for _, v := range candies {
        result += v
    }
    
    return result
}

func max(a int, b int) int {
	if a > b {
		return a
	}

	return b
}