/*
This class is the brains of the Virtual Agent
*/
public class JShizzle extends VirtualAgent {
    private String userName = "User";
    private int userAge;


    //parameterized constructor
    public JShizzle(String name) {
        super (name);
    }

    //accesor for user's name
    public String getUserName() {
        return userName;
    }

    //accesor for user's age
    public int getUserAge() {
        return userAge;
    }

    //mutator for user's name
    public void setUserName(String newName) {
        if (newName.matches("[a-zA-Z. '-]+")) {
            userName = toTitleCase(newName);
        }
    }

    //mutator for user's age
    public void setUserAge(int newAge) {
        if (newAge < 0) {
            System.err.println( "Attempt to set age as negative ignored, setting to 0 by default." );
            userAge = 0;
        }
        else {
            userAge = newAge;
        }
    }

    //body of abstract method which responds to user's input
    @Override
    public String respondToUserQuery(String inp) {
        inp = toTitleCase(inp);
        if (inp.contains("Hi")|inp.contains("Hello")|inp.contains("Hey")|inp.contains("Yo")|inp.contains("Hello")) {
            return "Hello, how may I help you?";
        }
        else if (inp.contains("What Is")){
            if (inp.contains("Your Age")){
                return "My age is none of your concern";
            }
            else if (inp.contains("My Age")){
                if (userAge == 0){
                    return "I do not know your age, mind telling me?";
                }
                else {
                    return "You are " + getUserAge() + "years old";
                }
            }
            else {
                return "I'm not sure what that could be";
            }
        }
        else {
            return "I don't know what you may mean by that";
        }
    }
}
