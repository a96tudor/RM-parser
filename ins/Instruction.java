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
    *     Method that executes the instruction
    *
    *     @return the next line number
    */
   public int execute();

}