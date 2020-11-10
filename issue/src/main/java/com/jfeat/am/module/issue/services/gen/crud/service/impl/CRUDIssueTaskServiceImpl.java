package com.jfeat.am.module.issue.services.gen.crud.service.impl;
// ServiceImpl start

            
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.issue.services.gen.persistence.model.IssueTask;
import com.jfeat.am.module.issue.services.gen.persistence.dao.IssueTaskMapper;
import com.jfeat.am.module.issue.services.gen.crud.service.CRUDIssueTaskService;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDIssueTaskService
 * @author Code generator
 * @since 2020-11-10
 */

@Service
public class CRUDIssueTaskServiceImpl  extends CRUDServiceOnlyImpl<IssueTask> implements CRUDIssueTaskService {





        @Resource
        protected IssueTaskMapper issueTaskMapper;

        @Override
        protected BaseMapper<IssueTask> getMasterMapper() {
                return issueTaskMapper;
        }







}


