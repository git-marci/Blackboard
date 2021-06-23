package ires.corso.parttwo.generics.vehicles;

import ires.corso.parttwo.generics.entities.Course;
import ires.corso.parttwo.generics.entities.Student;
import ires.corso.parttwo.generics.vehicles.ContainerTruck;
import ires.corso.parttwo.generics.vehicles.air.Aereo;
import ires.corso.parttwo.generics.vehicles.air.Elicottero;
import ires.corso.parttwo.generics.vehicles.air.Volante;
import ires.corso.parttwo.generics.vehicles.air.VolanteMotorizzato;
import ires.corso.parttwo.monitoring.vehicles.Automobile;

import java.util.*;

public class GenericTester
{
    public static void main(String[] args) {
        //ContainerTruck<Car> ctCar = new ContainerTruck<>();
        //ContainerTruck<Automobile> ctAutomobile = new ContainerTruck<>("PN33170", "Volvo superturbo bivalve");

        // Wildcard
        List<?> wildList = new ArrayList<Integer>();

        // ...Integer extends Number
        // List<Integer> NON extends List<Number>
        List<Integer> li = new ArrayList<Integer>();
        li.add(100);
        li.add(200);
        li.add(300);
        doSomethingGeneric(li);

        List<Number> ln = new ArrayList<Number>();
        ln.add(100);
        ln.add(200);
        ln.add(300);
        doSomethingGeneric(ln);

        doSomethingBetter(li);
        doSomethingBetter(ln);

        // List<Number> ln2 = li; NO! List<Integer> e List<Number> sono due tipi differenti...

        // Esperimenti in aria...
        List<VolanteMotorizzato> list1 = new ArrayList<VolanteMotorizzato>();
        list1.add(new Elicottero());
        test1(list1);

        List<Elicottero> list2 = new ArrayList<Elicottero>();
        list2.add(new Elicottero());
        //list2.add(new Aereo());
        test1(list2);

        List<Volante> list3 = new ArrayList<Volante>();
        list3.add(new Volante());
        list3.add(new VolanteMotorizzato());
        list3.add(new Aereo());
        list3.add(new Elicottero());

        list3.get(0).atterra();

        test2(list3);
        test3(list2);
        test3(list1);

        // Altre collections
        Map<String, VolanteMotorizzato> msv = new HashMap<>();
        msv.put("AEREO UNO", new Aereo());
        VolanteMotorizzato aereo = msv.get("AEREO UNO");

        Map<Student, List<Course>> frequenze = new HashMap<>();
        Student st = new Student();
        List<Course> ac =  new ArrayList<>();
        ac.add(new Course());
        ac.add(new Course());
        ac.add(new Course());
        frequenze.put(st, ac);

        // Per iterare su una mappa
        Set<Student> ks = frequenze.keySet();
        Iterator<Student> is = ks.iterator();

        while(is.hasNext()) {
            List<Course> ls = frequenze.get(is.next());
            for(Course c: ls) {
                // stampami il corso frequentato...
            }
        }
    }

    // posso passare:
    // List<Aereo>
    // List<Elicottero>
    public static void test1(List<? extends VolanteMotorizzato> lvm) {
        // vedo VolanteMotorizzato come tipo
        // lvm.add(new Aereo());
    }

    // posso passare:
    // List<Aereo>
    // List<Elicottero>
    // List<VolanteMotorizzato>
    public static void test4(List<? extends Volante> lvm) {
        // vedo Volante come tipo
        // NO: lvm.add(new Aereo());
    }

    // List<Volante>
    // List<VolanteMotorizzato>
    // List<Object>
    public static void test2(List<? super VolanteMotorizzato> lvm) {
        // vedo VolanteMotorizzato come tipo
        lvm.add(new VolanteMotorizzato());
        lvm.add(new Aereo());
        lvm.add(new Elicottero());
    }

    // Possiamo passare
    // List<Aereo>
    // List<Elicottero>
    // List<VolanteMotorizzato>
    public static <T extends VolanteMotorizzato> void test3(List<T> lt) {
        for(VolanteMotorizzato vm: lt)
            vm.motoriOn();
    }

    public static void doSomethingGeneric(List<?> list) {
        //list.add(Integer.valueOf(1000)); no! List<?> è read-only, il tipo vero è sconosciuto
        for(Object o: list) {
            System.out.println("Il valore dell'OGGETTO (toString) è ==> " + o.toString());
        }
    }

    // ...però a runtime ho la type erasure a List<Object> e quindi questi due metodi vanno in conflitto,
    // il compilatore non riesce a vederli come due overload!
    //public static void doSomethingElse(List<Integer> listInt) {}
    //public static void doSomethingElse(List<Number> listInt) {}

    public static void doSomethingBetter(List<? extends Number> list) {
        for(Number n: list) {
            System.out.println("BETTER: il valore del numero è ==> " + n.intValue());
        }
    }

    public static <T extends Integer> void doSomethingGenericInAMethod(List<T> list) {
        for(Integer i: list) {
            System.out.println("BETTER: il valore del numero è ==> " + i);
        }
    }
}
