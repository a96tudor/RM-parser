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
import str.ErrorMessages;
import str.Strings;
import str.UIMessages;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Main {

   private static Parser mParser;
   private static ArrayList<Register> mRegisters;        // list of registers
   private static ArrayList<Instruction> mInstructions;  // list of instructions
   private static int mStartingInstruction;              // the starting instruction
   private static boolean mLogs = false;
   private static PrintWriter mPrinter;

   private static void print_log(int ins, int count) {
      mPrinter.print(count + ". (" + ins);
      for (Register reg: mRegisters) {
         mPrinter.print(", " + reg.getContent());
      }
      mPrinter.println(")");
   }

   private static void execute() {
      int curr = mStartingInstruction;
      int cnt = 1;
      mPrinter.println("INITIAL STATUS : ");
      print_log(-1, 0);
      mPrinter.println(UIMessages.DELIMITER_MESSAGE);
      mPrinter.println();
      while (!(mInstructions.get(curr) instanceof HaltInstruction)) {
         Instruction ins = mInstructions.get(curr);
         int cpy = curr;
         curr = ins.execute();
         if (mLogs) {
            print_log(cpy, cnt);
         }
         if (curr >= mInstructions.size()) {
            // we halt the execution of the machine
            break;
         }
         //printResults();
         cnt++;
      }
      mPrinter.close();
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
      if (args.length >= 1) {
         if (args[0].equals("-log")) {
            mLogs = true;
            String logFile = Strings.DEFAULT_LOG_FILE;
            if (args.length == 2) {
               logFile = args[1];
            }
            try {
               mPrinter = new PrintWriter(logFile);
            } catch (FileNotFoundException e) {
               System.err.print(ErrorMessages.FAILED_OPEN_LOG_FILE);
               mLogs = false;
            }
         }
      }
      mParser = new UIParser();
      loadParsedData();
      execute();
      printResults();
   }

}
