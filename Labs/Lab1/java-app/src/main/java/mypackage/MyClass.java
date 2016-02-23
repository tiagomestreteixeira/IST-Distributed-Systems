package mypackage;


public class MyClass {

    public static void main(String[] args) throws Exception {
        System.out.println("Hi!");

        System.out.println();

        // receive arguments
        System.out.printf("Received %d arguments%n", args.length);
        // print input arguments
        for (int i=0; i < args.length; i++) {
            System.out.printf("arg[%d] = %s%n", i, args[i]);
        }


        System.out.println("Bye!");
    }

}
