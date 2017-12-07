import mathematix.*;
import java.util.*;
import java.io.IOException;

class ParserDriver{
    public static void main(String[] args){

        HashMap<String,Sexpr> map = new HashMap<String,Sexpr>();
        boolean shouldBeEval = true;

        System.out.println("Welcome to the parser!");
        System.out.print("Please enter an expression: "); 
        
        while(true) {
            try{
                Parser p =  new Parser(System.in);
                shouldBeEval = true;
                System.out.print("\n? ");
                Sexpr result = p.commands();

                if(result.isQuit()){
                    System.out.println(result);
                    return;
                }

                else if(result.isVars()){
                    if (!map.isEmpty()) {
                        System.out.println(map);
                    }
                    else {
                        System.out.println("There are no variables"); 
                    }
                }
                else if (shouldBeEval){
                    
                    Sexpr total = result.eval(map);
                    System.out.println("evaluated to: " + total);
		    System.out.println("expressoin is: " + result);
                    (new Assignment(total, new Variable("ans"))).eval(map);
                }
            }catch(SyntaxErrorException e){
                shouldBeEval = false;
                System.out.print("Syntax Error: ");
                System.out.println(e.getMessage());
            }catch(IOException e){
                shouldBeEval = false;
                System.err.println("IO Exception!");
            }
        }
    }
}
