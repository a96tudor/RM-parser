package ins;

/**
 * ins.Register.java
 *
 * Class representing a register. It can store any natural number (including 0) and perform operations, such as :
 *       (1) increment
 *       (2) decrement
 *       (3) check if 0
 *
 * MIT Standard Licence -- © Tudor Avram on 03/02/17.
 */
public class Register {

   private int mContent;

   /**
    *    EMPTY COSTRUCTOR
    *
    *    creates a new register, with 0 as content by default
    */
   public Register() {
      mContent = 0;
   }

   /**
    *       CONSTRUCTOR
    *
    *       Sets the content to v if v >= 0 and to 0 otherwise
    *
    * @param v    the initial value mContent
    */
   public Register(int v) {
      if (v >= 0) {
         mContent = v;
      } else {
         mContent = 0;
      }
   }

   /**
    *    Function that increments the content of the register
    */
   public void inc() {
      mContent++;
   }

   /**
    *    Function that checks if the content of the register is 0 or not
    *
    *   @returns  True if the content of the register is 0
    *             False otherwise
    */
   public boolean isZero() {
      return (mContent == 0);
   }

   /**
    *    Function that decrements the contents of the register.
    *    If the content is 0, it does nothing
    */
   public void decrement() {
      if (mContent > 0 ) mContent--;
   }

   /**
    *    Method that returns the contents of the register
    *
    * @return     the natural number associated with the register
    */
   public int getContent() {
      return mContent;
   }

}
