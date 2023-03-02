/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Next *Node
 * }
 */

func connect(root *Node) *Node {
	if root == nil {
		return nil
	}

	doLogic(root)

	return root
}

func doLogic(root *Node) {
	queue := NewQueue()
	queue.Push(root)

	for !queue.IsEmpty() {
		size := queue.Len()

		var prev *Node
		for i := 1; i <= size; i++ {
			current := queue.Pop()

			if i != 1 {
				prev.Next = current
			}

			if current.Left != nil {
				queue.Push(current.Left)
			}

			if current.Right != nil {
				queue.Push(current.Right)
			}

			prev = current
		}
	}
}

type Queue struct {
	v *list.List
}

func NewQueue() *Queue {
	return &Queue{list.New()}
}

func (q *Queue) Len() int {
	return q.v.Len()
}

func (q *Queue) IsEmpty() bool {
	if q.Len() == 0 {
		return true
	}

	return false
}

func (q *Queue) Push(v *Node) {
	q.v.PushBack(v)
}

func (q *Queue) Pop() *Node {
	front := q.v.Front()
	if front == nil {
		return nil
	}

	return q.v.Remove(front).(*Node)
}
