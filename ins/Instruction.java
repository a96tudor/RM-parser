package ins;

/**
 * Instruction.java
 * TODO : complete with functionality
 * <p>
 * Created by © Tudor Avram on 03/02/17.
 * Homerton College, University of Cambridge
 * tma33@cam.ac.uk
 */
public interface Instruction {

   /**
    *     Method that returns the next instruction
    * @return  The ID of the next instruction, as an int if it's a 'normal' instruction and -1 otherwise
    */
   public int getNext();

   /**
    *     Method that executes the given instruction
    */
   public void execute();

}