package edu.mtsu.csci3033;


/**
 * Student code goes below here!
 *
 *  Shawn Rhoades
 *  Project 2 - Fall18
 *
 *  Complete each method below so all test cases pass
 *  Do not hard code results. Will be graded with different test cases.
 *  Build your own test cases and add them to MyBrokenStringTest.
 *  (especially on those items below which do not already have test cases)
 *
 *  Note:
 *  Do not import third party libraries
 *
 */
public class MyBrokenString implements BrokenStringInterface {

    private String myBrokenString;

    /**
     *
     * Resets myBrokenString before each test with -> @BeforeEach
     */
    @Override
    public void setBrokenString(String inputString) {
        this.myBrokenString = inputString;
    }

    @Override
    public String getBrokenString() {
        return this.myBrokenString;
    }

    /**
     *
     * Returns just the even items from a string
     */
    @Override
    public StringBuilder getEvenCharacters() throws NullPointerException  {

        StringBuilder evenItems = new StringBuilder();
        for (int i = 0; i < this.myBrokenString.length(); i++)
        {
            if ((i % 2) == 0)
                evenItems.append(this.myBrokenString.charAt(i));
        }
        return evenItems;
    }

    /**
     *
     * Returns just the odd items from a string
     */
    @Override
    public StringBuilder getOddCharacters() throws NullPointerException  {

        StringBuilder oddItems = new StringBuilder();
        for (int i = 0; i < this.myBrokenString.length(); i++)
        {
            if ((i % 2 ) != 0)
                oddItems.append(this.myBrokenString.charAt(i));
        }
        return oddItems;
    }

    /**
     *
     * Returns total count of individual digits in a String
     */
    @Override
    public int countDigits() throws NullPointerException  {
        int numDigits = 0;
        for (int i = 0; i < this.myBrokenString.length(); i++)
        {
            if (Character.isDigit(this.myBrokenString.charAt(i)))
                numDigits++;
        }
        return numDigits;
    }

    /**
     *
     * Removes digits from String
     */
    @Override
    public StringBuilder numbersDroppedString()  throws NullPointerException {
        StringBuilder noNumberString = new StringBuilder();
        for (int i = 0; i < this.myBrokenString.length(); i++)
        {
            if (!Character.isDigit(this.myBrokenString.charAt(i)))
                noNumberString.append(this.myBrokenString.charAt(i));
        }
        return noNumberString;
    }

    /**
     *
     * Removes commas from String
     */
    @Override
    public StringBuffer commasDroppedString() throws NullPointerException {
        StringBuffer noCommasString = new StringBuffer();
        noCommasString.append(this.myBrokenString);
        for (int i = 0; i < noCommasString.length(); i++)
        {
            if (noCommasString.charAt(i) == ',')
                noCommasString.deleteCharAt(i);
        }

        return noCommasString;
    }

    /**
     *
     * Removes spaces from String
     */
    @Override
    public StringBuilder spacesDroppedString() throws NullPointerException {
        StringBuilder noSpacesString = new StringBuilder();
        for (int i = 0; i < this.myBrokenString.length(); i++)
        {
            if (this.myBrokenString.charAt(i) != ' ')
                noSpacesString.append(this.myBrokenString.charAt(i));
        }
        return noSpacesString;
    }

    /**
     *
     * Sorts String in ascending order
     */
    @Override
    public String sortedAscendingString() throws NullPointerException
    {
        //build an array of Chars from our string
        //establish a temp char to use as storage during comparison
        char[] workingArray = this.myBrokenString.toCharArray();
        char tempChar;

        //Compare the array using nested for loop and our tempChar
        for (int i = 0; i < workingArray.length; i++)
        {
            for (int k = 0; k < workingArray.length; k++)
            {
                if (workingArray[i] < workingArray[k])
                {
                    tempChar = workingArray[i];
                    workingArray[i] = workingArray[k];
                    workingArray[k] = tempChar;
                }
            }
        }

        //return the new string which is built using
        //our array of chars
        return new String(workingArray);
    }

    /**
     *
     * Sorts String in descending order
     */
    @Override
    public String sortedDescendingString() throws NullPointerException {
        //build an array of Chars from our string
        //establish a temp char to use as storage during comparison
        char[] workingArray = this.myBrokenString.toCharArray();
        char tempChar;

        //Compare the array using nested for loop and our tempChar
        for (int i = 0; i < workingArray.length; i++)
        {
            for (int k = 0; k < workingArray.length; k++)
            {
                if (workingArray[i] > workingArray[k])
                {
                    tempChar = workingArray[i];
                    workingArray[i] = workingArray[k];
                    workingArray[k] = tempChar;
                }
            }
        }

        //return the new string which is built using
        //our array of chars
        return new String(workingArray);
    }

