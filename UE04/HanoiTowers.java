
public class HanoiTowers {

	public static void main(String args[]) {
		hanoi(3, "A", "B", "C");
	}

	public static void hanoi(int n, String a, String b, String c) {

		if(n == 0) {
			return;
		} else {
			hanoi(n - 1, a, c, b);
			System.out.println("Von " + a + " nach " + c);
			hanoi(n - 1, b, a, c);
		}
	
	}

}
