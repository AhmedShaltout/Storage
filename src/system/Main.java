package system;

import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now().minusMonths(1).toLocalDate().toString());
	}

}
