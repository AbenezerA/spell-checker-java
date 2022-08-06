# HW8 - Sample Grader Classes 

## Setup
In order to copy these sample grader classes (and the associated test files) into the same level directory as your SpellChecker and KBestCounter classes, open a new terminal and invoke the following commands:

```
cp SampleGraderClasses/KBestGrader.class KBestGrader.class
cp SampleGraderClasses/Rectangle.class Rectangle.class
cp SampleGraderClasses/SpellCheckerGrader.class SpellCheckerGrader.class 
cp SampleGraderClasses/CorrectChecker.class CorrectChecker.class
cp -r SampleGraderClasses/TestFiles TestFiles
```

You need to perform this step only once. Please do not delete or change any files within this SampleGraderClasses directory. If you accidentally delete a sample grader class, these binary files can be accessed on Courseworks. 

## P1 - SpellCheckerGrader

SpellCheckerGrader instansiates a CorrectChecker object (which is essentially the correct SpellChecker implementation), comparing its output to your version of SpellChecker.

You will be graded with 7 test cases, 3 of which we are releasing here as sample test cases (Test cases #1, #2, and #3). As such, please perform additional testing on your classes. You can do this by adding your own test files as TestCase1.txt, TestCase2.txt, etc. into the TestFiles directory.

To run this grader, please make sure to copy the TestFiles directory, CorrectChecker.class, and SpellCheckerGrader.class into the same level directory as your classes (see the Setup section). Then, execute the grader via the below command:
```
java SpellCheckerGrader
```

**Test Case #1: ** Please see TestCase1.txt for the contents of this grading test case.

**Test Case #2: ** Please see TestCase2.txt for the contents of this grading test case.

**Test Case #3: ** Please see TestCase3.txt for the contents of this grading test case.

## P2 - BetterBSTGrader

To run this grader, please make sure to copy the KBestGrader.class into the same level directory as your classes (see the Setup section). Then, execute the grader via the below command:
```
java KBestGrader
```
#### Test Case 1:
First, we instansiate a KBestCounter for 6 Integers. 
```
KBestCounter<Integer> counter = new KBestCounter<>(6);
```
Then, the KBestCounter is exposed to the following stream of integers.
```
for (int i = -20; i > -100; i -= 7)
	counter.count(i);
for (int i = -10; i < 200; i += 15)
	counter.count(i);
```
We then call kbest() and check your results. The correct result can be found below.
```
List<Integer> result1 = counter.kbest();
List<Integer> correct = new ArrayList<Integer>(Arrays.asList(110, 125, 140, 155, 170, 185));
```
#### Test Case 2: 
First, we instansiate a KBestCounter for 7 Integers. 
```
KBestCounter<Integer> counter = new KBestCounter<Integer>(7);
```
Then, we expose the KBestCounter to the following stream of integers.
```
for (int i = -10; i < 200; i += 17)
	counter.count(i);

for (int i = -10; i < 200; i += 17)
	counter.count(i);
```
We then call kbest() and check your results. The correct result can be found below.
```
List<Integer> correct = new ArrayList<Integer>(Arrays.asList(143, 160, 160, 177, 177, 194, 194));
```

#### Test Case 3: 
First, we instansiate a KBestCounter for 3 Rectangle object. This is why you have to cp the binary of our Rectangle class as stated in the setup section.  
```
KBestCounter<Rectangle> counter = new KBestCounter<>(3);
```
Then, we instansiate 2 Rectangle objects and expose the KBestCounter to a stream of a combination of these Rectangles.
```
Rectangle r1 = new Rectangle(1.0, 4.0);
Rectangle r2 = new Rectangle(2.0, 2.0);
counter.count(r1);
counter.count(r1);
counter.count(r2);
```
We then call kbest() and check your results. The correct result can be created as follows.
```
LinkedList<Rectangle> ref = new LinkedList<>();
ref.add(r2);
ref.add(r1);
ref.add(r1); 
```

Just a reminder that these tests are not exhaustive (neither of the requirements nor of possible edge cases). As such, please perform additional testing on your classes. These released tests make up about a third of the the test cases you will be graded with. 