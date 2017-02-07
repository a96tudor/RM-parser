package parsers;

/**
 * UIParser.java
 *
 *    A parser that reads the information from stdin
 *
 *
 * MIT Standard Licence -- © Tudor Avram on 03/02/17.
*/

 import ins.Register;
import ins.Instruction;
import str.ErrorMessages;
import str.UIMessages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UIParser extends Parser{

   private BufferedReader reader;

   public UIParser() {
      super();
      reader = new BufferedReader(new InputStreamReader(System.in));

   }

   /**
    *       Method that 'talks' to the user using the UI and
    *    gets the following information out of him :
    *
    *                -  The total number of registers
    *                -  The initial values of the registers
    * @return     The list of registers
    */
   @Override
   public ArrayList<Register> getRegisters() {

      mRegisters = new ArrayList<>();
      mRegisters.add(new Register(0));  // adding R0
      System.out.println(UIMessages.GET_NUMBER_OF_REGISTERS);

      String input;
      int n = 0;      // size of the registers list

      // Reading the number of registers
      try {
         input = reader.readLine();
         n = Integer.parseInt(input);
      } catch (IOException e) {
         // Couldn't read useful information
         System.err.println(ErrorMessages.IO_ERROR);
         e.printStackTrace();
      } catch (NumberFormatException e) {
         // The input was not a valid number
         System.err.println(ErrorMessages.NUMBER_ERROR);
         e.printStackTrace();
         Runtime.getRuntime().exit(0);
      }

      System.out.println(UIMessages.GET_INITIAL_STATE_OF_REGISTERS);
      // reading the inital values of the registers
      try {
         input = reader.readLine();
         parseInitialRegisters(input, n);
      } catch (IOException e) {
         System.err.println(ErrorMessages.IO_ERROR);
         e.printStackTrace();
      }

      return mRegisters;
   }

   /**
    *       Method that 'talks' to the user using the UI and
    *    gets the following information out of him :
    *
    *                - The instructions
    *
    * @return     The list of instructions
    */
   @Override
   public ArrayList<Instruction> getInstructions() {

      UIMessages.printDelimiter();

      mInstructions = new ArrayList<>();


      System.out.println(UIMessages.GET_INSTRUCTIONS);
      System.out.println();
      // actual useful work
      try {
         String input = reader.readLine();
         while (!input.equals("done")) {
            // we read stuff
            parseInstruction(input);
            input = reader.readLine();
         }
      } catch (IOException e) {
         System.err.println(ErrorMessages.IO_ERROR);
         e.printStackTrace();
         Runtime.getRuntime().exit(0);
      }
      return mInstructions;
   }

   /**
    *       Method that 'talks' to the user using the UI and
    *    gets the following information out of him :
    *
    *                -  The index of the starting instruction
    *
    * @return     The list of instructions
    */
   @Override
   public int getFirstInstruction() {

      UIMessages.printDelimiter();


      System.out.println(UIMessages.GET_STARTING_INSTRUCTION);
      int result = 0;

      try {
         String input = reader.readLine();
         result = Integer.parseInt(input);
         if (result < 0 || result >= mInstructions.size()) {
            // it's out of range
            System.err.println(ErrorMessages.INDEX_OUT_OF_RANGE_ERROR);
            result = 0;
         }
      } catch (IOException e) {
         System.err.println(ErrorMessages.IO_ERROR);
         e.printStackTrace();
         Runtime.getRuntime().exit(0);
      } catch (NumberFormatException e) {
         System.err.println(ErrorMessages.NUMBER_ERROR);
         Runtime.getRuntime().exit(0);
      }

      return result;
   }
}
