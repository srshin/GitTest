package com.encore.day07;
/*오리(꽥꽥이)는 날지 않습니다.
오리(꽥꽥이)가  소리내어 웁니다.
오리의 이름은 꽥꽥이 입니다.
참새(짹짹)가 날아다닙니다.
참새(짹짹)가  소리내어 웁니다.
참새의 이름은 짹짹 입니다.
*/

public class PlayBird {

	public static void main(String[] args) {
		
		Duck a = new Duck("꽥꽥이", 2, 10.5);
		Sparrow s = new Sparrow("짹짹",  2,  5.5);
		a.fly();
		a.sing();
		System.out.println(a);
		s.fly();
		s.sing();
		System.out.println(s);
		
		
	}
}
