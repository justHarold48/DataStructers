ph    // table operations
    public boolean tableIsEmpty()
    {
      return size==0;
    }  // end tableIsEmpty

    public int tableLength()
    {
      return size;
    }  // end tableLength

    @SuppressWarnings("unchecked")
  //implement the following 4 methods
  public void tableInsert(K key, V value) throws HashException
  {
    int index = hashIndex(key);

    if (table[index] == null)
    {
      table[index] = new ChainNode<K,V>(key, value,null);
    }
    else
    {
      ChainNode<K, V> temp = new ChainNode<K,V>(key, value,table[index]);
      ChainNode<K,V> curr = table[index];

      while(curr.getKey() != key || curr != null)
        curr = curr.getNext();

      if(curr == null)
        table[index] = temp;
      else
        throw new HashException("Key already in Table");
    }

    size++;
  }
  @SuppressWarnings({ "unchecked", "unused" })
  public boolean tableDelete(K searchKey)
  {
    int index = hashIndex(searchKey);
    ChainNode<K,V> prev = null;
    ChainNode<K,V> curr;

    for(curr = table[index]; !curr.getKey().equals(searchKey); curr = curr.getNext())
      prev = curr;

    if (curr == null)
      return false;

    if(prev == null)
      table[index] = null;
    size--;
    return true;

  }

  @SuppressWarnings({"null","unchecked"})
  public V tableRetrieve(K searchKey)
  {
    int index = hashIndex(searchKey);
    ChainNode<K,V> curr;

    for(curr = table[index]; !curr.getKey().equals(searchKey); curr = curr.getNext())
    {
      //iterate through nodes
    }

    return curr.getValue();
  }

  public int hashIndex(K key)
  {
    return x(key) % table.length;
  }

  public int x(K key)
  {
    int result = 0;
    Character character;
    Character charA = 'A';

    for(int i = 2; i > -1 ; i--)
    {
      character = key.toString().charAt(i);
      result += (character.charValue() - charA.charValue()) << i+5;
    }

    return result;
  }

}  // end HashTable
