package usr;

/**
 * Created by mac on 16/6/26.
 */
public class Employee extends User{
    private String name;
    private User supervisor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }
}
