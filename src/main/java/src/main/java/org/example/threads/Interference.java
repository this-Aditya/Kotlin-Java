package org.example.threads;

/**
 * Class demonstrating ow thread interference works:
 */

class InterferenceCounter {
    int c = 0;
    
    void increase() {
        c++;
    }
    
    void decrease() {
        c--;
    }
    int value() {
        return c;
    }
}

/**
 * Suppose Thread A invokes increment at about the same time Thread B invokes decrement.
 * If the initial value of c is 0, their interleaved actions might follow this sequence:

 * Thread A: Retrieve c.
 * Thread B: Retrieve c.
 * Thread A: Increment retrieved value; result is 1.
 * Thread B: Decrement retrieved value; result is -1.
 * Thread A: Store result in c; c is now 1.
 * Thread B: Store result in c; c is now -1.
 */