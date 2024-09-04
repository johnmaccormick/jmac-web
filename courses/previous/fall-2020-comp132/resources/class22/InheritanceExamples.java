import java.util.*;

/**
 * Sample code illustrating inheritance and polymorphism using the
 * TextMessage and MultimediaMessage classes.
 * 
 * @author Grant Braught, minor changes by John MacCormick
 * @author Dickinson College
 */
public class InheritanceExamples {

	/**
	 * Demonstrate the inheritance and overriding of methods in the
	 * MultimediaMessage class.
	 */
	public static void demoMultimediaMessage() {
		// Notice L to indicate long.
		MultimediaMessage mm1 = new MultimediaMessage(7171234567L,
				3517654321L, "IMHO CS rocks!");

		/*
		 * MultimediaMessage contains (inherited) the methods defined in
		 * the TextMessage class.
		 */
		System.out.println("recipiant # = " + mm1.getRecipientNumber());
		System.out.println("message = " + mm1.getMessageText());

		/*
		 * MultimediaMessage also contains the methods that it defined.
		 */
		mm1.attachFile("SteveJobs.jpg", 2000);
		System.out.println("filename = " + mm1.getFileName());

		/*
		 * Methods can be overridden in a sub-class to redefine their
		 * behavior. Invoking getMessageType on a MultimediaMessage object
		 * invokes the version defined in that class.
		 */
		System.out.println("message type = " + mm1.getMessageType());

		/*
		 * Invoking getMessageType on a TextMessage object still invokes
		 * the version defined in that class.
		 */
		TextMessage tm1 = new TextMessage(3517654321L, 7171234567L,
				"ROFL ;)");
		System.out.println("message type = " + tm1.getMessageType());

		/*
		 * Overridden methods can invoke the super-class version of the
		 * method when it is useful. The getMessageLength method defined in
		 * MultimediaMessage invokes the getMessageLength method in the
		 * TextMessage class. See the code for the MultimediaMessage class.
		 */
		System.out.println("message length = " + mm1.getMessageLength());
	}

	/**
	 * Demo the use of a variable of the super-class to refer to an object
	 * of the sub-class. The type of the reference determines which methods
	 * are available to be called. The type of the object determines the
	 * method that is called.
	 */
	public static void usingSuperClassVariable() {
		TextMessage tm1 = new MultimediaMessage(7171234567L, 3517654321L,
				"This is 2G2BT");

		/*
		 * The type of the reference determines which methods are available
		 * to be invoked.
		 */
		System.out.println("recipient # = " + tm1.getRecipientNumber());
		System.out.println("message = " + tm1.getMessageText());

		/*
		 * The type of the object determines which implementation of the
		 * method is invoked. E.g. here the overridden version of
		 * getMessageType from MultimediaMessage is invoked because the
		 * object is of type MultimediaMessage even though the reference is
		 * of type TextMessage.
		 */
		System.out.println("message type = " + tm1.getMessageType());

		/*
		 * The following are illegal because the methods being invoked are
		 * not in the TextMessage class.
		 */
		// System.out.println("filename = " + tm1.getFileName());
		// tm1.attachFile("freshPow.jpg", 500);

		/*
		 * The reference can be cast to the sub-class type to invoke the
		 * other methods that the object offers.
		 */
		MultimediaMessage mm1 = (MultimediaMessage) tm1;
		mm1.attachFile("freshPow.jpg", 500);
		System.out.println("filename = " + mm1.getFileName());

		/*
		 * What do these lines output?
		 */
		System.out.println("tm1 length = " + tm1.getMessageLength());
		System.out.println("mm1 length = " + mm1.getMessageLength());
	}

	/**
	 * Demonstrates the poloymorphic use of the .equals method by the
	 * ArrayList class in the JDK. The results from this method will differ
	 * depending upon whether or not the TextMessage class has overidden
	 * the .equals method.
	 */
	public static void equalsInTheJDK() {
		TextMessage tm1 = new TextMessage(7171234567L, 3517654321L,
				"Polymorphism Rocks");
		TextMessage tm2 = new TextMessage(3517654321L, 7171234567L,
				"YKSTA!");

		ArrayList<TextMessage> tmList = new ArrayList<TextMessage>();
		tmList.add(tm1);
		tmList.add(tm2);

		TextMessage tm3 = new TextMessage(7171234567L, 3517654321L,
				"Polymorphism Rocks");

		System.out.println("contains tm1: " + tmList.contains(tm1));
		System.out.println("contains tm3: " + tmList.contains(tm3));
	}

	/**
	 * Demo the toString method that were inherited from the Object class
	 * and then overridden by TextMessage.
	 */
	public static void inheritedToStringMethod() {

		/*
		 * The println method invokes toString on the object and prints the
		 * String that is returned. Overriding toString allows a class to
		 * define how instances are printed.
		 */
		TextMessage tm1 = new TextMessage(3517654321L, 7171234567L,
				"Dinner? WDYT?");
		System.out.println(tm1);
	}

	/**
	 * Demo the equals method that were inherited from the Object class and
	 * then overridden by TextMessage.
	 */
	public static void inheritedEqualsMethod() {

		/*
		 * The equals method in Object compares two references to see if
		 * they are the same (i.e. using ==). Overriding equals allows a
		 * class to determine how instances are compared.
		 */
		TextMessage tm1 = new TextMessage(3517654321L, 7171234567L,
				"YGTBKM total WOMBAT");
		System.out.println("tm1.equals(tm1): " + tm1.equals(tm1));

		TextMessage tm2 = new TextMessage(3517654321L, 7171234567L,
				"YGTBKM total WOMBAT");
		System.out.println("tm1.equals(tm2): " + tm1.equals(tm2));

		TextMessage tm3 = tm1;
		System.out.println("tm1.equals(tm3): " + tm1.equals(tm3));

		TextMessage tm4 = new TextMessage(7171234567L, 3517654321L,
				"produced by DORD");
		System.out.println("tm1.equals(tm4): " + tm1.equals(tm4));
	}

	/**
	 * Main method that allows each of the example methods to be run.
	 * 
	 * @param args none
	 */
	public static void main(String[] args) {

		System.out.println("demoMultimediaMessage:");
		demoMultimediaMessage();

		System.out.println();
		System.out.println("usingSuperClassVariable:");
		usingSuperClassVariable();

		System.out.println();
		System.out.println("inheritedToStringMethod:");
		inheritedToStringMethod();

		System.out.println();
		System.out.println("inheritedEqualsMethod:");
		inheritedEqualsMethod();

		System.out.println();
		System.out.println("equalsInTheJDK:");
		equalsInTheJDK();
	}
}
