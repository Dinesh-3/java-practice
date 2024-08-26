package com.dinesh.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 282. Expression Add Operators
 * https://leetcode.com/problems/expression-add-operators/
 *
 *
 * dfs(0, "", 0, 0)
 * |
 * |-- dfs(1, "1", 1, 1)
 *     |
 *     |-- dfs(2, "1+2", 3, 2)
 *     |   |
 *     |   |-- dfs(3, "1+2+3", 6, 3)  ---> Match: ["1+2+3"]
 *     |   |
 *     |   |-- dfs(3, "1+2-3", 0, -3)
 *     |   |
 *     |   |-- dfs(3, "1+2*3", 7, 6)
 *     |
 *     |-- dfs(2, "1-2", -1, -2)
 *     |   |
 *     |   |-- dfs(3, "1-2+3", 2, 3)
 *     |   |
 *     |   |-- dfs(3, "1-2-3", -4, -3)
 *     |   |
 *     |   |-- dfs(3, "1-2*3", -5, -6)
 *     |
 *     |-- dfs(2, "1*2", 2, 2)
 *         |
 *         |-- dfs(3, "1*2+3", 5, 3)
 *         |
 *         |-- dfs(3, "1*2-3", -1, -3)
 *         |
 *         |-- dfs(3, "1*2*3", 6, 6)  ---> Match: ["1*2*3"]
 * |
 * |-- dfs(2, "12", 12, 12)
 *     |
 *     |-- dfs(3, "12+3", 15, 3)
 *     |
 *     |-- dfs(3, "12-3", 9, -3)
 *     |
 *     |-- dfs(3, "12*3", 36, 36)
 * |
 * |-- dfs(3, "123", 123, 123)
 *
 */
public class ExpressionAddOperator {
    public static void main(String[] args) {
        ExpressionAddOperator operator = new ExpressionAddOperator();
        operator.addOperators("123", 6);
    }
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        generate(0, 0, 0, "", target, num, result);
        return result;
    }

    private void generate(int index, int sum, int prevNum, String output, int target, String num, List<String> result) {
        if(index == num.length()) {
            if(sum == target)
                result.add(output);
            return;
        }

        int number = Integer.parseInt(num.charAt(index) + "");

        if(index == 0) {
            generate(index+1, number, number, "" + number, target, num, result);
        } else {
            generate(index+1, (sum - prevNum) + (prevNum * number), number, output + "*" + number, target, num, result);
            generate(index+1, sum + number, number, output + "+" + number, target, num, result);
            generate(index+1, sum - number, number, output + "-" + number, target, num, result);
        }
    }

}
