student(gao).
student(nicosia).

course(proglang).
course(dataStructures).

teachingCourse(maccormick,proglang).
teachingCourse(wells,dataStructures).

instructor(maccormick).
instructor(X) :- teachingCourse(X,_).

teachingStudent(X,Y) :- teachingCourse(X,Z), takingCourse(Y,Z).

takingCourse(gao,proglang).
takingCourse(nicosia,proglang).
takingCourse([],_).
takingCourse([A|B],X) :- takingCourse(A,X), takingCourse(B,X).
