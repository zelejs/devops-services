package com.jfeat.am.module.kpi.api;


import com.jfeat.crud.plus.META;
import com.jfeat.am.core.jwt.JWTKit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.dao.DuplicateKeyException;
import com.jfeat.am.module.kpi.services.domain.dao.QueryCodingCommitRecordDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.am.module.kpi.api.permission.*;
import com.jfeat.am.common.annotation.Permission;

import java.math.BigDecimal;

import com.jfeat.am.module.kpi.services.domain.service.*;
import com.jfeat.am.module.kpi.services.domain.model.CodingCommitRecordRecord;
import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingCommitRecord;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * api
 * </p>
 *
 * @author Code generator
 * @since 2020-10-29
 */
@RestController

@Api("CodingCommitRecord")
@RequestMapping("/api/crud/codingCommitRecord/codingCommitRecords")
public class CodingCommitRecordEndpoint {

    @Resource
    CodingCommitRecordService codingCommitRecordService;


    @Resource
    QueryCodingCommitRecordDao queryCodingCommitRecordDao;

    @BusinessLog(name = "CodingCommitRecord", value = "create CodingCommitRecord")
    @Permission(CodingCommitRecordPermission.CODINGCOMMITRECORD_NEW)
    @PostMapping
    @ApiOperation(value = "新建 CodingCommitRecord", response = CodingCommitRecord.class)
    public Tip createCodingCommitRecord(@RequestBody CodingCommitRecord entity) {

        Integer affected = 0;
        try {
            affected = codingCommitRecordService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @Permission(CodingCommitRecordPermission.CODINGCOMMITRECORD_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 CodingCommitRecord", response = CodingCommitRecord.class)
    public Tip getCodingCommitRecord(@PathVariable Long id) {
        return SuccessTip.create(codingCommitRecordService.queryMasterModel(queryCodingCommitRecordDao, id));
    }

    @BusinessLog(name = "CodingCommitRecord", value = "update CodingCommitRecord")
    @Permission(CodingCommitRecordPermission.CODINGCOMMITRECORD_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 CodingCommitRecord", response = CodingCommitRecord.class)
    public Tip updateCodingCommitRecord(@PathVariable Long id, @RequestBody CodingCommitRecord entity) {
        entity.setId(id);
        return SuccessTip.create(codingCommitRecordService.updateMaster(entity));
    }

    @BusinessLog(name = "CodingCommitRecord", value = "delete CodingCommitRecord")
    @Permission(CodingCommitRecordPermission.CODINGCOMMITRECORD_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 CodingCommitRecord")
    public Tip deleteCodingCommitRecord(@PathVariable Long id) {
        return SuccessTip.create(codingCommitRecordService.deleteMaster(id));
    }

    @Permission(CodingCommitRecordPermission.CODINGCOMMITRECORD_VIEW)
    @ApiOperation(value = "CodingCommitRecord 列表信息", response = CodingCommitRecordRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "orgId", dataType = "Long"),
            @ApiImplicitParam(name = "orgTag", dataType = "String"),
            @ApiImplicitParam(name = "moduleId", dataType = "Long"),
            @ApiImplicitParam(name = "moduleName", dataType = "String"),
            @ApiImplicitParam(name = "commitId", dataType = "String"),
            @ApiImplicitParam(name = "commitAuthor", dataType = "String"),
            @ApiImplicitParam(name = "commitComment", dataType = "String"),
            @ApiImplicitParam(name = "commitLines", dataType = "Integer"),
            @ApiImplicitParam(name = "isDeleted", dataType = "Integer"),
            @ApiImplicitParam(name = "createTime", dataType = "Date"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
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
        page.setRecords(queryCodingCommitRecordDao.findCodingCommitRecordPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
