import java.util.Stack;

public class balancedBracket {
    static boolean checkBalance(String brackCharacter){

        Stack<Character> bucket = new Stack<Character>();
        //input the value of the string into the stack Bucket
        for(int i=0;i<brackCharacter.length();i++){
            char character  = brackCharacter.charAt(i);
            if(character=='(' || character=='{' || character=='['){
                bucket.push(character);
                continue;
                }
        if(bucket.isEmpty())
         return false;
         char c;
         switch (character) {
             case '}':c=bucket.pop();
                        if(c=='('||c=='[')
                        return false;            
                 break;
              case ']':c=bucket.pop();
                        if(c=='{' || c=='(')
                        return false;
                        break;
             case ')': c=bucket.pop();
                        if(c=='[' || c=='{')  
                        return false;
                        break;     
         
             default:
                 break;
         }        
        }
        return(bucket.isEmpty());
    }
    public static void main(String[] args)throws Exception {
        String input = "{[()])}";
               boolean value = checkBalance(input);
        if(value)
        System.out.println("The entered String has Balanced Brackets");
        else
        System.out.println("The entered Strings do not contain Balanced Brackets");
    }
}