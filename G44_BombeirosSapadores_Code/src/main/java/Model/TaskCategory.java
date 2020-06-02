package Model;

/**
 *
 * @author jorge
 */
public class TaskCategory {
    
    /**
     * The code of the category of the Task
     */
    private String catCode;
    
    /**
     * The description of the category of the Task
     */
    private String catDescription;

    /**
     * Category's code by omission
     */
    private static final String CATCODE_BY_OMISSION = "no category provided";
    
    /**
     * Category's description by omission
     */
    private static final String CATDESCRIPTION_BY_OMISSION = "no description provided";

    /**
     * It builds an instance of a TaskCategory.
     * 
     * @param catCode the code of the category
     * @param catDescription the description of the category
     */ 
    public TaskCategory(String catCode, String catDescription) {
        this.catCode = catCode;
        this.catDescription = catDescription;
    }   
    
    /**
     * It builds an instance of an TaskCategory copying another instance.
     *
     * @param anotherCategory
     */
    public TaskCategory(TaskCategory anotherCategory) {
        this.catCode = anotherCategory.catCode;
        this.catDescription = anotherCategory.catDescription;
    }

    /**
     * It builds an instance of a Company with values by omission.
     */    
    public TaskCategory() {
        this.catCode = CATCODE_BY_OMISSION;
        this.catDescription = CATDESCRIPTION_BY_OMISSION;
    }

    /**
     * Returns the task category code.
     *
     * @return 
     */
    public String getCatCode() {
        return catCode;
    }

    /**
     * Returns the task category description.
     *
     * @return
     */
    public String getCatDescription() {
        return catDescription;
    }

    /**
     * It changes the category's code.
     *
     * @param catCode
     */
    public void setCatCode(String catCode) {
        if (catCode == null || catCode.isEmpty()) {
            throw new IllegalArgumentException("There are no arguments.");
        }
        this.catCode = catCode;
    }

    /**
     * It changes the task category description.
     *
     * @param catDescription
     */
    public void setCatDescription(String catDescription) {
        if (catDescription == null || catDescription.isEmpty()) {
            throw new IllegalArgumentException("There are no arguments.");
        }
        this.catDescription = catDescription;
    }
    
    /**
     * It compares two instances of task category and if all the atributes are the
     * same, then it is the same object.
     *
     * @param anotherObject
     * @return true, if all the references refer to the same object false, if
     * any of the reference is different between both objects
     */
    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null || this.getClass() != anotherObject.getClass()) {
            return false;
        }
        TaskCategory anotherCategory = (TaskCategory) anotherObject;
        return this.catCode.equalsIgnoreCase(anotherCategory.catCode)
                && this.catDescription.equalsIgnoreCase(anotherCategory.catDescription);
    }

    /**
     * It returns the characteristics of a record of categories.
     *
     * @return characteristics of a record of categories.
     */
    @Override
    public String toString() {
        return String.format("Category with the ID code: %s and with the description: %s.", catCode, catDescription);
    }  
    
}
