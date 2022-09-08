/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

public class MyUtil {

    public static final int DMY = 0;
    public static final int MDY = 1;
    public static final int YMD = 2;
    public static final String phone = "[\\d]{10,12}";
    public static final String EMAIL = ".+@.+[.].+";
    static Scanner sc = new Scanner(System.in);

    public static int readInt(String message, int min, int max) {
        int t;
        if (min > max) {
            t = min;
            min = max;
            max = t;
        }
        boolean OK = false;
        do {
            System.out.println(message + ":");
            t = Integer.parseInt(sc.nextLine());
            OK = (t > min && t < max);
        } while (!OK);
        return t;
    }

    public static int readInt(String message, int min) {
        return readInt(message, min, Integer.MAX_VALUE);
    }

    public static double readInt1(String message, double min, double max) {
        double t;
        if (min > max) {
            t = min;
            min = max;
            max = t;
        }
        boolean OK = false;
        do {
            System.out.println(message + ":");
            t=Double.parseDouble(sc.nextLine());
//            t = Integer.parseInt(sc.nextLine());
            OK = (t > min && t < max);
        } while (!OK);
        return t;
    }

    public static double readInt1(String message, double min) {
        return readInt(message, (int) min, (int) Double.MAX_VALUE);
    }
//HÀM XÉT ĐIỆU KIỆN KHÔNG NHẬP GIÁ TRỊ

    public static String readNonBlankStr(String message) {
        String S;
        boolean OK = false;
        do {
            System.out.print(message + ":");
            S = sc.nextLine().trim();
            OK = S.matches(S);
            if (S.isEmpty()) {
                OK = false;
                System.out.println("Invalid input!");
            } else {

            }
        } while (!OK);
        return S;
    }

    public static String readPattern(String message, String regex) {
        String S;
        boolean OK;
        do {
            System.out.print(message + ":");
            S = sc.nextLine().trim();
            OK = S.matches(regex);
            if (!OK) {
                System.out.println("Invalid input!");
            }
        } while (!OK);
        return S;
    }

// hàm không để trống số nguyên INT
    public static int getInt(String wellcome, int min, int max) {
        boolean check = true;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println(wellcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println(" Must input number !");
            }
        } while (check || number > max || number < min);

        return number;
    }
        public static double getdouble(String wellcome, double min, double max) {
        boolean check = true;
        double number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println(wellcome);
                number = Double.parseDouble(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println(" Must input number !");
            }
        } while (check || number > max || number < min);

        return number;
    }
// hàm nhận giá trị trống số nguyên INT

    public static int updateInt(String wellcome, int min, int max, int oldData) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(wellcome);
                String tmp = sc.nextLine();
                if (!tmp.isEmpty()) {
                    number = Integer.parseInt(tmp);
                    check = false;
                } else {
                    number = oldData;
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Must input number !");
            }
        } while (check || number > max || number < min);
        return number;
    }

