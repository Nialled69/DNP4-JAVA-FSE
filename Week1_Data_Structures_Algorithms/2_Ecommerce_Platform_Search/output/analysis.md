## 1. Compare the time complexity of linear and binary search algorithms.

-- The Linear search compares the target element with each and every element of the array in sequential manner. Hence it takes a Time Complexity of O(n). It works for both sorted and unsorted array of elements

-- The Binary search compares the target element with middle element only and in each iteration divides the array into 2 halves. If the target is less than mid element, it'll do the searching in the first half of the array and if it is greater than mid element, it'll repeat the searching in the 2nd half of the array. Hence it takes a Time Complexity of O(logn). It works for only sorted array of elements

## 2. Discuss which algorithm is more suitable for your platform and why.

-- For sorted arrays, binary search technique is the most optimised method for searching

-- However, if the postion of the elements are not ordered and they are randomised, then linear search is the most viable method.