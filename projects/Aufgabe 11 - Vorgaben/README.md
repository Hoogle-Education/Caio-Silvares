# Aufagbe 10

## Task 11 (9 points)
In this task, you will extend the posting system from the last task to include
concurrency. To do this, first import the project "Task 11 - Defaults" into your your workspace or use your solution from last week as a basis.

## Task 11.1 - JournalEntryQueue (2 points)
Create a class named JournalEntryQueue in the package ledger and implement a cache in it. implement in it a buffer for a given number of entry records. It records must be able to be added, the first record must be able to be removed and the must be able to be removed and the current number of entry records in the must be able to be determined.
Note: For the implementation of the temporary storage (JournalEntryQueue) you can use JavaCollections, you do not have to implement "own" data types in this task. in this task.

## Task 11.2 - Accountant (5 points)

Extend the Accountant class by either letting the class inherit from the Thread class or implementing the Runnable interface and implementing the following functionality in the corresponding run() method:

1. if there are accounting records in the buffer (see Task 11.1), then take out the first accounting record; otherwise, terminate the algorithm.

2. try to post the booking record (see postEntry()).

3. If the entry cannot be posted because there is a syntax error or some other unrecoverable error (e.g. account does not exist, debit amount is not equal to credit amount), then the entry should be discarded.

4. If the entry cannot be posted at the current time (e.g. the account is already open), the entry should be returned to the temporary storage. 5.

5. go to 1. In your solution, make sure that only the accountant thread accesses an account and changes its amounts. and change its amounts only by the accountant thread that has opened this account. For this you will you will have to adjust other classes as well (see supplementary notes on page 3).

Also consider deadlocks and their resolution in your algorithm: Accountant A1 has already opened account K1 and now wants to open account K2, A2 has opened K2 and wants to open K1.

## Task 11.3 - Main (2 points)

   Modify the Main method as follows and test your algorithm with the parameter values x={10,000, 100,000, 1,000,000} and y={1, 2, 5, 10}. Also make sure make sure that the constant ERRORRATIO in the AccountManager class is set to 0, to allow as many successful bookings as possible.

1. create an object of the class JournalEntryQueue and fill it with x
   random entry records.
2. start y accountant threads that process the entry records. 
3. Wait until all accountant threads have terminated and the cache is cleared.
   cache has been cleared. 
4. Enter the number of successfully executed bookings and the total runtime required for them. total runtime (note: System.currentTimeMillis()) on the console,
      
Ex: "1,000,000 postings in 73903ms".
Create a table with your runtime results:
```
10.000 100.000 1.000.000
1
2
5
10
```

### Additional notes

An account may only ever be modified by one accountant thread (the one that opened the account). To do this, you must save the instance of the opening accountant thread and make sure in the corresponding methods that only this thread changes the values of the account. For this purpose, the following code example (this can also be implemented with a different approach approach): 

```java
public abstract class Account {
    ...
    private Accountant accountant = null;
   ...
   
   public boolean isLockedByAccountant(Accountant accountant) {
   ...
    }

    public boolean open(Accountant accountant) {
        if ((this.accountant == null && this.open==false)) {
            this.open = true;
            this.accountant = accountant;
        }
    ...
    }
    
    ...
    public boolean commit(Accountant accountant) {
        if (isLockedByAccountant(accountant)) {
            value += delta;
            delta = 0;
            return true;
        }
        return false;
    }
    
    ...
   
    public boolean close(Accountant accountant) {
        if (isLockedByAccountant(accountant)) {
            this.open = false;
            this.accountant = null;
        }
    ...
    }
    
}
```
