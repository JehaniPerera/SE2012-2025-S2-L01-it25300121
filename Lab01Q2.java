import java.util.Scanner
public class Marks {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.print("Enter the number of students (n): ");
int n = scanner.nextInt();
scanner.nextLine(); 

double[][] marks = new double[n + 1][4];
boolean[][] hasMarks = new boolean[n + 1][4]; 

System.out.println("\nCommands available:");
System.out.println(" 1. add [studentID]");
System.out.println(" 2. update [studentID] [subjectID]");
System.out.println(" 3. average_s [subjectID]");
System.out.println(" 4. average [studentID]");
System.out.println(" 5. total [studentID]");
System.out.println(" Type 'exit' to quit.\n");

while (true) {
System.out.print("Enter command: ");
String input = scanner.nextLine().trim();
if (input.equalsIgnoreCase("exit")) {
break;
}

String[] parts = input.split("\\s+");
String command = parts[0];

try {
if (command.equalsIgnoreCase("add")) {
int studentID = Integer.parseInt(parts[1]);
if (studentID < 1 || studentID > n) {
System.out.println("Invalid student ID. Must be between 1 and " + n);
continue;
}
System.out.print("Enter Mathematics mark: ");
marks[studentID][1] = scanner.nextDouble();
System.out.print("Enter Chemistry mark: ");
marks[studentID][2] = scanner.nextDouble();
System.out.print("Enter Physics mark: ");
marks[studentID][3] = scanner.nextDouble();
scanner.nextLine(); 

hasMarks[studentID][1] = true;
hasMarks[studentID][2] = true;
hasMarks[studentID][3] = true;

System.out.println("Marks added successfully for Student " + studentID);

} else if (command.equalsIgnoreCase("update")) {
int studentID = Integer.parseInt(parts[1]);
int subjectID = Integer.parseInt(parts[2]);

if (studentID < 1 || studentID > n || subjectID < 1 || subjectID > 3) {
System.out.println("Invalid student ID or subject ID.");
continue;
}

System.out.print("Enter new mark: ");
double newMark = scanner.nextDouble();
scanner.nextLine(); 

marks[studentID][subjectID] = newMark;
hasMarks[studentID][subjectID] = true;

System.out.println("Student " + studentID + "'s marks for subject " + subjectID + " was updated to " + (int)newMark);

} else if (command.equalsIgnoreCase("average_s")) {
int subjectID = Integer.parseInt(parts[1]);
if (subjectID < 1 || subjectID > 3) {
System.out.println("Invalid subject ID. Must be between 1 and 3.");
continue;
}

double sum = 0;
int count = 0;
for (int i = 1; i <= n; i++) {
if (hasMarks[i][subjectID]) {
sum += marks[i][subjectID];
count++;
}
}

if (count == 0) {
System.out.println("No marks entered for subject " + subjectID + " yet.");
} else {
double avg = sum / count;
System.out.println("Subject " + subjectID + " has an average of " + avg);
}

} else if (command.equalsIgnoreCase("average")) {
int studentID = Integer.parseInt(parts[1]);
if (studentID < 1 || studentID > n) {
System.out.println("Invalid student ID.");
continue;
}

if (!hasMarks[studentID][1] && !hasMarks[studentID][2] && !hasMarks[studentID][3]) {
System.out.println("No marks found for Student " + studentID);
continue;
}

double total = marks[studentID][1] + marks[studentID][2] + marks[studentID][3];
double avg = total / 3.0;
System.out.println("Student " + studentID + " has an average of " + avg);

} else if (command.equalsIgnoreCase("total")) {
int studentID = Integer.parseInt(parts[1]);
if (studentID < 1 || studentID > n) {
System.out.println("Invalid student ID.");
continue;
}

double total = marks[studentID][1] + marks[studentID][2] + marks[studentID][3];
System.out.println("Student " + studentID + " has a total mark of " + total);

} else {
System.out.println("Unknown command. Please try again.");
}
} catch (Exception e) {
System.out.println("Invalid command format or missing arguments. Please check syntax.");
}
}

scanner.close();
}
}
