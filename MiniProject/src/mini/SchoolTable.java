package mini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;
import java.util.Scanner;

public class SchoolTable {
	public static void main(String[] args) {
/*
		1. 정렬할 기준이 있는 compareTo<T>,
		2. 중복을 체크할 equals
			내부에서 한번 확인
		3. toString
		4. 생성자.
		5. 상수
		6. 파일 쓰기,읽기 - 처음에 파일없으면 만들어서 읽기
		7. 파일 초기화.
		8. 중복찾으면 인덱스반환,
		9. 중복찾으면 누적카운트반환,
		10.랜덤번호 생성.(null주의)
		11.배열 추가
		12.배열 삭제
		13.출력 
*/
		Ezen aa = new Ezen("C:/Users/yousd/Desktop/Ezen");
		aa.run();
	}
}
interface Comparable<T> {
	public int compareTo(T t);
}
interface TakeOutable {
	public String getData();
}
interface Inputable<T> {
	public T getInstance(String[] arr);
}
class Student implements Comparable<Student> ,TakeOutable,Inputable<Student> {
	static int no = 1;
	int studentID;
	String studentName;
	
	Student(){
		this(0,"이름없음"+no);
		Student.no++;
	}
	Student(int studentID,String studentName){
		this.studentID = studentID;
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return String.format("학생번호:%4d 학생명:%4s\n",studentID,studentName);
	}
	@Override
	public String getData() {
		return String.format("%d,%s",studentID,studentName);
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		else if(obj instanceof Student) {
			return this.studentName.equals(((Student)obj).studentName);
		}
		else if(obj instanceof String) {
			return this.studentName.equals((String)obj);
		}
		else
			return false;
	}
	@Override
	public int compareTo(Student student) {
		return this.studentName.compareTo(student.studentName);
	}
	@Override
	public Student getInstance(String[] arr) {
		if(arr.length==2) {
			int id = Integer.parseInt(arr[0]);
			return new Student(id,arr[1]);
		}
		else
			return new Student();
	}
}

class Subject implements Comparable<Subject> ,TakeOutable ,Inputable<Subject> {
	static int no=1;
	int subjectID;
	String subjectName;
	
	Subject(){
		this(0,"이름없음"+no);
		Subject.no++;
	}
	Subject(int subjectID, String subjectName) {
		this.subjectID = subjectID;
		this.subjectName = subjectName;
	}
	@Override
	public String toString() {
		return String.format("과목번호:%4d 과목명:%4s\n", subjectID, subjectName);
	}
	@Override
	public String getData() {
		return String.format("%d,%s",subjectID,subjectName);
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		else if (obj instanceof Subject) {
			return this.subjectName.equals(((Subject)obj).subjectName);
		}
		else if(obj instanceof String) {
			return this.subjectName.equals((String)obj);
		}
		else 
			return false;
	}
	@Override
	public int compareTo(Subject subject) {
		return this.subjectName.compareTo(subject.subjectName);
	}
	@Override
	public Subject getInstance(String[] arr) {
		if(arr.length==2) {
			int id = Integer.parseInt(arr[0]);
			return new Subject(id,arr[1]);
		}
		else
			return new Subject();
	}
}

class Score implements Comparable<Score> ,TakeOutable ,Inputable<Score>{
	static int no = 1;
	String studentName;
	String subjectName;
	int score;
	
