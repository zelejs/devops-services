package com.jfeat.am.module.kpi.services.domain.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.module.kpi.services.domain.model.CodingCommitRecordRecord;
import com.jfeat.am.module.kpi.services.domain.model.CodingProjectRecord;
import com.jfeat.am.module.kpi.services.domain.model.CodingSubmitterRecord;
import com.jfeat.am.module.kpi.services.gen.crud.model.CodingProjectModel;
import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingProject;
import com.jfeat.crud.plus.QueryMasterDao;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Code generator on 2020-10-29
 */
public interface QueryKPIPageDao {

     List<CodingCommitRecordRecord> QueryCommitRecords(Page<CodingCommitRecordRecord> page,
                        @Param("record") CodingCommitRecordRecord record,
                        @Param("search") String search);
}