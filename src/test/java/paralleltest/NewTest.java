package paralleltest;

import org.testng.annotations.Test;

public class NewTest {
  @Test(threadPoolSize=4,invocationCount=8,timeOut=2000)
  public void f() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Sample one - Test 1 ;"+id);
  }
  
  
}
