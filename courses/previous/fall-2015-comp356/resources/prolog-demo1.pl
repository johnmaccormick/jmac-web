student(gao).
student(nicosia).

course(proglang).
course(dataStructures).
% course(X) :- teaching(_,X).  %% initially, ignore this line

teaching(maccormick,proglang).
teaching(wells,dataStructures).

taking(gao,proglang).
taking(nicosia,proglang).


% Exercise: write a rule for instructor(X)

studentOf(X,Y) :- taking(X,Z), teaching(Y,Z).

% Exercise: write a rule for instructorOf(X,Y)
% Exercise: write a rule for haveClassTogether(X,Y)

% Exercise: write a rule first(E,L) which is true 
%           if E is the first element of list L
% Exercise: similarly for FirstTwo(A,B,L) and firstThree(A,B,C,L)

% Exercise: write a rule final(E,L) which is true 
%           if E is the last element of list L

% Exercise: write isMember(X,L) and isReverse(L1,L2)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 
%% don't look below here -- solutions to in-class exercises
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 





% instructor(X) :- teachingCourse(X,_).

% instructorOf(X,Y) :- teaching(X,Z), taking(Y,Z).

% the first solution below has an interesting problem.
% haveClassTogether(X,Y) :- taking(X,Z), taking(Y,Z)
% haveClassTogether(X,Y) :- taking(X,Z), taking(Y,Z), X\=Y.

% first(E,[E|_]).
% firstTwo(A,B,[A,B|_]).
% firstThree(A,B,C,[A,B,C|_]).

% final(X,[X]).
% final(X,[_|L]) :- final(X,L).

% isMember(X,[X|_]).
% isMember(X,[_|L]) :- isMember(X,L).

% isReverse([], []).
% isReverse([X|L1], L2) :- isReverse(L1, L1Rev), append(L1Rev,[X],L2).
