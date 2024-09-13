class Student {
    private String name;
    private int age;
    private Student[] students;
    private int studentCount = 0;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
        this.students = new Student[5]; // we can make the array dynamic
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount] = student;
            studentCount++;
        } else {
            System.out.println("List is full.");
        }
    }

    public String getStudent(Student student) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i] == student) {
                return "Name: " + students[i].getName() + ", Age: " + students[i].getAge();
            }
        }
        return null;
    }

    public void getAllStudents() {
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Name: " + students[i].getName() + ", Age: " + students[i].getAge());
        }
    }

    public void updateStudent(Student oldStudent, Student newStudent) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].equals(oldStudent)) {
                students[i] = newStudent;
                break;
            }
        }
    }

    public void deleteStudent(Student student) {
        int studentIndex = 0;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].equals(student)) {
                studentIndex = i;
                break;
            }
        }

        for (int i = studentIndex; i < studentCount - 1; i++) {
            students[i] = students[i + 1];
        }
        studentCount--;
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student std1 = new Student("John", 23);
        Student std2 = new Student("Smith", 54);
        Student std3 = new Student("David", 39);

        Student mng = new Student();

        // add student
        mng.addStudent(std1);
        mng.addStudent(std2);
        mng.addStudent(std3);
        mng.addStudent(new Student("Joe", 32));

        // get all students
        mng.getAllStudents();

        // get specific student
        String getStudent = mng.getStudent(std1);
        System.out.println(getStudent);

        // update student
        Student updatedStd1 = new Student("John Doe", 23);
        mng.updateStudent(std1, updatedStd1);

        System.out.println("After update:");
        mng.getAllStudents();

        // delete student
        mng.deleteStudent(std2);

        System.out.println("After delete:");
        mng.getAllStudents();
    }
}