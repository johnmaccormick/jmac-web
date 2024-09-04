import java.util.ArrayList;
import java.util.Iterator;

public class FriendsNested implements Iterable<String> {
	private ArrayList<String> friendList;

	public FriendsNested() {
		friendList = new ArrayList<String>();
		friendList.add("Shafi Goldwasser");
		friendList.add("Yoshua Bengio");
		friendList.add("Cynthia Dwork");
	}

	public String getFriend(int i) {
		return friendList.get(i);
	}

	private class FriendsIterator implements Iterator<String> {
		private ArrayList<String> theFriendList;
		private int index = 0;

		public FriendsIterator(ArrayList<String> theFriendList) {
			this.theFriendList = theFriendList;
		}

		@Override
		public boolean hasNext() {
			return index < theFriendList.size();
		}

		@Override
		public String next() {
			String nextFriend = theFriendList.get(index);
			index++;
			return nextFriend;
		}

	}

	@Override
	public Iterator<String> iterator() {
		return new FriendsIterator(this.friendList);
	}

	public static void main(String[] args) {
		FriendsNested friends = new FriendsNested();

		for (String friend : friends) {
			System.out.println(friend);
		}

		Iterator<String> iterator = friends.iterator();
		for (int i = 0; iterator.hasNext(); i++, iterator.next()) {
			String friend = friends.getFriend(i);
			System.out.println(friend);
		}
		
		Iterator<String> iterator2 = friends.friendList.iterator();
		for (int i = 0; iterator2.hasNext(); i++, iterator2.next()) {
			String friend = friends.getFriend(i);
			System.out.println(friend);
		}
	}

}
