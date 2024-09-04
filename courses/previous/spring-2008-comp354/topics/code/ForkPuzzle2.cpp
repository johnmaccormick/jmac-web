/*
 * An interesting demonstration of the effects of the fork() system
 * call
 */
 
#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

using namespace std;

int main() {
 
    int pid = fork();

    if (pid != 0) {
        for (int i=0; i<10000; i++) {
            cout << "Parent process running." << endl;
        }
        wait(NULL);  
    }
    else {
        for (int i=0; i<10000; i++) {
            cout << "Child process running." << endl;
        }
    }
}
