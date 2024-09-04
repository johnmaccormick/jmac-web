#include <stdio.h>

// In the following examples, only two of the structs are structurally
// equivalent. (Exercise: which ones?) But experienced C programmers
// occasionally cast non-equivalent pointer types.

typedef struct {
  int i1;
  int i2;
} TwoInts;

typedef struct {
  int i1;
  int i2;
  int i3;
} ThreeInts;

typedef struct {
  float f1;
  float f2;
} TwoFloats;

typedef struct {
  int j1;
  int j2;
} TwoMoreInts;



int main(int argn, char* argv[]) {
  printf("%lu, %lu\n", sizeof(int), sizeof(float));


  TwoInts a;
  a.i1 = 1234;
  a.i2 = 5678;
  printf("%d, %d\n", a.i1, a.i2);

  TwoInts *p = &a;
  printf("%d, %d\n", p->i1, p->i2);

  TwoMoreInts *r = (TwoMoreInts*) &a;
  printf("%d, %d\n", r->j1, r->j2);

  TwoFloats *s = (TwoFloats*) &a;
  printf("%g, %g\n", s->f1, s->f2);

  ThreeInts *q = (ThreeInts*) &a;
  printf("%d, %d\n", q->i1, q->i2);
  /* Exercise: what will the following line produce? */
  /* printf("%d, %d, %d\n", q->i1, q->i2, q->i3); */
}
