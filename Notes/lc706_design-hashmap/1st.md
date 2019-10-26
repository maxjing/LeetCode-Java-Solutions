## Solution1 - List<int[]>

#### complexity

| time | space |
| ---- | ----- |
| O(1) | O(n)  |

创建hashmap same as hashmap

---

#### note

---

#### code

```java
class MyHashMap {
    LinkedList<int[]>[] map;
    int size=100000;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map=new LinkedList[size];
        for(int i=0;i<size;i++)
            map[i]= new LinkedList<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
      //int hash = key % size;
        int hash = Integer.valueOf(key).hashCode()%size;
        LinkedList<int[]> list = map[hash];
        for(int[] kv : list){
            if(kv[0]==key) kv[1]=value;
            return;
        }
        list.add(new int[]{key,value});
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = Integer.valueOf(key).hashCode()%size;
        LinkedList<int[]> list = map[hash];
        for(int[] kv : list){
            if(kv[0]==key) return kv[1];
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = Integer.valueOf(key).hashCode()%size;
        LinkedList<int[]> list = map[hash];
        for(int[] kv : list){
            if(kv[0]==key) list.remove(kv);
        }
    }
}
```

---

## Follow up

why use hashcode?

* use hashing algorithm (e.g. fmix64) to convert a non-uniform distribution dataset to a uniform distribution data, so that the collision rate can be lowered

---

## Solution2 - Array

#### complexity

| time | space |
| ---- | ----- |
| O(1) | O(n)  |



---

#### note

一个large array fill with -1, 存数字的时候 map[key] = value就行了

---

#### code

```java
class MyHashMap
{
    int[] map;

    public MyHashMap()
	{
        map = new int[1000001];
        Arrays.fill(map,-1);
    }
	
    public int get(int key)
	{
        return map[key];
    }
    
	public void put(int key, int value)
	{
        map[key] = value;
    }
    
	public void remove(int key)
	{
        map[key] = -1;
    }
}
```

---

## Follow Up

怎么避免collision

* 用LinkedList<int[]>[] map key % size, 这样就可以存多个pair 没个 index 里面