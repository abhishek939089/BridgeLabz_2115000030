class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    TextState current;

    void addState(String content) {
        TextState newState = new TextState(content);
        if (current == null) {
            current = newState;
            return;
        }
        current.next = newState;
        newState.prev = current;
        current = newState;
    }

    void undo() {
        if (current != null && current.prev != null) current = current.prev;
    }

    void redo() {
        if (current != null && current.next != null) current = current.next;
    }

    void displayCurrentState() {
        if (current != null) System.out.println(current.content);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addState("Hello");
        editor.addState("World");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
