teachingCourse(skalak,algorithms).
teachingCourse(jmac,architecture).
teachingCourse(jmac,ai).

takingCourse(vy,ai).
takingCourse(tim,ai).
takingCourse(jon,algorithms).

teachingStudent(X,Y) :- teachingCourse(X,Z), takingCourse(Y,Z).

/* try query: teachingStudent(jmac,vy).  */
/* try query: teachingStudent(skalak,jon).  */
/* try query: teachingStudent(jmac,jon).  */
