package com.jfeat.am.module.kpi.services.domain.dao;

import com.jfeat.am.module.kpi.services.domain.model.CodingProjectRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingProject;
import com.jfeat.am.module.kpi.services.gen.crud.model.CodingProjectModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2020-10-29
 */
public interface QueryCodingProjectDao extends QueryMasterDao<CodingProject> {
   /*
    * Query entity list by page
    */
    List<CodingProjectRecord> findCodingProjectPage(Page<CodingProjectRecord> page, @Param("record") CodingProjectRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);



    /*
     * Query entity model for details
     */
    CodingProjectModel queryMasterModel(@Param("id") Long id);
}