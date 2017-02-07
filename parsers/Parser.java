package parsers;

import ins.*;
import str.ErrorMessages;

import java.util.ArrayList;

/**
 * Parser.java
 * TODO : complete with functionality
 * <p>
 * Created by © Tudor Avram on 03/02/17.
 * Homerton College, University of Cambridge
 * tma33@cam.ac.uk
 */

public abstract class Parser {

   protected ArrayList<Register> mRegisters;
   protected ArrayList<Instruction> mInstructions;

   public abstract ArrayList<Register> getRegisters();

   public abstract ArrayList<Instruction> getInstructions();

   public abstract int getFirstInstruction();

   /**
    *       Method that takes an input as a string,
    *    splits it into tokens (i.e. parts of instruction),
    *    creates the right type of instruction and inserts
    *          it into the instructions list.
    *
    * @param ins     The instruction in its raw form
    */
   protected void parseInstruction(String ins) {


      if (ins.equals("HALT")) {
         mInstructions.add(new HaltInstruction());
         return;
      }

      String[] tokens = ins.split(" ");

      if (tokens.length < 2 || tokens.length > 3) {
         // too many or too few arguments
         System.err.println(ErrorMessages.INSTRUCTION_FORMAT_ERROR);
         return; // exiting
      }

      // getting the register number
      if (!tokens[0].startsWith("R")) {
         System.err.println(ErrorMessages.INSTRUCTION_FORMAT_ERROR);
         return;
      }

      Register reg = null;

      try {
         int regIndex = Integer.parseInt(tokens[0].replaceAll("R",""));
         reg = mRegisters.get(regIndex);
      } catch (NumberFormatException e) {
         System.err.println(ErrorMessages.NUMBER_ERROR);
         e.printStackTrace();
         return;
      }

      // getting the 1st goto pointer

      if (!tokens[1].startsWith("L")) {
         System.err.println(ErrorMessages.INSTRUCTION_FORMAT_ERROR);
         return;
      }

      int index1 = 0;

      try {
         index1 = Integer.parseInt(tokens[1].replaceAll("L", ""));
      } catch (NumberFormatException e) {
         System.err.println(ErrorMessages.NUMBER_ERROR);
         e.printStackTrace();
         return;
      }

      if (tokens.length == 2) {
         //it's an add instruction
         mInstructions.add(new AddInstruction(reg, index1));
         return;
      }

      // otherwise, we have to read the index of the next instruction, too

      if (!tokens[2].startsWith("L")) {
         System.err.println(ErrorMessages.INSTRUCTION_FORMAT_ERROR);
         return;
      }

      int index2 = 0;

      try {
         index2 = Integer.parseInt(tokens[2].replaceAll("L",""));
      } catch (NumberFormatException e) {
         System.err.println(ErrorMessages.NUMBER_ERROR);
         return;
      }

      // now we add the branch instruction to the list

      mInstructions.add(new BranchInstruction(reg, index1, index2));
   }

   /**
    *
    *      Method that takes the line with the initial values
    *   of the registers, parses it and inserts the needed registers
    *   to the register list. If there are fewer register values specified
    *   than the actual number of registers, the list if filled with registers
    *                         set to 0
    *
    * @param line       The line containing the inital values of the registers
    * @param lng        The actual number of registers the RM needs
    */
   protected void parseInitialRegisters(String line, int lng) {
      String[] tokens = line.split(" ");

      try {
         for (int i = 0; i < tokens.length; i++) {
            mRegisters.add(new Register(Integer.parseInt(tokens[i])));
         }

         for (int i = tokens.length + 1; i < lng; i++) {
            mRegisters.add(new Register(0));
         }
      } catch (NumberFormatException e) {
         System.err.println(ErrorMessages.NUMBER_ERROR);
         e.printStackTrace();
      }

   }

}
