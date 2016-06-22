# MapReduce


This consists of two tasks. 
1) Design and Implementation of a streaming version of MapReduce program
2) A Java API version for Document Indexing. This MapReduce program will index the file(s) in HDFS,
   and output the index file that contains lines
                word \t a list of docID:position

   where “word” is any word showing in the documents, “docID” is used to identify
   the documents, and “position” is the byte offset of the indexed word in the
   document.


NOTE:Streaming Version of the MapReduce Program has been coded in Python and the API version for Document Indexing has been coded in JAVA

## Streaming Notes

First we need to check the mapper code and make sure that mapper output is correct so that it will be the input to the reducer. We can doing this by the command called ‘ECHO’ as follows

echo "13 ss dd ff " | python map.py
ss      <13,1>
dd      <13,2>
ff      <13,3>

So we got our output of the mapper correct.

Then we need to execute the reducer code . So the streaming command for this will be
 
hadoop jar $HADOOP_HOME/hadoop-*streaming.jar -mapper "python mapper.py" -reducer "python reducer.py" -input /user/hadoop/text/prj1.txt  -output output2 -file /home/hadoop/examples/wordcount/mapper.py -file /home/hadoop/examples/wordcount/reducer.py

if we execute this command then the following will appear

packageJobJar: [/home/u00717314/map.py, /home/u00717314/reducer.py, /tmp/hadoop-u00717314/hadoop-unjar725185582664128705/] [] /tmp/streamjob1321445056878833012.jar tmpDir=null
13/09/20 18:37:31 INFO mapred.FileInputFormat: Total input paths to process : 1
13/09/20 18:37:31 INFO streaming.StreamJob: getLocalDirs(): [/usr/local/hadoop-datastore/hadoop-u00717314/mapred/local]
13/09/20 18:37:31 INFO streaming.StreamJob: Running job: job_201303042120_1418
13/09/20 18:37:31 INFO streaming.StreamJob: To kill this job, run:
13/09/20 18:37:31 INFO streaming.StreamJob: /usr/local/hadoop/bin/../bin/hadoop job  -Dmapred.job.tracker=localhost:54311 -kill job_201303042120_1418
13/09/20 18:37:31 INFO streaming.StreamJob: Tracking URL: http://localhost:50030/jobdetails.jsp?jobid=job_201303042120_1418
13/09/20 18:37:32 INFO streaming.StreamJob:  map 0%  reduce 0%
13/09/20 18:37:41 INFO streaming.StreamJob:  map 100%  reduce 0%
13/09/20 18:37:52 INFO streaming.StreamJob:  map 100%  reduce 100%
13/09/20 18:37:55 INFO streaming.StreamJob: Job complete: job_201303042120_1418
13/09/20 18:37:55 INFO streaming.StreamJob: Output: output8


Now the streaming job is complete which we can see in the above lines and that map and reduce programs are executed completely without any failure of the job. On the successful completion of the job, the mapreduce runtime creates a_SUCCESS file in the output directory. To display the output the following command is used.

                        bin/hadoop dfs –cat output(8)    _|

output(8) is the value which we have given at the time of streaming. This will appear after entering the above command

-rw-r--r--   1 u00717314 u00717314       1162 2013-09-20 18:37 /user/u00717314/output8/part-00000

-rw--r—are the file permissions. Our output will be stored in part-00000 which displays the respective program. Then the following command is used to display the output on the screen which is as follows

                       bin/hadoop dfs –cat output(8)/part-00000   _|
 
This is the final step of the process which displays the output as follows.

and     <3,7><8,6><15,6><13,10><10,10>
the     <14,5><12,5><11,4><15,2><15,7><16,4><12,2><5,3><7,7><9,5><4,3><3,3><6,4><8,2><2,3><1,6><9,2>
there   <3,2><4,2><5,2>
moon-bird       <5,4>
For     <15,1>
is      <1,2><10,8><13,8>
There   <1,1>
walk    <13,6><10,6><10,3><13,3>
this    <7,4>
To      <6,1><12,1>
street  <2,4><8,4>
sidewalk        <12,6><16,5><1,7>
winds   <8,5>
bright, <4,7>
go      <11,7><14,3>
begins, <2,5>
blows   <7,9>
slow,   <13,11><10,11>
The     <16,1>
before  <2,2>
leave   <7,3>
We      <10,1>
flowers <9,7>
from    <5,6>
asphalt <9,6>
bends.  <8,7>
sun     <4,4>
chalk-white     <14,6><11,5>
that    <10,7><13,7>
black   <7,10>
crimson <4,6>
Let     <7,1>
grows   <3,5>
a       <10,5><13,5><1,3>
ends    <1,8>
his     <5,7>
flight  <5,8>
wind.   <6,6>
shall   <10,2>
with    <13,4><10,4>
watch   <11,2>
dark    <8,3>
know    <15,10>
they    <15,4><15,9>
white,  <3,8>
children,       <15,3><15,8>
burns   <4,5>
measured        <13,9><10,9>
grow    <9,8>
cool    <6,2>
And     <11,1><14,1><8,1><3,1><4,1><5,1><2,1>
go,     <14,8>
we'll   <13,2><14,2>
in      <6,3>
mark,   <15,5>
where   <16,3><12,4><14,4><11,3><7,6><1,5><9,4>
pits    <9,3>
arrows  <14,7><11,6>
peppermint      <6,5>
Past    <9,1>
rests   <5,5>
place   <7,5><1,4><12,3><16,2>
smoke   <7,8>
ends.   <16,6><12,7>
Yes     <13,1>
grass   <3,4>
soft    <3,6>
us      <7,2>
 
This is the Streaming version of a mapreduce program for document indexing.

	
## Main Goal

Get familiar with HDFS and mapreduce programming, and understand the basic techniques for constructing a mapreduce solution
