package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map1= new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("addr", "노량진");
		
		Map<String, Object> map2= new HashMap<>();
		map2.put("num", 2);
		map2.put("name", "해골");
		map2.put("addr", "행신동");
		
		Map<String, Object> map3= new HashMap<>();
		map3.put("num", 3);
		map3.put("name", "원숭이");
		map3.put("addr", "상도동");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		for (Map<String, Object> tmp : list) {
			int num=(int)tmp.get("num");
			String name=(String)tmp.get("name");
			String addr=(String)tmp.get("addr");
			System.out.println("num:"+num+" name:"+name+" addr:"+addr);
		}
	}
}