	Score(){
		this("이름없음"+Score.no,"이름없음"+Score.no,0);
		Score.no++;
	}
	Score(String studentName, String subjectName, int score){
		this.studentName = studentName;
		this.subjectName = subjectName;
		this.score = score;
	}
	@Override
	public String toString() {
		return String.format("이름:%3s 과목:%2s %3d점\n", studentName, subjectName, score);
	}
	@Override
	public String getData() {
		return String.format("%s,%s,%d",studentName,subjectName,score);
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		else if(obj instanceof Score) {
			boolean student = this.studentName.equals(((Score)obj).studentName);
			boolean subject = this.subjectName.equals(((Score)obj).subjectName);
			return student&&subject;
		}
		else
			return false;
	}
	@Override
	public int compareTo(Score score) {
		if(this.score-score.score>0) {
			return -1;
		}
		else if(this.score-score.score==0) {
			return this.studentName.compareTo(score.studentName);
		}
		else {
			return 1;
		}
	}
	public boolean equalsTo(Object obj) {
		if(obj instanceof Student)
			return this.studentName.equals(((Student)obj).studentName);
		else if(obj instanceof Subject) {
			return this.studentName.equals(((Subject)obj).subjectName);
		}
		return false;
	}
	@Override
	public Score getInstance(String[] arr) {
		if(arr.length==3) {
			int id = Integer.parseInt(arr[2]);
			return new Score(arr[0],arr[1],id);
		}
		else
			return new Score();
	}
}
@SuppressWarnings("unchecked")
class Ezen {
	private static int no;
	private final int INSERT = 1;
	private final int DELETE = 2;
	private final int SORTED = 3;
	private final int PRINT = 4;
	private final int SAVE = 5;
	private final int LOAD = 6;
	private final int STUDENT = 1;
	private final int SUBJECT = 2;
	private final int SCORE = 3;
	private final int PARENT_FOLDER_ADDR = 0;
	private final int NOT_FIND = -1;
	
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	Student[] students;
	Subject[] subjects;
	Score[] scores;
	String parentFolderAddr;
	String[] tableAddr;
	int[] checkID;
	
	File ezenFile;
	FileWriter fw = null;
	FileReader fr = null;
	BufferedWriter bw = null;
	BufferedReader br = null;
	LineNumberReader lnr = null; 
	
