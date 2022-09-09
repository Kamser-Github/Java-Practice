package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest01 {
	public static void main(String[] args) {
		HashMap<String,Integer> stu1ban = new HashMap<>();
		stu1ban.put("둘리", 25);
		stu1ban.put("또치", 23);
		stu1ban.put("핑핑이", 27);
		stu1ban.put("스펀지밥", 25);
		stu1ban.put("뚱이", 25);
		//데이터 추가 
		//1.데이터 개개인 추가.
		HashMap<String,Integer> stu2ban = new HashMap<>();
		stu2ban.put("희동이", 25);
		stu2ban.put("핑핑이", 27);
		stu2ban.put("스펀지밥", 99);
		stu2ban.put("민가유", 21);
		stu2ban.put("짱구", 12);
		System.out.println("Key중복이면 old Value 를 반환"+stu2ban.put("짱구", 13));
		//Key값이 중복이 아닌경우 null , 그리고 데이터 추가된다.
		
		//데이터 그룹 추가.
		//#2 putAll(<Map<? extends K,? extends V> m)
		stu1ban.putAll(stu2ban);
		
		System.out.println(stu1ban);
		//{둘리=25, 짱구=12, 뚱이=25, 희동이=25, 민가유=21, 스펀지밥=99, 또치=23, 핑핑이=27}
		//Key값인 String이 중복이되면 새로 추가된게 덮어진다.
		//입력순서와 출력순서는 불일치한다.
		
		//데이터 변경
		
		//#3.replace(K key,V value) //return old value;
		int num = stu1ban.replace("스펀지밥", 25); 
		System.out.println(num); //old value = return 99
		System.out.println(stu1ban.get("스펀지밥")); //new value = 25
		
		//#3-1.replace(K key,V oldValue,V newVelue) void
		stu1ban.replace("짱구", 13, 25); // key value 모두 같아야한다.
		System.out.println(stu1ban.get("짱구")); //value = 25
		stu1ban.replace("짱구", 12, 25); // XX
		System.out.println(stu1ban.get("짱구")); //value = 25
		
		//데이터 정보추출
		//#4 containsKey(Object key)
		System.out.println(stu1ban.containsKey("민가유"));//true
		System.out.println(stu1ban.containsKey("난가유"));//false
		//#4-1 containsValue(Object value)
		System.out.println(stu1ban.containsValue(25));//true
		System.out.println(stu1ban.containsValue(99));//false
		
		//#5 Set<K> keySet() Set으로 관리하기때문에 equals,hashCode()재정의필요
		Set<String> keySet = stu1ban.keySet();
		System.out.println(keySet);
		//[둘리, 짱구, 뚱이, 희동이, 민가유, 스펀지밥, 또치, 핑핑이] //입력순서!=출력순서
		
		//#6 Set<Map.Entry<K,V>> entrySet()
		Set<Map.Entry<String,Integer>> entrySet = stu1ban.entrySet();
		System.out.println(entrySet);
		//[둘리=25, 짱구=25, 뚱이=25, 희동이=25, 민가유=21, 스펀지밥=25, 또치=23, 핑핑이=27]
		
		//#7 size() 실제 데이터 길이
		System.out.println(stu1ban.size()); //8 Entry의 개수
		
		//데이터 삭제
		if(stu1ban.remove("스펀지밥")==null) {
			System.out.println("데이터가 없습니다.");
		}
		else {
			System.out.println("데이터가 삭제되었습니다.");
		}
		
		
		
		
	}
}
