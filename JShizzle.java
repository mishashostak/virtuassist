import javax.swing.*;
/*
This class is the brains of the Virtual Agent
*/
public class JShizzle extends VirtualAgent {
    public String userName;

    public JShizzle(String un) {
        super ("JShizzle");
    }

    public static int right(){
        return 1;
    }

    @Override
    public String respondToUserQuery(String userQuery) {
        return userQuery;
    }
}
