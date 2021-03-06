package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    //def list: List[Char] = List('(', 'i', 'f', ' ', '(', 'z', 'e', 'r', 'o', '?', ' ', 'x', ')', ' ', 'm', 'a', 'x', ' ', '(', '/', ' ', '1', ' ', 'x', ')', ')')
    def list: List[Char] = List(')', '(')
    if(balance(list)) println("Balanced")
    else if (!balance(list)) println("Not balanced")
  }

  /**
   * Exercise 1
   * Done
   */
    def pascal(c: Int, r: Int): Int = {
      if(r == 0) 1
      else if (c == 0) 1
      else if (c == r) 1
      else pascal(c-1, r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def balanceIter(chars: List[Char], balanceCnt: Int): Int = {
        var newBalanceCnt: Int = 0;

        if(balanceCnt < 0) balanceIter(chars.tail, -1)

        if (!chars.tail.isEmpty) {
          if (chars.head == '(') {
            newBalanceCnt = balanceCnt + 1
          }
          else if (chars.head == ')') {
            newBalanceCnt = balanceCnt - 1
          }

          newBalanceCnt + balanceIter(chars.tail, newBalanceCnt)
        } else {
          if (chars.head == '(') {
            newBalanceCnt =  1
          }
          else if (chars.head == ')') {
            newBalanceCnt = -1
          }
          newBalanceCnt
        }
      }

      val balanceCnt = 0

      if(chars.isEmpty) false
      else if (balanceIter(chars, balanceCnt) > 0) false
      else if (balanceIter(chars, balanceCnt) < 0) false
      else true
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
