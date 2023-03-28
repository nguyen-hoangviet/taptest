import string

alpb = list(string.ascii_lowercase)


def getInt(num):
    try:
        return int(num)
    except:
        return -1


def getFloat(num):
    try:
        return float(num)
    except:
        return -1


def correctFormat(lst, inMax, acros):
    if len(lst) == 0: return False
    if len(lst) == 1: return getInt(lst[0]) == 0
    if len(lst) - 1 != getInt(lst[0]): return False
    for k in range(1, len(lst)):
        s = lst[k].split(" ")
        if len(s) < 2 or len(s) < inMax: return False
        if getInt(s[0]) >= 0 or s[0] not in acros: return False
        for j in range(1, len(s)):
            if getInt(s[j]) < 0: return False
    return True



def countPass(lst, tot, sub, acros, subIns):
    p = 0
    if len(lst) == 1 and getInt(lst[0]) == 0: return 0
    for k in range(getInt(lst[0])):
        s = lst[k + 1].split(" ")
        t = sum(float(s[l]) for l in range(1, len(s)))
        if t >= tot:
            to = sum(float(s[int(j) + 1]) for j in subIns[acros.index(s[0])].split(","))
            if to >= sub: p += 1
    return p


def correctInFor(inds):
    for ind in inds.split(","):
        if getInt(ind) < 0:
            return False
    return True


if __name__ == "__main__":
    acronyms = []
    subjectIns = []
    maxIns = []
    print("Enter total pass score: ")
    x = input()
    while getFloat(x) < 0:
        print("Please enter a positive number. ")
        print("Enter total pass score: ")
        x = input()
    print("Enter subject pass score: ")
    y = input()
    while getFloat(y) < 0:
        print("Please enter a positive number. ")
        print("Enter subject pass score: ")
        y = input()
    print("Enter number of types of subjects: ")
    z = input()
    while getInt(z) <= 0:
        print("Please enter a positive number. ")
        print("Enter number of types of subjects: ")
        z = input()
    for i in range(getInt(z)):
        print("Enter #" + str(i + 1) + " subject type's acronym: ")
        a = input()
        while a not in alpb:
            print("Please enter lowercase alphabet character. ")
            print("Enter #" + str(i + 1) + " subject type's acronym: ")
            a = input()
        acronyms.append(a)
        print("Enter " + a + "'s indexes (ex: 0,2,3): ")
        b = input()
        while not correctInFor(b) or len(b) < 1:
            print("Please enter correct indexes format. ")
            print("Enter " + a + "'s indexes: ")
            b = input()
        subjectIns.append(b)
        maxIns.append(max([getInt(ind) for ind in b.split(",")]))
    inMax = max(maxIns)
    print("Enter exam result: ")
    r = []
    while True:
        line = input()
        if not line:
            break
        r.append(line)
    while not correctFormat(r, inMax, acronyms):
        print("Please enter correct test result format. ")
        print("Enter exam result: ")
        r = []
        while True:
            line = input()
            if not line:
                break
            r.append(line)
    print("Number of passers in the exam is: " + str(countPass(r, float(x), float(y), acronyms, subjectIns)))
