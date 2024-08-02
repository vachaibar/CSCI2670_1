Name: Vanessa Achaibar
Email: vda59962@uga.edu

Instructions to run files: please use the file "assignment1.sh"
chmod +x assignment1.sh
./assignment1.sh      

mergeList time complexity: O(n)
pseudocode:
1. initalize pointers 
    - initalize 'current1' and 'current2', to the heads of the two sorrted lists.
    - create an empty list 'mergedList' which stores the merged outputs. 
2. mergedLists
    - when 'current1' and 'current2' are not null (empty):
        - inner loop: while both 'current1' and 'current2' are not null:
            - compare the vlaues of 'current1' with 'current2'
            - if 'current1' is ≤ 'current2', insert value of 'current1' into 'mergedList' and move 'current1' to next node.
            - otherwise, insert 'current2' value into 'mergedList'and move 'current2' to next node. 
3. handling remaning nodes
    - while 'current1' is not null, insert remaining nodes into 'mergedList'
    - while 'current2' is not null, insert remaining nodes into 'mergedList'
4. updating original list:
    - set the head of original list to 'mergeList'

intersection time complexity: O(n^3)
pseudocode:
1. initalize pointers 
    - initalize 'current1' and 'current2', to heads of the two sorted lists.
    - create empty list 'intersectionList' to store intersection output
2. find intersection
    - while both 'current1' and 'current2' are not null:
        - compare value of 'current1' with value of 'current2':
        - if values are equal: insert value to 'intersectionList'
        - move both 'current1' and 'current2' to respective next nodes from comparison result. 
3. print intersection
    - print elements in 'intersectionList'

