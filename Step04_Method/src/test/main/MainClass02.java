package test.main;

import test.mypac.Test;
import test.mypac.Airplane;

public class MainClass02 {
	public static void main(String[] args) {
		Test t = new Test();
		
		t.send();
		//값을 즉석해서 만들어서 전달
		t.send(10);
		t.send("xxx");
		t.send(new Airplane());
		
		t.send();
		
		//참조되는 값을 전달 할수도 있다.
		int a =999;
		t.send(a);
		
		String b = "하이";
		t.send(b);
		
		Airplane c=new Airplane();
		t.send(c);
	}
}
