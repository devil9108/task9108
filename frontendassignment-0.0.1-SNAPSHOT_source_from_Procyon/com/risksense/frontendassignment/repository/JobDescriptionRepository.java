// 
// Decompiled by Procyon v0.5.36
// 

package com.risksense.frontendassignment.repository;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.util.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.RowMapper;
import com.risksense.frontendassignment.model.mapper.JobDescriptionMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.risksense.frontendassignment.model.JobDescription;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

@Repository
public class JobDescriptionRepository
{
    @Autowired
    private DataSource dataSource;
    
    public List<JobDescription> findAll() {
        final NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
        return (List<JobDescription>)jdbcTemplate.query("SELECT * FROM `job_description`", (RowMapper)new JobDescriptionMapper());
    }
    
    public List<JobDescription> search(final String query, final String title, final String jobType, final String description, final String location) {
        final NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
        final MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        final StringBuilder conditionStr = new StringBuilder();
        if (!StringUtils.isEmpty((Object)query)) {
            conditionStr.append(" (LOWER(`title`) LIKE :attr_title OR LOWER(`job_type`) LIKE :attr_job_type OR LOWER(`description`) LIKE :attr_description OR LOWER(`location`) LIKE :attr_location)");
            final String attrQuery = "%" + query.toLowerCase() + "%";
            mapSqlParameterSource.addValue("attr_title", (Object)attrQuery).addValue("attr_job_type", (Object)attrQuery).addValue("attr_description", (Object)attrQuery).addValue("attr_location", (Object)attrQuery);
        }
        if (!StringUtils.isEmpty((Object)title)) {
            if (0 != conditionStr.length()) {
                conditionStr.append(" AND");
            }
            final String attrTitle = "%" + title.toLowerCase() + "%";
            conditionStr.append(" LOWER(`title`) LIKE :title");
            mapSqlParameterSource.addValue("title", (Object)attrTitle);
        }
        if (!StringUtils.isEmpty((Object)jobType)) {
            if (0 != conditionStr.length()) {
                conditionStr.append(" AND");
            }
            final String attrJobType = "%" + jobType.toLowerCase() + "%";
            conditionStr.append(" LOWER(`job_type`) LIKE :job_type");
            mapSqlParameterSource.addValue("job_type", (Object)attrJobType);
        }
        if (!StringUtils.isEmpty((Object)description)) {
            if (0 != conditionStr.length()) {
                conditionStr.append(" AND");
            }
            final String attrDescription = "%" + description.toLowerCase() + "%";
            conditionStr.append(" LOWER(`description`) LIKE :description");
            mapSqlParameterSource.addValue("description", (Object)attrDescription);
        }
        if (!StringUtils.isEmpty((Object)location)) {
            if (0 != conditionStr.length()) {
                conditionStr.append(" AND");
            }
            final String attrLocation = "%" + location.toLowerCase() + "%";
            conditionStr.append(" LOWER(`location`) LIKE :location");
            mapSqlParameterSource.addValue("location", (Object)attrLocation);
        }
        return (List<JobDescription>)jdbcTemplate.query("SELECT * FROM `job_description` WHERE" + conditionStr.toString(), (SqlParameterSource)mapSqlParameterSource, (RowMapper)new JobDescriptionMapper());
    }
}
