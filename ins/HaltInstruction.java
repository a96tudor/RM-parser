package ins;

/**
 * HaltInstruction.java
 * TODO : complete with functionality
 * <p>
 * Created by © Tudor Avram on 03/02/17.
 * Homerton College, University of Cambridge
 * tma33@cam.ac.uk
 */
public class HaltInstruction implements Instruction{

   public HaltInstruction() {
      super();
   }

   public int getNext() {
      return -1;
   }

   public void execute() {

   }

}
