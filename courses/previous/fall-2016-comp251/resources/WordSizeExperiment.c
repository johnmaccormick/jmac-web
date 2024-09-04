/* This program compares the speed of doing addition on */
/* three basic integral data types (short, int, long). */

/* compile and run with: */
/* gcc WordSizeExperiment.c -o WordSizeExperiment.exe; ./WordSizeExperiment.exe */

#include <sys/time.h>
#include <stdio.h>

int numIters = (int) 1e7;

int doIntExperiment(int increment) {
  int val = 0;
  int i;
  for (i = 0; i < numIters; i++) {
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
  }
  return val;
}

long long doLongExperiment(long long increment) {
  long long val = 0;
  int i;
  for (i = 0; i < numIters; i++) {
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
  }
  return val;
}

short doShortExperiment(short increment) {
  short val = 0;
  int i;
  for (i = 0; i < numIters; i++) {
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
    val += increment; val += increment; val += increment; val += increment; val += increment;
  }
  return val;
}

int main() {
  short increment = 32231; // an arbitrary number
  long long start, stop, durationInt, durationLong, durationShort;
  struct timeval now;

  /* run the experiment for "int"s */
  gettimeofday(&now, NULL); 
  start = now.tv_sec * (int)1e6 + now.tv_usec;
  doIntExperiment((int) increment);
  gettimeofday(&now, NULL); 
  stop = now.tv_sec * (int)1e6 + now.tv_usec;
  durationInt = stop - start;

  /* run the experiment for "long"s */
  gettimeofday(&now, NULL); 
  start = now.tv_sec * (int)1e6 + now.tv_usec;
  doLongExperiment((long long) increment);
  gettimeofday(&now, NULL); 
  stop = now.tv_sec * (int)1e6 + now.tv_usec;
  durationLong = stop - start;

  /* run the experiment for "short"s */
  gettimeofday(&now, NULL); 
  start = now.tv_sec * (int)1e6 + now.tv_usec;
  doShortExperiment((short) increment);
  gettimeofday(&now, NULL); 
  stop = now.tv_sec * (int)1e6 + now.tv_usec;
  durationShort = stop - start;

  /* print out results */
  printf("total time taken (seconds): short %g, int %g, long %g\n", 
	 (float) durationShort/1e6, (float) durationInt/1e6, (float) durationLong/1e6);
  printf("ratio of time taken, compared to int: short/int %f, long/int %f\n", 
	 (float) durationShort / durationInt,
	 (float) durationLong / durationInt);
}


