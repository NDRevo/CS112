package tree;

import java.util.ArrayList;
import java.util.Arrays;

// User MUST implement the Comparable interface
class User implements Comparable<User> {
	String userId;
	String pwd;
	String name;
	
	public User(String userId, String pwd, String name) {
		this.userId = userId;
		this.pwd = pwd;
		this.name = name;
	}
	
	public int compareTo(User other) {
		return userId.compareTo(other.userId);
	}
	
}

public class BSTApp {

	public static void main(String[] args) {
		// BST with String objects
		BST<String> strBST = new BST<String>();
		strBST.insert("godfather");
		strBST.insert("last samurai");
		strBST.insert("black panther");
		strBST.insert("sicario");
		strBST.insert("mad max: fury road");
		
		System.out.println(strBST.search("last samurai"));
		System.out.println(strBST.search("bourne supremacy"));
		
		// BST with User objects
		BST<User> userBST = new BST<User>();
		userBST.insert(new User("kwinslet","kw65!abc","Kate Winslet"));
		userBST.insert(new User("ielba","gg7%$7hh", "Idris Elba"));
		userBST.insert(new User("estone","ytq217gvc","Emma Stone"));
		
		// get password for a user, matching on id
		User user = userBST.search(new User("estone",null,null));
		System.out.println(user.name + ": " + user.pwd);
		
		// sort
		BST<Integer> intBST = new BST<Integer>();
		int[] arr = {13,5,-10,15,67,8,25,44};
		System.out.print("\nInput:  " + Arrays.toString(arr));
		for (int item: arr) {
			intBST.insert(item);
		}
		ArrayList<Integer> res = intBST.sort();
		System.out.println("\nSorted: " + res);
				
	}

}
