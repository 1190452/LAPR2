package Model;

import Utils.Time;

/**
 *
 * @author jorge
 */
public class Task {

    /**
     * The id of the Task
     */
    String idTask;

    /**
     * The description of the Task
     */
    String description;

    /**
     * The time of the Task
     */
    Time time;

    /**
     * The cost per hour of the Task
     */
    double costHour;

    /**
     * The category of the Task
     */
    TaskCategory taskCategory;

    /**
     * The Task status by being payed
     */
    boolean isPayed;

    /**
     * the Task status by being finished
     */
    boolean isFinished;

    /**
     * The id of the Task per omission
     */
    private static final String ID_BY_OMISSION = "no id provided";

    /**
     * The description of the Task per omission
     */
    private static final String DESCRIPTION_BY_OMISSION = "no description provided";

    /**
     * The cost of the Task per hour per omission
     */
    private static final double COST_BY_OMISSION = 0;

    /**
     *
     * @param idTask
     * @param description
     * @param time
     * @param costHour
     * @param taskCategory
     * @param isPayed
     * @param isFinished
     */
    public Task(String idTask, String description, Time time, double costHour, TaskCategory taskCategory, boolean isPayed, boolean isFinished) {
        this.idTask = idTask;
        this.description = description;
        this.time = time;
        this.costHour = costHour;
        this.taskCategory = taskCategory;
        this.isPayed = isPayed;
        this.isFinished = isFinished;
    }

    /**
     * Builds an instance of Task with the omission values
     */
    public Task() {
        idTask = ID_BY_OMISSION;
        description = DESCRIPTION_BY_OMISSION;
        time = new Time();
        costHour = COST_BY_OMISSION;
        taskCategory = new TaskCategory();
        isPayed = false;
        isFinished = false;
    }
    
    /**
     * Builds an instance of Task that is a copy passed by parameter
     * @param otherTask address that is copied
     */
    public Task(Task otherTask) {
        idTask = otherTask.idTask;
        description = otherTask.description;
        time = otherTask.time;
        costHour = otherTask.costHour;
        taskCategory = otherTask.taskCategory;
        isPayed = otherTask.isPayed;
        isFinished = otherTask.isFinished;
    }

    /**
     * Returns the id of the Task
     * @return id of the Task
     */
    public String getIdTask() {
        return idTask;
    }

    /**
     * Modifies the ID of the Task
     * @param idTask the new ID of the task
     */
    public void setIdTask(String idTask) {
        this.idTask = idTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public double getCostHour() {
        return costHour;
    }

    public void setCostHour(double costHour) {
        this.costHour = costHour;
    }

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(TaskCategory taskCategory) {
        this.taskCategory = taskCategory;
    }

    public boolean isIsPayed() {
        return isPayed;
    }

    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }

    public boolean isIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Compares 2 Task objects through id with both objects being considered equal only when this parameter is the same
     * @param otherObject
     * @return 
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        Task otherTask = (Task) otherObject;
        return this.idTask.equals(otherTask.idTask);
    }

    /**
     * Returns the characteristics of the Task
     * @return characteristics of the Task
     */
    public String toString() {
        return String.format("Task %s, description: %s, cost per hour: %s, "
                + "category: %s", idTask, description, costHour, taskCategory);
    }
    
    
    
    
    
    
    
    
    

}
