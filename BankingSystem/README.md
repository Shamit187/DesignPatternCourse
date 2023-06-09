# BankingSystem

BANGLADESH UNIVERSITY OF ENGINEERING AND TECHNOLOGY<br>
Department of Computer Science and Engineering<br>
January 2022 CSE 308 Offline Assignment on<br>
Basics of Object Oriented Programming (OOP)<br>

In this assignment, you will implement a simple banking system using the basic concepts of
Object Oriented Programming.


Accounts: In our banking system, there will be four types of accounts: Savings, Student, Loan,
and Fixed deposit. For the sake of simplicity, assume an user can open one account only. You have
to implement the following functionalities:

1. Create Account: After entering the system, users can request to open a new account with
their name, account type, and initial deposit (or initial loan amount if the account is a loan
account). A fixed deposit account must ensure the first deposit is at least 100,000$. After
successful opening of the account, the user will be notified accordingly. If an account already
exists against that name, an error message will be shown. Assume the names to be primary
keys.

2. Deposit: An user can deposit any sum of money into an account, except for a fixed deposit
account. The deposit amount must not be less than 50,000$ for the latter case. The deposit
of loan accounts shall be used to reduce the loan amount.

3. Withdraw: Withdrawing is different across different account types:
(a) A student account cannot withdraw more than 10,000$ in one transaction.
(b) A fixed deposit account cannot withdraw if it has not reached a maturity period of one
year.
(c) A savings account cannot withdraw if the withdrawal results in a deposit of less than
1,000$.
(d) A loan account cannot withdraw any amount from the account. It is just used to repay
the loan taken.

A transaction will be deemed invalid if the amount to withdraw exceeds the deposited sum.

4. Request Loan: Any user can request a loan. The maximum allowable loan for savings,
student, and fixed deposit accounts are 10,000$, 1,000$, 100,000$, respectively. The loan
account holders can apply for additional 5% of the current loan amount. All loans have a
fixed 10% interest rate, which will be deducted after one year. The loans must be approved
by an employee of the bank.

5. Query Deposit: An user can query the amount of deposit and loan at any time (See sample
I/O in the table below).

Interest rates on deposit for savings, student, and fixed deposit accounts are 10%, 5%, 15%,
respectively. Savings, student, and fixed deposit accounts will be deducted an amount of 500$ of
service charge after one year.


Employees: There will be three types of employees in a banking system: Managing Director,
Officer, and Cashier. There are different operations of employees based on their roles:

1. Lookup: Any employee can see the deposit sum of any user account.

2. Approve Loan: The Managing director and officer can approve loan requests of users.

3. Change Interest Rate: The managing director has the discretion to change the interest
rates of different types of accounts.

4. See Internal Fund: The managing director can see the internal funds.

Maintain a bank class for handling the accounts and employees, and the internal fund. The
initial fund is 1,000,000$. Assume the bank class will not be instantiated more than once, and the
following employees will be created at the time of bank instantiation: 
1 Managing Director (MD),
2 Officers (O1, O2), 
5 Cashiers (C1, · · · , C5). 
Also maintain a clock variable to increment the year
count of operation (assume all accounts are created at the same time).
Some test inputs and corresponding outputs are shown in Table 1.
Your implementation must abide by the encapsulation, inheritance, and polymorphism properties of OOP. Make the design choices accordingly.
Please DO NOT COPY solutions from anywhere (e.g., your friends, seniors, internet). 
Any form of plagiarism, irrespective of source or destination, will result in -100% marks in the online/offline.

Submission Deadline: 11 AM, May 22, 2022
Platform: Moodle, obviously!

Sample Input Output

Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created<br>
  ~Create Alice Student 1000 <br>
Student account for Alice Created; initial balance 1,000$<br>
  ~Deposit 20000 <br>
20,000$ deposited; current balance 21,000$<br>
  ~Withdraw 12,000 <br>
Invalid transaction; current balance 21,000$<br>
  ~Query <br>
Current balance 21,000<br>
  ~Request 500 <br>
Loan request successful, sent for approval<br>
  ~Close Transaction <br>
Closed for Alice<br>
  ~Open S1 <br>
S1 active, there are loan approvals pending<br>
  ~Approve Loan <br>
Loan for Alice approved<br>
  ~Change Student 7.50 <br>
You don’t have permission for this operation<br>
  ~Lookup Alice<br>
Alice’s current balance 21,500$<br>
  ~See<br>
You don’t have permission for this operation<br>
  ~Close <br>
Operations for S1 closed<br>
  ~Open <br>
Alice Welcome back, Alice<br>
  ~Query <br>
Current Balance 21,500$, loan 500$<br>
 ~ Close <br>
Transaction Closed for Alice<br>
  ~INC<br>
1 year passed<br>
  ~Open <br>
Alice Welcome back, Alice<br>
  ~Query<br>
Current balance, 22,525$, loan 500$<br>
  ~Close <br>
Transaction Closed for Alice<br>
