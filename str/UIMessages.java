package str;

/**
 * UIMessages.java
 *
 *    A class storing all the messages that are being printed to the UI
 *
 * MIT Standard Licence -- © Tudor Avram on 03/02/17.
 *
 */
public class UIMessages {


   /*
         UI MESSAGES
    */

   public static final String GET_NUMBER_OF_REGISTERS =
           "Please specify how many registers your machine will use : ";

   public static final String GET_INITIAL_STATE_OF_REGISTERS =
           "Please specify the initial values of the registers as a stream of natural numbers" +
                   ", separated by space. Note : R0 and the unspecified registers are by default 0.";

   public static final String GET_INSTRUCTIONS =
           "Please specify the instructions your register machine will use, one per line in the format : \n " +
                   "Rx Ly -> for normal add instructions \n" +
                   "Rx Ly Lx -> for branch instructions \n" +
                   "HALT -> for halt instructions \n" +
                   "done -> to specify the end of the instructions stream";

   public static final String GET_STARTING_INSTRUCTION =
           "Please specify the starting instruction for your register machine in the format : Lx";

   private static final String DELIMITER_MESSAGE =
           "---------------------------------------------------------------------------------------------------";

   public static void printDelimiter() {
      // making it look pretty :D
      System.out.println();
      System.out.println(UIMessages.DELIMITER_MESSAGE);
      System.out.println();
   }
}
