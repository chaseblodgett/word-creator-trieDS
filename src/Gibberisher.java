// CODE WRITTEN BY CHASE BLODGETT

/* Gibberisher is a class that uses the Trie data structure to store CharBags
* to be used to generate random gibberish words
*/
public class Gibberisher{

  private Trie<CharBag> model;
  private int segmentSize;
  private int numSamples;

  /* A Gibberisher consists of a Trie data structure where each node is a CharBag,
  *  a segment size for the word samples and a count for the number of samples processed.
  */
  public Gibberisher(int segmentSize){
    this.model = new Trie<>();
    this.segmentSize = segmentSize;
    this.numSamples = 0;
  }

  /* train is a function that takes in an array of Strings and generates LetterSamples
  * for each word, and adds the data to the charBag of the correct node in the Trie
  */
  public void train(String [] wordList){
    for(int i = 0; i < wordList.length; i++){
      LetterSample [] wordSamples = LetterSample.toSamples(wordList[i],segmentSize);
      for(int j = 0; j <= wordList[i].length(); j++){
        if(model.get(wordSamples[j].getSegment()) == null){
          CharBag newCharBag = new CharBag();
          newCharBag.add(wordSamples[j].getNextLetter());
          model.put(wordSamples[j].getSegment(),newCharBag);
        }
        else{
          model.get(wordSamples[j].getSegment()).add(wordSamples[j].getNextLetter());
        }
        numSamples++;
      }
    }
  }

  public int getSampleCount(){ // returns the number of samples processed from the word list
    return numSamples;
  }

  /* generate is a function which generates a statistical random word from the data
  * stored in the trie
  */
  public String generate(){
    String word = "";
    String wordSegment = "";
    char lastLetter = model.get(word).getRandomChar();
    while(lastLetter != LetterSample.STOP){
      word += lastLetter;
      if(word.length() < segmentSize){
        lastLetter = model.get(word).getRandomChar();
      }
      else{
        for(int i = word.length() -segmentSize;i < word.length();i++){
          wordSegment += word.charAt(i);
        }
        lastLetter = model.get(wordSegment).getRandomChar();
        wordSegment = "";
      }
    }
    return word;
  }
}
