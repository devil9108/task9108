// 
// Decompiled by Procyon v0.5.36
// 

package com.risksense.frontendassignment.model.mapper;

import java.sql.SQLException;
import java.sql.ResultSet;
import com.risksense.frontendassignment.model.JobDescription;
import org.springframework.jdbc.core.RowMapper;

public class JobDescriptionMapper implements RowMapper<JobDescription>
{
    public JobDescription mapRow(final ResultSet resultSet, final int i) throws SQLException {
        final JobDescription jobDescription = new JobDescription();
        jobDescription.setId(resultSet.getLong("id"));
        jobDescription.setTitle(resultSet.getString("title"));
        jobDescription.setDesciption(resultSet.getString("description"));
        jobDescription.setSalarymin(resultSet.getString("salary_min"));
        jobDescription.setSalarymax(resultSet.getString("salary_max"));
        jobDescription.setJobType(resultSet.getString("job_type"));
        jobDescription.setLocation(resultSet.getString("location"));
        jobDescription.setRequiredSkills(resultSet.getString("required_skills"));
        return jobDescription;
    }
}
