package mini;

import java.io.*;
import java.util.*;

public class SchoolTable {
	public static void main(String[] args) {
		Ezen aa = new Ezen("C:/Users/yousd/Desktop/Ezen");
		aa.run();
	}
}

interface checkOverLapable {
	boolean compareTo(Object obj);
}
interface savable {
	String getInfo();
}
class Student implements checkOverLapable,savable{
	int id;
	String name;

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("학생번호:%4d 학생명:%4s\n", id, name);
	}

	@Override
	public boolean compareTo(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		}
		if (obj instanceof Student) {
			Student tmp = (Student) obj;
			return this.name.equals(tmp.name);
		}
		return false;
	}
	public int compareTo(String name) {
		return this.name.compareTo(name);
	}
	public int compareTo(int id) {
		return this.id - id ;
	}
	public String getInfo() {
		return String.format("%d,%s",id,name);
	}
}

class Subject implements checkOverLapable,savable{
	int subjectID;
	String subjectName;

	Subject(int subjectID, String subjectName) {
		this.subjectID = subjectID;
		this.subjectName = subjectName;
	}
	
	@Override
	public String toString() {
		return String.format("과목번호:%4d 과목명:%4s\n", subjectID, subjectName);
	}

	@Override
	public boolean compareTo(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		}
		if (obj instanceof Subject) {
			Subject tmp = (Subject) obj;
			return this.subjectName.equals(tmp.subjectName);
		}
		return false;
	}
	public int compareTo(String name) {
		return this.subjectName.compareTo(name);
	}
	public int compareTo(int id) {
		return this.subjectID - id ;
	}
	public String getInfo() {
		return String.format("%d,%s",subjectID,subjectName);
	}
}

class Grade implements checkOverLapable,savable{
	String studentName;
	String subjectName;
	int score;

	Grade(Student student, Subject subject, int score) {
		this.studentName = student.name;
		this.subjectName = subject.subjectName;
		this.score = score;
	}
	Grade(String studentName, String subjectName, int score){
		this.studentName = studentName;
		this.subjectName = subjectName;
		this.score = score;
	}
	@Override
	public String toString() {
		return String.format("이름:%4s 과목:%3s %3d점\n", studentName, subjectName, score);
	}

