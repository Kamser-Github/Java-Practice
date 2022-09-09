package collection;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapEx01 {
	public static void main(String[] args) {
		TreeMap<Integer,String> sample = new TreeMap<>();
		for(int i=20 ; i>0 ; i-=2) {
			sample.put(i,i+"번째 데이터");
		}
		System.out.println(sample);
		//{2=2번째 데이터, 4=4번째 데이터,..., 20=20번째 데이터}
		
		//데이터 검색
		//#1 K 	firstKey() / lastKey()
		System.out.println(sample.firstKey());// 2
		//#2 Map.Entry<K,V> 	firstEntry() / lastEntry()
		System.out.println(sample.firstEntry());//2=2번째 데이터
		//#3 K 	lowerKey(K key) / higherKey(K key)
		//key값 제외 바로 아래	/ 바로 위
		System.out.println(sample.lowerKey(9)); //8
		//#4 Map.Entry<K,V>	 	lowerEntry(K key) / higherEntry(K key)
		//key값 제외 바로 아래 엔트리 / 바로 위 엔트리 검색
		System.out.println(sample.higherEntry(9)); //10=10번째 데이터
		
		//데이터 꺼내기(배열에서 지워진다)
		//#5 Map.Entry<K,V>	 pollFirstEntry() / pollLastEntry()
		System.out.println(sample.pollFirstEntry()); //2=2번째 데이터
		System.out.println(sample); // {4=4번째 데이터,..., 20=20번째 데이터}
		
		//데이터 부분집합(SubMap)  ──┐ || ┌──
		//자기보다 작을땐 자신은 미포함! default false
		//자비고다 클땐 자기자신은 포함! default true
		//#6 SortedMap<K,V> headMap(K toKey)
		SortedMap<Integer,String> sortedMap = sample.headMap(8);
		System.out.println(sortedMap);//{4=4번째 데이터, 6=6번째 데이터}
		//#7 NavigableMap<K,V> headMap(K toKey,boolean inclusive)
		NavigableMap<Integer,String> naviMap = sample.headMap(8,true);
		System.out.println(naviMap);//{4=4번째 데이터, 6=6번째 데이터, 8=8번째 데이터}
		
		//데이터 부분집합(SubMap)  ┌───┐
		//자기보다 작을땐 자신은 미포함! default false
		//자비고다 클땐 자기자신은 포함! default true
		//#8 SortedMap<K,V> subMap(K formKey,K toKey)
		sortedMap = sample.subMap(6,10);//6은포함 10은 미포함
		System.out.println(sortedMap);//{6=6번째 데이터, 8=8번째 데이터}
		//#9 NavigableMap<K,V> subMap(K key,boolean from,K Key,boolean to}
		naviMap = sample.subMap(6, false, 10, true); //6 미포 10 포
		System.out.println(naviMap); //{8=8번째 데이터, 10=10번째 데이터}
		
		//출력해보기
		
		//Map 출력방법 3가지 (TreeMap이니까 subMap으로)
		//1.Iterator + keySet()
		Iterator<Integer> it = sample.subMap(6, 14).keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			System.out.printf("%d:%s",key,sample.get(key));
		}
		System.out.println();
		
		//2.Iterator + entrySet()
		Iterator<Map.Entry<Integer,String>> it2 = sample.subMap(4,true,12,true).entrySet().iterator();
		while(it2.hasNext()) {
			Map.Entry<Integer,String> map = it2.next();
			Integer num = map.getKey();
			String str = map.getValue();
			System.out.printf("%d:%s",num,str);
		}
		
		//3.for + entrySet()
		Set<Map.Entry<Integer,String>> set = sample.subMap(6,false,16,false).entrySet();
		for(Map.Entry<Integer,String> a : set) {
			System.out.printf("%d:%s",a.getKey(),a.getValue());
		}
		
		
	}
}
