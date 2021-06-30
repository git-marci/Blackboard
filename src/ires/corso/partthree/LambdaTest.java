package ires.corso.partthree;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class LambdaTest
{
    public static void main(String[] args)
    {
        /* Dall'esempio di Davide

        Comparator<Map.Entry<Categoria, List>> comparator = new Comparator<Map.Entry<Categoria, List>>() {
            @Override
            public int compare(Map.Entry<Categoria, List> o1, Map.Entry<Categoria, List> o2) {
                Integer size1 = o1.getValue().size();
                Integer size2 = o2.getValue().size();
                Integer result = -size1.compareTo( size2 );
                if( result == 0 ) {
                    String titolo1 = o1.getKey().getTitolo();
                    String titolo2 = o2.getKey().getTitolo();
                    result = titolo1.compareTo( titolo2 );
                }
                return result;
            }
        };

        */

        // Old way... anonymous classes!
        Comparator<String> oldStringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        // New way -> Lambda expression
        Comparator<String> stringComparator = (String first, String second) -> first.length() - second.length();
        // Riassegnazione: stringComparator = (String first, String second) -> 111;

        // Più dettagliato...
        Comparator<String> anotherStringComparator = (String first, String second) -> {
            int difference = first.length() - second.length();
            if (difference < 0) return -1;
            else if (difference > 0) return 1;
            else return 0;
        };

        /*
            Qual è il meccanismo "ponte" tra le anonymous classes e le lambda expressions?

            You can supply a lambda expression whenever an object of an interface with
            a single abstract method is expected. Such an interface is called a functional
            interface.

            ==> FUNCTIONAL INTERFACES!

            In most programming languages that support function literals, you can declare
            function types such as (String, String) -> int, declare variables of those types,
            put functions into those variables, and invoke them. In Java, there is only one
            thing you can do with a lambda expression: put it in a variable whose type
            is a functional interface, so that it is converted to an instance of that interface.

            Java Functional Interfaces Summary:
            -----------------------------------
            BiConsumer<T,U>: Represents an operation that accepts two input arguments and returns no result.
            BiFunction<T,U,R>: Represents a function that accepts two arguments and produces a result.
            BinaryOperator<T>: Represents an operation upon two operands of the same type, producing a result of the same type as the operands.
            BiPredicate<T,U>: Represents a predicate (boolean-valued function) of two arguments.
            BooleanSupplier: Represents a supplier of boolean-valued results.
            Consumer<T>: Represents an operation that accepts a single input argument and returns no result.
            DoubleBinaryOperator: Represents an operation upon two double-valued operands and producing a double-valued result.
            DoubleConsumer: Represents an operation that accepts a single double-valued argument and returns no result.
            DoubleFunction<R>: Represents a function that accepts a double-valued argument and produces a result.
            DoublePredicate: Represents a predicate (boolean-valued function) of one double-valued argument.
            DoubleSupplier: Represents a supplier of double-valued results.
            DoubleToIntFunction: Represents a function that accepts a double-valued argument and produces an int-valued result.
            DoubleToLongFunction: Represents a function that accepts a double-valued argument and produces a long-valued result.
            DoubleUnaryOperator: Represents an operation on a single double-valued operand that produces a double-valued result.
            Function<T,R>: Represents a function that accepts one argument and produces a result.
            IntBinaryOperator: Represents an operation upon two int-valued operands and producing an int-valued result.
            IntConsumer: Represents an operation that accepts a single int-valued argument and returns no result.
            IntFunction<R>: Represents a function that accepts an int-valued argument and produces a result.
            IntPredicate: Represents a predicate (boolean-valued function) of one int-valued argument.
            IntSupplier: Represents a supplier of int-valued results.
            IntToDoubleFunction: Represents a function that accepts an int-valued argument and produces a double-valued result.
            IntToLongFunction: Represents a function that accepts an int-valued argument and produces a long-valued result.
            IntUnaryOperator: Represents an operation on a single int-valued operand that produces an int-valued result.
            LongBinaryOperator: Represents an operation upon two long-valued operands and producing a long-valued result.
            LongConsumer: Represents an operation that accepts a single long-valued argument and returns no result.
            LongFunction<R>: Represents a function that accepts a long-valued argument and produces a result.
            LongPredicate: Represents a predicate (boolean-valued function) of one long-valued argument.
            LongSupplier: Represents a supplier of long-valued results.
            LongToDoubleFunction: Represents a function that accepts a long-valued argument and produces a double-valued result.
            LongToIntFunction: Represents a function that accepts a long-valued argument and produces an int-valued result.
            LongUnaryOperator: Represents an operation on a single long-valued operand that produces a long-valued result.
            ObjDoubleConsumer<T>: Represents an operation that accepts an object-valued and a double-valued argument, and returns no result.
            ObjIntConsumer<T>: Represents an operation that accepts an object-valued and a int-valued argument, and returns no result.
            ObjLongConsumer<T>: Represents an operation that accepts an object-valued and a long-valued argument, and returns no result.
            Predicate<T>: Represents a predicate (boolean-valued function) of one argument.
            Supplier<T>: Represents a supplier of results.
            ToDoubleBiFunction<T,U>: Represents a function that accepts two arguments and produces a double-valued result.
            ToDoubleFunction<T>: Represents a function that produces a double-valued result.
            ToIntBiFunction<T,U>: Represents a function that accepts two arguments and produces an int-valued result.
            ToIntFunction<T>: Represents a function that produces an int-valued result.
            ToLongBiFunction<T,U>: Represents a function that accepts two arguments and produces a long-valued result.
            ToLongFunction<T>: Represents a function that produces a long-valued result.
            UnaryOperator<T>: Represents an operation on a single operand that produces a result of the same type as its operand.

            Alcune tra le + importanti
            --------------------------
            Consumer<T>: Represents an operation that accepts a single input argument and returns no result.
            Function<T,R>: Represents a function that accepts one argument and produces a result.
            BiFunction<T,U,R>: Represents a function that accepts two arguments and produces a result.
            Predicate<T>: Represents a predicate (boolean-valued function) of one argument.
            BiPredicate<T,U>: Represents a predicate (boolean-valued function) of two arguments.
            Supplier<T>: Represents a supplier of results.
            UnaryOperator<T>: Represents an operation on a single operand that produces a result of the same type as its operand.

            ...e un'importante "outsider":
            Runnable: Runs an action without arguments or return value
         */

        // Arraylist di esempio
        ArrayList<Long> arLong = new ArrayList<>();
        arLong.add(1l);
        arLong.add(2l);
        arLong.add(3l);

        // Utilizzo di interfaccia Function
        Function<Long, Long> adder = new AddThree(); // ...uso la classe che la implementa

        Stream<Long> streamAdded = arLong.stream().map(adder); // adder ha un metodo "apply", e questo viene
                                                               // invocato internamente da map su ciascun
                                                               // elemento dello stream

        Stream<Long> streamAddedEqu = arLong.stream().map(aLong -> aLong + 3); //...oppure una lambda expression

        System.out.println("");
        System.out.println("- test con AddThree:");
        streamAdded.forEach(l -> System.out.println("result after addition = " + l));
        System.out.println("- test con lambda expression equivalente:");
        streamAddedEqu.forEach(l -> System.out.println("result after addition = " + l));

        // Utilizzo di interfaccia Predicate
        Predicate<Long> greaterThanOne = new CheckIfGreaterThanOne();
        ArrayList<Long> arLongCopy = (ArrayList<Long>)arLong.clone();
        Stream<Long> longStream = ((ArrayList<Long>)arLong.clone()).stream();

        System.out.println("");
        System.out.println("- test con CheckIfGreaterThanOne:");
        arLongCopy.removeIf(l -> l <= 1);
        //arLongCopy.removeIf(Predicate.not(greaterThanOne));
        arLongCopy.forEach(l -> System.out.println("result after removal if !> 1 = " + l));
        System.out.println("- test con lambda expression equivalente:");
        longStream.filter(l -> l > 1).forEach(l -> System.out.println("result after removal if !> 1 = " + l));

        // Utilizzo di interfaccia UnaryOperator
        UnaryOperator<Long> square = new SquareIt();
        ArrayList<Long> arLongCopy2 = (ArrayList<Long>)arLong.clone();
        Stream<Long> longStream2 = ((ArrayList<Long>)arLong.clone()).stream();

        System.out.println("");
        System.out.println("- test con SquareIt:");
        arLongCopy2.replaceAll(square); // Uso classe che implementa UnaryOperator...
        arLongCopy2.forEach(l -> System.out.println("result after squaring = " + l));
        System.out.println("- test con lambda expression equivalente:");
        longStream2
                .map(l -> l * l) // ...o una lambda expression, ad essa equivalente!
                .forEach(l -> System.out.println("result after squaring = " + l));

        // Dichiarazione di variabili-funzioni come lambda expression
        UnaryOperator<Long> inlineSquare = (Long l) -> {
            // Puoi mettere quante istruzioni vuoi...
            return l * l;
        };

        // Concatenazione: andThen
        System.out.println("- test di concatenazione operatori:");
        UnaryOperator<Long> minusOne = new MinusOne();
        Stream<Long> longStream3 = ((ArrayList<Long>)arLong.clone()).stream();
        longStream3
                .map(minusOne.andThen(square)) // lambda expr. <=> classi che implementano func. interfaces
                .forEach(l -> System.out.println("result after subtracting 1 and squaring = " + l));

        // Composizione
        System.out.println("- test di composizione operatori:");
        Stream<Long> longStream4 = ((ArrayList<Long>)arLong.clone()).stream();
        longStream4
                .map(minusOne.compose(square)) // lambda expr. <=> classi che implementano func. interfaces
                .forEach(l -> System.out.println("result after composing (squaring) and (subtracting 1) = " + l));

        // Utilizzo di interfaccia Consumer
        Consumer<Long> printIt = new Printer();
        System.out.println("");
        System.out.println("- test di utilizzo Consumer:");
        arLong.forEach(printIt);

        // Concatenazione di consumer
        System.out.println("- test di composizione di Consumer:");
        arLong.forEach(printIt.andThen(new Mailer()));

        // ...e adesso con le lamba expression
        System.out.println("- test di composizione con Lambda expressions:");
        arLong.forEach(
                (
                        (Consumer<Long>) // necessario "castare" all'interfaccia funzionale per poter applicare andThen!
                                (Long l) -> System.out.println("Lambda version: this is the val ==>" + l)
                )
                        .andThen(
                                (Long l) -> System.out.println("And now I'll lambda-mail it ==>" + l))
        );

        // Espressione in linea
        // arLong.forEach(((Consumer<Long>)(Long l) -> System.out.println("Lambda version: this is the val ==>" + l)).andThen((Long l) -> System.out.println("And now I'll lambda-mail it ==>" + l)));

        /*
            Le "method references" sono dei puntatori ad un metodo.
            -------------------------------------------------------

            Sometimes, a lambda expression only calls an existing method.
            In those cases, it looks clear to refer to the existing method by name.
            The method references can do this, they are compact, easy-to-read as
            compared to lambda expression.

            A method reference is the SHORTHAND SYNTAX for a lambda expression
            that contains just one method call.

            Example ==> To print all element in a list:

                list.forEach(s -> System.out.println(s));

            This lambda expression can be replaced with a method reference:

                list.forEach(System.out::println);

                                   ATTENZIONE ATTENZIONE ATTENZIONE ATTENZIONE
            ==========================================================================================
            The method references can only be used to replace a single method of the lambda expression
            ==========================================================================================

            Non esiste il tipo di dati "puntatore ad un metodo": l'utilizzo delle method references
            poggia in definitiva sull'equivalenza con una Functional Interface e in tal senso
            si devono vedere piuttosto come SINTASSI ALTERNATIVA alle lambda expression.

            There are four kinds of method references:
            1 - Static methods
            2 - Instance methods of particular objects
            3 - Instance methods of an arbitrary object of a particular type
            4 - Constructor
        */

        // 1. Reference to a static method:
        // --------------------------------
        // If a Lambda expression is like:
        //
        //     (args) -> Class.staticMethod(args)
        //
        // Then method reference is like:
        //
        //     Class::staticMethod
        //
        System.out.println("\n- METHOD REFERENCES: static method");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("jessica", 24));
        personList.add(new Person("deborah", 25));
        personList.add(new Person("olga", 19));

        // Sintassi 1: Lambda expression
        // Collections.sort(personList, (p1, p2) -> PersonComparator.compareByName(p1, p2));

        // Con method reference (static method)
        Collections.sort(personList, PersonComparator::compareByName);
        System.out.println("--Sort by name :");
        personList.stream().map(x -> x.getName()).forEach(System.out::println);

        Collections.sort(personList, PersonComparator::compareByAge);
        System.out.println("--Sort by age :");
        personList.stream().map(x -> x.getName()).forEach(System.out::println);

        // 2. Reference to an instance method of a particular object
        // ---------------------------------------------------------
        //
        // If a Lambda expression is like:
        //
        //     (args) -> obj.instanceMethod(args)
        //
        // Then method reference is like:
        //
        //     obj::instanceMethod
        //
        System.out.println("\n- METHOD REFERENCES: specific instance method");
        PersonComparator pc = new PersonComparator();

        /// Lambda expression
        // Collections.sort(personList, (p1, p2) -> pc.instanceCompareByAge(p1, p2));

        // Con method reference (instance method)
        Collections.sort(personList, pc::instanceCompareByName);
        System.out.println("--Sort by name :");
        personList.stream().map(x -> x.getName()).forEach(System.out::println);

        Collections.sort(personList, pc::instanceCompareByAge);
        System.out.println("--Sort by age :");
        personList.stream().map(x -> x.getName()).forEach(System.out::println);

        // 3. Reference to an instance method of an arbitrary object of a particular type
        // ------------------------------------------------------------------------------
        //
        // If a Lambda expression is like:
        //
        //     (obj, args) -> obj.instanceMethod(args)
        //
        // Then method reference is like:
        //
        //     ObjectType::instanceMethod
        //
        System.out.println("\n- METHOD REFERENCES: arbitrary instance method");
        List<String> stringList = new ArrayList<>();
        stringList.add("inter");
        stringList.add("napoli");
        stringList.add("lazio");

        // Method reference to String type
        Collections.sort(stringList, String::compareToIgnoreCase);
        stringList.forEach(System.out::println);

        // 4. Constructor method reference
        // -------------------------------
        //
        // If a Lambda expression is like:
        //
        //      (args) -> new ClassName(args)
        //
        // Then method reference is like:
        //
        //     ClassName::new
        //
        System.out.println("\n- METHOD REFERENCES: constructor");
        List<String> titleList = new ArrayList<>();
        titleList.add("2001 A space odissey");
        titleList.add("Despair");
        titleList.add("Existenz");

        Stream<Movie> movieStream = titleList.stream().map(Movie::new);
        //movieStream.forEach(Movie::project);
        movieStream.forEach(m -> m.project());
    }
}

