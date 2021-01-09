import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main (String []args)throws FileNotFoundException {


        int size = 0;                                                               // prepei na diabazw ena arithmo k gia na printarw tis poleis
        ListInterface <City> li = new List <>();                                    // kai oxi oles tis poleis

        try {
            Scanner sc = new Scanner(new File("file.txt"));
            while (sc.hasNext()) {
                int id = sc.nextInt();
                String name = sc.next();
                int pop = sc.nextInt();
                int cases = sc.nextInt();
                //System.out.println(City.calculate(cases,pop));
                City s1 = new City(id, name, pop, cases);
                li.insertAtBack(s1);
                String a1 = s1.toString();
                //System.out.println(a1);
                size +=1;
            }
            sc.close();
        }catch (InputMismatchException e) {
                System.out.println("Error");
                e.printStackTrace();
            }

        //System.out.println(li.toString());
        //System.out.println(list[0].calculateDensity());

        City.sort(li,size);                             // den exw ftia3ei gia idio density kai idio onoma na ginetai mesw id i heapsort
                                                        // ta if.


        
    }
}