	@Override
	public boolean compareTo(Object obj) {
		System.out.println("진입 1!");
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		}
		if (obj instanceof Grade) {
			Grade tmp = (Grade) obj;
			return this.subjectName.equals(tmp.subjectName) && this.studentName.equals(tmp.studentName);
		} else if (obj instanceof Student) {
			System.out.println("진입");
			return this.studentName.equals(((Student) obj).name);
		} else if (obj instanceof Subject) {
			return this.subjectName.equals(((Subject) obj).subjectName);
		}
		return false;
	}
	public int compareTo(Grade grade) {
		if(this.score - grade.score>0)
			return 1;
		else if(this.score - grade.score<0)
			return -1;
		else
			return 0;
	}
	public int compareTo(Student student) {
		return this.studentName.compareTo(student.name);
	}
	public int compareTo(Subject subject) {
		return this.subjectName.compareTo(subject.subjectName);
	}
	public String getInfo() {
		return String.format("%s,%s,%d",studentName,subjectName,score);
	}
}
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
	
	Student[] students;
	Subject[] subjects;
	Grade[] grades;
	File ezenFile;
	String parentFolderAddr;
	String[] table;
	
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();

	Ezen(String parentFolderAddr) {
		this.students = new Student[0];
		this.subjects = new Subject[0];
		this.grades = new Grade[0];
		this.table = new String[4];
		this.parentFolderAddr = parentFolderAddr;
		tableInit();
		loadEzen();
		Ezen.no++;
		
	}
	void tableInit() {
		this.table[0] = parentFolderAddr;
		this.table[STUDENT] = "student"+no+".txt";
		this.table[SUBJECT] = "subject"+no+".txt";
		this.table[SCORE] = "score"+no+".txt";
	}

	String inputMessage(String message) {
		System.out.println(message);
		String str = sc.nextLine().replace(" ", "");
		return str;
	}
	
	void sortedInfo(Student[] stu,boolean isASC) {
		Student max = null;
		int maxIdx = 0;
		int sortStand = isASC ? 1 : -1;
		for(int i=0 ; i<stu.length ; i++) {
			max = stu[i];
			maxIdx = i;
			for(int j=i-1 ; j>=0 ; j--) {
				int sort = max.compareTo(stu[j].name)*sortStand;
				if(sort>0) {
					stu[j+1]=stu[j];
					maxIdx = j;
				}
				stu[maxIdx]=max;
			}
		}
	}

	int findNameCnt(checkOverLapable[] obj, Object findObject) {
		int cnt = 0;
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] != null && obj[i].compareTo(findObject)) {
				System.out.println(i);
				cnt++;
			}
		}
		return cnt;
	}

	int findNameIdx(checkOverLapable[] obj, Object findObject) {
		int Idx = -1;
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] != null && obj[i].compareTo(findObject)) {
				System.out.println(i);
				Idx = i;
			}
		}
		return Idx;
	}

	// 배열에서 없는 숫자 만드는 메서드
	int makeRandomPrimaryKey(int range, checkOverLapable[] obj) {
		if (range <= 0) {
			return -1;
		}
		// 랜덤번호 생성
		int ranID = 0;// ranID = ran.nextInt(9999);
		for (int i = 0; i < 1; i++) {
			ranID = ran.nextInt(range);
			if (obj.length > 1) {
				for (int j = 0; j < obj.length; j++) {
					if (isCheckID(ranID, j, obj))
						i--;
				}
			}
		}
		return ranID;
	}

	boolean isCheckID(int newID, int idx, checkOverLapable[] obj) {
		return obj[idx].compareTo(newID);
	}

	boolean isCheckRange(String name, int range) {
		return range <= 0 || name.length() == 0;
	}

	// 배열 추가
	void addStudent(String name, int range) {
		int findCnt = findNameCnt(students, new Student(0, name));
		if (findCnt > 0 || name.length() == 0) {
			System.out.println("다시 확인해주세요.");
		}
		else {
			if (isCheckRange(name, range)) {
				System.err.println("문자의 길이나 범위를 확인해주세요.");
			} else {
				// 학생 추가
				Student[] tmp = new Student[students.length + 1];
				if (tmp.length > 1) {
					for (int i = 0; i < students.length; i++) {
						tmp[i] = students[i];
					}
				}
				// 랜덤번호 생성
				System.out.println("삭제후 학생 : " + students.length);
				int ranID = makeRandomPrimaryKey(range, students);
				tmp[students.length] = new Student(ranID, name);
				students = tmp;
			}
		}
	}

	// 과목추가
	void addSubject(String name, int range) {
		int findCnt = findNameCnt(subjects, new Subject(0, name));
		if (findCnt > 0 || name.length() == 0) {
			System.out.println("중복입니다.");
		}
		else{
			if (isCheckRange(name, range)) {
				System.err.println("문자의 길이나 범위를 확인해주세요.");
			} else {
				// 과목 추가
				Subject[] tmp = new Subject[subjects.length + 1];
				for (int i = 0; i < subjects.length; i++) {
					tmp[i] = subjects[i];
				}
				// 랜덤번호 생성
				int ranID = makeRandomPrimaryKey(range, subjects);
				tmp[subjects.length] = new Subject(ranID, name);
				subjects = tmp;
			}
		}
	}

	// 점수추가
	void addScore(String studentName, String subjectNmae, int score) {
		int stuIdx = findNameIdx(students, new Student(0, studentName));
		// 과목이 있는지
		int subIdx = findNameIdx(subjects, new Subject(0, subjectNmae));
		System.out.println(stuIdx + ":" + subIdx);
		if (stuIdx >= 0 && subIdx >= 0) {// 둘다 있는경우
			// 이미 있는지 확인
			Student testStudent = students[stuIdx];
			Subject testSubject = subjects[subIdx];
			int Idx = findNameIdx(grades, new Grade(testStudent, testSubject, score));
			if (Idx == -1) {// 새 점수 추가.
				Grade[] tmp = new Grade[grades.length + 1];
				for (int i = 0; i < grades.length; i++) {
					tmp[i] = grades[i];
				}
				tmp[grades.length] = new Grade(testStudent, testSubject, score);
				grades = tmp;
			} else {
				grades[Idx] = new Grade(testStudent, testSubject, score);
			}
			System.out.println(Arrays.toString(grades));
		} else {
			System.out.println("학생명이나 과목명을 다시 확인해주세요.");
		}
	}

	void deleteScore(checkOverLapable obj) {
		if (obj instanceof Student) {
			deleteStudentScores(((Student) obj).name);
		} else if (obj instanceof Subject) {
			deleteSubjectScores(((Subject) obj).subjectName);
		} else {
			System.out.println("학생,과목만 들어올수 있습니다.");
		}
	}

	void ReduceScoresOfNull(int delCnt) {
		// 새 배열
		int tmpIdx = 0;
		Grade[] tmp = new Grade[grades.length - delCnt];
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] != null) {
				tmp[tmpIdx++] = grades[i];
			}
		}
		grades = tmp;
	}

	void deleteStudentScores(String studentName) {
		int delCnt = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i].studentName.equals(studentName)) {
				delCnt++;
				grades[i] = null;
			}
		}
		if(delCnt>0) ReduceScoresOfNull(delCnt);
		else System.out.println("해당 정보가 없습니다.");
	}

	void deleteSubjectScores(String subjectName) {
		int delCnt = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i].subjectName.equals(subjectName)) {
				delCnt++;
				grades[i] = null;
			}
		}
		if(delCnt>0) ReduceScoresOfNull(delCnt);
		else System.out.println("해당 정보가 없습니다.");
	}
	
	// 학생삭제
	boolean deleteData(checkOverLapable[] arr, Object deleteDate) {
		int idx = findNameIdx(arr, deleteDate);
		if(idx==-1) {
			System.out.println("해당 정보가 없습니다.");
			return false;
		}
		arr[idx] = null;
		int tmpIdx = 0;
		checkOverLapable[] tmp = new Student[0];
		if (arr instanceof Student[]) {
			tmp = new Student[arr.length - 1];
		} else if (arr instanceof Subject[]) {
			tmp = new Subject[arr.length - 1];
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				tmp[tmpIdx++] = arr[i];
			}
		}
		if (arr instanceof Student[]) {
			students = (Student[]) tmp;
		} else if (arr instanceof Subject[]) {
			subjects = (Subject[]) tmp;
		}
		System.out.println("데이터가 삭제되었습니다.");
		return true;
	}
	void printTableInfo(checkOverLapable[] tables) {
		for (int i = 0; i < tables.length; i++) {
			System.out.println(tables[i]);
		}
	}
	void writeInfoToTable(savable[] saves,int tableNum,String fileName) throws IOException{
		//파일
		final int PARENT = 0;
		ezenFile = new File(table[PARENT],table[tableNum]);
		FileWriter fw = new FileWriter(ezenFile);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=0; i<saves.length ; i++) {
			bw.write(saves[i].getInfo());
			if(i<saves.length-1)
				bw.write("\n");
		}
		bw.close();
		fw.close();
	}
	void saveEzenTable() {
		try {
			mkdirParentFolder();
			//학생 파일
			writeInfoToTable(students,STUDENT,table[STUDENT]);
			//과목 파일
			writeInfoToTable(subjects,SUBJECT,table[SUBJECT]);
			//성적 파일
			writeInfoToTable(grades,SCORE,table[SCORE]);
			System.out.println("저장성공");
		}catch (IOException e) {
			System.out.println("저장실패");
			e.printStackTrace();
		}
	}
	int lineCount(String parant,String fileName) throws IOException{
		ezenFile=new File(parant,fileName);
		FileReader fr = new FileReader(ezenFile);
		LineNumberReader lnr = new LineNumberReader(fr);
		while(lnr.readLine()!=null);
		int accountIdx = lnr.getLineNumber();
		lnr.close();
		fr.close();
		return accountIdx;
	}
	
	void loadStudent() throws IOException {
		int accountIdx = lineCount(this.table[0],this.table[STUDENT]);
		FileReader fr = new FileReader(this.ezenFile);
		BufferedReader br = new BufferedReader(fr);
		this.students = new Student[accountIdx];
		String[] initArr = new String[0];
		while(accountIdx>0) {
			int idx = this.students.length-accountIdx;
			initArr = br.readLine().split(",");
			this.students[idx]=new Student(Integer.parseInt(initArr[0]),initArr[1]);
			accountIdx--;
		}
		br.close();
		fr.close();
	}
	void loadSubject() throws IOException {
		int accountIdx = lineCount(this.table[0],this.table[SUBJECT]);
		FileReader fr = new FileReader(this.ezenFile);
		BufferedReader br = new BufferedReader(fr);
		this.subjects = new Subject[accountIdx];
		String[] initArr = new String[0];
		while(accountIdx>0) {
			int idx = this.subjects.length-accountIdx;
			initArr = br.readLine().split(",");
			this.subjects[idx]=new Subject(Integer.parseInt(initArr[0]),initArr[1]);
			accountIdx--;
		}
		br.close();
		fr.close();
	}
	void loadGrade() throws IOException {
		int accountIdx = lineCount(table[0],table[SCORE]);
		FileReader fr = new FileReader(ezenFile);
		BufferedReader br = new BufferedReader(fr);
		grades = new Grade[accountIdx];
		String[] initArr = new String[0];
		while(accountIdx>0) {
			int idx = grades.length-accountIdx;
			initArr = br.readLine().split(",");
			grades[idx]=new Grade(initArr[0],initArr[1],Integer.parseInt(initArr[2]));
			accountIdx--;
		}
		br.close();
		fr.close();
	}
	void mkdirParentFolder() {
		ezenFile = new File(table[0]);
		if(!ezenFile.exists()) ezenFile.mkdirs();
	}
	void loadEzen() {
		try{
			
			loadStudent();
			loadSubject();
			loadGrade();
			System.out.println("읽기 성공");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("읽기 실패");
		}
	}
	void run() {
		while (true) {
			// menu print
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
					String studentName = inputMessage("학생이름을 입력해주세요.");
					// 이름 중복검사
					addStudent(studentName, 9999);
					printTableInfo(students);
				} else if (insertSel == SUBJECT) {
					sc.nextLine();
					String subjectName = inputMessage("과목명을 입력해주세요.");
					// 이름 중복검사
					addSubject(subjectName, 9999);
					printTableInfo(subjects);
				} else if (insertSel == SCORE) {
					sc.nextLine();
					int scoreTable = 0;
					String[] contents = { "학생명", "과목명", "성적" };
					for (int i = 0; i < contents.length; i++) {
						contents[i] = inputMessage(contents[i] + "을 입력해주세요.");
					}
					scoreTable = Integer.parseInt(contents[2]);
					addScore(contents[STUDENT - 1], contents[SUBJECT - 1], scoreTable);
				}
			} // if end
			else if (sel == DELETE) {
				System.out.println(STUDENT + " > 학생 삭제");
				System.out.println(SUBJECT + " > 과목 삭제");
				int deleteSel = sc.nextInt();
				// 삭제
				if (deleteSel == STUDENT) {
					sc.nextLine();
					String name = inputMessage("학생명을 입력해주세요.");
					deleteScore(new Student(0, name));
					deleteData(students, new Student(0, name));
				} else if (deleteSel == SUBJECT) {
					sc.nextLine();
					String name = inputMessage("과목명을 입력해주세요.");
					deleteScore(new Student(0, name));
					deleteData(subjects, new Subject(0, name));
				}
			}
			else if (sel == SORTED) {//정렬
				//정렬기준 입력
				//정렬 방법
				sortedInfo(students,false);
				printTableInfo(students);
			}
			else if (sel == PRINT) {
				System.out.println(STUDENT + " > 학생 ");
				System.out.println(SUBJECT + " > 과목 ");
				System.out.println(SCORE + " > 점수 ");
				int printSel = sc.nextInt();
				if(printSel==STUDENT) {
					printTableInfo(students);
				}
				else if(printSel==SUBJECT) {
					printTableInfo(subjects);
				}
				else if(printSel==SCORE) {
					printTableInfo(grades);
				}
			}
			else if (sel == SAVE) {
				saveEzenTable();
			}
			else if (sel == LOAD) {
				loadEzen();
			}
		}//while
	}// run() end

}
