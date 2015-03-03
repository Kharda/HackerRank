// minimum-draws
package main

import (
	"fmt"
)

func main() {
	var totInp, totShock int

	fmt.Scanf("%d", &totInp)

	for i := 0; i < totInp; i++ {
		fmt.Scanf("%d", &totShock)
		fmt.Println(totShock + 1)
	}

}
