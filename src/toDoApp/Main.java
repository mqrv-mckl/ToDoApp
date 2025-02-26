package toDoApp;

import java.time.LocalDate;
import java.util.List;

class Main {

	public static void main(String[] args) {
		Task t1 = new Task("Buy Flowers", "buy some flowers at the farmers market", LocalDate.of(2025, 2, 13),
				Priority.HIGH);
		Task t2 = new Task("Write Paper", "write a scientifical paper about monkeys", LocalDate.of(2025, 1, 3),
				Priority.LOW);
		Task t3 = new Task("Plan Trip", "Organize the itinerary for the Europe trip", LocalDate.of(2025, 3, 15),
				Priority.MEDIUM);
		Task t4 = new Task("Pay Bills", "Pay electricity and water bills before the due date",
				LocalDate.of(2025, 1, 30), Priority.HIGH);
		Task t5 = new Task("Workout", "Complete a 30-minute cardio session at the gym", LocalDate.of(2025, 2, 7),
				Priority.LOW);
		Task t6 = new Task("Call Mom", "Catch up with mom over the phone", LocalDate.of(2025, 2, 14), Priority.MEDIUM);
		Task t7 = new Task("Submit Taxes", "File the annual tax return before the deadline", LocalDate.of(2025, 4, 1),
				Priority.HIGH);
		Task t8 = new Task("Clean House", "Clean the living room and kitchen thoroughly", LocalDate.of(2025, 2, 9),
				Priority.LOW);
		Task t9 = new Task("Finish Project", "Complete the pending coding project at work", LocalDate.of(2025, 2, 20),
				Priority.HIGH);
		Task t10 = new Task("Read Book", "Finish reading 'The Art of War'", LocalDate.of(2025, 3, 5), Priority.MEDIUM);
		Task t11 = new Task("Buy Gift", "Purchase a birthday gift", LocalDate.of(2025, 2, 14), Priority.MEDIUM);
		Task t12 = new Task("Schedule Meeting", "Arrange a meeting with the manager", LocalDate.of(2025, 2, 10),
				Priority.MEDIUM);

		TaskList taskList = new TaskList("myTasks", List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));

		taskList.sortTasksByPriority().printList();

		testFrame();
	}

	private static void testFrame() {
		MainFrame mainFrame = new MainFrame();
	}

}
