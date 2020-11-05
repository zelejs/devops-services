package com.jfeat.am.module.kpi.services.domain.model;

import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingCommitRecord;

/**
 * Created by Code generator on 2020-10-29
 */
public class CodingCommitRecordRecord extends CodingCommitRecord{

    String projectName;


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
