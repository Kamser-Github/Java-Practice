package collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
	public static void main(String[] args) {
		HashMap<Integer,Pokemon> pokemon = new HashMap<Integer,Pokemon>();
		pokemon.put(001, new Pokemon("파이리", "불"));
		pokemon.put(002, new Pokemon("피카츄", "전기"));
		pokemon.put(003, new Pokemon("꼬부기", "물"));
		pokemon.put(004, new Pokemon("이상해씨", "풀"));
		
		//데이터 출력 (println 제외)
		//#1.Iterator + keySet()
		//Set<Integer> set = pokemon.keySet();
		//Iterator<Integer> it = set.iterator();
		Iterator<Integer> it = pokemon.keySet().iterator();
		while(it.hasNext()) {
			Pokemon poke = pokemon.get(it.next());
			String name = poke.getName();
			String attribute = poke.getAttribute();
			System.out.println(name+" : "+attribute);
		}
		
		//#2.Iterator, entrySet()
		Set<Map.Entry<Integer,Pokemon>> poke = pokemon.entrySet();
		Iterator<Map.Entry<Integer,Pokemon>> it2 = poke.iterator();
		while(it2.hasNext()) {
			Map.Entry<Integer,Pokemon> poke2 = it2.next();
			String name = poke2.getValue().getName();
			String attribute = poke2.getValue().getAttribute();
			System.out.println(name+" : "+attribute);
		}
		
		//#3.출력 3 - 확장 for문, entrySet()
		Set<Map.Entry<Integer,Pokemon>> poke3 = pokemon.entrySet();
		for(Map.Entry<Integer,Pokemon> a : poke3) {
			System.out.printf("%s : %s\n",a.getValue().getName(),a.getValue().getAttribute());
		}
		System.out.println("==============");
		//데이터 수정하기
		Set<Integer> nums = pokemon.keySet();
		Iterator<Integer> it3 = nums.iterator();
		while(it3.hasNext()) {
			Integer num = it3.next();
			if(pokemon.get(num).getName().equals("파이리")) {
				pokemon.get(num).setName("리자몽");
			}
		}
		System.out.println(pokemon);
		//{1=리자몽:불, 2=피카츄:전기, 3=꼬부기:물, 4=이상해씨:풀}
		
		//데이터 변경하기
		nums = pokemon.keySet();
		it3 = nums.iterator();
		while(it3.hasNext()) {
			Integer num = it3.next();
			if(pokemon.get(num).getName().equals("이상해씨")) {
				pokemon.replace(num, new Pokemon("이상해꽃","바위"));
			}
		}
		System.out.println(pokemon);
		//{1=리자몽:불, 2=피카츄:전기, 3=꼬부기:물, 4=이상해꽃:바위}
	}
}

class Pokemon {
	
	private String name;
	private String attribute;
	
	public Pokemon() {
		this("몬스터볼","무");
	}
	
	public Pokemon(String name,String attribute) {
		this.name = name;
		this.attribute = attribute;
	}
	
	//get/set
	public String getName() {return name;}
	public String getAttribute() {return attribute;}

	public void setName(String name) {
		this.name = name;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	@Override
	public String toString() {
		return name+":"+attribute;
	}
}