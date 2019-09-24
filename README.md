# GameOfLife

## Description   
* Consider a two dimensional array with M rows and N columns. 
* This represents the world in  which some organisms live. Each of the M by N cells in this array is either occupied (if an  organism lives there) or is vacant. 
* No more than one organism can live in any one cell at  any time. 
* Each cell, except those on the boundaries (the edge of the world), has exactly  eight neighboring cells (above, below, left, right, and four diagonals).
* The cells on the  boundaries have less than eight neighboring cells.    
* Initially, there is a given population of organisms occupying certain of the cells. 
* At each  succeeding generation, the organisms reproduce and die as follows:  
  * Each organism of the current generation survives to the next generation if, and only  if, it has 2 or 3 neighbors (a neighbor is an organism that lives in a neighboring cell).  Otherwise, it dies and its cell becomes empty in the next generation. Note: it dies if  it is “lonely” or “overcrowded”.
  
  * Each vacant cell in the current generation becomes occupied by a new organism in  the next generation if, and only if, it has exactly 3 neighbors. Otherwise, it remains  vacant in the next generation. 
  
  
For example, suppose the initial world (the “zero”th generation) is as follows, using X to  indicate the occupied cells and blanks for the vacant cells: 
 
 ![1](https://user-images.githubusercontent.com/51673576/65379563-2b3bf480-dc98-11e9-8760-25ff4ade0685.JPG)
 
               
Then the next generation is 
![2](https://user-images.githubusercontent.com/51673576/65379564-2c6d2180-dc98-11e9-83ec-5ebee65153df.JPG)

On the input file, the blanks are represented by dots.  



## Design and Implementation 

* Write a program to play this Game of Life. Your program should read the initial world from  a file with **.dat file(see below)** and repeatedly generate new generations, prompting the user each time  to see if he or she wants to see the next generation or terminate the program. Also, the  program should terminate automatically if the world becomes empty, displaying a message  accordingly (this will happen for ​life3.dat​). 


* Use two-dimensional arrays of type ​char​ to store the old and new generations respectively.  To keep things simple, assume that ​M=25​ and ​N=75​, i.e. the world has 25 rows and 75  columns, and define these in a ​final​ statement before declaring your array variables.  


* Data files for testing your program are provided. You should make sure your program  works correctly on all these files, and you should also try your own test data. If you type  .dat​ after the file name, it will be saved as ​dat​ file. Thus your program would read for  instance, ​file0.dat​. The program should prompt the user for the name of the input file (use  a String variable).  


* Empty cells are represented with dots and occupied cells with X's. Read the data and assign  the data to a two-dimensional array using two nested ​for​ loops. The outer loop reads a  string consisting of the data on a given line of the input file. The inner loop assigns the data  to a given row of the array. 




## Example Output

* When you compile the **GameOfLife.java** file, then you will be asked which file to open. The files(**.dat**) are also provided for your convenience. You can simply type the file name such as life1.dat.

* The sample result is also provided below. 

![testOutput](https://user-images.githubusercontent.com/51673576/65380099-e917b080-dca1-11e9-9716-4f4842c37310.JPG)
