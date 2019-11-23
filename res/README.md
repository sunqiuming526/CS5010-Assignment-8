# CS5010-Assignment-8
We remain the MVC structure as what we did in Assignment-7. In this assignment, there are several
 changes including:
 1. We use the Command design pattern and build an interface called Command.
 2. We extract functions which are used to change the image from Controller. 
 3. We use xxxCommand to represent for those functions. Now we are able to use Controller to
    implements all these commands.
 4. There is a class called BatchCommand which is used to read 'batch' from input.txt.

 # Usage
Use the following command to run the program

```bash
java -jar CS5010-Assignment-8.jar [input-file-path]
```

# Command

- load [image-file-path]
- save [image-file-path]
- grey
- sepia
- dither
- mosaic [random-seed-number]

# Image Citation

1. Vu, Andy. “Pexels.” *Pexels*, 13 Nov. 2019, https://www.pexels.com/photo/a-house-near-the-lake-shore-3218137/.

2.  Chuck, Wallace. “Pexels.” *Pexels*, 17 Sept. 2019, https://www.pexels.com/photo/photo-of-man-wearing-headphones-2954389/. 

