package assignments;

import java.util.*;
public class BalancingBrackets {

	    static boolean areBracketsBalancing(String expression)
	    {
	        Deque<Character> stack= new ArrayDeque<Character>();
	        for (int i = 0; i < expression.length(); i++)
	        {
	            char a = expression.charAt(i);
	 
	            if (a=='(' || a=='[' || a=='{')
	            {
	                stack.push(a);
	                continue;
	            }
	 
	            if (stack.isEmpty())
	                return false;
	            char check;
	            switch (a) {
	            case ')':
	                check = stack.pop();
	                if (check == '{' || check == '[')
	                    return false;
	                break;
	 
	            case '}':
	                check = stack.pop();
	                if (check == '(' || check == '[')
	                    return false;
	                break;
	 
	            case ']':
	                check = stack.pop();
	                if (check == '(' || check == '{')
	                    return false;
	                break;
	            }
	        }
	 
	        return (stack.isEmpty());
	    }



	public static void main(String[] args) {
		String expression = "(( [ [ { } ] ] ))";
		 
        if (areBracketsBalancing(expression))
            System.out.println("The entered String has Balanced Brackets ");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets ");

	}


}
