package collection;

public class ArrayListSelf {
	public static void main(String[] args) {
		
//		private void sortByStudentName() {
//			// this.list 
//			for(int i=0; i<this.list.size(); i++) {
//				Student first = this.list.get(i);
//				for(int j=i; j<this.list.size(); j++) {
//					Student last = this.list.get(j);
//					if(first.getName().compareTo(last.getName()) > 0) {
//						this.list.set(i, last);		// ArrayList 의 값 수정 set() 
//						this.list.set(j, first);
//					}
//				}
//			}
//		}
		
		
//		private String createData() {
//			// 학번/이름,수강과목1/성적1,수강과목2/성적2... 
//			String data = "";
//			for(int i=0; i<this.list.size(); i++) {
//				Student student = this.list.get(i);
//				data += student.getNumber() + "/";
//				data += student.getName();
//				
//				// 과목 
//				for(int j=0; j<student.getSubjectsSize(); j++) {
//					Subject subject = student.getSubject(j);
//					String title = subject.getTitle();
//					int score = subject.getScore();
//					
//					data += ",";
//					data += title + "/" + score;
//				}
//				
//				if(i < this.list.size() -1)
//					data += "\n";
//			}
//			return data;
//		}
		
		
//		void saveFiles(ArrayList<Student> stu) {
//			FileManager.this.save = "";
//			try {
//				this.fw = new FileWriter(file);
//				this.bw = new BufferedWriter(fw);
//				stu.forEach(new Consumer<Student>() {
//					@Override
//					public void accept(Student stu) {
//						FileManager.this.save+=stu.getData();
//						ArrayList<Subject> tmp = stu.getSubjects();
//						if(!tmp.isEmpty()) {
//							tmp.forEach(new Consumer<Subject>() {
//								@Override
//								public void accept(Subject sub) {
//									FileManager.this.save+="/"+sub.getData();
//								}
//							});
//						}
//						FileManager.this.save+="\n";
//					}
//				});
		
	}
}
