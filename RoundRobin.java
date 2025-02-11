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

    void removeProcess(int id) {
        if (head == null) return;
        if (head.id == id && head.next == head) {
            head = null;
            return;
        }
        Process temp = head, prev = null;
        do {
            if (temp.id == id) {
                if (prev != null) prev.next = temp.next;
                else {
                    Process last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void simulateRoundRobin(int timeQuantum) {
        if (head == null) return;
        Process temp = head;
        while (true) {
            if (temp.burstTime > timeQuantum) {
                temp.burstTime -= timeQuantum;
                System.out.println("Process " + temp.id + " executed for " + timeQuantum + " units.");
            } else {
                System.out.println("Process " + temp.id + " executed for " + temp.burstTime + " units and completed.");
                removeProcess(temp.id);
            }
            temp = temp.next;
            if (head == null) break;
        }
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
        scheduler.addProcess(3, 8, 3);
        scheduler.displayProcesses();
        scheduler.simulateRoundRobin(2);
    }
}
