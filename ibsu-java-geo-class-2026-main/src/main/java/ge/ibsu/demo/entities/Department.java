package ge.ibsu.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "department_name")
    private String departmentName;


    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;


    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }
}