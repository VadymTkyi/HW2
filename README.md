Homework 2 — Sorting and Searching Algorithms

Name: Vadym Tutetskyi  
Programming Language: Java  
IDE / Editor: IntelliJ IDEA   
(Update!!! noticed that wrong acc was making commits...apologies for that)

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



