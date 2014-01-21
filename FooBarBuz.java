
public class FooBarBuz {
	public static void main (String args[]) {
		
		for(int i=1; i<=110; i++){
			 if (i%3 ==0 ){
				 System.out.println("Foo");
			 }
			 else if (i%5 == 0 ){
				 System.out.println("Foo Bar");
			 }
			 else if (i%7 == 0 ){
				 System.out.println("Baz");
			 }
			 else {
				 System.out.println(i);
			 }
		 }
		
	}

}
