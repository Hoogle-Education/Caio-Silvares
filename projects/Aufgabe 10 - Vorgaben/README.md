# Task 10 (11 points)

In this task you will implement a simple booking system. To do this, first import the "Task 10 - Defaults" project into your workspace and take a closer look at the Account class: An account has the attributes name, open, value and delta (change). A posting to an account should proceed as follows:

1. the account is opened (open)
2. a transaction is prepared (credit or debit)
3. a transaction is executed (commit)
4. the account is closed (abort or close)

# Task 10.1 - Accounting (2 points)

Become roughly familiar with the following accounting terms: account, debit, credit, asset accounts (asset), liability accounts (liability), and posting record. There are countless tutorials, explanations, and videos available on the Internet on this topic.

# Task 10.2 - Account, Asset & Liability (2 points)

Implement the credit(int) and debit(int) methods in the Asset1 (asset account) and Liability2 (liability account) classes. Be careful to change only the delta value and not the value of the account itself. Only when commit() is called later (see Account class) should the value of the account be adjusted. Throw appropriate exceptions (see package exceptions) if an account is not open or the amount on the account is not sufficient to post the given value to the account (negative value on the account).

# Task 10.3 - AccountManager (2 points)

Implement the getAccount, getAsset and getLiability methods in the AccountManager class. While the getAsset(name) and getLiability(name) methods should only search for given account in the list of asset accounts, or liability accounts, the getAccount(name) method should search all accounts. Throw an appropriate exception if no account with the given name is found and do not return the value null to the caller.

# Task 10.4 - Accountant (4 points)

Implement the postEntry() method in the Accountant class, which is passed a posting record as a parameter. A correct entry record consists of a series of accounts addressed in debit followed by a ';'.
followed by a ';' character, followed by a series of accounts that are agreed upon in credit. The individual account-value pairs are separated by commas, and the account name and value are separated by a space. An example posting record reads:
"Equity 27, Bonds_Payable 385; Land 137, Other_Revenues 275".
In your implementation, first check the syntax of the posting record passed and make sure that the amount on the debit side matches the amount on the credit side. Throw appropriate exceptions in case of errors.
For the subsequent posting, do the following:

1. first open all accounts involved (open).
2. prepare the posting on each account (credit or debit)
3. if no error occurs on any account, then perform the posting (commit)
4. if an error occurs (e.g. amount is not sufficient), all previous changes to the accounts should be undone to the accounts should be undone (abort).
5. finally, all accounts should be closed in any case (close).
   
> Tip: You can use the class Pair<Account, Integer> (see package util) to process the account value pairs.

# Task 10.5 - Test (1 point)

Test your solution (see package main). The method
AccountManager.getRandomJournalEntry() returns sample journal entries, which may contain can also contain various errors. To increase or decrease the percentage of erroneous entry records, you can modify the ERRORRATIO variable in the class AccountManager class.

