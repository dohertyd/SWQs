# TopNumbers

Compile javac TopNumbers.java

Usage   java TopNumbers numbers.txt  6
Produces top six numbers from the input file numbers.txt

The algorithim used is simply a priorityQueue inserting the first N elements from the input file
thereafter iterating through the full list n, (n - N) comparisions are carried out against the HEAD
of the Q, if a value is greater than the HEAD then the HEAD is removed this time/Complexity O(1)
and the value is inserted into the Q which is time/Complexity O(log N) as a prioity Q is usually
a binary Heap with min value as the root node. At the end the priority Q contains the required 
list of top numbers.A List is then used to allow printing the Q out in highest first order.

Considering the usual case where N is small compared to n the worst case time would be 
(n -N) comparisions + (n - N)(logN) insertions which gives a Big O of O(nlogN) or O(n).
In most cases the number of insertions needed would be far less an would depend on the
distribtion of numbers relative to the intial priority Q contents.
One way to overcome the intial Q contents bad case scenario is to select at random say 10 * N
values at random from the list and fill the Q first with the highest N values from this.

Improvments to Approach
For large input files a parallel approach would improve speed (Machine/cores Dependent)
Splitting the input file into a number of subfiles and having a seperate thread handle 
each subfile, each thread would have its own priority Q which would be merged into one
at the end.

Another method would be to use a Hadoop Map Reduce job over a number of machines

Support different numbers, any length and type

