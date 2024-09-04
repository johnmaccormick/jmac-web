def multiply(input): #/* \label{line:multiplyFunction-def}  */
    # split on whitespace #/* \label{line:multiplyFunction-same}  */
    numberStrings = input.split()  # numberStrings = ["5", "8", "3"] #/* \label{line:multiplyFunction-split}  */

    # convert strings to integers
    numbers = map(int, numberStrings)    # numbers = [5, 8, 3] #/* \label{line:multiplyFunction-convert}  */

    # compute the product of the numbers array
    product = 1  #/* \label{line:multiplyFunction-product}  */
    for n in numbers:
        product = product * n   #/* \label{line:multiplyFunction-product-end}  */
        
    # convert the product to a string, and return it
    productString = str(product) #/* \label{line:multiplyFunction-return}  */
    return productString #/* \label{line:multiplyFunction-return-end}  */

