// CODE WRITTEN BY CHASE BLODGETT

/* The LetterSample class represents a segment of a word along with the letter following it
*/
public class LetterSample{

  private String wordSeg;
  private char nextLetter;
  public static final char STOP = '.';

  /* A LetterSample consists of a word segment and the letter following the word segment
  */
  public LetterSample(String wordSeg, char nextLetter){
    this.wordSeg = wordSeg;
    this.nextLetter = nextLetter;
  }

  public String getSegment(){
    return wordSeg;
  }
  public char getNextLetter(){
    return nextLetter;
  }

@Override
  public String toString(){
    return "\"" + this.wordSeg + "\" -> " + this.nextLetter;
  }

  /* toSamples is a function which takes in a word to get samples from
  * and the length of the word segments and returns an array of LetterSamples
  * consisting of all the samples of the word.
  */
  public static LetterSample [] toSamples(String input, int segmentSize){
    input += LetterSample.STOP;
    String currentSegment = "";
    LetterSample [] letterArr = new LetterSample[input.length()];
    for(int i = 0; i < letterArr.length; i++){
      if(i < segmentSize){
        letterArr[i] = new LetterSample(currentSegment,input.charAt(i));
        currentSegment += input.charAt(i);
      }
      else if(i >= segmentSize){
        currentSegment = "";
        for(int j = i - segmentSize;j < i; j++){
          currentSegment += input.charAt(j);
        }
        letterArr[i] = new LetterSample(currentSegment,input.charAt(i));
      }
    }
    return letterArr;
  }

}
