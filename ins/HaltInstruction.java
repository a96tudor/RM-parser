package ins;

/**
 * HaltInstruction.java
 *
 *    A simple class, representing the HALT instruction
 *
 * MIT Standard Licence -- © Tudor Avram on 03/02/17.
 *
 */
public class HaltInstruction implements Instruction{

   public HaltInstruction() {
      super();
   }


   public int execute() {
      return -1;
   }

}
