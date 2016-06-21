# MapReduce


This consists of two tasks. 
1) Design and Implementation of a streaming version of MapReduce program
2) A Java API version for Document Indexing. This MapReduce program will index the file(s) in HDFS,
   and output the index file that contains lines
                word \t a list of docID:position

   where “word” is any word showing in the documents, “docID” is used to identify
   the documents, and “position” is the byte offset of the indexed word in the
   document.


Streaming Version of the MapReduce Program has been coded in Python and the API version for Document Indexing has been coded in JAVA



## Main Goal

Get familiar with HDFS and mapreduce programming, and understand the basic techniques for constructing a mapreduce solution