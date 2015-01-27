//ChocolateFeast

package main

import (
	"fmt"
)

func main() {
	var totInp, n, c, m int
	fmt.Scanf("%d", &totInp)

	for i := 0; i < totInp; i++ {
		fmt.Scanf("%d %d %d", &n, &c, &m)
		answer := countChoc(n, c, m)
		fmt.Println(answer)
	}
}

func countChoc(n, c, m int) int {
	answer := n / c
	p := answer

	for p >= m {
		temp := p / m
		answer += temp
		p = (p - (temp * m)) + temp
	}

	return answer
}
