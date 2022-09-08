package data;

import data.Student;
import data.Student;
import data.StudentList;
import data.Subject;
import data.Subject;
import data.SubjectList;
import data.Transcript;
import data.Transcript;
import data.TranscriptList;
import data.TranscriptList;
import java.util.Date;
import java.util.Scanner;
import tools.MyUtil;
import static tools.MyUtil.EMAIL;
import static tools.MyUtil.readDMY;
import static tools.MyUtil.readPattern;
import static tools.MyUtil.strDMY;
import static tools.MyUtil.strMDY;

public class StudentManager {

    SubjectList subList;
    StudentList stList;
    TranscriptList trList;

    public StudentManager() {
        subList = new SubjectList();
        stList = new StudentList();
        trList = new TranscriptList();
    }

    public void addSubject() {
        String subID;
        int pos;
        do {
            subID = (String) MyUtil.readNonBlankStr("Subject ID").toUpperCase();
            pos = subList.indexOf(new Subject(subID));
            if (pos >= 0) {
                System.out.println("ID duplicate!");
            }
        } while (pos >= 0);
        String name = MyUtil.readNonBlankStr("Subject name").toUpperCase();
        int credit = MyUtil.getInt("credit", 1, 10);
        Subject sb = new Subject(subID, name, credit);
        subList.add(sb);
        System.out.println("A subject was added.");

    }

    public void updateSubject() {
        String subID;
        Scanner sc = new Scanner(System.in);
        subID = MyUtil.readNonBlankStr("Subject ID").toUpperCase();
        int pos = subList.indexOf(new Subject(subID));
        do {
            if (pos < 0) {
                System.out.println("ID does not exist");
            } else {
                System.out.println("1.Update Subject");
                System.out.println("2.Delete Subject");
                System.out.println("3.Exit");
                int x = sc.nextInt();
                switch (x) {
                    case 1:
                        //nếu không nhập giá trị sẽ để nguyên giá trị
                        String se = MyUtil.updateString("Subject ID", subList.get(pos).getSubID()).toUpperCase();
                        subList.get(pos).setSubID(se);
                        String name = MyUtil.updateString("Subject name:", subList.get(pos).getSubName()).toUpperCase();
                        subList.get(pos).setSubName(name);
                        int credit = MyUtil.updateInt("credit repair:", 1, 10, subList.get(pos).getCredit());
                        subList.get(pos).setCredit(credit);
                        System.out.println("DONE!");
                        pos = -1;
                        break;
                    case 2:
                        int a = MyUtil.getInt("Are you sure delete this Subject?[1.yes/2.no]", 1, 2);
                        if (a == 1) {
                            if (trList.containsSubject(subID)) {
                                System.out.println("Deployed.It can not be removed!");
                            } else {
                                subList.remove(pos);

                                System.out.println("DONE!");
                            }
                        } else {
                            System.out.println("Cancel successfully!");
                        }
                        pos = -1;
                        break;
                }
            }

        } while (pos > 0);
    }

    public void deleteSubject() {
        // xóa theo cách của thầy
        String subID;
        subID = MyUtil.readNonBlankStr("sub ID will be remove").toUpperCase();
        if (trList.containsSubject(subID)) {
            System.out.println("Deployed.It can not be removed!");
        } else {
            int pos = subList.indexOf(new Subject(subID));
            subList.remove(pos);

            System.out.println("DONE!");
        }
    }
//  thêm sinh viên

