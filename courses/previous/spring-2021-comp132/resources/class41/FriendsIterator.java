import java.util.ArrayList;
import java.util.Iterator;

public class FriendsIterator implements Iterator<String> {
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

