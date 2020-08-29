package am.tech42.staff.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name ="user_id", referencedColumnName = "user_id")
    private Company company;

    private String description;

    private Date deadline;

    @ManyToOne
    @JoinColumn(name = "jobType_id" ,referencedColumnName = "id")
    private JobType jobType;

    @ManyToMany(fetch = FetchType.EAGER)//because any time when I get post entity I use levels.
    @JoinTable(name = "post_level",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "level_id")}
    )
    private Set<Level> levels = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "skill_id" ,referencedColumnName = "id")
    private Skill skill;

    public Post(){}
    public Post(Company company, String description, Date deadline, JobType jobType, Set<Level> levels, Skill skill) {
        this.company = company;
        this.description = description;
        this.deadline = deadline;
        this.jobType = jobType;
        this.levels = levels;
        this.skill = skill;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Set<Level> getLevels() {
        return levels;
    }

    public void setLevels(Set<Level> levels) {
        this.levels = levels;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }


}