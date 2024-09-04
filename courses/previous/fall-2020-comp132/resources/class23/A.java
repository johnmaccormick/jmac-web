public class A {
	public void print() {
		System.out.println("apple");
	}
	
	
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		A a3 = new C();
		
		a1.print();
		a2.print();
		a3.print();
		
		B b2 = (B) a2;
		B b3 = (B) a3;
		
		b2.print();
		b3.print();
		
		A a4 = b3;
		
		a4.print();
	}
}