    /**
     *
     * Reverses a String
     */
    @Override
    public String getReverseString() throws NullPointerException {
        StringBuilder reverseString = new StringBuilder();

        //loop through our original string backwards, append to stringbuilder
        for (int i = (this.myBrokenString.length()-1); i >= 0; i--)
        {
            reverseString.append(this.myBrokenString.charAt(i));
        }

        return reverseString.toString();
    }

    /**
     * Converts digits in a string to words, 9 converts to nine or 90 to ninety.
     * These may occur in a sentence or by themselves.
     * Write your own test cases.
     */
    @Override
    public StringBuilder convertDigitsToStrings() throws NullPointerException {
        StringBuilder digitsToStrings = new StringBuilder();

        //loop through the original string item by item
        //if a char is found that matches a number
        //we will append the stringbuilder with the word as opposed to the number
        for (int i = 0; i < this.myBrokenString.length(); i++)
        {
            if (!Character.isDigit(this.myBrokenString.charAt(i)))
            {
                digitsToStrings.append(this.myBrokenString.charAt(i));
            }
            else if (Character.isDigit(this.myBrokenString.charAt(i)) && !Character.isDigit(this.myBrokenString.charAt(i+1)))
            {
                switch(this.myBrokenString.charAt(i))
                {
                    case '0':
                    {
                        if (i == 0)
                            digitsToStrings.append("Zero");
                        else
                            digitsToStrings.append("zero");
                    }break;
                    case '1':
                    {
                        if (i == 0)
                            digitsToStrings.append("One");
                        else
                            digitsToStrings.append("one");
                    }break;
                    case '2':
                    {
                        if (i == 0)
                            digitsToStrings.append("Two");
                        else
                            digitsToStrings.append("two");
                    }break;
                    case '3':
                    {
                        if (i == 0)
                            digitsToStrings.append("Three");
                        else
                            digitsToStrings.append("three");
                    }break;
                    case '4':
                    {
                        if (i == 0)
                            digitsToStrings.append("Four");
                        else
                            digitsToStrings.append("four");
                    }break;
                    case '5':
                    {
                        if (i == 0)
                            digitsToStrings.append("Five");
                        else
                            digitsToStrings.append("five");
                    }break;
                    case '6':
                    {
                        if (i == 0)
                            digitsToStrings.append("Six");
                        else
                            digitsToStrings.append("six");
                    }break;
                    case '7':
                    {
                        if (i == 0)
                            digitsToStrings.append("Seven");
                        else
                            digitsToStrings.append("seven");
                    }break;
                    case '8':
                    {
                        if (i == 0)
                            digitsToStrings.append("Eight");
                        else
                            digitsToStrings.append("eight");
                    }break;
                    case '9':
                    {
                        if (i == 0)
                            digitsToStrings.append("Nine");
                        else
                            digitsToStrings.append("nine");
                    }break;
                }
            }
            //if there is a 2 digit number, parse into an integer
            //then evaluate the integer
            else if (Character.isDigit(this.myBrokenString.charAt(i)) && Character.isDigit(this.myBrokenString.charAt(i+1)))
            {
                int tensValue = Character.getNumericValue(this.myBrokenString.charAt(i));
                int singlesValue = Character.getNumericValue(this.myBrokenString.charAt(i+1));

                if (tensValue == 1)
                {
                    switch(singlesValue) {
                        case 0: {
                            if (i == 0)
                                digitsToStrings.append("Ten");
                            else
                                digitsToStrings.append("ten");
                            i++;
                        }
                        break;
                        case 1: {
                            if (i == 0)
                                digitsToStrings.append("Eleven");
                            else
                                digitsToStrings.append("eleven");
                            i++;
                        }
                        break;
                        case 2: {
                            if (i == 0)
                                digitsToStrings.append("Twelve");
                            else
                                digitsToStrings.append("twelve");
                            i++;
                        }
                        break;
                        case 3: {
                            if (i == 0)
                                digitsToStrings.append("Thirteen");
                            else
                                digitsToStrings.append("thirteen");
                            i++;
                        }
                        break;
                        case 4: {
                            if (i == 0)
                                digitsToStrings.append("Fourteen");
                            else
                                digitsToStrings.append("fourteen");
                            i++;
                        }
                        break;
                        case 5: {
                            if (i == 0)
                                digitsToStrings.append("Fifteen");
                            else
                                digitsToStrings.append("fifteen");
                            i++;
                        }
                        break;
                        case 6: {
                            if (i == 0)
                                digitsToStrings.append("Sixteen");
                            else
                                digitsToStrings.append("sixteen");
                            i++;
                        }
                        break;
                        case 7: {
                            if (i == 0)
                                digitsToStrings.append("Seventeen");
                            else
                                digitsToStrings.append("seventeen");
                            i++;
                        }
                        break;
                        case 8: {
                            if (i == 0)
                                digitsToStrings.append("Eighteen");
                            else
                                digitsToStrings.append("eighteen");
                            i++;
                        }
                        break;
                        case 9: {
                            if (i == 0)
                                digitsToStrings.append("Nineteen");
                            else
                                digitsToStrings.append("nineteen");
                            i++;
                        }
                        break;
                    }

                }
                else if (tensValue > 1)
                {
                    switch(tensValue) {
                        case 2: {
                            if (i == 0)
                                digitsToStrings.append("Twenty ");
                            else
                                digitsToStrings.append("twenty ");
                        }
                        break;
                        case 3: {
                            if (i == 0)
                                digitsToStrings.append("Thirty ");
                            else
                                digitsToStrings.append("thirty ");
                        }
                        break;
                        case 4: {
                            if (i == 0)
                                digitsToStrings.append("Forty ");
                            else
                                digitsToStrings.append("forty ");
                        }
                        break;
                        case 5: {
                            if (i == 0)
                                digitsToStrings.append("Fifty ");
                            else
                                digitsToStrings.append("fifty ");
                        }
                        break;
                        case 6: {
                            if (i == 0)
                                digitsToStrings.append("Sixty ");
                            else
                                digitsToStrings.append("sixty ");
                        }
                        break;
                        case 7: {
                            if (i == 0)
                                digitsToStrings.append("Seventy ");
                            else
                                digitsToStrings.append("seventy");
                        }
                        break;
                        case 8: {
                            if (i == 0)
                                digitsToStrings.append("Eighty ");
                            else
                                digitsToStrings.append("eighty ");
                        }
                        break;
                        case 9: {
                            if (i == 0)
                                digitsToStrings.append("Ninety ");
                            else
                                digitsToStrings.append("ninety ");
                        }
                        break;
                    }
                    switch(singlesValue) {
                        case '0':
                            i++;
                            break;
                        case '1':
                            digitsToStrings.append("one");
                            i++;
                            break;
                        case '2':
                            digitsToStrings.append("two");
                            i++;
                            break;
                        case '3':
                            digitsToStrings.append("three");
                            i++;
                            break;
                        case '4':
                            digitsToStrings.append("four");
                            i++;
                            break;
                        case '5':
                            digitsToStrings.append("five");
                            i++;
                            break;
                        case '6':
                            digitsToStrings.append("six");
                            i++;
                            break;
                        case '7':
                            digitsToStrings.append("seven");
                            i++;
                            break;
                        case '8':
                            digitsToStrings.append("eight");
                            i++;
                            break;
                        case '9':
                            digitsToStrings.append("nine");
                            i++;
                            break;
                    }

                }


            }
        }
        return digitsToStrings;
    }

