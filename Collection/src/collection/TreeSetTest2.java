package collection;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest2 {
	public static void main(String[] args) {
		
		TreeSet<Integer> subNum = new TreeSet<Integer>();
		
		for(int i=1 ; i<51 ; i+=2) {
			subNum.add(i);
		}
		System.out.println(subNum);
		//[1, 3, 5, ... , 45, 47, 49]
		
		//부분집합(subSet) 생성
		
		//====== 특정 요소 앞 ======
		SortedSet<Integer> header = subNum.headSet(21);
		//숫자 20은 포함되지 않는다.
		System.out.println(header);
		//[1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
		SortedSet<Integer> header2 = subNum.headSet(21,true);
		//21도 포함해서 앞에있는 요소를 다른 집합으로 만든다.
		System.out.println(header2);
		//[1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21]
		//특정요소보다 작은값을 만들때는 기본이 false
		
		//====== 특정 요소 뒤 ======
		SortedSet<Integer> tailer = subNum.tailSet(21);
		//특정 요소기준보다 큰 요소를 부분 집합으로 만든다.
		System.out.println(tailer);
		//[21, 23, 25, ... , 45, 47, 49]
		SortedSet<Integer> tailer2 = subNum.tailSet(21,false);
		//특정 요소기준보다 큰 요소를 부분 집합으로 만든다.
		System.out.println(tailer2);
		//[23, 25, 27, ... , 45, 47, 49]
		//특정요소보다 큰값을 만들때는 기본이 true
		
		//====== to요소 from 요소 ======
		SortedSet<Integer> areaSet = subNum.subSet(11, 21);
		System.out.println(areaSet);
		//[11, 13, 15, 17, 19]
		//특정요소보다 클때는 포함이 기본,작은건 미포함이 기본이기 때문
		//둘다 포함하거나 둘다 미포함도 가능하다.
		SortedSet<Integer> areaSet2 = subNum.subSet(11,true,21,true);
		System.out.println(areaSet2);
		//[11, 13, 15, 17, 19, 21]
		SortedSet<Integer> areaSet3 = subNum.subSet(11,false,21,false);
		System.out.println(areaSet3);
		//[13, 15, 17, 19]
		//이때에는 한쪽만 범위지정을 해줄수없고 둘다 해야한다.
		
	}
}
