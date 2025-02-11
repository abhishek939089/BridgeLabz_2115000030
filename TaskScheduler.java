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
    Task head, currentTask;

    void addTaskAtBeginning(int taskId, String name, int priority, String dueDate) {
        Task newTask = new Task(taskId, name, priority, dueDate);
        if (head == null) {
            head = currentTask = newTask;
            return;
        }
        Task temp = head;
        while (temp.next != head) temp = temp.next;
        newTask.next = head;
        head = newTask;
        temp.next = head;
    }

    void addTaskAtEnd(int taskId, String name, int priority, String dueDate) {
        Task newTask = new Task(taskId, name, priority, dueDate);
        if (head == null) {
            head = currentTask = newTask;
            return;
        }
        Task temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newTask;
        newTask.next = head;
    }

    void addTaskAtPosition(int taskId, String name, int priority, String dueDate, int position) {
        if (position <= 1) {
            addTaskAtBeginning(taskId, name, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskId, name, priority, dueDate);
        Task temp = head;
        int count = 1;
        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }

    void removeTask(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId) {
            if (head.next == head) {
                head = currentTask = null;
                return;
            }
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            head = head.next;
            temp.next = head;
            return;
        }
        Task temp = head;
        while (temp.next != head && temp.next.taskId != taskId) temp = temp.next;
        if (temp.next.taskId == taskId) temp.next = temp.next.next;
    }

    Task searchTaskByPriority(int priority) {
        if (head == null) return null;
        Task temp = head;
        do {
            if (temp.priority == priority) return temp;
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println(temp.taskId + " " + temp.name + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void viewCurrentTask() {
        if (currentTask != null) {
            System.out.println(currentTask.taskId + " " + currentTask.name + " " + currentTask.priority + " " + currentTask.dueDate);
        }
    }

    void moveToNextTask() {
        if (currentTask != null) currentTask = currentTask.next;
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTaskAtEnd(1, "Task A", 1, "2025-02-20");
        scheduler.addTaskAtEnd(2, "Task B", 2, "2025-02-21");
        scheduler.addTaskAtPosition(3, "Task C", 3, "2025-02-22", 2);
        scheduler.displayTasks();
        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.viewCurrentTask();
        scheduler.removeTask(2);
        scheduler.displayTasks();
    }
}
