// building-a-list
package main

import (
	"fmt"
	"sort"
)

func main() {
	var totInp, inpLen int
	var input string

	fmt.Scanf("%d", &totInp)

	for i := 0; i < totInp; i++ {
		fmt.Scanf("%d", &inpLen)
		fmt.Scanf("%s", &input)

		buildAList(totInp, input)
	}
}

func buildAList(totInp int, input string) {
	var words []string

	for _, c := range input {
		words = append(words, string(c))

		for _, word := range words {
			if word != string(c) {
				word += string(c)
				words = append(words, word)
			}
		}
	}

	sort.Strings(words)
	for _, element := range words {
		fmt.Println(element)
	}
}
