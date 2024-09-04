import java.util.*;

/**
 * A list of TextMessage objects. Note that because MultimediaMessage is
 * a sub-class of TextMessage, the list can contain both TextMessage and
 * MultimediaMessage objects.  In addition, Java's polymorphism ensures that
 * the correct message type and length is displayed for each message.
 *
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 2019
 */
public class TextMessageList {

    private ArrayList<TextMessage> messageList;
    
    /**
     * Construct a new empty list of text messages.
     */
    public TextMessageList() {
        messageList = new ArrayList<TextMessage>();
    }
    
    /**
     * Add a text message to the list.  Note: The parameter is of type 
     * TextMessage so it can refer to either a TextMessage or any sub-class
     * of TextMessage (for e.g. MultimediaMessage).
     * 
     * @param tm the TextMessage to add to the list.
     */
    public void addMessage(TextMessage tm) {
    	if (!messageList.contains(tm)) {
            messageList.add(tm);
    	}
    	
    }
    
    /**
     * Display information about all of the text messages in the list.
     */
    public void printMessageList() {
        for (TextMessage tm : messageList) {
            System.out.println(tm);
        }
    }
    
    /**
     * Create a TextMessageList with a few messages and invoke one or two of the
     * methods for the purposes of illustration.
     * 
     * @param args none
     */
    public static void main(String[] args) {
        TextMessageList tmList = new TextMessageList();
        
        TextMessage tm1 = new TextMessage(3517654321L, 7171234567L, "Yo Joe!");
        TextMessage tm2 = new TextMessage(2159876543L, 7171234567L, "WYUT Joe?");
        TextMessage tm3 = new TextMessage(2159876543L, 7171234567L, "WYUT Joe?");
        MultimediaMessage mm1 = new MultimediaMessage(3517654321L, 7171234567L, "WDYT?");
        mm1.attachFile("skiTrip.jpg", 2000);
        
        tmList.addMessage(tm1);
        tmList.addMessage(tm1);
        tmList.addMessage(tm2);
        tmList.addMessage(tm3);
        tmList.addMessage(mm1);
        
        tmList.printMessageList();
    }
}
