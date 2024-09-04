import sys

if len(sys.argv)>1:
    num_hellos = int(sys.argv[1])
else:
    num_hellos = 1

if len(sys.argv)>2:
    name = sys.argv[2]
else:
    name = raw_input('Enter your name: ')

for i in range(num_hellos):
    print 'Hello', name
