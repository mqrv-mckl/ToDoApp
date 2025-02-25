package toDoApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class TaskListManager {
	private List<TaskList> lists;

	public TaskListManager() {
		this(new ArrayList<TaskList>());
	}

	public TaskListManager(List<TaskList> lists) {
		this.lists = lists;
	}

	public List<TaskList> getTaskLists() {
		return lists;
	}

	public int getAmountOfLists() {
		return lists.size();
	}

	public TaskList getTaskList(int index) {
		return lists != null ? lists.get(index) : new TaskList();
	}

	public TaskList getTaskList(String name) {
		return lists.stream().filter(list -> list.getName().equals(name)).findFirst().orElse(null);
		// returns null if no matching task is found
	}

	public TaskList getAllTasks() {
		return lists != null
				? new TaskList("allTasksFromMultipleLists",
						lists.stream().flatMap(taskList -> taskList.getList().stream()).collect(Collectors.toList()))
				: new TaskList();
	}

	public void addTaskList(TaskList newTaskList) {
		lists.add(newTaskList);
	}

	public void removeTaskList(int index) {
		lists.remove(index);
	}

	public void removeTaskList(String name) {
		Iterator<TaskList> iterator = lists.iterator();
		while (iterator.hasNext()) {
			TaskList list = iterator.next();
			if (list.getName().equals(name)) {
				iterator.remove();
			}
		}
	}
}
