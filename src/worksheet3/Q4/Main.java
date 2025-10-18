package worksheet3.Q4;

public class Main {
    public static void main(String[] args) {
        Lecturer lecturer = new Lecturer();
        lecturer.setLecturerName("Kesavan Selvarajah");
        lecturer.setCourseTeaching("Object oriented programming 1");

        Course course1 = new Course();
        course1.setCourseCode("CS21042");
        course1.setCourseName("Software Engineering");
        course1.setLecturer(lecturer);

        Student student1 = new Student();
        student1.setStudentName("K.H.P.Thejana");
        student1.setDegreeName("Bsc.(Hours) in Computer Science");
        student1.setCourseFollowing(course1.getCourseName());

        //Print details
        System.out.println("\n\n___________University Course Registration System___________");
        System.out.println("===========================================================");
        System.out.println(" \t\t\t\t--Lecturer Details--");
        System.out.println("Lecture Name \t\t:\t " + lecturer.getLecturerName());
        System.out.println("Course Name \t\t:\t " + lecturer.getCourseTeaching());

        System.out.println("___________________________________________________________");
        System.out.println(" \t\t\t\t--Course Details--");
        System.out.println("Course Code \t\t:\t " + course1.getCourseCode());
        System.out.println("Course Name \t\t:\t " + course1.getCourseName());
        System.out.println("Lecturer for this Course : " + course1.getLecturer().getLecturerName());

        System.out.println("___________________________________________________________");
        System.out.println(" \t\t\t\t--Student Details--");
        System.out.println("Student Name \t\t:\t " + student1.getStudentName());
        System.out.println("Degree Name \t\t:\t " + student1.getDegreeName());
        System.out.println("Course Enrolled \t:\t " + student1.getCourseFollowing());

        System.out.println("===========================================================");


    }
}
