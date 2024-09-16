package model;

public class SubTask extends Task{
    Epic epic;
    private int epicId;

    public SubTask(String name, Status status, String description, int epicId) {
        super(name, status, description);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    public Epic getEpic() {
        return epic = new Epic(name, status, description);
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }
}
