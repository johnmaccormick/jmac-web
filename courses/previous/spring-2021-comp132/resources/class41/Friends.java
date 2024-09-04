import java.util.ArrayList;
import java.util.Iterator;

public class Friends implements Iterable<String> {
	private ArrayList<String> friendList;

	public Friends() {
		friendList = new ArrayList<String>();
		friendList.add("Shafi Goldwasser");
		friendList.add("Yoshua Bengio");
		friendList.add("Cynthia Dwork");
	}

	public String getFriend(int i) {
		return friendList.get(i);
	}


	@Override
	public Iterator<String> iterator() {
		return new FriendsIterator(this.friendList);
	}

	public static void main(String[] args) {
		Friends friends = new Friends();

		for (String friend : friends) {
			System.out.println(friend);
		}

		
//		Iterator<String> iterator = friends.iterator();
//		for (int i = 0; iterator.hasNext(); i++, iterator.next()) {
//			String friend = friends.getFriend(i);
//			System.out.println(friend);
//		}
//		
//		Iterator<String> iterator2 = friends.friendList.iterator();
//		for (int i = 0; iterator2.hasNext(); i++, iterator2.next()) {
//			String friend = friends.getFriend(i);
//			System.out.println(friend);
//		}
	}

}
