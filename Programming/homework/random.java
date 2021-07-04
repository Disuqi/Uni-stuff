
/**
 * Write a description of class random here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class random
{  
    private boolean result;
    
    public boolean randomMethod(int a)
    {
       if( a%2 == 0)
       {
           result = true;
       }
       else
       {
           result = false;
       }
       return result;

    }
}
