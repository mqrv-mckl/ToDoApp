package toDoApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class TaskList {

	private String name;
	private List<Task> list;

	public TaskList() {
		this("taskList", new ArrayList<>());
	}

	public TaskList(String name) {
		this(name, new ArrayList<>());
	}

	public TaskList(List<Task> list) {
		this("taskList", list);
	}

	public TaskList(String name, List<Task> list) {
		this.name = name;
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public List<Task> getList() {
		return list;
	}

	public void addTask(Task task) {
		list.add(task);
		System.out.println("added task: " + task);
	}

	public boolean removeTask(String taskTitle) {
		for (Task task : list) {
			if (task.getTitle().equalsIgnoreCase(taskTitle)) {
				list.remove(task);
				System.out.println("removed task: " + task);
				return true;
			}
		}
		System.out.println("couldn't find task '" + taskTitle + "'");
		return false;
	}

	public boolean updateTask(String title, String description, LocalDate deadline, Priority priority) {
		for (Task task : list) {
			if (task.getTitle().equalsIgnoreCase(title)) {
				task.setDescription(description);
				task.setDeadline(deadline);
				task.setPriority(priority);
				System.out.println("updated task: " + task);
				return true;
			}
		}
		System.out.println("couldn't find task");
		return false;
	}

	public void printList() {
		if (!taskListIsEmpty()) {
			System.out.println("Task list '" + this.name + "':");
			list.forEach(System.out::println);
		}
	}

	public TaskList filterTasksByTitle(String taskTitle) {
		if (!taskListIsEmpty()) {
			return new TaskList(this.name + "_filteredByTitle",
					list.stream().filter(task -> task.getTitle().contains(taskTitle)).collect(Collectors.toList()));
		}
		return null;
	}

	public TaskList filterTasksByDeadline(LocalDate taskDeadline) {
		if (!taskListIsEmpty()) {
			return new TaskList(this.name + "_filteredByDeadline",
					list.stream().filter(task -> task.getDeadline().equals(taskDeadline)).collect(Collectors.toList()));
		}
		return null;
	}

	public TaskList filterTasksByPriority(Priority taskPriority) {
		if (!taskListIsEmpty()) {
			return new TaskList(this.name + "_filteredByPriority",
					list.stream().filter(task -> task.getPriority().equals(taskPriority)).collect(Collectors.toList()));
		}
		return null;
	}

	public TaskList sortTasksByDeadline() {
		return new TaskList(this.name + "_sortedByDeadline", list.stream().sorted((t1, t2) -> {
			int deadlineComparison = t1.getDeadline().compareTo(t2.getDeadline());
			// if t1.deadline is not equal to t2.deadline return the "cpmpareTo"-result;
			// else return the "compareTo"-result of the priority comparison of t1 and t2:
			return deadlineComparison != 0 ? deadlineComparison : t1.getPriority().compareTo(t2.getPriority());
		}).collect(Collectors.toList()));
	}

	public TaskList sortTasksByPriority() {
		return new TaskList(this.name + "_sortedByPriority", list.stream().sorted((t1, t2) -> {
			int priorityComparision = t1.getPriority().compareTo(t2.getPriority());
			return priorityComparision != 0 ? priorityComparision : t1.getDeadline().compareTo(t2.getDeadline());
		}).collect(Collectors.toList()));
	}

	private boolean taskListIsEmpty() {
		return list.isEmpty();
	}

}
