package java_priority_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable<Student> {
    String name;
    double cgpa;
    int id;

    public Student(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public double getCgpa() {
        return this.cgpa;
    }

    public int getId() {
        return this.id;
    }

    public int compareTo(Student s) {
        if (this.cgpa < s.cgpa) {
            return 1;
        } else if (this.cgpa > s.cgpa) {
            return -1;
        } else {
            if (this.name.equals(s.name)) {
                return this.id - s.id;
            } else {
                return this.name.compareTo(s.name);
            }
        }
    }
}

class Priorities {
    List<Student> p = new ArrayList<>();
    List<Student> st = new ArrayList<>();

    List<Student> getStudents(List<String> events) {
        for (String event : events) {
            String[] arr = event.split(" ");
            if (arr[0].equals("ENTER")) {
                p.add(new Student(arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3])));
            } else {
                if (!p.isEmpty()) {
                    p.remove(0);
                }

            }
            Collections.sort(p);
        }
        while (!p.isEmpty()) {
            st.add(p.get(0));
            p.remove(0);
        }
        return st;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}