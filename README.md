# Workers-development-exercise
a UML diagram (and non implemented visitor version) included, aside from README file. 

Hello - this is my assignment implemantaion
(Nes Afriat)

This repository include a UML class diagram made when planning the implementation,
also, there was 2 different ideas with implementation (one with visitor patterns)-
But after rethinking the pros and cons I decided to implement the second.

~~~~~~~~~About the program~~~~~~~~~~~~
Written in JAVA, with a console's menu.
In order to run - run the main file of the project.
*be impressed of the menu's enterance sign of "2bprecise"*
and click 'Enter'.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Now to the big Menu-  (Keep reading below)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0) Initialize with existing scenario data
1) Create the root manager
2) Create a new employee
3) Set existing employee direct manager
4) Login to your employee-user
5) Logout
6) Create new assignment for employee
7) Submit a report to direct manager
8) Edit employee's phone number and address
9) Calculate month's salaries for all employees
10) Get salary
11) Print all employees reports arranged by manager
12) Print your assignments
13) Print All employees assignments
14) Print All employees
15) Exit
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


Explanation about the task:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
there are 4 main functions that were asked to implement:
- Print all workers assignments (13) (I also implemented personal option(12))
- Print all workers reports to managers aggregated by managers.(11)
- Calculate month salaries for each company employee.(9) (and to get yours -(10)
- Edit phone number and adress of another employee. (8)

For your convinence, I added more funcionality according to the restrictions limitations.
(1)  - create the Top manager (root)
(2) - create a new employee (one of 4 types -(regular, manager,secretary or manager assistant).
(3) - set existing employee with existing manager (by ID's)
(4) - login - every employee gets an ID, and has password. (click (14) if forgot ID) 
(5) - logout - get out from existing user.
(6) - Create new assignment (only possible if you are the employees manager or assistant manager).
(14) - print the details of all employees exist in the system.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


~~~~~~~~~~~~~~~~~~~~~~DATA~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
and how about some data sets for the proof of concept?
the option (0) provide initiaiton of scenario to check the functionality easly:
What does it gives?
ID:0 , Name:mrNice, Role: Manager , Position:CEO  password: "123"
	|
	ID:1 , Name:Yair Yair, Role: Manager, Position:Product manager, password: "123"
		|         	        	                      
		ID:2 , Name:Alon Alon, Role: Employee , password :"123"
		ID:3 , Name:Ben Ben, Role: Employee,  password: "123"
		ID:4 , Name:Galit Galit, Role: Assistant Manager , password: "123"
		ID:5 , Name:Evyatar Evyatar, Role: Secretary, password: "123"
 		Product manager
*each of Yair's employees has submitted 2 reports to Yair.
*each of Yair's employees has been given 2 assignments by Yair- one completed.
*Calculation of salaries- expected salaries: 
- Galit, Assistant manager worked 45 hours. expeted salary = (45*10)*1.05= 472.5 
- Alon, Employee worked 15 hours, completed 1 task. expeted salary = (15*10)+1(task)*5=155  
- Evyatar, Secretary worked 60 hours. expeted salary = (60*12)*1.085= 781.1999 
~~~~~~~~~~~~~~~~~~~~~~DATA~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


~~~~~~~~~~~~~~~~~~~~~Guided Tour~~~~~~~~~~~~~~~~~~~~~~~~~~
- Run the menu and click Enter
- In order to details, init The system by entering 0.
- choose employee of the job you desire (watch employees (14))
- Log in the desired employee - username = id (1 or 2 or 3 etc) password- "123" (default)
- logout when you want to log in another
- Choose the functionality you want to check - Have Fun.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



