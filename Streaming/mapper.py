import sys

# input comes from STDIN (standard input)
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()
    # split the line into words
    words = line.split()
    # increase counters

    DID = words[0]
    wordpn = 0
    for word in words:
        # write the results to STDOUT (standard output);
        # what we output here will be the input for the
        # Reduce step, i.e. the input for reducer.py
        #
        # tab-delimited; the trivial word count is 1


        if wordpn==0:
                 wordpn=wordpn + 1
                 continue
        DIDwordpn="<"+DID+","+str(wordpn)+">"

        wordpn=wordpn + 1
        print(word+"\t" + DIDwordpn)
