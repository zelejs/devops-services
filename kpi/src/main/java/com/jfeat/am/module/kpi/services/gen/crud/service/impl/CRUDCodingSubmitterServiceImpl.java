package com.jfeat.am.module.kpi.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingSubmitter;
import com.jfeat.am.module.kpi.services.gen.persistence.dao.CodingSubmitterMapper;
import com.jfeat.am.module.kpi.services.gen.crud.service.CRUDCodingSubmitterService;
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
 *CRUDCodingSubmitterService
 * @author Code generator
 * @since 2020-10-29
 */

@Service
public class CRUDCodingSubmitterServiceImpl  extends CRUDServiceOnlyImpl<CodingSubmitter> implements CRUDCodingSubmitterService {





        @Resource
        protected CodingSubmitterMapper codingSubmitterMapper;

        @Override
        protected BaseMapper<CodingSubmitter> getMasterMapper() {
                return codingSubmitterMapper;
        }







}


