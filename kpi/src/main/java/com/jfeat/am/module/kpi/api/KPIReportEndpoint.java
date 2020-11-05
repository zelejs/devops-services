package com.jfeat.am.module.kpi.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.kpi.api.permission.CodingCommitRecordPermission;
import com.jfeat.am.module.kpi.api.permission.CodingProjectPermission;
import com.jfeat.am.module.kpi.services.domain.dao.QueryCodingProjectDao;
import com.jfeat.am.module.kpi.services.domain.dao.QueryKPIPageDao;
import com.jfeat.am.module.kpi.services.domain.model.CodingCommitRecordRecord;
import com.jfeat.am.module.kpi.services.domain.model.CodingProjectRecord;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.crud.plus.META;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@Api("CodingSubmitter")
@RequestMapping("/api/crud/kpi")
public class KPIReportEndpoint {

    @Resource
    QueryCodingProjectDao queryCodingProjectDao;
    @Resource
    QueryKPIPageDao queryKPIPageDao;

    @Permission(CodingProjectPermission.CODINGPROJECT_VIEW)
    @ApiOperation(value = "CodingProject 列表信息", response = CodingProjectRecord.class)
    @GetMapping("/projects")
    public Tip queryCodingProjects(Page<CodingProjectRecord> page,
                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                   @RequestParam(name = "search", required = false) String search,
                                   @RequestParam(name = "id", required = false) Long id,
                                   @RequestParam(name = "orgId", required = false) Long orgId,
                                   @RequestParam(name = "orgTag", required = false) String orgTag,
                                   @RequestParam(name = "name", required = false) String name,
                                   @RequestParam(name = "clientId", required = false) Long clientId,
                                   @RequestParam(name = "desc", required = false) String desc,
                                   @RequestParam(name = "isDeleted", required = false) Integer isDeleted,
                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                   @RequestParam(name = "createTime", required = false) Date createTime) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        CodingProjectRecord record = new CodingProjectRecord();
        record.setId(id);
        if (META.enabledSaaS()) {
            record.setOrgId(JWTKit.getOrgId());
        }
        record.setOrgTag(orgTag);
        record.setName(name);
        record.setClientId(clientId);
        record.setDesc(desc);
        record.setIsDeleted(isDeleted);
        record.setCreateTime(createTime);
        page.setRecords(queryCodingProjectDao.findCodingProjectPage(page, record, search,null, null, null));

        return SuccessTip.create(page);
    }


    @Permission(CodingCommitRecordPermission.CODINGCOMMITRECORD_VIEW)
    @ApiOperation(value = "CodingCommitRecord 列表信息", response = CodingCommitRecordRecord.class)
    @GetMapping("/commitRecords")
    public Tip queryCodingCommitRecords(Page<CodingCommitRecordRecord> page,
                                        @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                        @RequestParam(name = "search", required = false) String search,
                                        @RequestParam(name = "id", required = false) Long id,
                                        @RequestParam(name = "orgId", required = false) Long orgId,
                                        @RequestParam(name = "orgTag", required = false) String orgTag,
                                        @RequestParam(name = "moduleId", required = false) Long moduleId,
                                        @RequestParam(name = "moduleName", required = false) String moduleName,
                                        @RequestParam(name = "commitId", required = false) String commitId,
                                        @RequestParam(name = "commitAuthor", required = false) String commitAuthor,
                                        @RequestParam(name = "commitComment", required = false) String commitComment,
                                        @RequestParam(name = "commitLines", required = false) Integer commitLines,
                                        @RequestParam(name = "isDeleted", required = false) Integer isDeleted,
                                        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                        @RequestParam(name = "createTime", required = false) Date createTime,
                                        @RequestParam(name = "orderBy", required = false) String orderBy,
                                        @RequestParam(name = "sort", required = false) String sort) {
        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String pattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(pattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";
            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        CodingCommitRecordRecord record = new CodingCommitRecordRecord();
        record.setId(id);
        if (META.enabledSaaS()) {
            record.setOrgId(JWTKit.getOrgId());
        }
        record.setOrgTag(orgTag);
        record.setModuleId(moduleId);
        record.setModuleName(moduleName);
        record.setCommitId(commitId);
        record.setCommitAuthor(commitAuthor);
        record.setCommitComment(commitComment);
        record.setCommitLines(commitLines);
        record.setIsDeleted(isDeleted);
        record.setCreateTime(createTime);
        page.setRecords(queryKPIPageDao.QueryCommitRecords(page, record, search));

        return SuccessTip.create(page);
    }


}