    /**
     * Converts word representations of numbers, like nine to 9, or ninety to 90
     * These may occur in a sentence or by themselves.
     * 	Write your own test cases.
     */
    @Override
    public StringBuilder convertWordNumbersToDigits() throws NullPointerException {
        //building an array from our original string
        //array is each part of the string, split using the spaces
        String[] arrayOfStrings = this.myBrokenString.split(" ");
        //currentNumber will be used to track double digit numbers of 20 and above
        int currentNumber;
        StringBuilder finalString = new StringBuilder();

        for (int i = 0; i < arrayOfStrings.length; i++)
        {
            //currentNumber is reset each loop
            //if a word is found that matches a number, append the StringBuilder with the number
            //or add it to Current Number if it's double digit
            currentNumber = 0;
            //each time, we will check if a string matches, or contains a word representation of a digit
            //we will use matches, and regex markers to see if the word is part of a longer string
            if (arrayOfStrings[i].equalsIgnoreCase("zero") || arrayOfStrings[i].matches("(?i)ZERO(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)zero", "0");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("one") || arrayOfStrings[i].matches("(?i)ONE(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)one", "1");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("two") || arrayOfStrings[i].matches("(?i)two(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)two", "2");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("three") || arrayOfStrings[i].matches("(?i)three(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)three", "3");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("four") || arrayOfStrings[i].matches("(?i)four(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)four", "4");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("five") || arrayOfStrings[i].matches("(?i)five(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)five", "5");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("six") || arrayOfStrings[i].matches("(?i)six(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)six", "6");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("seven") || arrayOfStrings[i].matches("(?i)seven(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)seven", "7");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("eight") || arrayOfStrings[i].matches("(?i)eight(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)eight", "8");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("nine") || arrayOfStrings[i].matches("(?i)nine(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)nine", "9");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("ten") || arrayOfStrings[i].matches("(?i)ten(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)ten", "10");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("eleven") || arrayOfStrings[i].matches("(?i)eleven(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)eleven", "11");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("twelve") || arrayOfStrings[i].matches("(?i)twelve(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)twelve", "12");
                finalString.append(arrayOfStrings[i]);
            } else if  (arrayOfStrings[i].equalsIgnoreCase("thirteen") || arrayOfStrings[i].matches("(?i)thirteen(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)thirteen", "13");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("fourteen") || arrayOfStrings[i].matches("(?i)fourteen(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)fourteen", "14");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("fifteen") || arrayOfStrings[i].matches("(?i)fifteen(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)fifteen", "15");
                finalString.append(arrayOfStrings[i]);
            } else if  (arrayOfStrings[i].equalsIgnoreCase("sixteen") || arrayOfStrings[i].matches("(?i)sixteen(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)sixteen", "16");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("seventeen") || arrayOfStrings[i].matches("(?i)seventeen(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)seventeen", "17");
                finalString.append(arrayOfStrings[i]);
            } else if  (arrayOfStrings[i].equalsIgnoreCase("eighteen") || arrayOfStrings[i].matches("(?i)eighteen(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)eighteen", "18");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("nineteen") || arrayOfStrings[i].matches("(?i)nineteen(.*)"))
            {
                arrayOfStrings[i] = arrayOfStrings[i].replaceAll("(?i)nineteen", "19");
                finalString.append(arrayOfStrings[i]);
            } else if (arrayOfStrings[i].equalsIgnoreCase("twenty")) {
                currentNumber += 20;
            } else if (arrayOfStrings[i].equalsIgnoreCase("thirty")) {
                currentNumber += 30;
            } else if (arrayOfStrings[i].equalsIgnoreCase("forty")) {
                currentNumber += 40;
            } else if (arrayOfStrings[i].equalsIgnoreCase("fifty")) {
                currentNumber += 50;
            } else if (arrayOfStrings[i].equalsIgnoreCase("sixty")) {
                currentNumber += 60;
            } else if (arrayOfStrings[i].equalsIgnoreCase("seventy")) {
                currentNumber += 70;
            } else if (arrayOfStrings[i].equalsIgnoreCase("eighty")) {
                currentNumber += 80;
            } else if (arrayOfStrings[i].equalsIgnoreCase("ninety")) {
                currentNumber += 90;
            }
            else
            {
                finalString.append(arrayOfStrings[i]);
            }

            //if the world value indicates double digit above 19, we will seek the second digit in the next index of array
            //if there is a number, we will add it
            if ((currentNumber > 19)) {
                if (arrayOfStrings[i + 1].equalsIgnoreCase("one")) {
                    currentNumber += 1;
                    i++;
                } else if (arrayOfStrings[i + 1].equalsIgnoreCase("two")) {
                    currentNumber += 2;
                    i++;
                } else if (arrayOfStrings[i + 1].equalsIgnoreCase("three")) {
                    currentNumber += 3;
                    i++;
                } else if (arrayOfStrings[i + 1].equalsIgnoreCase("four")) {
                    currentNumber += 4;
                    i++;
                } else if (arrayOfStrings[i + 1].equalsIgnoreCase("five")) {
                    currentNumber += 5;
                    i++;
                } else if (arrayOfStrings[i + 1].equalsIgnoreCase("six")) {
                    currentNumber += 6;
                    i++;
                } else if (arrayOfStrings[i + 1].equalsIgnoreCase("seven")) {
                    currentNumber += 7;
                    i++;
                } else if (arrayOfStrings[i + 1].equalsIgnoreCase("eight")) {
                    currentNumber += 8;
                    i++;
                } else if (arrayOfStrings[i + 1].equalsIgnoreCase("nine")) {
                    currentNumber += 9;
                    i++;
                }finalString.append(Integer.toString(currentNumber));

            }
            //to ensure proper spacing, we need to add spaces back into our string.
            if (i < arrayOfStrings.length - 1)
                finalString.append(" ");

        }
        return finalString;
    }

