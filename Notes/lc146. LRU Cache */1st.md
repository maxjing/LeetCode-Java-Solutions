## Solution1 - 

#### complexity

| time | space |
| ---- | ----- |
| O()  | O()   |



---

#### note

```
LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
```



---

#### code

```java
class LRUCache {
    class DlinkedList {
        int key;
        int value;
        DlinkedList pre;
        DlinkedList post;
    }
    
    private HashMap<Integer, DlinkedList> cache = new HashMap<Integer, DlinkedList>();
    
    private int count, capacity;
    
    private DlinkedList head, tail;
    
    private void addNode(DlinkedList node) {
        node.pre = head;
        node.post = head.post;
        
        head.post.pre = node;
        head.post = node;
    }
    
    private void removeNode(DlinkedList node) {
        DlinkedList pre = node.pre;
        DlinkedList post = node.post;
        
        pre.post = post;
        post.pre = pre;
    }
    
    private void moveToHead(DlinkedList node) {
        this.removeNode(node);
        this.addNode(node);
    }
    
    private DlinkedList popTail() {
        DlinkedList node = tail.pre;
        this.removeNode(node);
        return node;
    }

    
    public LRUCache(int capacity) {
        this.count = 0;
         this.capacity = capacity;
        head = new DlinkedList();
        head.pre = null;
        
        tail = new DlinkedList();
        tail.post = null;
        
        head.post = tail;
        tail.pre = head;
        
        
    }
    
    public int get(int key) {
        DlinkedList node = cache.get(key);
        if(node == null) {
            return -1;
        }
        
        this.moveToHead(node);
        return node.value;
    }
    
  public void put(int key, int value) {
  DlinkedList node = cache.get(key);

  if(node == null){

    DlinkedList newNode = new DlinkedList();
    newNode.key = key;
    newNode.value = value;

    this.cache.put(key, newNode);
    this.addNode(newNode);

    ++count;

    if(count > capacity){
      // pop the tail
      DlinkedList tail = this.popTail();
      this.cache.remove(tail.key);
      --count;
    }
  }else{
    // update the value.
    node.value = value;
    this.moveToHead(node);
  }
}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```

