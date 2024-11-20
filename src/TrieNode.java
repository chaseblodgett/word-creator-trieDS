// CODE WRITTEN BY CHASE BLODGETT

/* This class represents a node of a certain Trie
* - each node has its own data, size and new nodes within
*/
public class TrieNode<T>{

  private T data;
  private TrieNode<T> [] node;
  private int size;

  /* Constructor to set new TrieNode variables to starting values i.e an empty node
  */
  public TrieNode(){
    data = null;
    size = 1;
    node = new TrieNode[26];
  }

  public T getData(){
    return data;
  }

  public void setData(T data){
    this.data = data;
  }

  /* This function returns the correct child node of a given Character.
  * - if the correct node does not exist, a new TrieNode is created.
  */
  public TrieNode<T> getChild(char letter){
    letter = Character.toLowerCase(letter);
    boolean isLetter = false;
    for(char c = 'a'; c <= 'z';c++){
      if(letter == c){
        isLetter = true;
      }
    }
    if(!isLetter){
      return null;
    }
    int letterIndex = (int)(letter - 'a');
    if(node[letterIndex] == null){
      node[letterIndex] = new TrieNode<>();
      size++;
      return node[letterIndex];
    }
    else{
      return node[letterIndex];
    }
  }

  /* getTreeSize is a function that returns the size of a given node
  * meaning the size of itself(1) plus the sum of all of it's child nodes
  * and their child nodes etc.
  */
  public int getTreeSize(){
    size = 1;
    for(int i = 0; i < 26;i++){
      if(node[i] != null){
        size += node[i].getTreeSize();
      }
    }
    return size;
  }
}
