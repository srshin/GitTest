package com.encore.day08;

/*주의 사항:IllegalArgumentException 클래스는 java.lang 패키지에 존재하므로 별도로 생성하지 않습니다.
 * 테스트 목적으로 스스로 main을 구현할 수 있습니다.main의 내용은 채점하지 않습니다.주어진 메쏘드의 signature는 변경하지 않습니다.
*/

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}
	int play() {
		int number = (int) (Math.random() * size) + 1; // 1~8
		return number;
	}
}

public class DiceGame {
	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);

		int result2 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);

	}

	int countSameEye(int n)   {
		int count = 0; 
		try { 
			if (n <0 ) throw new IllegalArgumentException("음수불가");
			Dice d1 = new Dice(8);
			Dice d2 = new Dice(8);
			for (int i=0; i <=8; i++) {
				int n1 = d1.play();
				int n2 = d2.play();
				if (n1 == n2) count++;
				System.out.println(n1 + " " + n2);
			}
		} catch ( IllegalArgumentException aa) {
			System.out.println(aa.getMessage());
		}
		return count; 
	}

}
