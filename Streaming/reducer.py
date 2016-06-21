from operator import itemgetter
import sys

# maps words to their counts
wordtocount = {}

# input comes from STDIN
for line in sys.stdin:
    # remove leading and trailing whitespace
        line = line.strip()

    # parse the input we got from mapper.py
        words = line.split('\t')
    # convert count (currently a string) to int
        word=words[0]
        DIDpn=words[1]
        if word in wordtocount.keys():
                wordtocount[word]=wordtocount[word]+DIDpn
        else:
                wordtocount[word]=DIDpn
for word,DIDpn in wordtocount.items():
        print '%s\t%s'%(word,DIDpn)
