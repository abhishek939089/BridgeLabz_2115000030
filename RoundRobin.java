class Process {
    int id, burstTime, priority;
    Process next;

    Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = this;
    }
}

class RoundRobin {
    Process head;

    void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = newProcess;
            return;
        }
        Process temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newProcess;
        newProcess.next = head;
    }

    void displayProcesses() {
        if (head == null) return;
        Process temp = head;
        do {
            System.out.println(temp.id + " " + temp.burstTime + " " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        RoundRobin scheduler = new RoundRobin();
        scheduler.addProcess(1, 5, 2);
        scheduler.addProcess(2, 3, 1);
        scheduler.displayProcesses();
    }
}
