
import data.StudentManager;

import tools.MyUtil;

public class GradeProgram {

    public static void main(String[] args) {
        StudentManager mng = new StudentManager();
        Menu mainMnu = new Menu();
        mainMnu.add("Add new Student");
        mainMnu.add("Update Student");
        mainMnu.add("Add new Subject");
        mainMnu.add("Update Subject");
        mainMnu.add("Enter Grade");
        mainMnu.add("Student Grade Report");
        mainMnu.add("Subject Grade Report");
        mainMnu.add("Others- Quit");
        int choice1, choice2;

        do {
            System.out.println("1-Add new Student");
            System.out.println("2-Update Student");
            System.out.println("   2.1Update Student\n"
                    + "   2.2Delete Student");
            System.out.println("3-Add new Subject");
            System.out.println("4-Update Subject");
            System.out.println("   4.1Update Subject\n"
                    + "   4.2Delete Subject");
            System.out.println("5-Enter Grade");
            System.out.println("6-Student Grade Report");
            System.out.println("7-Subject Grade Report");
            System.out.println("0- Quit");
//            choice1 = mainMnu.getChoice();
            choice1 = MyUtil.getInt("Choose:", 0, 7);
            switch (choice1) {
                case 1:
                    do {
                        mng.addStudent();
                        choice1 = MyUtil.getInt("1.Continue to add new Student \n2.Exit", 1, 2);
                    } while (choice1 != 2);
                    break;
                case 2:
                    mng.updateStudent();
                    break;
                case 3:
                    do {
                        mng.addSubject();
                        choice1 = MyUtil.getInt("1.Continue to add new Subjects \n2.Exit", 1, 2);
                    } while (choice1 != 2);
                    break;
                case 4:
                    mng.updateSubject();
                    break;
                case 5:
                    mng.addGrade();
                    break;
                case 6:
                    mng.reportStudent();
                    break;
                case 7:
                    mng.reportSubject();
                    break;
            }
        } while (choice1 > 0 && choice1 < 8);
    }
}
