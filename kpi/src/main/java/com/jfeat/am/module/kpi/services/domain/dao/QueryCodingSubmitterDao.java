package com.jfeat.am.module.kpi.services.domain.dao;

import com.jfeat.am.module.kpi.services.domain.model.CodingSubmitterRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingSubmitter;
import com.jfeat.am.module.kpi.services.gen.crud.model.CodingSubmitterModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2020-10-29
 */
public interface QueryCodingSubmitterDao extends QueryMasterDao<CodingSubmitter> {
   /*
    * Query entity list by page
    */
    List<CodingSubmitterRecord> findCodingSubmitterPage(Page<CodingSubmitterRecord> page, @Param("record") CodingSubmitterRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    CodingSubmitterModel queryMasterModel(@Param("id") Long id);
}