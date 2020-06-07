package Model;

import Utils.Time;
import java.io.Serializable;

/**
 *
 * @author jorge
 */
public class Task implements Serializable{

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
    int timeTask;

    /**
     * The cost per hour of the Task
     */
    double costHour;

    /**
     * The category of the Task
     */
    private String taskCategory;

    /**
     * The Task status by being payed
     */
    private boolean isPayed;

    /**
     * the Task status by being finished
     */

    private boolean isFinished;
    
    private TaskExecution texec;


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
     * The category by omission
     */
    private static final String CATEGORY_BY_OMISSION = "no category";
    
    private static final int TIMETASK_BY_OMISSION = 0;

    /**
     *
     * @param idTask
     * @param description
     * @param costHour
     * @param taskCategory
     * @param isPayed
     * @param isFinished
     */
    public Task(String idTask, String description, int timeTask, double costHour, String taskCategory, boolean isPayed, boolean isFinished) {
        this.idTask = idTask;
        this.description = description;
        this.timeTask = timeTask;
        this.costHour = costHour;
        this.taskCategory = taskCategory;
        this.isPayed = isPayed;
        this.isFinished = isFinished;
        this.texec = new TaskExecution();
    }

    public Task(String idTask, String description, int timeTask, double costHour, String taskCategory) {
        this.idTask = idTask;
        this.description = description;
        this.timeTask = timeTask;
        this.costHour = costHour;
        this.taskCategory = taskCategory;
        this.texec = new TaskExecution();
    }

    /**
     * Builds an instance of Task with the omission values
     */
    public Task() {
        idTask = ID_BY_OMISSION;
        description = DESCRIPTION_BY_OMISSION;
        timeTask = TIMETASK_BY_OMISSION;
        costHour = COST_BY_OMISSION;
        taskCategory = CATEGORY_BY_OMISSION;
        isPayed = false;
        isFinished = false;
        this.texec = new TaskExecution();
    }

    /**
     * Builds an instance of Task that is a copy passed by parameter
     *
     * @param otherTask address that is copied
     */
    public Task(Task otherTask) {
        idTask = otherTask.idTask;
        description = otherTask.description;
        timeTask = otherTask.timeTask;
        costHour = otherTask.costHour;
        taskCategory = otherTask.taskCategory;
        isPayed = otherTask.isPayed;
        isFinished = otherTask.isFinished;
        texec = otherTask.texec;
    }

    /**
     * Returns the id of the Task
     *
     * @return id of the Task
     */
    public String getIdTask() {
        return idTask;
    }

    /**
     * Modifies the ID of the Task
     *
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

    public int getTimeTask() {
        return timeTask;
    }

    public void setTime(int timeTask) {
        this.timeTask = timeTask;
    }

    public double getCostHour() {
        return costHour;
    }

    public void setCostHour(double costHour) {
        this.costHour = costHour;
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
    
    /**
     * @return the taskCategory
     */
    public String getTaskCategory() {
        return taskCategory;
    }

    /**
     * @param taskCategory the taskCategory to set
     */
    public void setTaskCategory(String taskCategory) {
        this.taskCategory = taskCategory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Compares 2 Task objects through id with both objects being considered
     * equal only when this parameter is the same
     *
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
     *
     * @return characteristics of the Task
     */
    public String toString() {
        return String.format("Task %s, description: %s, cost per hour: %s, "
                + "category: %s", idTask, description, costHour, taskCategory);
    }
    
     public String toStringS() {
        return String.format("Task %s\nDescription: %s\nCost per hour: %s"
                + "\nCategory: %s", idTask, description, costHour, taskCategory);
    }
    

    /**
     * @return the texec
     */
    public TaskExecution getTexec() {
        return texec;
    }

    /**
     * @param texec the texec to set
     */
    public void setTexec(TaskExecution texec) {
        this.texec = texec;
    }

    

    

}
