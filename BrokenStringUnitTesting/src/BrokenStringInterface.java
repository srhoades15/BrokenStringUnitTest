package edu.mtsu.csci3033;

/**
 * Do not alter this file
 */
public interface MyBrokenStringInterface {
    void setBrokenString(String string);
    String getBrokenString();
    int countDigits();
    StringBuilder getEvenCharacters();
    StringBuilder getOddCharacters();
    StringBuilder numbersDroppedString();
    StringBuffer commasDroppedString();
    StringBuilder spacesDroppedString();
    String sortedAscendingString();
    String sortedDescendingString();
    String getReverseString();

    //Build your own test cases for the rest
    StringBuilder convertDigitsToStrings();
    StringBuilder convertWordNumbersToDigits();
    //BONUS
    StringBuilder convertDigitsToRomans();
    //SUPER BONUS
    StringBuilder convertWordsToKlingon();
}

