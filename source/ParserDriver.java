import java.util.*;
import java.io.IOException;

class ParserDriver{
    public static void main(String[] args){

        HashMap<String,Sexpr> map = new HashMap<String,Sexpr>();

        System.out.println("Welcome to the parser!");
        System.out.print("Please enter an expression: "); 

        while(true) {
            try{
                Parser p = new Parser();
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
                
                else {
                    System.out.println("result: " + result);
                    Sexpr total = result.eval(map);
                    System.out.println("evaluated to: " + total);
                    System.out.println("Now in map: " +  map);
                }
            }catch(SyntaxErrorException e){
                System.out.print("Syntax Error: ");
                System.out.println(e.getMessage());
            }catch(IOException e){
                System.err.println("IO Exception!");
            }
        }
    }
}
