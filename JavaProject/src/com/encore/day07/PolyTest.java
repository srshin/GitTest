package com.encore.day07;

class A {

	@Override
	public String toString() {
		return this.getClass().getSimpleName() +"클래스입니다"; 
	}}
class B extends A{
	public void go() {
		System.out.println("B에 있는 go함수입니다. ");
	}
}
class D extends B{}

class C extends A{}
class E extends C{}

public class PolyTest {
	public static void show(A a) {
		System.out.println(a);
		if (a instanceof B) ((B)a).go();
	}
	public static void main(String[] args) {
		A a = new A(); 
		B b = new B(); 
		C c = new C();
		D d = new D();
		E e = new E(); 
		show(a);
		show(b);
		show(c);
		show(d);
		show(e);
		
		
	}
}
