package uilities;

public class SwitchCaseExample {

    // take 2 numbers and do different operations like +,-,x, /
    // based on the input or instruction

    public static void main(String[] args) {


        int a =10;
        int b = 2;
        int c;

        String operation ="sub";

        switch (operation)
        {
            case "add" :
                System.out.println("addition:"+(a+b)); break;
            case "sub" :
                System.out.println("substraction:"+(a-b)); break;
            case "mul" :
                System.out.println("mul:"+(a*b)); break;
            case "div" :
                System.out.println("div:"+(a/b)); break;

        }

    }
}
