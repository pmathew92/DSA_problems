package arrays

import java.util.*

/**
 * Given a string s containing just the characters '(' , ')' , '{' , '}' ,
'[' & ']' , determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.

Open brackets must be closed in the correct order.

Every close bracket has a corresponding open bracket of the same type.
 */
fun main() {
    println("Valid parentheses examples ")
    println("input  [[]] ${validParentheses("[[]]")}")
    println("input  {()}[][]({[]}) ${validParentheses("{()}[][]({[]})")}")
    println("input  {}([]{}() ${validParentheses("{}([]{}()")}")
    println("input  ((((())))))) ${validParentheses("((((()))))))")}")
}

private fun validParentheses(s: String): Boolean {
    val stack = Stack<Char>()
    for (char in s.toCharArray()) {
        when (char) {
            '(', '{', '[' -> stack.push(char)
            ')' -> {
                if (stack.isEmpty()) return false
                val top = stack.pop()
                if (top != '(') return false

            }
            '}' -> {
                if (stack.isEmpty()) return false
                val top = stack.pop()
                if (top != '{') return false

            }
            ']' -> {
                if (stack.isEmpty()) return false
                val top = stack.pop()
                if (top != '[') return false
            }
        }
    }

    return stack.isEmpty()
}