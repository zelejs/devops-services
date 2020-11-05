package com.jfeat.am.module.kpi.services.domain.dao;

import com.jfeat.am.module.kpi.services.domain.model.CodingCommitRecordRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingCommitRecord;
import com.jfeat.am.module.kpi.services.gen.crud.model.CodingCommitRecordModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2020-10-29
 */
public interface QueryCodingCommitRecordDao extends QueryMasterDao<CodingCommitRecord> {
   /*
    * Query entity list by page
    */
    List<CodingCommitRecordRecord> findCodingCommitRecordPage(Page<CodingCommitRecordRecord> page, @Param("record") CodingCommitRecordRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    CodingCommitRecordModel queryMasterModel(@Param("id") Long id);
}