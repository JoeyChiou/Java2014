import java.util.*;
import static java.lang.System.out;

public class aa {
   public static void samples() throws IOException {
	BufferedReader in = new BufferedReader(new FileReader("question.txt" ));
	String s="",s2="";
	while((s=in.readLine())!=null)
	s2+=s+"\n";
	in.close();    

    private static String toPostfix(String infix, boolean isPost) {
        String expr = isPost ? 
            infix : new StringBuffer(infix).reverse().toString();
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder output = new StringBuilder();
        char toStack = isPost ? '(' : ')';
        char toOutput = isPost ? ')' : '(';
        for(char c : expr.toCharArray()) {
            if(c == toStack) { stack.add(c); }
            else if("+-*/".indexOf(c) != -1) {
                while(!stack.isEmpty() && 
                       priority(stack.getLast()) >= priority(c)) { 
                    output.append(stack.removeLast());
                } 
                stack.add(c);
            }
            else if(c == toOutput) {
                while(stack.getLast() != toStack) { 
                    output.append(stack.removeLast());
                } 
                stack.removeLast();
            }
            else { output.append(c); }
        }
        
        while(!stack.isEmpty()) { output.append(stack.removeLast()); }
        
        return isPost ? output.toString() : output.reverse().toString();
    }
    
    public static String toPostfix(String infix) {
        return toPostfix(infix, true);
    }
    
    public static String toPrefix(String infix) {
        return toPostfix(infix, false);
    }
    
    public static void main(String[] args) {
        String infix = "(a+b)*(c+d)";
        out.println(toPostfix(infix));
        out.println(toPrefix(infix));
    }
}  