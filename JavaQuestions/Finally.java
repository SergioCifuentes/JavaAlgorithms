public class Finally {
    public static void main(String[] args) {
        System.out.println(sum());
    }

    public static int sum(){
        int[] arr = new int[4];
         
        try
        {
                 
            // this statement will never execute
            // as exception is raised by above statement
            System.out.println("Inside try block");
            return 1;
        }
         
        catch(ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Exception caught in catch block");
        }
         
        finally
        {
            System.out.println("finally block executed");
        }
        return 0;
    }
}
