# CS5010-Assignment-8
We remain the MVC structure as what we did in Assignment-7. In this assignment, there are several
 changes including:
 1. We use the Command design pattern and build an interface called Command.
 2. We extract functions which are used to change the image from Controller. 
 3. We use xxxCommand to represent for those functions. Now we are able to use Controller to
  implements all these commands.
  4. There is a class called BatchCommand which is used to read 'batch' from input.txt. 