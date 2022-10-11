package inheritance;

public class Main {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.setName("Binod Sharma");
        s1.setAge(24);
        s1.setFees(40000);
        s1.setCgpa(3.22);

        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        System.out.println(s1.getFees());
        System.out.println(s1.getCgpa());

        Teacher t1=new Teacher();
        t1.setName("rahul");
        t1.setAge(44);
        t1.setSalary(100000);
        System.out.println(t1.getName());
        System.out.println(t1.getAge());
        System.out.println(t1.getSalary());
    }

}
