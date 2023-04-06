import (
    "strconv"
)

func findRelativeRanks(score []int) []string {
	h := &IntHeap{}
	for i, v := range score {
		h.Push(Model{i, v})
	}

	values := make([]string, h.Len())
	heap.Init(h)
	result := heap.Pop(h)
	for i := range values {
		values[result.(Model).Location] = fetchMessage(i + 1)
		if !h.IsEmpty() {
			result = heap.Pop(h)
		}
	}

	return values
}

func fetchMessage(i int) string {
	if i == 1 {
		return "Gold Medal"
	} else if i == 2 {
		return "Silver Medal"
	} else if i == 3 {
		return "Bronze Medal"
	} else {
		return strconv.Itoa(i)
	}
}

type Model struct {
	Location int
	Score    int
}

type IntHeap []Model

func (h IntHeap) Len() int {
	return len(h)
}

func (h IntHeap) IsEmpty() bool {
	return h.Len() == 0
}

func (h IntHeap) Less(i, j int) bool {
	return h[i].Score > h[j].Score
}

func (h IntHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *IntHeap) Push(element interface{}) {
	*h = append(*h, element.(Model))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	element := old[n-1]
	*h = old[0 : n-1]
	return element
}