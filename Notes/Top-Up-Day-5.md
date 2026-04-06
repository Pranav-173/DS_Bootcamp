# Hashing

**Hashing:** It is a fundamental technique in data structures used to store and retrieve data with an average time 
complexity of O(1). In a hash table, a new index is processed using the keys and the element corresponding to 
that key is stored in the index.This process is known as hashing.
Let k be a key and h(x) be a hash function.
here, h(k) will give us a new index to store the element linked with k.

### **Componenets of Hashing:** 
There are majorly three components of hashing:
- **key:** A key can a string or integer which is fed as input in the hash function the technique that determines 
an index or location for storage of an item in a data structure.
- **Hash Function:** The hash function recieves the input key and returns the index of an element in an array called 
a hash table. The index is known as hash index.
- **Hash Table:** It is a data structure that maps keys tp values using a special function called a hash function. 
Hash stores the data in an associative manner in an array where each data value has its own unique function.

### **Hash functions:** 
There are many hash functions that use numeric or alphanumeric keys. Different hash functions are:
- **Division method:**
  
    <img width="530" height="244" alt="image" src="https://github.com/user-attachments/assets/57bf9d14-bd95-4cc0-b16a-cef3de540345" />

- **Mid square method:**
    Example:
    K = 50
    k*8 k = 2500
    h(k) = 50
    The hash value obtained is 50
- **Folding method:**
  The folding method involves dividing the key into equal parts, summing the parts and then taking the modulo with respect to m.
  Steps:
  - Divide the key into parts.
  - Sum the parts
  - Take the modulo m of the sum
  Example: key = 123456789
  Action - Divide into 3-digit parts: 123,456,789
  sum = 123 + 456 + 789 = 1368
  Hash Adress = 1368 % 10 = 8
 123456789 is inserted at index 8
- **Multiplication method:**
  The hash function used for multiplication method is:
  h(k) = floor ( n (K A % 1) ). Here, k is the key and A can be any constant value between 0 and 1. Both K and A are multiplied and their   fractional       part is seperated. This is then multiplied with n to get the hash value.
  Example: K = 123
  n = 100
  A = 0.618033
  h(123) = 100 * (123 * 0.618033 % 1) = 100
  (76.018059 % 1) = 100 (0.018059) = 1
  The hash value obtained is 1
  An advantage of multiplication method is that it can work with any value of A
