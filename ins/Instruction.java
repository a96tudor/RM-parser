package ins;

/**
 * Instruction.java
 *
 *    Interface that gives an outline for instruction classes
 *
 * MIT Standard Licence -- © Tudor Avram on 03/02/17.
 *
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