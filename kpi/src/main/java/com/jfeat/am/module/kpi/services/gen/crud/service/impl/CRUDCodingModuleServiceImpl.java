package com.jfeat.am.module.kpi.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingModule;
import com.jfeat.am.module.kpi.services.gen.persistence.dao.CodingModuleMapper;
import com.jfeat.am.module.kpi.services.gen.crud.service.CRUDCodingModuleService;
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
 *CRUDCodingModuleService
 * @author Code generator
 * @since 2020-10-29
 */

@Service
public class CRUDCodingModuleServiceImpl  extends CRUDServiceOnlyImpl<CodingModule> implements CRUDCodingModuleService {





        @Resource
        protected CodingModuleMapper codingModuleMapper;

        @Override
        protected BaseMapper<CodingModule> getMasterMapper() {
                return codingModuleMapper;
        }







}


