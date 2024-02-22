package org.tmanager.taskmanager.model;

public enum TaskStatus {
    NOT_STARTED("Не начата"),
    IN_PROGRESS("В процессе"),
    COMPLETED_ON_TIME("Выполнена в срок"),
    OVERDUE("Просрочена");

    private final String displayName;

    TaskStatus (String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

}
