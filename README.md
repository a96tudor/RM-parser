## Synopsis

This is a small interpreter for a register machine. <br \>

A register stores a natural number(including 0) and the Register Machine performs operations over them. <br \>

It can support 3 kinds of instructions : <br \>

(1) Add Instruction : **Rx -> Li** (*adds 1 to the register Rx and proceeds to line Li*) <br \>
(2) Branch Instruction : **Rx -> Li, Lj** <br \>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; If Rx > 0 -> *decrements Rx and proceeds to line Li* <br \>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; If Rx = 0 -> *proceeds to line Lj* <br \>
(3)  Halt Instruction : **HALT**  (*terminates the execution of the program*) <br \>

## Motivation

I created this project for fun and I'm going to maintain it as much as I can. <br \>
For the future, I want to add a file parser and maybe event extend it to work for universal register machines.

## Installation

In order to install this project, you have to perform a few basic operations : <br \> <br \>

(1) Download the repository <br \>
(2) Unarchive the code and save it in your preffered folder <br \>
(3) Compile the source code, by running the following in your console (for bash systems - i.e. Linux and Mac OS) : 
```bash 
./compile.sh
```
It might give you an error (i.e. *Permission denied*). If it does so, just run : 
```bash
sudo ./compile.sh
```
(4) Run the application by, typing : 
```bash
./run.sh
```
to the console. <br \>
(5) Follow the instructions from the UI to enter the register machine

## License

This project is available under standard MIT licence. See [LICENSE.md](LICENSE.md) file for details.
 
