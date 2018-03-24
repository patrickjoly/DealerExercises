-- Prerequisites:

To run this application, you need maven.

To verify if maven is installed on your system, run this command on a command line:

mvn -version

-- How to build this application:

To build everything just run this command on a command line:


If everything goes fine, you should see something similar as what you see here below:
That means, the building process is a success and 8 tests has been just running without
failures.

Results :

Tests run: 8, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.2:jar (default-jar) @ DealerExercises ---
[INFO] Building jar: /home/patrick/dev/DealerExercises/target/DealerExercises-1.0-SNAPSHOT.jar
[INFO]
[INFO] --- maven-install-plugin:2.3:install (default-install) @ DealerExercises ---
[INFO] Installing /home/patrick/dev/DealerExercises/target/DealerExercises-1.0-SNAPSHOT.jar to /home/patrick/.m2/repository/DealerExercises/DealerExercises/1.0-SNAPSHOT/DealerExercises-1.0-SNAPSHOT.jar
[INFO] Installing /home/patrick/dev/DealerExercises/pom.xml to /home/patrick/.m2/repository/DealerExercises/DealerExercises/1.0-SNAPSHOT/DealerExercises-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.082s
[INFO] Finished at: Sun Mar 24 13:14:26 EDT 2013
[INFO] Final Memory: 13M/179M
[INFO] ------------------------------------------------------------------------

-- How to run exercises:

There is two exercises, KeyCounter and Polindrome. Each of them has its own
maven profile (keycounter and palindrome)

KeyCounter:
-----------

To run KeyCounter, run this command:

mvn exec:java -Dexec.mainClass=com.detail.client.KeyCounterClient -Dexec.args="/tmp/keycountdata.txt ," -P=keycounter -e

where -Dexec.args="/tmp/keycountdata.txt ," stands for the parameters.
The first one is where your file is located, the second is the delimiter. The
second one is optional, a comma is the default value.

Warning, this example use a unix path since my system is a linux. If your system
is windows,  -Dexec.args="/tmp/keycountdata.txt ," must be changed by something like
-Dexec.args="c:\temp\keycountdata.txt ," for instance.

-P=keycounter is the selected profile and -e provides
more information is something goes wrong.

Palindrome:
-----------

To run Palindrome, run this command:

mvn exec:java -Dexec.mainClass=com.detail.client.PalindromeClient -Dexec.args="'This is not a good palindrome example'" -P=palindrome -e

where -Dexec.args="'This is not a good palindrome example'" stands for the only one accepted parameter. Take
care to put cote in the double cote, otherwise, only the first word will be validated.

-P=palindrome is the selected profile and -e provides
more information is something goes wrong.
