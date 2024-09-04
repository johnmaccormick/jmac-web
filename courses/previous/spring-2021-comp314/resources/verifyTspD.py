import utils; from utils import rf
from graph import Graph, Path
def verifyTspD(I, S, H): #/* \firstDisplayLine */
    if S == 'no': return 'unsure' #/* \label{line:verifyTspD-no}  */
    # extract G,L from I, and convert to correct data types etc.
    (G,L) = I.split(';')
    G = Graph(G, directed=False); L = int(L)

    # split the hint string into a list of vertices, which will
    # form a Hamilton cycle of length at most L, if the hint is correct
    cycle = Path(H.split(','))
    
    # verify the hint is a Hamilton cycle, and has length at most L
    if G.isHamiltonCycle(cycle) and \
               G.cycleLength(cycle) <= L:
        return 'correct'
    else:
        return 'unsure' #/* \lastDisplayLine */

def testVerifyTspD():
    G = 'a,b,5 a,c,9 b,d,1 d,c,6'
    S = 'yes'
    for (L, H) in \
        [ (22, 'a,b,d,c' ), \
          (21, 'a,b,d,c' ), \
          (20, 'a,b,d,c' ), \
          (23, 'a,b,d' ), \
          (23, 'a,b,c,d' ), \
          ]:
        I = G + ';' + str(L)
        print(I, H, ':', verifyTspD(I, S, H))


if __name__ == '__main__':
    testVerifyTspD()
