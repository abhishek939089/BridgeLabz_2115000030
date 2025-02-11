class Task {
    int taskId, priority;
    String name, dueDate;
    Task next;

    Task(int taskId, String name, int priority, String dueDate) {
        this.taskId = taskId;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = this;
    }
}

class TaskScheduler {
    Task head;

    void addTask(int taskId, String name, int priority, String dueDate) {
        Task newTask = new Task(taskId, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            return;
        }
        Task temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newTask;
        newTask.next = head;
    }

    void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println(temp.taskId + " " + temp.name + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask(1, "Task A", 1, "2025-02-20");
        scheduler.addTask(2, "Task B", 2, "2025-02-21");
        scheduler.displayTasks();
    }
}
