package com.dinesh.datastructure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParentheses {

    private final Map<Character, Character> BRACKET = new HashMap<>();

    public BalancedParentheses(){
        BRACKET.put('{', '}');
        BRACKET.put('(', ')');
        BRACKET.put('[', ']');
    }

    public boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for(char letter: input.toCharArray()){
            if(isOpenBracket(letter)){
                stack.push(letter);
            }else {
                if(stack.empty() || !isValidClose(stack.pop(), letter)) return false;
            }
        }
        return stack.empty();
    }

    private boolean isValidClose(Character open, char close) {
        return BRACKET.get(open) == close;
    }

    private boolean isOpenBracket(Character letter) {
        return BRACKET.containsKey(letter);
    }
}
