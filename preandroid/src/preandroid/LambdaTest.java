package preandroid;

import com.kitri.dto.Test;
import com.kitri.dto.TestImpl;

public class LambdaTest {

	public static void test(Test t) {
		t.m(10);
	}
	
	public static void main(String[] args) {
//		TestImpl impl = new TestImpl();
//		impl.m(10);
//		test(impl);
		
		
//		i->System.out.println(i);
		test(i->System.out.println(i));
		
	}
}
