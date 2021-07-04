/**
 * class <code>Animal</code> simulates an animal and stores 
 * the species and name.
 * 
 * @author D Newton 
 * @version Version 1, 1 November 2010
 */
public class Animal
{
   // species of the animal e.g.  lion, tiger
   private String species;
   // name of the animal e.g. Leo, Tommy
   private String name;
   
   /**
    * Create an animal of the specified species and with the specified name
    * 
    * @param  <code>species</code> a <code>String</code> specifying the
    * type of animal
    * @param  <code>name</code> a <code>String</code> specifying the 
    * name of animal
    */
   public Animal(String species, String name)
   {
      this.species = species;
      this.name  = name;
   }
   
   /**
    * Returns the species of the <code>Animal</code> object
    * 
    * @return   the species of animal, as a <code>String</code>
    */
   public String getSpecies()
   {
      return species;
   }
   
   /**
    * Returns the name of the <code>Animal</code> object
    * 
    * @return   the name of animal, as a <code>String</code>
    */
   public String getName()
   {
      return name;
   }
   
   /**
    * Returns a string representing the <code>Animal</code> object.  For a 
    * lion with name Leo it will return the <code>String</code> "Leo, a lion"
    * 
    * @return   a <code>String</code> representation of the animal
    */
   public String toString()
   {
      return name + ", a " + species;
   }
}