package algorithm;

import java.util.ArrayList;
import java.util.List;

class FindCombinationPairs {
    // Store solutions in the class instance, to avoid passing/copying lists in every function call
    // This saves memory and performance
    List<String> solutions = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        // We start our recursive dfs with an empty string
        dfs(n, 0, 0, "");
        return solutions;
    }

    /**
     * Each recursive call, we keep track of:
     * n        - the amount of pairs to generate
     * open     - the current amount of open brackets
     * closed   - the current amount of closed brackets
     * curr     - the current solution at this recursive depth
     */
    public void dfs(int n, int open, int closed, String curr) {
        // if we have n open brackets and n closed brackets in curr, it is complete
        // We add our current solution curr to the list of solutions
        if (n == open && n == closed) {
            solutions.add(curr);
            return;
        }

        // If we can still add more open brackets, we add an open bracket to the current solution,
        // increase the count of open brackets and recurse
        if (open < n) {
            dfs(n, open + 1, closed, curr + "(");
        }

        // If we have more open brackets than closed, then there is an open bracket in curr that will
        // match a closing bracket we might add. We add that closing bracket, increase the count of 
        // closed brackets, and recurse
        if (closed < open) {
            dfs(n, open, closed + 1, curr + ")");
        }
    }
    
    /*
        Each dfs layer will look something like this:
        n = 3
        
        ""
        "("
        "()", "(("
        "()(", "(((", "(()"
        "()()", "()((", "((()", "(())", "(()("
        "()()(", "()(()",  "((())", "(())(", "(()()"
        "()()()", "()(())", "((()))", "(())()", "(()())"
     */
}