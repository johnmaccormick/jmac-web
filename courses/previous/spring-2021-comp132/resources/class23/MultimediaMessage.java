/**
 * Class representing a Multimedia Message. This class is a sub-class of
 * the TextMessage class. It inherits methods related to the text portion
 * of the method, adds methods related to the multimedia content and
 * overrides inherited methods whose behavior needed to change.
 * 
 * @author Grant Braught, revisions by Farhan Siddiqui, John MacCormick
 * @author Dickinson College
 */
public class MultimediaMessage extends TextMessage {

	private String fileName;
	private int fileSize;

	public MultimediaMessage(long fromNumber, long toNumber,
			String msgText) {
		super(fromNumber, toNumber, msgText);
		fileName = "";
		fileSize = 0;
	}

	public void attachFile(String file, int size) {
		fileName = file;
		fileSize = size;
	}

	public String getFileName() {
		return fileName;
	}

	public String getMessageType() {
		return "This is a Multimedia Message";
	}

	public int getMessageLength() {
		int textLen = super.getMessageLength();
		int totalLen = textLen + fileSize;
		return totalLen;
	}

	
	
	public static void main(String[] args) {
		MultimediaMessage mms = new MultimediaMessage(7179998888L,
				9253337777L, "get well soon");

		// Invoke a method in TextMessage, not MultimediaMessage.
		String msgText = mms.getMessageText();
		System.out.println("Message text is: " + msgText);

		// Obviously, can also invoke methods in MultimediaMessage.
		mms.attachFile("selfie.jpg", 467300);
		System.out.println("Attached file name is: " + mms.getFileName());

	}

}
