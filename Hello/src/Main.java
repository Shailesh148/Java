import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void  main(String[] args) {
        Main1 p1 = new Main1("om ", 24);
        Main1 p2 = new Main1("ram", 10);
        Main1 p3 = new Main1("raghav", 15);
        Main1 p4 = new Main1("om prakash", 22);
        Main1 p5 = new Main1("om prakash", 23);
        

        List<String> singleString = new ArrayList<>(Arrays.asList("Desk", "Table", "Chair"));
        String concatenatedString = singleString.stream().map(sstring -> sstring.toLowerCase()).collect(Collectors.joining(","));
        System.out.println(concatenatedString);

        List<Main1> groupByPerson = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5));
        Map<String, List<Main1>> listPersonGroupBy = groupByPerson.stream().collect(Collectors.groupingBy(Main1::getName));
        listPersonGroupBy.forEach((key, value) -> {
            System.out.println("person name: " + key);
            value.forEach(eachAge -> {
                System.out.println("eachAges of people present: " + eachAge.getAge());
            });
        });

//        List<Person> groupByAndAverage = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5));
//        Map<String, Double> averageAgesOfPeople = groupByAndAveragev.stream().collect(Collectors.groupingBy(Person::getName,Collectors.averagingInt(Person::getAge)));
//        averageAgesOfPeople.forEach((key, value) -> {
//            System.out.println("person name: " + key + " person age " + value
//            );
//        });
        //Random values : parallelStream()
        List<Main1> parallelStreamList = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5));
        parallelStreamList.parallelStream().forEach(ps -> System.out.println(ps.getName()));

        //Overlapping=false
        // First HasMap Problem
        List<Integer> a1 = new ArrayList<>(Arrays.asList(2,4,6,11,44,50));
        List<Integer> a2 = new ArrayList<>(Arrays.asList(2,50,11));
        boolean isOverlapping = false;
        for (int i=0; i<a2.size();i++){
            for (int j=0; j<a1.size();j++){
                if(a2.get(i) == a1.get(j)){
                    isOverlapping=true;
                    break;
                }else{
                    isOverlapping=false;

                }




            }
        }
        if(isOverlapping==true){
            System.out.println("Yes there is overlapping");
        }else{
            System.out.println("No there is no overlapping");
        }
       // Second HasMap Problem
        Map<Integer,Integer> hashMap = new HashMap<>();
        Boolean isOverlapp = true;
        for (int t1=0; t1<a2.size();t1++){
            hashMap.put(a2.get(t1), a2.get(t1));
        }
        for(int t2=0; t2<a1.size();t2++){
            if (!hashMap.containsKey(a1.get(t2))){
                isOverlapp = false;
                break;
            }
        }
        System.out.println(isOverlapp);
        // --------------------------------------------------------------------------------------------------------
        Map<Integer,Integer> hashMap1 = new HashMap<>();
        hashMap1.put(1,1);
        hashMap1.put(2,2);
        hashMap1.put(1,3); //replaces key value of 1
        // --------------------------------------------------------------------------------------------------------

        // Third HasMap Problem

        //first repeating element in the list off elements in an array
        //arr[] = {1,5,3,4,3,5,6}
        Map<Integer,Integer> hashMap2 = new HashMap<>();
        for (int t1=0; t1<a2.size();t1++){
            if(hashMap2.containsKey(a2.get(t1))){
                System.out.println("first repeating element is: " +a2.get(t1));
                break;
            }
            hashMap.put(a2.get(t1), a2.get(t1));
        }
//        Do {
//
//        }while()

    }

}
class Main1 implements Comparable<Main1>{
    int age;
    String name;

    public Main1() {

    }
    public Main1(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Main1 o) {
        return this.age - o.getAge();

    }

}