/*
    Function

    The Java Function interface (java.util.function.Function) interface is one of the most central functional
    interfaces in Java. The Function interface represents a function (method) that takes a single parameter
    and returns a single value. Here is how the Function interface definition looks:

    public interface Function<T,R> {
        public <R> apply(T parameter);
    }
*/
class AddThree implements Function<Long, Long> {
    @Override
    public Long apply(Long aLong) {
        return aLong + 3;
    }
}

/*
    Predicate

    The Java Predicate interface, java.util.function.Predicate, represents a simple function that takes a single
    value as parameter, and returns true or false. Here is how the Predicate functional interface definition looks:

    public interface Predicate<T> {
        boolean test(T t);
    }
*/
class CheckIfGreaterThanOne implements Predicate<Long> {
    @Override
    public boolean test(Long l) {
        return l > 1;
    }
}

/*
    UnaryOperator

    The Java UnaryOperator interface is a functional interface that represents an operation which takes a single parameter
    and returns a parameter of the same type. Here is how the UnaryOperator functional interface definition looks:

    public interface UnaryOperator<T> extends Function<T, T> {
    }
*/
class SquareIt implements UnaryOperator<Long> {
    @Override
    public Long apply(Long aLong) {
        return aLong * aLong;
    }
}

class MinusOne implements UnaryOperator<Long> {
    @Override
    public Long apply(Long aLong) {
        return aLong -1;
    }
}

/*
    Consumer

    The Java Consumer interface is a functional interface that represents an function that consumes a value without
    returning any value. A Java Consumer implementation could be printing out a value, or writing it to a file, or
    over the network etc. Here is how the Consumer functional interface definition looks like:

    public interface Consumer<T> {
        void accept(T t);
    }
*/
class Printer implements Consumer<Long> {
    @Override
    public void accept(Long aLong) {
        System.out.println("I received a Long value: " + aLong);
    }
}

class Mailer implements Consumer<Long> {
    @Override
    public void accept(Long aLong) {
        System.out.println("...and now I'll send an email with this value: " + aLong);
    }
}

/*********************/
/* METHOD REFERENCES */
/*********************/
class Person {
    private String name;
    private Integer age;

    // Constructor
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() { return age; }
    public String getName() { return name; }
}

class PersonComparator
{
    // Static methods
    public static int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }

    public static int compareByAge(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }

    // Instance methods
    public int instanceCompareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }

    public int instanceCompareByAge(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }
}

// Classe di appoggio per ctor reference
class Movie {
    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    public void project() {
        System.out.println("[[[ You are now watching: " + title + " ]]]");
    }
}