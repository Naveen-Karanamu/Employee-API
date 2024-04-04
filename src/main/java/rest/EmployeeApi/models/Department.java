package rest.EmployeeApi.models;

import java.util.Objects;

public class Department {
    private DepartmentInfo department1;
    private DepartmentInfo department2;

    public DepartmentInfo getDepartment1() {
        return department1;
    }

    public void setDepartment1(DepartmentInfo department1) {
        this.department1 = department1;
    }

    public DepartmentInfo getDepartment2() {
        return department2;
    }

    public void setDepartment2(DepartmentInfo department2) {
        this.department2 = department2;
    }

    public static class DepartmentInfo {
        private int id;
        private String name;

        public DepartmentInfo() {
        }

        public DepartmentInfo(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DepartmentInfo that = (DepartmentInfo) o;
            return id == that.id &&
                    Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "DepartmentInfo{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
