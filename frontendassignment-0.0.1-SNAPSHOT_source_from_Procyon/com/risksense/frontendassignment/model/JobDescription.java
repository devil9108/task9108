// 
// Decompiled by Procyon v0.5.36
// 

package com.risksense.frontendassignment.model;

public class JobDescription
{
    private long id;
    private String title;
    private String desciption;
    private String salarymin;
    private String salarymax;
    private String jobType;
    private String location;
    private String requiredSkills;
    
    public long getId() {
        return this.id;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getDesciption() {
        return this.desciption;
    }
    
    public String getSalarymin() {
        return this.salarymin;
    }
    
    public String getSalarymax() {
        return this.salarymax;
    }
    
    public String getJobType() {
        return this.jobType;
    }
    
    public String getLocation() {
        return this.location;
    }
    
    public String getRequiredSkills() {
        return this.requiredSkills;
    }
    
    public void setId(final long id) {
        this.id = id;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public void setDesciption(final String desciption) {
        this.desciption = desciption;
    }
    
    public void setSalarymin(final String salarymin) {
        this.salarymin = salarymin;
    }
    
    public void setSalarymax(final String salarymax) {
        this.salarymax = salarymax;
    }
    
    public void setJobType(final String jobType) {
        this.jobType = jobType;
    }
    
    public void setLocation(final String location) {
        this.location = location;
    }
    
    public void setRequiredSkills(final String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof JobDescription)) {
            return false;
        }
        final JobDescription other = (JobDescription)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        if (this.getId() != other.getId()) {
            return false;
        }
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        Label_0079: {
            if (this$title == null) {
                if (other$title == null) {
                    break Label_0079;
                }
            }
            else if (this$title.equals(other$title)) {
                break Label_0079;
            }
            return false;
        }
        final Object this$desciption = this.getDesciption();
        final Object other$desciption = other.getDesciption();
        Label_0116: {
            if (this$desciption == null) {
                if (other$desciption == null) {
                    break Label_0116;
                }
            }
            else if (this$desciption.equals(other$desciption)) {
                break Label_0116;
            }
            return false;
        }
        final Object this$salarymin = this.getSalarymin();
        final Object other$salarymin = other.getSalarymin();
        Label_0153: {
            if (this$salarymin == null) {
                if (other$salarymin == null) {
                    break Label_0153;
                }
            }
            else if (this$salarymin.equals(other$salarymin)) {
                break Label_0153;
            }
            return false;
        }
        final Object this$salarymax = this.getSalarymax();
        final Object other$salarymax = other.getSalarymax();
        Label_0190: {
            if (this$salarymax == null) {
                if (other$salarymax == null) {
                    break Label_0190;
                }
            }
            else if (this$salarymax.equals(other$salarymax)) {
                break Label_0190;
            }
            return false;
        }
        final Object this$jobType = this.getJobType();
        final Object other$jobType = other.getJobType();
        Label_0227: {
            if (this$jobType == null) {
                if (other$jobType == null) {
                    break Label_0227;
                }
            }
            else if (this$jobType.equals(other$jobType)) {
                break Label_0227;
            }
            return false;
        }
        final Object this$location = this.getLocation();
        final Object other$location = other.getLocation();
        Label_0264: {
            if (this$location == null) {
                if (other$location == null) {
                    break Label_0264;
                }
            }
            else if (this$location.equals(other$location)) {
                break Label_0264;
            }
            return false;
        }
        final Object this$requiredSkills = this.getRequiredSkills();
        final Object other$requiredSkills = other.getRequiredSkills();
        if (this$requiredSkills == null) {
            if (other$requiredSkills == null) {
                return true;
            }
        }
        else if (this$requiredSkills.equals(other$requiredSkills)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof JobDescription;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * 59 + (int)($id >>> 32 ^ $id);
        final Object $title = this.getTitle();
        result = result * 59 + (($title == null) ? 43 : $title.hashCode());
        final Object $desciption = this.getDesciption();
        result = result * 59 + (($desciption == null) ? 43 : $desciption.hashCode());
        final Object $salarymin = this.getSalarymin();
        result = result * 59 + (($salarymin == null) ? 43 : $salarymin.hashCode());
        final Object $salarymax = this.getSalarymax();
        result = result * 59 + (($salarymax == null) ? 43 : $salarymax.hashCode());
        final Object $jobType = this.getJobType();
        result = result * 59 + (($jobType == null) ? 43 : $jobType.hashCode());
        final Object $location = this.getLocation();
        result = result * 59 + (($location == null) ? 43 : $location.hashCode());
        final Object $requiredSkills = this.getRequiredSkills();
        result = result * 59 + (($requiredSkills == null) ? 43 : $requiredSkills.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "JobDescription(id=" + this.getId() + ", title=" + this.getTitle() + ", desciption=" + this.getDesciption() + ", salarymin=" + this.getSalarymin() + ", salarymax=" + this.getSalarymax() + ", jobType=" + this.getJobType() + ", location=" + this.getLocation() + ", requiredSkills=" + this.getRequiredSkills() + ")";
    }
}
