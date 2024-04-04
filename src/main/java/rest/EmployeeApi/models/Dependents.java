package rest.EmployeeApi.models;

import java.util.Arrays;
import java.util.Objects;

public class Dependents {
    private String[] parents;
    private String[] parentsInLaw;
    private String[] others;

    // Getters and Setters
    public String[] getParents() {
        return parents;
    }

    public void setParents(String[] parents) {
        this.parents = parents;
    }

    public String[] getParentsInLaw() {
        return parentsInLaw;
    }

    public void setParentsInLaw(String[] parentsInLaw) {
        this.parentsInLaw = parentsInLaw;
    }

    public String[] getOthers() {
        return others;
    }

    public void setOthers(String[] others) {
        this.others = others;
    }

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependents that = (Dependents) o;
        return Arrays.equals(parents, that.parents) &&
                Arrays.equals(parentsInLaw, that.parentsInLaw) &&
                Arrays.equals(others, that.others);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(parents);
        result = 31 * result + Arrays.hashCode(parentsInLaw);
        result = 31 * result + Arrays.hashCode(others);
        return result;
    }

    // toString() method
    @Override
    public String toString() {
        return "Dependents{" +
                "parents=" + Arrays.toString(parents) +
                ", parentsInLaw=" + Arrays.toString(parentsInLaw) +
                ", others=" + Arrays.toString(others) +
                '}';
    }
}
