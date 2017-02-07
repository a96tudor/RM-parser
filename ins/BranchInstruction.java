package ins;

/**
 * BranchInstruction.java
 * TODO : complete with functionality
 * <p>
 * Created by © Tudor Avram on 03/02/17.
 * Homerton College, University of Cambridge
 * tma33@cam.ac.uk
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
      if (taken) {
         mReg.decrement();
      }
   }
}
