/**
 * Main.java
 *
 *    Main Class for a register machine interpreter
 *
 * MIT Standard Licence -- © Tudor Avram -- 03/02/17
 *
 */

import ins.HaltInstruction;
import ins.Instruction;
import ins.Register;
import parsers.Parser;
import parsers.UIParser;
import str.UIMessages;

import java.util.ArrayList;
public class Main {

   private static Parser mParser;
   private static ArrayList<Register> mRegisters;        // list of registers
   private static ArrayList<Instruction> mInstructions;  // list of instructions
   private static int mStartingInstruction;              // the starting instruction

   private static void execute() {
      int curr = mStartingInstruction;
      int cnt = 0;
      while (!(mInstructions.get(curr) instanceof HaltInstruction)) {
         Instruction ins = mInstructions.get(curr);
         curr = ins.execute();
         if (curr >= mInstructions.size()) {
            // we halt the execution of the machine
            break;
         }
         //printResults();
         cnt++;
      }

   }

   private static void printResults() {
      UIMessages.printDelimiter();
      for (Register reg:mRegisters) {
         System.out.print(reg.getContent() + " ");
      }

   }

   private static void loadParsedData() {
      mRegisters = mParser.getRegisters();
      mInstructions = mParser.getInstructions();
      mStartingInstruction = mParser.getFirstInstruction();
   }

   public static void main(String args[]) {
      mParser = new UIParser();
      loadParsedData();
      execute();
      printResults();
   }

}
