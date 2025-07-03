import javax.swing.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice  {
    public static void main(String[] args) {
        Employeee e=new Employeee();
        e.setDept("HR"); e.setEmpName("Ravi"); e.setSalary(240000);
        Employeee e1=new Employeee();
        e1.setDept("Sales"); e1.setEmpName("ram"); e1.setSalary(150000);
        Employeee e2=new Employeee();
        e2.setDept("HR"); e2.setEmpName("surya"); e2.setSalary(20000);
        Employeee e3=new Employeee();
        e3.setDept("Marketing"); e3.setEmpName("ranaaa"); e3.setSalary(4500000);

        var emplist=List.of(e,e1,e2,e3);

        var ml=IntStream.range(1,101).boxed().collect(Collectors.groupingBy(x->x%2==0));

        var even=ml.get(true);
        //print even number
        System.out.println("print even numbers List: "+ even);

        var odd=ml.get(false) ;
        //print odd numbers
        System.out.println("print odd numbers List: "+ odd);

         // get count of even and odd
        System.out.println("even numbers count : "+even.stream().count());
        System.out.println("odd numbers count: "+ odd.stream().count());

          // 2nd higesh even
        System.out.println("2nd highest even number: "+ even.stream().sorted(Collections.reverseOrder()).skip(1).findFirst());
     var names= List.of("ravi","ram","surya","ravi");

     // frequency of each String in List
        System.out.println(" frequency of each string in given list");
        names.stream().collect(Collectors.groupingBy(x->x,Collectors.counting())).entrySet().forEach(System.out::println);


     // find unique names in list (remove duplicates)
        System.out.println("find unique names in list (remove duplicates)");
      names.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

      String s="ravitejanaik";
      // frequency of each char in given string
        System.out.println(" frequency of each char in given string");
        s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(x->x,Collectors.counting())).entrySet().forEach(System.out::println);

    // To remove duplicates just use distinct on stream
        // remove duplcates in string
        System.out.println("remove duplcates in string");
    s.chars().mapToObj(x->(char)x).distinct().forEach(System.out::print);

    // remove duplicate words in strings
         String sx="hi i am i ravi hi teja";

        System.out.println("remove duplicate words in strings");
        Arrays.stream(sx.split(" ")).distinct().forEach(System.out::println);

        //Print duplicate count with names
        // To print duplicates with count first group by with given element and counting , then from entryset use filter to find values count >1 to print duplcates
        System.out.println("Print duplicate count with names");
        names.stream().collect(Collectors.groupingBy(x->x, Collectors.counting())).entrySet().stream().filter(x->x.getValue()>1).forEach(System.out::println);

        // print duplcate chars in string with count
        System.out.println("print duplcate chars in string with count");
       s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(a->a,Collectors.counting())).entrySet().stream().filter(x->x.getValue()>1).forEach(System.out::print);

        //Print Employees dept with count (group by emp dept)
        System.out.println("\n print employees dept with count");
       emplist.stream().map(Employeee::getDept).collect(Collectors.groupingBy(x->x,Collectors.counting())).entrySet().stream().forEach(System.out::println);

        //Print Unique Employee dept (remove duplciate dept)
        System.out.println("\n print employee Unique Employee dept");
       emplist.stream().map(Employeee::getDept).distinct().forEach(System.out::println);

       //Print Duplcate dept employees
        System.out.println("Print Duplcate dept employees");
       emplist.stream().collect(Collectors.groupingBy(Employeee::getDept)).entrySet().stream().filter(x->x.getValue().stream().count()>1).flatMap(xy->xy.getValue().stream()).map(Employeee::getEmpName).forEach(System.out::println);

        //example for flatmap
        var criclist=List.of("kohli,virat,rana,shami");
        var actorslist=List.of("nag,chiru,bunny,");
        var singerslist=List.of("thaman,dsp,rahman");

        System.out.println("flatmap example: flatmap is used when we have nested structures if we have stream of streams (list of list to get as single list we use flatmap)");
          List.of(actorslist,singerslist, criclist).stream().flatMap(x->x.stream()).forEach(System.out::println);

        System.out.println("print unique employee names based on dept");
        emplist.stream().collect(Collectors.groupingBy(t->t.getDept())).entrySet().stream().filter(x->x.getValue().stream().count()==1).flatMap(en->en.getValue().stream()).map(Employeee::getEmpName).forEach(System.out::println);

        //print employees who are having highest salary based on dept
        var v= emplist.stream().collect(Collectors.groupingBy(x->x.getDept(),Collectors.maxBy(Comparator.comparing(Employeee::getSalary))));
        System.out.println("print employees who are having highest salary based on dept");
        //reverse numbers
        System.out.println("reverse number");
       IntStream.range(1,101).boxed().sorted(Collections.reverseOrder()).forEach(System.out::println);

       System.out.println("reverse names");
        var simlist=List.of("apple","ball","cat","dog");
           simlist.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

           //joining using delimeter and prefix and sufix
           var sl=simlist.stream().collect(Collectors.joining("-","A","z"));
           String xc=new String("ravi");
           System.out.println("Joining using delimeter"+ sl);

           //print multiples of 5 form 1 to 100 (multiples means given list numbers should be divisible by 5 )
        IntStream.range(1,101).boxed().filter(x->x%5==0).forEach(System.out::println);

        //Print max and min numbers
        var max=IntStream.range(1,101).boxed().max(Comparator.naturalOrder());
        var min=IntStream.range(1,101).boxed().min(Comparator.naturalOrder());
        System.out.println("max number: "+ max);
        System.out.println("min number: "+ min);

        var mynumlist= List.of(101,1,500,20,50,800,5,2);
        System.out.println("sorted order number in natural order:");
         mynumlist.stream().sorted().forEach(System.out::println);

        System.out.println("print numbers in reverse order");
        mynumlist.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

        // To join any two lists or streams we can use Stream.concat method
        System.out.println("concat two streams meaning joining two list or streams");
        Stream.concat(List.of("ravi","ram","shaym").stream(),List.of("dhoni","rayudu","virat").stream()).forEach(System.out::println);

        //sum of numbers
        var mysum= mynumlist.stream().collect(Collectors.summingInt(x->x));
        System.out.println("sum of number is :"+mysum);

        var myavg= mynumlist.stream().collect(Collectors.averagingInt(x->x));
        System.out.println("avg of number is :"+myavg);

        // find top 3 max and 3 min from given list
        var mymaxminlist=List.of(100,500,2,80,9,250,454,584,588,447,585,5254);
        //printing max 3 from given list
        mymaxminlist.stream().sorted(Collections.reverseOrder()).limit(3).forEach(System.out::println);
        //printing min 3 from given list
        mymaxminlist.stream().sorted().limit(3).forEach(System.out::println);

        //Comparator.naturalOrder(), Comparator.reverseOrder() , Comparator.comparing(Employee:: age)

        //Print given Strings based on lengTH in reverse order
       //   List.of().stream().sorted() by default sorting
        //   List.of().stream().sorted().
        // Important point for Sorting stream.sorted(Comparator.naturalOrder())  //NATURAL ORDER
        // Important point for Sorting stream.sorted(Comparator.reverseOrder())  // REVERSE ORDER
        //  Important point for Sorting stream.sorted(Comparator.comparing(String::length).reversed())   // CUSTOM SORTED ORDER
        List.of("ravi","raviteja","ra","nak","sugali").stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);

        // find the common Strings in two Lists
        System.out.println("common Strings in two Lists ");
        var ml1=List.of("apple","ball","cat","dog","elephant");
        var ml2=List.of("rat","cat","bat","apple","dog");
        ml1.stream().filter(x->ml2.contains(x)).forEach(System.out::println);

        String mys="hi i am ravi teja working as software engineer";
       var myar= mys.split(" ");
       for(int i=myar.length-1;i>0;i--){
           System.out.print(" "+myar[i]);
       }
        System.out.println("\n");
        for(int i=myar.length-1;i>0;i--){
            System.out.print(" "+new StringBuilder(myar[i]).reverse());

        }
        System.out.println("\n");
        for(int i=0;i<myar.length-1;i++){
            System.out.print(" "+new StringBuilder(myar[i]).reverse());

        }

        String sss="A12c5huui";
       sss.chars().mapToObj(x->(char)x).filter(Character::isDigit).forEach(System.out::println);

       var mynlis= List.of("ravi","teja","ravi","naik","ravi");
          Set hs= new HashSet();
          for(String ss: mynlis){
               if(!hs.add(ss)){
                   System.out.println(ss);
               }
          }

          var myh=mynlis.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
     myh.entrySet().stream().forEach(System.out::println);
         String sssc="hi I am RaviTeja Naik SUgali";
          sssc.chars().mapToObj(x->(char)x).map(y->Character.isUpperCase(y)? Character.toLowerCase(y): Character.toUpperCase(y)).forEach(System.out::print);
        System.out.println("\n");
         // remove spl char in given string

          String sch="Ra4@hjkjb5  48$%&#hgu254";

          sch.chars().mapToObj(x->(char)x).filter(y->!Character.isLetterOrDigit(y) && !Character.isWhitespace(y)).forEach(System.out::print);

          //find the 2nd non reapeated character
        String sr="raviteja";
        var l=sr.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(y->y,LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(cc->cc.getValue()==1).map(String::valueOf).skip(1).findFirst();
        System.out.println("\n 2nd non reapeated character:: "+l);


          // find missing numbers in myl2 from 10 to 20
         var myl1=IntStream.range(10,21).boxed();
         var myl2=List.of(10,15,19);
         myl1.filter(x->!myl2.contains(x)).forEach(System.out::println);
         var r=List.of(1,2,3,4,5).stream().reduce(Integer::max);
        System.out.println(r);

        // find the surname for given names o/p sugali ,nenavath
        List.of("raviteja sugali","anusha nenavath").stream().map(x-> Arrays.stream(x.split(" ")).skip(1).findFirst().get().toUpperCase()).forEach(System.out::println);
        String ss="ravi teja how are you";
      //  o/p should be "rAvi tEja hOw aRe yOu"; // 2nd char should be upper case
        Arrays.stream(ss.split(" ")).map(mystr->mystr.length()>2 ?mystr.substring(0,1)+mystr.substring(1,2).toUpperCase()+mystr.substring(2):mystr).collect(Collectors.toList()).forEach(System.out::println);
        Arrays.stream(ss.split(" ")).map(mystr->mystr.length()>2 ?mystr.charAt(0)+String.valueOf(mystr.charAt(1)).toUpperCase()+mystr.substring(2):mystr).collect(Collectors.toList()).forEach(System.out::println);

        // print only first 3  numbers
        List.of(1,2,3,4,5,6,7).stream().limit(3).forEach(System.out::println);

    }
}
