Exercise 2.1-3
--------------

The code for **linear search** can be found in LinearSearch.java (within this same package name).

Our loop invariant is the following:

>The loop either ends before the start of the `i`th iteration of the `for` loop or `v` does not equal any of the elements in `A[1..i-1]`.*

We will now prove that this loop invariant fulfills each of Initialization, Maintenance, and Termination.

* **Initialization**: Prior to the first iteration of the loop, our list of candidate elements is empty, and thus none of the items in this list could possibly equal `v`.

* **Maintenance**: Suppose that the loop invariant holds for the `i`th iteration for some `1<=i<=n`. If `v == A[i]`, then we break out of the loop before the `(i+1)`st iteration. If `v != A[i]`, then `v` equals none of the elements in `A[1..i]`. Thus, the loop invariant is preserved before the start of the next iteration (if there is one).

* **Termination**: Either the loop terminates early or it doesn't. If it does, then we have found the first index `i` for which `v == A[i]`, which is what the algorithm calls for. If we don't `break` out of the loop early, then `null` is returned.

Thus, our loop invariant fulfills the inductive properties of Initialization and Maintenance, and by Termination, it produces the result called for by **linear search**.




*- In keeping with the book's pseudocode notation, we'll use arrays and lists whose indices start at 1 instead of 0.