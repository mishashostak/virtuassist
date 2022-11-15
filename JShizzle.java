import java.util.*;

/**
 * This class defines the basic virtual agent portion of the virtual agent
 * 
 * @author Misha Shostak
 * 
 * @version November 13, 2022
 */
public class JShizzle extends VirtualAgent {
    private String userName;
    private boolean convProceed;

    /**
     * Parameterized constructor to initialize the convProceed instance variable, userName and the Virtual Agent name
     * and calls the convCon method to begin the virtual agent
     * 
     * @param name The initial String value of the Virtual Agent name
     * @param userName The initial String value of the userName instance variable
     * @param bool The initial boolean value of convProceed instance variable
     */
    public JShizzle(String name, String userName, boolean bool) {
        super (name);
        setConvProceed(bool);
        setUserName(userName);
        convCon();
    }

    /**
     * Non-parameterized constructor which calls the parameterized constructor to intialize the Virtual Agent 
     * The initial Virtual Agent name is "J Shizzle"
     * The initial userName is " "
     * The initial convProceed boolean value is false
     */
    public JShizzle() {
        this("J Shizzle", " ", false);
    }

    /**
     * Accessor to return the value userName
     *
     * @return String - the userName String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Accessor to return the boolean value of convProceed
     *
     * @return boolean - the convProceed boolean
     */
    public boolean getConvProceed() {
        return convProceed;
    }

    /**
     * Mutator to set a new value for userName
     *
     * @param userName The value to set the userName to
     */
    public void setUserName(String userName) {
        if (userName.matches("[a-zA-Z. '-]+")) {
            this.userName = toTitleCase(userName);
        }
    }

    /**
     * Mutator to set a new boolean value for convProceed
     *
     * @param change The boolean value to set convProceed to
     */
    public void setConvProceed(boolean change) {
        convProceed = change;
    }

    /**
     * This method defines the general conversation with the user and is the heart of JShizzle
     * Accepts input from the user and calls the respondToUserQuery
     */
    public void convCon() {
        String text;
        try (Scanner input = new Scanner(System.in)) {
            while(!getConvProceed()) {
                System.out.println("Greet to Begin.");
                text = input.nextLine();
                String response = respondToUserQuery(text);
                if(response.equals("bye")) {
                    System.out.println(":[ ok");
                    System.exit(0);
                } else if (response.equals("yay")) {
                    setConvProceed(true);
                }
            }
            while(getUserName().equals(" ")) {
                System.out.println("Hello! May I have your name?");
                text = input.nextLine();
                String response = respondToUserQuery(text);
                if(response.equals("bye")) {
                    System.out.println(":[ ok");
                    System.exit(0);
                } else if (response.contains("I'm J Shizzle")) {
                    System.out.println(response);
                }
            }
            System.out.print(getName() + ": ");
            System.out.println("So, how may I help? (\"cmnds\" might help you decide)");
            while(true) {
                System.out.print(getUserName() + ": ");
                text = input.nextLine();
                String response = respondToUserQuery(text);
                if(response.equals("bye")) {
                    System.out.println(":[ ok");
                    System.exit(0);
                } else {
                    System.out.print(getName() + ": ");
                    System.out.println(response);
                }
            }
        }
    }

    /**
     * This method accepts a String query, and returns an appropriate String response
     * 
     * @param query The text that the user has entered requesting a response
     * 
     * @return String - The response from the Basic Virtual agent
     */
    @Override
    public String respondToUserQuery(String inp) {
        inp = toTitleCase(inp).trim();
        while(!getConvProceed()|getUserName().equals(" ")) {
            if (inp.contains("Hi")|inp.contains("Hello")|inp.contains("Hey")|inp.contains("Yo")|inp.contains("Top Of The Mornin") && !getConvProceed()) {
                return "yay";
            } else if (inp.equals("Bye")|inp.equals("No")){
                return "bye";
            } else if (getConvProceed()){
                setUserName(inp);
                return "\nHey there " + getUserName() + ", I'm J Shizzle, you'll find I'm pretty good at talking about colours and not much else\n";
            } else {
                return " ";
            }
        }
        /* Full virtual agent is unlocked once user has made necessary steps */
        if (inp.contains("What Is")){
            if (inp.contains("Your Age")){
                return "My age is none of your concern, I talk about colours, how has this not been established";
            }
            else if (inp.contains("My Age")){
                return "I do not know your age, and I don't care";
            }
            else if (inp.contains("My Name")){
                return "Well, your name is " + getUserName();
            }
            else {
                return "I'm not sure what that could be";
            }
        }
        else if (inp.contains("Your Name Is")){
            setName(inp.substring(inp.lastIndexOf(" ")+1));
            return "Ok, my name is now " + getName();
        }
        else if (inp.contains("My Name Is")){
            setUserName(inp.substring(inp.lastIndexOf(" ")+1));
            return "Ok, your name is now " + getUserName();
        }
        else if (inp.contains("Bye")|inp.contains("No")){
            return "bye";
        }
        /* "cmnds" String contains a list of all of the virtual agent's functions/responses */
        else if (inp.contains("Cmnds")){
            return "\n\"<common colour name>\": returns the rgb values of the input colour\n\"blend\": shows the blend of the 2 colours you input\n" 
            +"\"your name is <name>\": changes JShizzle's name\n\"bye\" or \"no\": makes the virtual assisstant program stop\n"
            +"\"my name is <name>\": changes user's name\n";
        }
        else if (inp.equals("Black")) return Calcer.COLSTR[0];
        else if (inp.equals("White")) return Calcer.COLSTR[1];
        else if (inp.equals("Red")) return Calcer.COLSTR[2];
        else if (inp.equals("Lime")) return Calcer.COLSTR[3];
        else if (inp.equals("Blue")) return Calcer.COLSTR[4];
        else if (inp.equals("Yellow")) return Calcer.COLSTR[5];
        else if (inp.equals("Cyan")) return Calcer.COLSTR[6];
        else if (inp.equals("Magenta")|inp.equals("Pink")) return Calcer.COLSTR[7];
        else if (inp.equals("Silver")) return Calcer.COLSTR[8];
        else if (inp.equals("Gray")|inp.equals("Grey")) return Calcer.COLSTR[9];
        else if (inp.equals("Maroon")) return Calcer.COLSTR[10];
        else if (inp.equals("Olive")) return Calcer.COLSTR[11];
        else if (inp.equals("Green")) return Calcer.COLSTR[12];
        else if (inp.equals("Purple")) return Calcer.COLSTR[13];
        else if (inp.equals("Teal")) return Calcer.COLSTR[14];
        else if (inp.equals("Navy")) return Calcer.COLSTR[15];
        else if (inp.equals("Blend")){
            new ColorChoice(1);
            return "Anything else? (\"cmnds\" might help you decide)\n";
        }
        else {
            return "I'm not sure what to say to that";
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
