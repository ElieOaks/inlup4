import java.io.IOException;

class ParserDriver{
    public static void main(String[] args){


        System.out.println("Welcome to the parser!");
        System.out.print("Please enter an expression: ");

        while(true) {
            try{

                Parser p = new Parser();
                System.out.print("\n? ");
                Sexpr result = p.expression();
                System.out.println("result: " + result);
                Sexpr total = result.eval();
                System.out.println("evaluated to: " + total);

            
            }catch(SyntaxErrorException e){
                System.out.print("Syntax Error: ");
                System.out.println(e.getMessage());
            }catch(IOException e){
                System.err.println("IO Exception!");
            }
        }
    }
}
