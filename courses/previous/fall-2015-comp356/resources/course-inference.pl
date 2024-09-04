teachingCourse(wells,dataStructures).
teachingCourse(maccormick,introToCS).
teachingCourse(maccormick,proglang).

takingCourse(gao,dataStructures).
takingCourse(gao,proglang).
takingCourse(nicosia,proglang).

teachingStudent(X,Y) :- teachingCourse(X,Z), takingCourse(Y,Z).

/* try query: teachingStudent(maccormick,gao).  */
/* to trace in XGP: trace, teachingStudent(maccormick,gao).  */
