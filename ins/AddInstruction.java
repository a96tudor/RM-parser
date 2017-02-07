package ins;

/**
 * ins.AddInstruction.java
 *
 * Class representing an add instruction.
 *
 * MIT Standard Licence -- © Tudor Avram on 03/02/17.
 *
 */

public class AddInstruction implements Instruction{

   private Register mReg;
   private int mNext;

   /**
    *       CONSTRUCTOR
    * @param r    The register associated with this instruction
    * @param nReg The index of the next instruction
    */
   public AddInstruction(Register r, int nReg) {
      super();
      mReg = r;
      mNext = nReg;
   }

   /**
    *    Increments the contents of the register
    */
   @Override
   public void execute() {
      mReg.inc();
   }

   /**
    *    Method that returns the index of the next instruction
    *
    * @return  the index of the next instruction
    */
   @Override
   public int getNext() {
      return mNext;
   }

}
