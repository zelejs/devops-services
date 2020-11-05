package com.jfeat.am.module.issue.services.domain.dao;

import com.jfeat.am.module.issue.services.domain.model.IssueTaskRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.issue.services.gen.persistence.model.IssueTask;
import com.jfeat.am.module.issue.services.gen.crud.model.IssueTaskModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2020-10-29
 */
public interface QueryIssueTaskDao extends QueryMasterDao<IssueTask> {
   /*
    * Query entity list by page
    */
    List<IssueTaskRecord> findIssueTaskPage(Page<IssueTaskRecord> page, @Param("record") IssueTaskRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    IssueTaskModel queryMasterModel(@Param("id") Long id);
}