//    tool chỉnh sửa những giá trị còn trống
    public static String updateString(String wellcome, String oldData) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        System.out.println(wellcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        } else {
            result = oldData;
        }
        return result;
    }

    // sửa thông tin trong ngày tháng năm
    public static Date updatereadDMY(String message, Date oldData) {
        Date d;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(message + "[d/m/y]:");
            String tmp = sc.nextLine().trim();
            d = toDate(tmp, DMY);
            if (tmp.isEmpty()) {
                d = oldData;
            } else if (d == null) {

            } else {
                d = toDate(tmp, DMY);
            }
        } while (d == null);

        return d;
    }

    public static String updatereadPattern(String message, String regex, String oldData) {
        String S = null;
        boolean OK;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(message + ":");
            String tmp = sc.nextLine().trim();
            OK = tmp.matches(regex);
            if (tmp.isEmpty()) {
                S = oldData;
                OK = true;
            } else if (!OK) {
                System.out.println("Invalid input!");
            } else {
                S = tmp;
            }
        } while (!OK);
        return S;
    }

    public static boolean readBool(String message) {
        
        System.out.println(message + "[1.Male/2.Female]:");
        String S = sc.nextLine().trim().toLowerCase();
        char c = S.charAt(0);
        
        return (c == 'T' || c == 'Y' || c == '1');
    }

    public static boolean readBoolyesno(String message) {
        System.out.println(message + "[1.YES/2.NO]:");
        String S = sc.nextLine().trim().toLowerCase();
        char c = S.charAt(0);
        return (c == 'T' || c == 'Y' || c == '1');
    }

    public static boolean isLeap(int y) {
        boolean result = false;
        if ((y % 400 == 0) || (y % 4 == 0) && (y % 100 != 0)) {
            result = true;
        }
        return result;
    }

    public static boolean valid(int y, int m, int d) {
        if (y < 0 || m < 0 || m > 12 || d < 0 || d > 31) {
            return false;
        }
        int maxD = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxD = 30;
        } else if (m == 2) {
            if (isLeap(y)) {
                maxD = 29;
            } else {
                maxD = 28;
            }
        }
        return d <= maxD;
    }

    public static Date toDate(int y, int m, int d) {
        if (!valid(y, m, d)) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, d);
        return cal.getTime();
    }

    public static Date toDate(String dateStr, int dateFormat) {
        int yIndex, mIndex, dIndex;
        switch (dateFormat) {
            case YMD:
                yIndex = 0;
                mIndex = 1;
                dIndex = 2;
                break;
            case MDY:
                yIndex = 2;
                mIndex = 0;
                dIndex = 1;
                break;
            case DMY:
                yIndex = 2;
                mIndex = 1;
                dIndex = 0;
                break;
            default:
                return null;
        }
        String[] parts = dateStr.split("[/-]");
        if (parts.length != 3) {
            return null;
        }
        int y = Integer.parseInt(parts[yIndex]);
        int m = Integer.parseInt(parts[mIndex]);
        int d = Integer.parseInt(parts[dIndex]);
        return toDate(y, m, d);
    }

    public static Date readMDY(String message) {
        Date d;
        String S;
        do {
            System.out.println(message + "[m/d/y]:");
            S = sc.nextLine().trim();
            d = toDate(S, MDY);
            if (d == null) {
                System.out.println("Invalid date!");
            }
        } while (d == null);
        return d;
    }

    public static Date readDMY(String message) {
        Date d;
        String S;
        do {
            System.out.print(message + "[d/m/y]:");
            S = sc.nextLine().trim();
            d = toDate(S, DMY);
            if (d == null) {
                System.out.println("Invalid date! (Example: 17/12/2000)");
            }
        } while (d == null);
        return d;
    }

    public static Date readYMD(String message) {
        Date d;
        String S;
        do {
            System.out.println(message + "[y/m/d]:");
            S = sc.nextLine().trim();
            d = toDate(S, YMD);
            if (d == null) {
                System.out.println("Invalid date!");
            }
        } while (d == null);
        return d;
    }

    public static String strDMY(Date d) {
        String S = "";
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return S + c.get(Calendar.DATE) + '-' + (c.get(Calendar.MONDAY) + 1) + '-' + c.get(Calendar.YEAR);
    }

    public static String strMDY(Date d) {
        String S = "";
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return S + (c.get(Calendar.MONDAY) + 1) + '-' + c.get(Calendar.DATE) + '-' + c.get(Calendar.YEAR);
    }

    public static void main(String[] args) {
        boolean x = readBool("t/f");
        System.out.println(x);
        String n = readNonBlankStr(EMAIL);
        System.out.println(n);
        String phone = readPattern("nhap phone", MyUtil.phone);
        System.out.println(phone);
        String mail = readPattern("nhap gmail", EMAIL);
        System.out.println(mail);
        Date d = readDMY("nhap ngay thang nam:");
        System.out.println("DMY" + strDMY(d));
        System.out.println("MDY" + strMDY(d));

    }
}
