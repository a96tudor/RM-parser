package ins;

/**
 * BranchInstruction.java
 *
 *    A class representing a branch instruction.
 *    The behaviour is as follows :
 *        - If the contents of the register is 0, it returns the 2nd line number
 *        - Otherwise, it decrements the register and returns the 1st line number
 *
 * MIT Standard Licence -- © Tudor Avram on 03/02/17.
 *
 */
public class BranchInstruction implements Instruction{

   private Register mReg;
   private int mNextTaken;
   private int mNextNotTaken;
   private boolean taken;

   /**
    *       CONSTRUCTOR
    *
    * @param r          the register associated with the instruction
    * @param nTaken     the index of the next instruction, if the branch is taken
    * @param nNotTaken  the index of the next instruction, if the branch is not taken
    */
   public BranchInstruction(Register r, int nTaken, int nNotTaken) {
      mReg = r;
      mNextNotTaken = nNotTaken;
      mNextTaken = nTaken;
      taken =  mReg.isZero();
   }

   /**
    *    Method that returns the accurate index of the next instruction
    * @return  - mNextTaken if the branch is taken
    *          - mNextNotTaken otherwise
    */
   @Override
   public int getNext() {
      if (taken) {
         return mNextTaken;
      } else {
         return mNextNotTaken;
      }
   }

   /**
    *    Method that executes the instruction (i.e. decrements mReg)
    */
   @Override
   public void execute() {
      mReg.decrement();
   }
}
