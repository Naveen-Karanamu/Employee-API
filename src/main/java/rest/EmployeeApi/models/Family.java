package rest.EmployeeApi.models;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private String spouse;
    private String[] kids;
    private Dependents dependents;

    // Getters, Setters, equals(), hashCode(), and toString() methods

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String[] getKids() {
        return kids;
    }

    public void setKids(String[] kids) {
        this.kids = kids;
    }

    public Dependents getDependents() {
        return dependents;
    }

    public void setDependents(Dependents dependents) {
        this.dependents = dependents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(spouse, family.spouse) &&
                Arrays.equals(kids, family.kids) &&
                Objects.equals(dependents, family.dependents);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(spouse, dependents);
        result = 31 * result + Arrays.hashCode(kids);
        return result;
    }

    @Override
    public String toString() {
        return "Family{" +
                "spouse='" + spouse + '\'' +
                ", kids=" + Arrays.toString(kids) +
                ", dependents=" + dependents +
                '}';
    }
}
