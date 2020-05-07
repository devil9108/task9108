// 
// Decompiled by Procyon v0.5.36
// 

package com.risksense.frontendassignment.controller;

import java.util.ArrayList;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import com.risksense.frontendassignment.model.JobDescription;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.risksense.frontendassignment.repository.JobDescriptionRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping({ "/api/jobdescriptions" })
@Api(value = "Job Description", description = "Description of the jobs")
public class JobDescriptionController
{
    @Autowired
    private JobDescriptionRepository jobDescriptionRepository;
    
    @GetMapping(value = { "", "/" }, produces = { "application/json" })
    @ApiOperation(value = "Get all available job from datasource", response = JobDescription.class, responseContainer = "List")
    @ApiResponses({ @ApiResponse(code = 200, message = "Successfully retrieved list") })
    public ResponseEntity<List<JobDescription>> getAll() {
        return (ResponseEntity<List<JobDescription>>)new ResponseEntity((Object)this.jobDescriptionRepository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(value = { "/search" }, produces = { "application/json" })
    @ApiOperation(value = "Filter the list of jobs on the specified parameter as described. Multiple parameter will be filtered on the basis of field in 'AND' Condition", response = JobDescription.class, responseContainer = "List")
    @ApiResponses({ @ApiResponse(code = 200, message = "Successfully retrieved filtered list"), @ApiResponse(code = 400, message = "Not a valid request") })
    public ResponseEntity<List<JobDescription>> search(@ApiParam(name = "query", value = "Applies filter on all fields on this api with conditional 'OR'") @RequestParam(value = "query", required = false) final String query, @ApiParam(name = "title", value = "Applies filter on `title` field") @RequestParam(value = "title", required = false) final String title, @ApiParam(name = "job_type", value = "Applies filter on `job_type` field") @RequestParam(value = "job_type", required = false) final String jobType, @ApiParam(name = "description", value = "Applies filter on `description` field") @RequestParam(value = "description", required = false) final String description, @ApiParam(name = "location", value = "Applies filter on `location` field") @RequestParam(value = "location", required = false) final String location) {
        if (StringUtils.isEmpty((Object)query) && StringUtils.isEmpty((Object)jobType) && StringUtils.isEmpty((Object)title) && StringUtils.isEmpty((Object)description) && StringUtils.isEmpty((Object)location)) {
            return (ResponseEntity<List<JobDescription>>)new ResponseEntity((Object)new ArrayList(), HttpStatus.BAD_REQUEST);
        }
        return (ResponseEntity<List<JobDescription>>)new ResponseEntity((Object)this.jobDescriptionRepository.search(query, title, jobType, description, location), HttpStatus.OK);
    }
}
