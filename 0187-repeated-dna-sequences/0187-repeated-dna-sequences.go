func findRepeatedDnaSequences(s string) []string {
	seen := Set{}
	repeat := Set{}
	for i := 0; i+9 < len(s); i++ {
		word := string(s[i : i+10])
		if !seen.Add(word) {
			repeat.Add(word)
		}
	}

	return repeat.ToArray()
}

type Set map[interface{}]struct{}

func (s Set) Add(v interface{}) bool {
	if len(v.(string)) == 0 {
		return true
	}
	isPresent := s.Contain(v)
	s[v] = struct{}{}
	return !isPresent
}

func (s Set) Remove(v interface{}) {
	delete(s, v)
}

func (s Set) Contain(v interface{}) bool {
	_, ok := s[v]
	return ok
}

func (s Set) Length() int {
	return len(s)
}

func (s Set) ToArray() []string {
	keys := make([]string, 0)
	for k := range s {
		keys = append(keys, k.(string))
	}

	return keys
}
