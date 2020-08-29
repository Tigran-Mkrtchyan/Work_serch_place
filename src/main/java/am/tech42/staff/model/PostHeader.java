package am.tech42.staff.model;

import java.sql.Date;
import java.util.List;

public class PostHeader {
    private int postId;
    private String CompanyName;
    private String skill;
    private String jobType;
    private Date deadline;
    private String logoPath;

    public PostHeader(int postId, String companyName, String skill, String jobType,Date deadline, String logoPath) {
        this.postId = postId;
        this.CompanyName = companyName;
        this.skill = skill;
        this.jobType = jobType;
        this.deadline = deadline;
        this.logoPath = logoPath;
    }

    public int getPostId() {
        return postId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getSkill() {
        return skill;
    }

    public String getJobType() {
        return jobType;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
}