	Ezen(String parentFolderAddr) {
		this.students = new Student[0];
		this.subjects = new Subject[0];
		this.scores = new Score[0];
		this.tableAddr = new String[4];
		this.parentFolderAddr = parentFolderAddr;
		this.checkID = new int[10000];
		tableInit();
		initFileEzen();
		load();
		Ezen.no++;
	}
	void tableInit() {
		this.tableAddr[PARENT_FOLDER_ADDR] = parentFolderAddr;
		this.tableAddr[STUDENT] = "student"+no+".txt";
		this.tableAddr[SUBJECT] = "subject"+no+".txt";
		this.tableAddr[SCORE] = "score"+no+".txt";
	}
	void fileExsistMkdir() {
		ezenFile = new File(tableAddr[PARENT_FOLDER_ADDR]);
		if(!ezenFile.exists()) {
			ezenFile.mkdirs();
		}
	}
	void exsistCreateFile(int tableAddrNum) throws IOException {
		ezenFile = new File(tableAddr[PARENT_FOLDER_ADDR],tableAddr[tableAddrNum]);
		if(!ezenFile.exists()) ezenFile.createNewFile();
	}
	void initFileEzen() {
		fileExsistMkdir();
		try {
			exsistCreateFile(STUDENT);
			exsistCreateFile(SUBJECT);
			exsistCreateFile(SCORE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//로드 메서드
	}
	int getRandomID() {
		int ranID = -1;
		while(ranID == -1) {
			ranID = ran.nextInt(checkID.length);
			if(checkID[ranID]==0) {
				checkID[ranID]++;
			}
			else
				ranID = -1;
		}
		return ranID;
	}
	<T> int findIndexOf(Comparable<T>[] arr,Object obj) {
		int idx = -1;
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i].equals(obj)) {
				idx = i;
			}
		}
		return idx;
	}
	<T> Inputable<T>[] castingExpandCapacity(Inputable<T> obj,int lineCnt){
		Inputable<T>[] tmp = null;
		if(obj instanceof Student) {
			tmp = (Inputable<T>[]) new Student[lineCnt];
		}
		else if(obj instanceof Subject) {
			tmp = (Inputable<T>[]) new Subject[lineCnt];
		}
		else if(obj instanceof Score) {
			tmp = (Inputable<T>[]) new Score[lineCnt];
		}
		return tmp;
	}
	<T> Comparable<T>[] castingExpandCapacity(Comparable<T> obj,int resizeNum){
		Comparable<T>[] tmp = null;
		if(obj instanceof Student) {
			tmp = (Comparable<T>[]) new Student[this.students.length+resizeNum];
		}
		else if(obj instanceof Subject) {
			tmp = (Comparable<T>[]) new Subject[this.subjects.length+resizeNum];
		}
		else if(obj instanceof Score) {
			tmp = (Comparable<T>[]) new Score[this.scores.length+resizeNum];
		}
		return tmp;
	}
	<T> Comparable<T>[] bringType(Comparable<T> obj) {
		Comparable<T>[] tmp = null;
		if(obj instanceof Student) {
			tmp = (Comparable<T>[]) this.students;
		}
		else if(obj instanceof Subject) {
			tmp = (Comparable<T>[]) this.subjects;
		}
		else if(obj instanceof Score) {
			tmp = (Comparable<T>[]) this.scores;
		}
		return tmp;
	}
	<T> T[] add(Comparable<T> obj) {
		Comparable<T>[] tmp = castingExpandCapacity(obj,1);
		Comparable<T>[] ezentmp = bringType(obj);
		for(int i=0 ; i<ezentmp.length ; i++) {
			tmp[i] = ezentmp[i];
		}
		tmp[ezentmp.length]=obj;
		ezentmp = tmp;
		return (T[])ezentmp;
	}
	<T> T[]  update(Comparable<T> obj,boolean updateData) {
		Comparable<T>[] ezentmp = bringType(obj);
		int idx = findIndexOf(ezentmp, obj);
		if(idx==-1) {
			ezentmp = (Comparable<T>[]) add(obj);
		}
		else if(updateData){
			ezentmp[idx] = null;
			ezentmp[idx] = obj;
		}
		else {
			System.out.println("다시 확인 바랍니다.");
		}
		printTable(ezentmp);
		return (T[])ezentmp;
	}
	void printTable(Object[] objs) {
		for(int i=0 ; i<objs.length ; i++) {
			System.out.println(objs[i]);
		}
	}
	String reseiveData(String message) {
		if(message.length()<1) return null;
		System.out.println(message);
		return sc.nextLine().replace(" ", "");
	}
	<T> int removeData(Comparable<T> constructor,Object searchObj) {
		Comparable<T>[] ezenTmp = bringType(constructor);
		int nullCnt = 0;
		System.out.println("ezenTmp length : "+ezenTmp[0]);
		for(int i=0 ; i<ezenTmp.length ; i++) {
			if(checkEquals(ezenTmp,i,searchObj)) {
				System.out.println("점수 제거");
				ezenTmp[i] = null;
				nullCnt++;
			}
		}
		return nullCnt;
	}
	<T> boolean checkEquals(Comparable<T>[] objArr,int idx,Object obj){
		if(objArr instanceof Student[]) {
			return ((Student[])objArr)[idx].equals(obj);
		}
		else if(objArr instanceof Subject[]) {
			return ((Subject[])objArr)[idx].equals(obj);
		}
		else if(objArr instanceof Score[]) {
			return ((Score[])objArr)[idx].equalsTo(obj);
		}
		else
			return false;
	}
	<T> T[] reduceArray(Comparable<T> constructor,int nullCnt) {
		Comparable<T>[] tmp 	= castingExpandCapacity(constructor,-nullCnt); 
		Comparable<T>[] ezentmp = bringType(constructor);
		int tmpIdx = 0;
		for(int i=0 ; i<ezentmp.length ; i++) {
			if(ezentmp[i]!=null) {
				tmp[tmpIdx++]=ezentmp[i];
			}
		}
		ezentmp = tmp;
		return  (T[]) ezentmp;
	}
	void deleteStudent(String str) {
		int nullCnt = removeData(new Score(),new Student(0,str));
		scores = reduceArray(new Score(), nullCnt);
		nullCnt = removeData(new Student(), new Student(0,str));
		students = reduceArray(new Student(), nullCnt);
	}
	void deleteSubject(String str) {
		int nullCnt = removeData(new Score(),new Subject(0,str));
		scores = reduceArray(new Score(), nullCnt);
		nullCnt = removeData(new Subject(), new Subject(0,str));
		subjects = reduceArray(new Subject(), nullCnt);
	}
	<T> void sort(Comparable<T>[] obj,boolean isASC) {
		Comparable<T> max = null;
		int maxIdx = 0;
		int sort = isASC ? 1 : -1;
		for(int i=0 ; i<obj.length ; i++) {
			max = obj[i];//1
			maxIdx = i;//0
			for(int j=i-1; j>=0 ; j--) {
				if(max.compareTo((T)obj[j])*sort>0) {
					obj[j+1]=obj[j];
					maxIdx = j;
				}
			}
			obj[maxIdx]=max;
		}
	}
	void saveData(String parentAddr,String fileName,TakeOutable[] arr) throws IOException{
		ezenFile = new File(parentAddr,fileName);
		fw = new FileWriter(ezenFile);
		bw = new BufferedWriter(fw);
		for(int i=0 ; i<arr.length ; i++) {
			bw.write(arr[i].getData());
			if(i<arr.length-1)
				bw.write("\n");
		}
		bw.close();
		fw.close();
	}
	void save() {
		try {
			saveData(tableAddr[PARENT_FOLDER_ADDR],tableAddr[STUDENT],students);
			saveData(tableAddr[PARENT_FOLDER_ADDR],tableAddr[SUBJECT],subjects);
			saveData(tableAddr[PARENT_FOLDER_ADDR],tableAddr[SCORE],scores);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	int lineCount(String parentAddr,String fileName) throws IOException{
		ezenFile = new File(parentAddr,fileName);
		fr = new FileReader(ezenFile);
		lnr = new LineNumberReader(fr);
		while(lnr.readLine()!=null);
		int lineCnt = lnr.getLineNumber();
		lnr.close();
		fr.close();
		return lineCnt;
	}
	<T> T[] loadData(Inputable<T> arr,int lineCnt) throws IOException {
		fr = new FileReader(ezenFile);
		br = new BufferedReader(fr);
		Inputable<T>[] tmp = castingExpandCapacity(arr, lineCnt);
		for(int i=0; i<lineCnt ; i++) {
			tmp[i] = (Inputable<T>)arr.getInstance(br.readLine().split(","));
		}
		fr = new FileReader(ezenFile);
		br = new BufferedReader(fr);
		return (T[])tmp;
	}
	void load() {
		try {
			int lineCnt = lineCount(tableAddr[PARENT_FOLDER_ADDR],tableAddr[STUDENT]);
			students = loadData(new Student(), lineCnt);
			lineCnt = lineCount(tableAddr[PARENT_FOLDER_ADDR],tableAddr[SUBJECT]);
			subjects = loadData(new Subject(), lineCnt);
			lineCnt = lineCount(tableAddr[PARENT_FOLDER_ADDR],tableAddr[SCORE]);
			scores = loadData(new Score(), lineCnt);
			} catch(IOException e) {
			e.printStackTrace();
		}
	}
	//////////////////////////////RUN
	<T> void run() {
		String[] savePoint = new String[3];
		while (true) {
			System.out.println("= = = = =Ezen= = = = =");
			System.out.println(" 1 > 추가 (학생,과목,성적)");
			System.out.println(" 2 > 삭제 (학생,과목)");
			System.out.println(" 3 > 정렬");
			System.out.println(" 4 > 출력");
			System.out.println(" 5 > 저장");
			System.out.println(" 6 > 로드");
			System.out.println("= = = = =Ezen= = = = =");
			int sel = sc.nextInt();
			if (sel == INSERT) {
				System.out.println(STUDENT + " > 학생 추가");
				System.out.println(SUBJECT + " > 과목 추가");
				System.out.println(SCORE + " > 점수 추가");
				int insertSel = sc.nextInt();
				if (insertSel == STUDENT) {// 학생 추가
					sc.nextLine();
					String str = reseiveData("학생명을 입력해주세요.");
					savePoint[STUDENT] = str;
					int ranID = this.getRandomID();
					students = update(new Student(ranID,str),false);
				} else if (insertSel == SUBJECT) {
					sc.nextLine();
					String str = reseiveData("과목명을 입력해주세요.");
					int idx = findIndexOf(subjects, str);
					if(idx==-1) {
						savePoint[SUBJECT] = str;
						int ranID = this.getRandomID();
						subjects = add(new Subject(ranID,str));
						printTable(subjects);
					}
					else {
						System.out.println("다시 확인해주세요.");
					}
				} else if (insertSel == SCORE) {
					sc.nextLine();
					System.out.println("학생명 : "+savePoint[STUDENT]);
					System.out.println("과목명 : "+savePoint[SUBJECT]);
					if(savePoint[STUDENT]!=null&&savePoint[SUBJECT]!=null) {
						int score = Integer.parseInt(reseiveData("점수를 입력해주세요."));
						scores = update(new Score(savePoint[STUDENT], savePoint[SUBJECT], score),true);
					}
					else {
						savePoint[STUDENT]=reseiveData("학생명을 입력해주세요.");
						savePoint[SUBJECT]=reseiveData("과목명을 입력해주세요.");
						int score = Integer.parseInt(reseiveData("점수를 입력해주세요."));
						int stuIdx = findIndexOf(this.students, new Student(0,savePoint[STUDENT]));
						int subIdx = findIndexOf(this.subjects, new Subject(0,savePoint[SUBJECT]));
						if(stuIdx==NOT_FIND||subIdx==NOT_FIND) {
							System.out.println("학생명이나 과목명을 다시 확인해주세요.");
						}
						else {
							scores = update(new Score(savePoint[STUDENT], savePoint[SUBJECT], score),true);
						}
					}
					savePoint = new String[3];//초기화
				}
			} // if end
			else if (sel == DELETE) {
				System.out.println(STUDENT + " > 학생 삭제");
				System.out.println(SUBJECT + " > 과목 삭제");
				int deleteSel = sc.nextInt();
				// 삭제
				sc.nextLine();
				if (deleteSel == STUDENT) {
					String str = reseiveData("학생명을 입력해주세요");
					deleteStudent(str);
				} else if (deleteSel == SUBJECT) {
					String str = reseiveData("과목명을 입력해주세요");
					deleteSubject(str); 
				}
			}
			else if (sel == SORTED) {//정렬
				System.out.println(STUDENT + " > 학생(이름) 정렬");
				System.out.println(SUBJECT + " > 과목(이름) 정렬");
				System.out.println(SCORE + " > 점수(성적) 정렬");
				int sort = sc.nextInt();
				System.out.println("1)오름차순    2)내림차순");
				int asc = sc.nextInt();
				boolean isASC = asc==1 ? true : false;
				Comparable<T>[] tmp = null;
				if(sort == STUDENT) {
					tmp = (Comparable<T>[]) students;
				}
				else if(sort == SUBJECT) {
					tmp = (Comparable<T>[]) subjects;
				}
				else if(sort == SCORE) {
					tmp = (Comparable<T>[]) scores;
				}
				sort(tmp, isASC);
				printTable(tmp);
			}
			else if (sel == PRINT) {
				System.out.println(STUDENT + " > 학생 출력");
				System.out.println(SUBJECT + " > 과목 출력");
				System.out.println(SCORE + " > 점수 출력");
				int choice = sc.nextInt();
				Comparable<T>[] tmp = null;
				if(choice == STUDENT) {
					tmp = (Comparable<T>[]) students;
				}
				else if(choice == SUBJECT) {
					tmp = (Comparable<T>[]) subjects;
				}
				else if(choice == SCORE) {
					tmp = (Comparable<T>[]) scores;
				}
				printTable(tmp);
			}
			else if (sel == SAVE) {
				save();
			}
			else if (sel == LOAD) {
				load();
			}
		}//while
	}// run() end
}