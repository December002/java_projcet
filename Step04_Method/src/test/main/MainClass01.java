package test.main;

import java.io.File;
import java.util.Scanner;

import test.mypac.Airplane;

import test.mypac.Test;
public class MainClass01 {
	public static void main(String[] args) {
        Test t = new Test();
        // retrun type 이 void 인 메소드 호출
        t.walk();
        
        // return type 이 int 인 메소드 호출하고 리턴되는 값을 a 라는 int tpye 지역변수에 담기
        int a = t.getNumber();
        System.out.println(a);
        
        // return type 이 String 인 메소드 호출하고 리턴되는 값을 b 라는 String type 지역변수에 담기
        String b = t.getGreeting();
        System.out.println(b);
        
        //return type 이 AirPlane 인 메소드호출하고 리턴되는 값을 c 라는 AirPlane type 지역변수에 담기
        Airplane c = t.getPlane();
        c.fly();

        
        // 위에서 생성한 객체의 setNum() 메소드를 호출해 보세요
        // int num = ???
        t.setNum(999);
        // 위에서 생성한 객체의 setName() 메소드를 호출해 보세요
        // String name = ???
        t.setName("김구라");
        // 위에서 생성한 객체의 setPlane() 메소드를 호출해 보세요
        // Airplane plane = ???
        t.setPlane(new Airplane());
        
        t.doSomething(999, "김구라", new Airplane());
        
        t.send();
        
        t.send(a);
        
        t.send(b);
        
        t.send(c);
        
        System.out.println("main 메소드가 종료 됩니다");
        
    }
}


