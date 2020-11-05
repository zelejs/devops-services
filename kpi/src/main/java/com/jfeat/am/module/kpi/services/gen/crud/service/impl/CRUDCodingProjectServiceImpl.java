package com.jfeat.am.module.kpi.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingProject;
import com.jfeat.am.module.kpi.services.gen.persistence.dao.CodingProjectMapper;
import com.jfeat.am.module.kpi.services.gen.crud.service.CRUDCodingProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDCodingProjectService
 * @author Code generator
 * @since 2020-10-29
 */

@Service
public class CRUDCodingProjectServiceImpl  extends CRUDServiceOnlyImpl<CodingProject> implements CRUDCodingProjectService {





        @Resource
        protected CodingProjectMapper codingProjectMapper;

        @Override
        protected BaseMapper<CodingProject> getMasterMapper() {
                return codingProjectMapper;
        }







}


