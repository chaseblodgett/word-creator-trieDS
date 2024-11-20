// CODE WRITTEN BY CHASE BLODGETT

/* Trie is a class which represents a Trie data structure, linking each TrieNode
*  A Trie consists of a root node with many child nodes, and thier child nodes etc.
*/
public class Trie<T>{

  private TrieNode<T> root;

  /* Creating a new Trie creates a root node with default value
  */
  public Trie(){
    root = new TrieNode<T>();
  }

  /* getNode is a function that gets child node of the last letter of the String
  * This is implemented by calling the getChild method of the trieNode class
  */
  private TrieNode<T> getNode(String word){
    TrieNode<T> tmpRoot = root;
    for(int i = 0;i < word.length();i++){
      tmpRoot = tmpRoot.getChild(word.charAt(i));
    }
    return tmpRoot;
  }

  /*  get is a function returns the data stored in the node associated with the string
  */
  public T get(String word){
    return this.getNode(word).getData();
  }

  /* put is a function which sets the data stored in the node associated with the String
  * to the new data
  */
  public T put(String word,T data){
    this.getNode(word).setData(data);
    return data;
  }

  /* getRoot is a function to return the root node of a Trie
  */
  public TrieNode<T> getRoot(){
    return root;
  }
}
