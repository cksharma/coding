
INPUT_FILE = "note.txt"
OUTPUT_FILE  = "note_output.txt"

allIds = set()
goodIds = set()

def processFile():
    fh = open(INPUT_FILE, 'r')
    
    for line in fh:
        if 'loadAccountForBdmAccountIdReq' in line:
            token = line[95:114]
            allIds.add(token)
        elif 'Success' in line and 'bdmAccountId' in line:
            idx = line.index('bdmAccountId')
            cks = line[idx + 16 : idx + 35]
            goodIds.add(cks)
        

if __name__ == "__main__":
    processFile()
    
    print ('Good IDS')
    for good_id in goodIds :
        print (good_id)
    print
    print
    print
    print ('BAD IDS')
    for id in allIds:
        if not id in goodIds:
            print (id)
