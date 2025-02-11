class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    TextState current, head;
    int historySize = 0;
    final int MAX_HISTORY = 10;

    void addState(String content) {
        TextState newState = new TextState(content);
        if (current == null) {
            current = head = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
        }
        historySize++;

        if (historySize > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            historySize--;
        }
    }

    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Undo not possible.");
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Redo not possible.");
        }
    }

    void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addState("Hello");
        editor.addState("World");
        editor.addState("Java");
        editor.addState("Programming");

        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
        editor.redo();
    }
}
