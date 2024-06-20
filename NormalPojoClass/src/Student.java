
public class Student {

	private int studentId;
	private String studentName;
	private double studentFee;
	private long studentPhno;
	private int  studentClass;
	Student(){
		System.out.println("Student is created");
	}
	Student(int id,String name,double fee,long phno,int sclass){
		studentId=id;
		studentName=name;
		studentFee=fee;
		studentPhno=phno;
		studentClass=sclass;
		System.out.println("student parameter constructor is created");
	}
	public String toString() {
		return studentId+" "+studentName+" "+studentFee+" "+studentPhno+" "+studentClass;
	}
	public static void main(String args[]) {
		Student student1=new Student(101,"sai",3000,1234567891,5);
		System.out.println(student1);
		Student  student2=new StudentBuilder().id(102).name("pavan").fee(4000).sclass(4).phno(1239876541).getStudent();
		
		System.out.println(student2);
		Student.StudentBuilder s=new Student.StudentBuilder();
		Student student3=s.id(202).fee(4003).getStudent();
		System.out.println(student3);
		
	}
	public static  class StudentBuilder{
		private int studentId;
		private String studentName;
		private double studentFee;
		private long studentPhno;
		private int  studentClass;
			public StudentBuilder id(int id) {
				this.studentId=id;
				return this;
			}
			public StudentBuilder name(String name) {
				this.studentName=name;
				return this;
			}
			public StudentBuilder fee(double fee) {
				this.studentFee=fee;
				return this;
			}
			public StudentBuilder phno(long phno) {
				this.studentPhno=phno;
				return this;
			}
			public StudentBuilder sclass(int sclass) {
				this.studentClass=sclass;
				return this;
			}
			public Student getStudent() {
				return new Student(studentId,studentName,studentFee,studentPhno,studentClass);
			}
	}
}
