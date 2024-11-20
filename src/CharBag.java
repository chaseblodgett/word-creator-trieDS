// CODE WRITTEN BY CHASE BLODGETT

/* CharBag is a class to represent the ADT bag, but to store chars and their
* counts only. Each bag can hold letters a-z and a period(.)
*/

import java.util.Random;

public class CharBag{

  private char [] letterBag;
  private int [] letterCount;
  private int size;

  /* CharBag constructor creates an empty char bag
  * - each letter is added with counts of zero
  */
  public CharBag(){
    this.letterBag = new char[27];
    this.letterCount = new int[27];
    this.size = 0;
    int count = 0;
    for(char c = 'a'; c <= 'z';c++){
      letterBag[count] = c;
      letterCount[count] = 0;
      count++;
    }
    letterBag[26] = LetterSample.STOP;
    letterCount[26] = 0;
  }

  /* The add function adds a letter to the CharBag
  *  - i.e. updates the count of that letter
  *  - if the char entered is not letters a-z or . then .'s count is updated
  */
  public void add(char letter){
    letter = Character.toLowerCase(letter);
    boolean inBag = false;
    for(int i = 0; i < 27; i++){
      if(letter == letterBag[i]){
        letterCount[i]++;
        size++;
        inBag = true;
      }
    }
    if(!inBag){
      letterCount[26] += 1;
      size++;
    }
  }

  /* The remove function takes a letter a-z or . out of the CharBag
  * i.e. decreases the letter count by one if there is 1 or more in the CharBag
  * if neither a-z or . are entered, .'s count is updated
  */
  public void remove(char letter){
    letter = Character.toLowerCase(letter);
    boolean inBag = false;
    for(int i = 0; i < 27; i++){
      if(letter == letterBag[i] && letterCount[i] > 0){
        inBag = true;
        letterCount[i]--;
        size--;
      }
    }
    if(!inBag && letterCount[26] > 0){
      letterCount[26]--;
      size--;
    }
  }

  /* getCount returns the number of times a certain char is in the bag
  */
  public int getCount(char letter){
    letter = Character.toLowerCase(letter);
    for(int i = 0; i < 27; i++){
      if(letter == letterBag[i]){
        return letterCount[i];
      }
    }
    return letterCount[26];
  }

  /* getSize returns the total number of Chars in the bag
  */
  public int getSize(){
    return this.size;
  }

  @Override
  public String toString(){
    String retVal = "CharBag{";
    for(int i = 0; i < 27; i++){
      if(i == 26){
        retVal += letterBag[i] + ":" + letterCount[i];
      }
      else{
        retVal += letterBag[i] + ":" + letterCount[i] + ", ";
      }
    }
    retVal += "}";
    return retVal;
  }

  /* getRandomChar returns a random char value a-z or . based off the counts of each char
  *  - each char's probablity is chosen based on proportion of their count to the total size
  */
  public char getRandomChar(){
    if(this.size > 0){
      Random rand = new Random();
      int randNum = rand.nextInt(size);
      int countSum = 0;
      for(int i = 0; i < 27; i++){
        if(randNum >= countSum && randNum < countSum + letterCount[i]){
          return letterBag[i];
          }
        countSum += letterCount[i];
      }
    }
    return letterBag[26];
  }
}
