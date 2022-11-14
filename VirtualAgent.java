/**
 * This abstract class defines the basic attributes and behaviours that all Virtual Agents should have.
 * 
 * @author Misha Shostak
 * 
 * @version November 13, 2022
 */
public abstract class VirtualAgent {

    private String name;
    
    /**
     * Parameterized constructor to initialize the "name" attribute of a Virtual Agent
     * 
     * @param name The initial String value for the "name" attribute
     */
    public VirtualAgent (String name) {
        setName(name);
    }

    /**
     * Accessor to return the value if the "name" attribute as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator to change the value of the "name" attribute.  
     * 
     * This method includes sanity checking to ensure that the newName given only contains: 
     * letters (upper or lower case), spaces, apostrophes ('), hyphens (-), or periods (.)
     *
     * @param newName The new String value of the "name" attribute
     */
    public void setName(String newName) {  
        // NOTE: Do some research on the String matches() method and regular expressions -- very powerful stuff!

        // Accept newName *only* if it contains 1 (or more) letters, spaces, apostrophes ('), hyphens (-), or periods (.)
        if (newName.matches("[a-zA-Z. '-]+")) {
            // accept the name, but convert it to title case first (see below).
            name = toTitleCase(newName);
        }
        // Otherwise, don't change name.
    }

    
    // SEE REQUIREMENT #1A: Complete the toTitleCase() method below

    /**
     * This method accepts a String containing a name and returns a title case version of it.
     * 
     * "title case" means that the first letter of each word [after a blank space, period (.), single quote ('), 
     * or hyphen (-)] in a given string is converted to upper case and all other letters are converted to lowercase.
     * 
     * Examples: "mR. rao" gives: "Mr. Rao", and
     *           "ms. o'kAY-DO'kay" gives: "Ms. O'Kay-Do'Kay"
     * 
     * @param text The original String to convert to titlecase.
     * 
     * @return String - The title case version of the original text 
     * 
     */
    protected String toTitleCase(String text) {
        // If there is nothing to work with, just pass back a reference to the parameter String
        if (text == null || text.isEmpty()) {
            return text;
        }
        
        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }
        return converted.toString();
    }
    
  
    /**
     * This is an ABSTRACT method.  Every child class of VirtualAgent must implement this method.  
     * It should accept a line of input from the  user, process an appropriate response, and 
     * return the response as a String.
     * 
     * @param userQuery The line (String) of input read from the user at the keyboard.
     *
     * @return String - The response of the Virtual Agent to the userQuery,.
     */
    public abstract String respondToUserQuery(String userQuery);

    
    /**
     * This is a standard toString() method.  
     * 
     * @return String - The String representation of the current object.
     */
    public String toString() {
        return "name is " + name;
    }
}
