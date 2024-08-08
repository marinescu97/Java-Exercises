package Objects.Examen;

import java.util.ArrayList;

/**
 * Represents an exam.
 */
public class Exam {
    /**
     * A Course object.
     */
    private final Course course;
    /**
     * A Professor object.
     */
    private final Professor professor;
    /**
     * A list of students.
     */
    private final ArrayList<Student> students;

    /**
     * Constructs a new exam.
     * @param course the course
     * @param professor the professor
     * @param students the students
     */
    Exam(Course course, Professor professor, ArrayList<Student> students) {
        this.course = course;
        this.professor = professor;
        this.students = students;
    }

    /**
     * Gets the exam's course.
     * @return the exam's course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Gets the exam's professor.
     * @return the exam's professor
     */
    public Professor getProfessor(){
        return professor;
    }

    /**
     * Gets the list of students.
     * @return the list of students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Gets the mean of the students' grades.
     * @return the mean of the students' grades
     */
    public double getGradesMean(){
        double sum = 0;
        for (int i=0;i<getStudents().size();i++){
            sum+=getStudents().get(i).getGrade();
        }
        double avg = sum/getStudents().size();
        return (double) Math.round(avg * 1000) / 1000;
    }

    /**
     * Gets the maximum grade.
     * @return the maximum grade
     */
    public double getMaxGrade(){
        double maxGrade = getStudents().get(0).getGrade();
        for (int i=0; i<getStudents().size(); i++){
            if (getStudents().get(i).getGrade()>maxGrade){
                maxGrade = getStudents().get(i).getGrade();
            }
        }
        return maxGrade;
    }

    /**
     * Gets the minimum grade.
     * @return the minimum grade
     */
    public double getMinGrade(){
        double minGrade = getStudents().get(0).getGrade();
        for (int i=0; i<getStudents().size(); i++){
            if (getStudents().get(i).getGrade()<minGrade){
                minGrade = getStudents().get(i).getGrade();
            }
        }
        return minGrade;
    }

    /**
     * Gets the students with the maximum grade.
     * @return the students with the maximum grade
     */
    public ArrayList<Student> getStudentsMaxGrade(){
        ArrayList<Student> stMaxGrade = new ArrayList<>();
        for (int i=0; i<getStudents().size();i++){
            if (getStudents().get(i).getGrade() == getMaxGrade()){
                stMaxGrade.add(getStudents().get(i));
            }
        }
        return stMaxGrade;
    }

    /**
     * Gets the students with minimum grade.
     * @return the students with minimum grade
     */
    public ArrayList<Student> getStudentsMinGrade(){
        ArrayList<Student> stMinGrade = new ArrayList<>();
        for (int i=0; i<getStudents().size();i++){
            if (getStudents().get(i).getGrade() == getMinGrade()){
                stMinGrade.add(getStudents().get(i));
            }
        }
        return stMinGrade;
    }

    /**
     * Orders the students in descending order by their grade.
     */
    public void ordering(){
        boolean flag = true;
        double temp;
        while(flag){
            flag=false;
            for (int i=0; i<getStudents().size()-1;i++){
                if (getStudents().get(i).getGrade()<getStudents().get(i+1).getGrade()){
                    temp=getStudents().get(i).getGrade();
                    getStudents().get(i).setGrade(getStudents().get(i+1).getGrade());
                    getStudents().get(i+1).setGrade(temp);
                    flag=true;
                }
            }
        }
    }

    /**
     * Displays the students.
     * @param students the students to display
     */
    public void displayStudents(ArrayList<Student> students){
        for (Student student : students) {
            student.display();
        }
    }

    /**
     * Displays the exam information.
     */
    public void displayExam(){
        System.out.println("Course: " + getCourse().getName() + "\n" +
                            "Professor: " + getProfessor().getName() + "\n" +
                            "Students: ");
        displayStudents(getStudents());
        System.out.println("Grade average: " + getGradesMean() + "\n" +
                            "Maximum grade: " + getMaxGrade() + "\n" +
                            "Minimum grade: " + getMinGrade() + "\n" +
                            "Students with minimum grade: ");
        displayStudents(getStudentsMinGrade());
        System.out.println("Students with maximum grade: ");
        displayStudents(getStudentsMaxGrade());
    }

}

class Test {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 7.8);
        Student student2 = new Student("Bob", 5.9);
        Student student3 = new Student("Carol", 8);
        Student student4 = new Student("Dave", 7.4);

        Course course = new Course("Web design");
        Professor professor = new Professor("James Wilson");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        Exam exam = new Exam(course, professor, students);
        exam.ordering();
        exam.displayExam();
    }
}
