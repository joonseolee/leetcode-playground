func findKthLargest(nums []int, k int) int {
    h := &IntHeap{}
    for _, v := range nums {
        h.Push(v)
    }
    
    heap.Init(h)
    result := heap.Pop(h)
    for k != 1 {
        result = heap.Pop(h)
        k--
    }
    
    return result.(int)
}

type IntHeap []int

func (h IntHeap) Len() int {
    return len(h)
}

func (h IntHeap) Less(i, j int) bool {
    return h[i] > h[j]
}

func (h IntHeap) Swap(i, j int) {
    h[i], h[j] = h[j], h[i]
}

func (h *IntHeap) Push(element interface{}) {
    *h = append(*h, element.(int))
}

func (h *IntHeap) Pop() interface{} {
    old := *h
    n := len(old)
    element := old[n - 1]
    *h = old[0 : n - 1]
    return element
}