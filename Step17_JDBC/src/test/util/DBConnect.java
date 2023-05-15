package test.util;

import java.sql.Connection;

public class DBConnect {
	//필드
	private Connection conn;
	//생성자
	public DBConnect() {
		
	}
	//필드에 저장된 값을 리턴하는 메소드
	public Connection getConn() {
		return conn;
	}
}
