import java.util.ArrayList;

class Student{
    String name;
    int marks;
    Student(String name ,int marks){
        this.name=name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }
    public int compareTo(Student other) {
        // Compare students based on their marks
        return Integer.compare(this.marks, other.marks);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + '}';
    }
}
public class StudentExample {
    public static void main(String[] args) {
        Student st1 = new Student("A Uday",94);
        Student st2 = new Student("A Rahul",44);
        Student st3 = new Student("B Mahesh",64);
        Student st4 = new Student("G SaiKrishna",94);
        Student st5 = new Student("G ShivaRamaKrishna",44);
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);
//        studentInsertionSort(studentList);
        studentSelectionSort(studentList);
        // Print the sorted studentList
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
    public static void studentSelectionSort(ArrayList<Student> students) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students.get(j).compareTo(students.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the elements at i and minIndex
            Student temp = students.get(minIndex);
            students.set(minIndex, students.get(i));
            students.set(i, temp);
        }
    }
    public static void insertionSort(ArrayList<Student> students) {
        int n = students.size();
        for (int i = 1; i < n; i++) {
            Student key = students.get(i);
            int j = i - 1;

            // Move elements of students[0..i-1], that are greater than key.marks, to one position ahead of their current position
            while (j >= 0 && students.get(j).compareTo(key) > 0) { //(x=j,y=key)
                students.set(j + 1, students.get(j));
                j = j - 1;
            }
            students.set(j + 1, key);
        }
    }
}
