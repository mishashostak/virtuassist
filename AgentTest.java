import java.util.*;

public class AgentTest {
    
    // Testing of the Virtual Agent
    public static void main(String[] args) {
        JShizzle J = new JShizzle("J Shizzle");
        try (Scanner input = new Scanner(System.in)) {
            while(true) {
                System.out.print(J.getUserName() + ": ");
                String inp = input.nextLine();
                String response = J.respondToUserQuery(inp);
                if(response.equals("bye")) {
                    break;
                } else if (response.equals("")) {
                    continue;
                } else {
                    System.out.print(J.getName() + ": ");
                    System.out.println(response);
                }
            }
        }
    }
}
