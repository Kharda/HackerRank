// handshake
package main

import (
	"fmt"
)

func main() {
	var totInp, totPeople int

	fmt.Scanf("%d", &totInp)

	for i := 0; i < totInp; i++ {
		fmt.Scanf("%d", &totPeople)
		fmt.Println(countHandShake(totPeople))
	}
}

func countHandShake(totPeople int) int {
	answer := 0
	if totPeople == 2 {
		answer = 1
	} else if totPeople > 2 {
		for j := totPeople - 1; j > 0; j-- {
			answer += j
		}
	}

	return answer
}
