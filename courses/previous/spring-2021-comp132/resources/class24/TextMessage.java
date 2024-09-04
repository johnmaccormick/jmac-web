/**
 * A class that represents a TextMessage.  Javadoc comments
 * within the class have been omitted for brevity.
 *
 * @author Grant Braught, revisions by Farhan Siddiqui, John MacCormick
 * @author Dickinson College
 */
public class TextMessage {
    private long senderNumber;
    private long recipientNumber;
    private String messageText;
    
    public TextMessage(long fromNumber, long toNumber, String msg) {
        senderNumber = fromNumber;
        recipientNumber = toNumber;
        messageText = msg;
    }
    
    public String getMessageText() {
        return messageText;
    }
    
    public long getRecipientNumber() {
        return recipientNumber;
    }
    
    public long getSenderNumber() {
        return senderNumber;
    }
    
    public int getMessageLength() {
        return messageText.length();
    }
    
    public String getMessageType() {
        return "Text Message";
    }
    
    public String toString() {
        return "(From " + senderNumber + " to "+ recipientNumber + "): " + messageText;
    }
    
    public boolean equals(Object o) {
        if (o instanceof TextMessage) {
            TextMessage msg = (TextMessage) o;

            if (this.senderNumber == msg.senderNumber
                    && this.recipientNumber == msg.recipientNumber
                    && this.messageText.equals(msg.messageText)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    

}
