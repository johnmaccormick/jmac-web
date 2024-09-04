
int main() {
    int oneGig = 1<<30;
    int oneK = 1<<10;
    int i;

    /* create a huge array */
    int array_size = oneGig;
    char* array = malloc(array_size);

    /* Optional: initialize the array  */
    for (i = 0; i < array_size; i++) {
        array[i] = i;
    }

    /* Repeatedly access only a small part of the huge array */
    while (1) {
        for (i = 0; i < oneK; i++) {
            array[i]++;
        }
        sleep(1);
    }
}
