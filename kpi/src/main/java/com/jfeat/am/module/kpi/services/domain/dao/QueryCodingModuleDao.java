package com.jfeat.am.module.kpi.services.domain.dao;

import com.jfeat.am.module.kpi.services.domain.model.CodingModuleRecord;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingModule;
import com.jfeat.am.module.kpi.services.gen.crud.model.CodingModuleModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2020-10-29
 */
public interface QueryCodingModuleDao extends QueryMasterDao<CodingModule> {
   /*
    * Query entity list by page
    */
    List<CodingModuleRecord> findCodingModulePage(Page<CodingModuleRecord> page, @Param("record") CodingModuleRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /*
     * Query entity model for details
     */
    CodingModuleModel queryMasterModel(@Param("id") Long id);
}