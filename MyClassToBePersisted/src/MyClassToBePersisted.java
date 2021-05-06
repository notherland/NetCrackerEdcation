import java.io.Serializable;
import java.util.Objects;

public class MyClassToBePersisted implements Serializable {
    private String profile;
    private String group;

    public MyClassToBePersisted(){}

    public MyClassToBePersisted(String profile, String group) {
        this.profile = profile;
        this.group = group;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyClassToBePersisted)) return false;
        MyClassToBePersisted that = (MyClassToBePersisted) o;
        return Objects.equals(getProfile(), that.getProfile()) && Objects.equals(getGroup(), that.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProfile(), getGroup());
    }

    @Override
    public String toString() {
        return "MyClassToBePersisted{" +
                "profile='" + profile + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
