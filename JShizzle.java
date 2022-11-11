/**
 * This class defines the intelligence of the virtual agent
 * 
 * @author Misha Shostak
 * 
 * @version November 10, 2022
 */
public class JShizzle extends VirtualAgent {
    private String userName = "User";
    private int userAge;

    /**
     * Parameterized constructor to initialize the chatBotName into hostValues, and userName into userValues of a chatBot
     * 
     * @param chatBotName The initial String value for the "name" key in the hostValues map
     * @param userName The initial String value for the "name" key in the userValues map
     */
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
            return "Hey there, I'm JShizzle ";
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

    /**
     * This is a standard toString() method.  
     * 
     * @return String - The String representation of the current object.
     */
    public String toString() {
        return super.toString();
    }
}
