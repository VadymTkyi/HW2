Homework 2 — Sorting and Searching Algorithms

Name: Vadym Tutetskyi  
Programming Language: Java  
IDE / Editor: IntelliJ IDEA   
(Update!!! noticed that wrong acc was making commits...apologies for that)  

ALL QUESTIONS FROM HOMEWORK ARE ANSWERED HERE  

Instead of hardcoding a data set for array manipulation decided to make user-friendly terminal based program that will demonstrate usage   
of   
bubble sort   
merge sort    
linear search    
binary search    

(Of course it lacks input safety, but it would take extra time to implement so user has to follow what is asked from him to not make program crash)     
It mainly work based on switch case system and given menu options      
user can decide what he wants to do with randomly created data set and see how different sorting and searching algo works     
of course some options does not work without some prerequisites, i. e user cannot invoke binary search without sorting     
the array by some of provided sorting options   
[    
boolean isBubbleSorted = false;    
boolean isMergeSorted = false;    
int[] bubbleSortedArray = null;//temporaryContainers    
int[] mergeSortedArray = null;//temporaryContainers    
]    
this chunk of code is main brain of the program their values decide can or can't some portion of code be executed   

                                         QUESTION ANSWERS
PART 4 Bubble Sort Big O  

Question 1 and 2 

The worst case of bubble sort time complexity is O(n^2)  

It has such complexity because it requires nested loops, when outer loop doing one loop inner going though entire array of elements  
this makes amount of computation needed to finish the loop grow in 0(n^2) amount of iterations

Question 3  

Since we know now that bubble sort takes O(n^2) to complete we may put 10 and 1000 elements into the formula  

O(10^2) = 100 while O(1000^2) = 10^6 and this is much larger amount of comparisons 

Question 4  

the time complexity of merge sort is O(n log n)  

Question 5  

merge sort performs much better because its time complexity is amount of elements times the log of them while bubble sort   
is amount of elements in the array times itself so it is much bigger number and thus less efficient

Question 6  
merge sort == O(n log n)

bubble sort == O (n^2)

Question 7  

linear search time complexity in worst case is the length of data set itself so O(n) 

Question 8 

binary search time complexity is O(log n)  which is much better on larger data sets that linear search

Question 9 
  
binary search require sorted data because the algorithm itself checks for larger and lower values and it relies on that larger are on right side while lower are on left side
  
Question 10 and 11   
if data is not sorted, and it is relatively small data set I would use linear search because it will require less work  
but if the data set is quite big I would first sort it and use binary search in order to safe time  
also if I know that I would search same data set more than a couple of times I might still sort it since single sort would then allow me to spend less time on each binary search  

Question 12 Comparison Table        

Algorithm           Purpose             Big O       
Bubble sort         sorting             O(n^2)          
Merge sort          sorting             O(n log n)      
Linear search       searching           O(n)        
Binary search       searching           O(log n)    



