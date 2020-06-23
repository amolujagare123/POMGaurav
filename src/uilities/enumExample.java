package uilities;

public class enumExample {

   // enum is a data strucre , it is used to make our program readle and user friendly
    // it has some user defined values
    public enum status    {
        pass, fail , deffered ,inprogress
    }


    public static void main(String[] args) {
       status s1 = status.pass ;


       switch (s1)
       {
           case pass:
               System.out.println("pass"); break;
           case fail:
               System.out.println("pass");break;
           case deffered:
               System.out.println("pass");break;
       }


    }
}
