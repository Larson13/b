package driver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider2 {
	int i=1;
@DataProvider(name="data")
public Object[][] objects(){
	return new Object[][]{
		{"user1","3"},{"user2","2"},{"user3","3"}
	};
}
/*@Test(dataProvider="data")
public void test1(String user,String password){

	System.out.println("第一次："+i);
	System.out.println(user);
	System.out.println(password);
	i++;
}*/
@Test 
public void test2(){
	System.out.println("这是个这是个dataProvider2--test2的方法");
}
@Test 
public void test3(){
	System.out.println("这是个这是个dataProvider2--test3的方法");
}
}