    public void addStudent() {
        String stID;
        int pos;
        do {
            stID = (String) MyUtil.readNonBlankStr("Student ID").toUpperCase();
            pos = stList.indexOf(new Student(stID));
            if (pos >= 0) {
                System.out.println("ID duplicate!");
            }
        } while (pos >= 0);
        String fName = MyUtil.readNonBlankStr("Student first name").toUpperCase();
        String lName = MyUtil.readNonBlankStr("Student last name").toUpperCase();
        int x = MyUtil.getInt("Select Gender[1.Male/2.Female]:", 1, 2);
        boolean c;
        if (x == 1) {
            c = true;
        } else {
            c = false;
        }
        Date d = readDMY("Date of Birth");
        String mail = readPattern("Email", EMAIL);
        String phone = readPattern("Phone number", MyUtil.phone);

        Student st = new Student(stID, fName, lName, c, d, mail, phone);
        stList.add(st);
        System.out.println("Done!");

    }

    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        String stID;
        int pos;
        do {
            stID = (String) MyUtil.readNonBlankStr("Subject ID").toUpperCase();
            pos = stList.indexOf(new Student(stID));
            if (pos < 0) {
                System.out.println("Student does not exist!");
            } else {
                System.out.println("1.Update Student");
                System.out.println("2.Delete Student");
                System.out.print("3.Exit");
                int x = MyUtil.getInt("", 1, 3);
                switch (x) {
                    case 1:
                        String fName = MyUtil.updateString("Student first name", stList.get(pos).getfName()).toUpperCase();
                        stList.get(pos).setfName(fName);
                        String lName = MyUtil.updateString("Student last name", stList.get(pos).getlName()).toUpperCase();
                        stList.get(pos).setlName(lName);
                        System.out.print("Select Gender[1.Male/2.Female]:");

                        String Gender = sc.nextLine().toUpperCase();
                        if (!Gender.isEmpty()) {
                            if (Gender.equals("T") || Gender.equals("Y") || Gender.equals("1")) {
                                stList.get(pos).setGender(true);
                            } else {
                                stList.get(pos).setGender(false);
                            }
                        }
                        Date d = MyUtil.updatereadDMY("Date of Birth", stList.get(pos).getbDate());
                        stList.get(pos).setbDate(d);
                        String mail = MyUtil.updatereadPattern("Email", EMAIL, stList.get(pos).getEmail());
                        stList.get(pos).setEmail(mail);
                        String phone = MyUtil.updatereadPattern("phone", MyUtil.phone, stList.get(pos).getPhone());
                        stList.get(pos).setEmail(phone);
                        System.out.println("DONE!");
                        pos = -1;
                        break;
                    case 2:

                        int a = MyUtil.getInt("Are you sure delete this student?[1.yes/2.no]", 1, 2);
                        if (a == 1) {
                            if (trList.containsStudent(stID)) {
                                System.out.println("Deployed.It can not be removed!");
                            } else {
                                stList.remove(pos);
                                System.out.println("DONE!");
                            }
                        } else {
                            System.out.println("Cancel successfully!");
                        }
                        pos = -1;
                        break;
                }
            }
        } while (pos > 0);

    }

    public void deleteStudent() {
        String stID;
        do {
            stID = MyUtil.readNonBlankStr("sub ID will be remove").toUpperCase();
            int pos = stList.indexOf(new Student(stID));

            if (pos < 0) {
                System.out.println("Student does not exist");
            } else {
                boolean x = MyUtil.readBoolyesno("Are you sure delete this student?");
                if (x) {
                    stList.remove(pos);
                    System.out.println("DONE!");
                }
            }

        } while (stList.indexOf(new Student(stID)) > 0);
    }

    public void addGrade() {
        String stID, subID;
        Student st = null;
        Subject sub = null;
        int pos;
        int x = 0;
       
        do {
            stID = (String) MyUtil.readNonBlankStr("Student ID").toUpperCase();
            pos = stList.indexOf(new Student(stID));
            if (pos < 0) {//không có sinh viên
                System.out.println("Student does not exist!");
                x = MyUtil.getInt("Do you want to find it again?[1.YES/2.NO]", 1, 2);
            } else {
                st = stList.get(pos);//có sinh viên
                do {
                    subID = (String) MyUtil.readNonBlankStr("Subject ID").toUpperCase();
                    pos = subList.indexOf(new Subject(subID));
                    if (pos < 0) {//không có mon hoc
                        System.out.println("Subject does not exist!");
                        x = MyUtil.getInt("Do you want to find it again?[1.YES/2.NO]", 1, 2);
                    } else {
                        sub = subList.get(pos);//có mon hoc
                    
                    int poss = trList.indexOf(new Transcript(sub, st));

                    if (poss < 0) {
                        // them bang diem moi
                        double lap = MyUtil.getdouble("Import Labs(1-10):", 0, 10);
                        double test = MyUtil.getdouble("Import Progress tests(1-10):", 0, 10);
                        double fina = MyUtil.getdouble("Import Final exam(1-10):", 0, 10);
                        Transcript t = new Transcript(sub, st, lap, test, fina);
                        trList.add(t);
                        x=2;

                    } else {
//                    sửa điểm
                        int a = MyUtil.getInt("Do you want to override it?[1.YES/2.NO]:", 1, 2);
                        if (a == 1) {
                            double lap = MyUtil.getdouble("Import Labs(1-10):", 0, 10);
                            double test = MyUtil.getdouble("Import Progress tests(1-10):", 0, 10);
                            double fina = MyUtil.getdouble("Import Final exam(1-10):", 0, 10);
                            Transcript t = new Transcript(sub, st, lap, test, fina);
                            trList.set(pos, t);
                            x=2;
                        }
                    }
                    }
                } while (x == 1);

            }

        } while (x == 1);

    }

//    xuat bao cao ve hoc sinh
//  mai chienes tiep
    public void reportStudent() {
        int j = 0;
        String stID;
        stID = (String) MyUtil.readNonBlankStr("Student ID").toUpperCase();
        boolean check = trList.containsStudent(stID);
        int pos = stList.indexOf(new Student(stID));
        if (check == false) {
            System.out.println("Student does not exist");
        } else {
            System.out.println("Student Name:" + stList.get(pos).getfName() + " " + stList.get(pos).getlName());
            System.out.println("|++	No	++|++    Subject name   ++ |++	  Average mark ++   |++   Status    ++|	");
            for (Transcript t : this.trList) {
                if (t.st.stID.equals(stID)) {

                    j++;
                    double a = (double) Math.round(t.average() * 100) / 100;
                    System.out.printf("%9s%30s%19s%21s\n", j, t.sub.getSubName(), a, t.truefalse());
                }
            }
        }

    }
//    xuat bao cao ve mon hoc

    public void reportSubject() {
        String stID;
        stID = (String) MyUtil.readNonBlankStr("Subject ID").toUpperCase();
        boolean check = trList.containsSubject(stID);
        int pos = subList.indexOf(new Subject(stID));
        int i = 0;
        if (check == false) {
            System.out.println("Subject does not exist");
        } else {
            System.out.println("Subject Name:" + subList.get(pos).getSubName());
            System.out.println("|++ Student ID  ++|++      Student name      ++ |++  Average mark  ++|++   Status    ++|	");
            for (Transcript t : this.trList) {
                if (t.sub.subID.equals(stID)) {
                    String v = t.st.getStID();
                    String q = t.st.getfName();
                    String k = t.st.getlName();
                    double a = (double) Math.round(t.average() * 100) / 100;
                    String w = t.truefalse();
                    i++;
                    System.out.printf("%9s%33s%17s%22s\n", v, (q + " " + k), a, w);

                }
            }
        }
    }

}
