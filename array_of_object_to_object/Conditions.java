package array_of_object_to_object;

public class Conditions {
    private boolean isFirstNameValid;
    private boolean isLastNameValid;
    private int remark;

    public Conditions(boolean isFirstNameValid, boolean isLastNameValid, int remark) {
        this.isFirstNameValid = isFirstNameValid;
        this.isLastNameValid = isLastNameValid;
        this.remark = remark;
    }

    public boolean isFirstNameValid() {
        return isFirstNameValid;
    }

    public void setFirstNameValid(boolean firstNameValid) {
        isFirstNameValid = firstNameValid;
    }

    public boolean isLastNameValid() {
        return isLastNameValid;
    }

    public void setLastNameValid(boolean lastNameValid) {
        isLastNameValid = lastNameValid;
    }

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }
}