    /**  BONUS
     * Converts numbers in a string to Roman Numerals,
     * 25 converts to XXV and 1025 converts to MXXV
     * These may occur in a sentence or by themselves.
     * Write your own test cases
     */
    @Override
    public StringBuilder convertDigitsToRomans() throws NullPointerException
    {
        StringBuilder digitsToRomans = new StringBuilder();
        int pullFromString, hundredsValue, tensValue, onesValue;

        //loop through the original string if a digit is found, grab each attached digit
        //once a digit is found, while loop will kick in
        for (int i = 0; i < this.myBrokenString.length(); i++)
        {
            //if no digit is found, just append to the StringBuilder digitsToRomans
            if (!Character.isDigit(this.myBrokenString.charAt(i)))
            {
                digitsToRomans.append(this.myBrokenString.charAt(i));
            }
            //if Digit is found, then we will test the following digits to grab the scope of the number
            //if a 3 digit # is found or a 2 digit # is found, we iterate i appropriately to avoid working
            //the same numbers
            else if (Character.isDigit(this.myBrokenString.charAt(i)))
            {
                if (Character.isDigit(this.myBrokenString.charAt(i+1)) && Character.isDigit(this.myBrokenString.charAt(i+2)))
                {
                    pullFromString = Integer.parseInt(this.myBrokenString.substring(i,i+3));
                    i+=2;
                }
                else if(Character.isDigit(this.myBrokenString.charAt(i+1)) && !Character.isDigit(this.myBrokenString.charAt(i+2)))
                {
                    pullFromString = Integer.parseInt(this.myBrokenString.substring(i,i+2));
                    i+=1;
                }
                else
                    pullFromString = Integer.parseInt(this.myBrokenString.substring(i,i+1));

                //we will start a new Stringbuilder that will be used to piece together whatever
                //roman numbers are needed
                StringBuilder integerString = new StringBuilder();
                //start breaking down the int, if it's above 100, get the hundreds value
                if (pullFromString >= 100)
                {
                    hundredsValue = pullFromString / 100;
                    if (hundredsValue == 1)
                        integerString.append("C");
                    else if (hundredsValue == 2)
                        integerString.append("CC");
                    else if (hundredsValue == 3)
                        integerString.append("CCC");
                    else if (hundredsValue == 4)
                        integerString.append("CD");
                    else if (hundredsValue == 5)
                        integerString.append("D");
                    else if (hundredsValue == 6)
                        integerString.append("DC");
                    else if (hundredsValue == 7)
                        integerString.append("DCC");
                    else if (hundredsValue == 8)
                        integerString.append("DCCC");
                    else if (hundredsValue == 9)
                        integerString.append("CM");
                }
                //now evaluate the 10 digit values
                if (pullFromString >= 10)
                {
                    tensValue = (pullFromString % 100) / 10;
                    if (tensValue == 1)
                        integerString.append("X");
                    else if (tensValue == 2)
                        integerString.append("XX");
                    else if (tensValue == 3)
                        integerString.append("XXX");
                    else if (tensValue == 4)
                        integerString.append("XL");
                    else if (tensValue == 5)
                        integerString.append("L");
                    else if (tensValue == 6)
                        integerString.append("LX");
                    else if (tensValue == 7)
                        integerString.append("LXX");
                    else if (tensValue == 8)
                        integerString.append("LXXX");
                    else if (tensValue == 9)
                        integerString.append("XC");
                }

                onesValue = (pullFromString % 100) % 10;
                //evaluate the Ones values, and store as an update roman number
                //append the stringbuilder accordingly
                if (onesValue ==0)
                    integerString.append("0");
                else if (onesValue == 1)
                    integerString.append("I");
                else if (onesValue == 2)
                    integerString.append("II");
                else if (onesValue == 3)
                    integerString.append("III");
                else if (onesValue == 4)
                    integerString.append("IV");
                else if (onesValue == 5)
                    integerString.append("V");
                else if (onesValue == 6)
                    integerString.append("VI");
                else if (onesValue == 7)
                    integerString.append("VII");
                else if (onesValue == 8)
                    integerString.append("VIII");
                else if (onesValue == 9)
                    integerString.append("IX");

                digitsToRomans.append(integerString.toString());
            }

        }
        return digitsToRomans;
    }

    /**  SUPER BONUS
     * Converts English words to Klingon language (https://en.wikipedia.org/wiki/Klingon_language)
     * These may occur in a sentence or by themselves.
     * Write your own test cases
     */
    @Override
    public StringBuilder convertWordsToKlingon() {
        return new StringBuilder();
    }
}
