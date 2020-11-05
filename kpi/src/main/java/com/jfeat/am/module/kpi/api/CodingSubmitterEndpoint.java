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
import com.jfeat.am.module.kpi.services.domain.dao.QueryCodingSubmitterDao;
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
import com.jfeat.am.module.kpi.services.domain.model.CodingSubmitterRecord;
import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingSubmitter;

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

@Api("CodingSubmitter")
@RequestMapping("/api/crud/codingSubmitter/codingSubmitters")
public class CodingSubmitterEndpoint {

    @Resource
    CodingSubmitterService codingSubmitterService;

    @Resource
    QueryCodingSubmitterDao queryCodingSubmitterDao;

    @BusinessLog(name = "CodingSubmitter", value = "create CodingSubmitter")
    @Permission(CodingSubmitterPermission.CODINGSUBMITTER_NEW)
    @PostMapping
    @ApiOperation(value = "新建 CodingSubmitter", response = CodingSubmitter.class)
    public Tip createCodingSubmitter(@RequestBody CodingSubmitter entity) {

        Integer affected = 0;
        try {
            affected = codingSubmitterService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @Permission(CodingSubmitterPermission.CODINGSUBMITTER_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 CodingSubmitter", response = CodingSubmitter.class)
    public Tip getCodingSubmitter(@PathVariable Long id) {
        return SuccessTip.create(codingSubmitterService.queryMasterModel(queryCodingSubmitterDao, id));
    }

    @BusinessLog(name = "CodingSubmitter", value = "update CodingSubmitter")
    @Permission(CodingSubmitterPermission.CODINGSUBMITTER_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 CodingSubmitter", response = CodingSubmitter.class)
    public Tip updateCodingSubmitter(@PathVariable Long id, @RequestBody CodingSubmitter entity) {
        entity.setId(id);
        return SuccessTip.create(codingSubmitterService.updateMaster(entity));
    }

    @BusinessLog(name = "CodingSubmitter", value = "delete CodingSubmitter")
    @Permission(CodingSubmitterPermission.CODINGSUBMITTER_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 CodingSubmitter")
    public Tip deleteCodingSubmitter(@PathVariable Long id) {
        return SuccessTip.create(codingSubmitterService.deleteMaster(id));
    }

    @Permission(CodingSubmitterPermission.CODINGSUBMITTER_VIEW)
    @ApiOperation(value = "CodingSubmitter 列表信息", response = CodingSubmitterRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "orgId", dataType = "Long"),
            @ApiImplicitParam(name = "orgTag", dataType = "String"),
            @ApiImplicitParam(name = "commitAuthor", dataType = "String"),
            @ApiImplicitParam(name = "commitEmail", dataType = "String"),
            @ApiImplicitParam(name = "userId", dataType = "Long"),
            @ApiImplicitParam(name = "createTime", dataType = "Date"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryCodingSubmitters(Page<CodingSubmitterRecord> page,
                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(name = "search", required = false) String search,
                                     @RequestParam(name = "id", required = false) Long id,
                                     @RequestParam(name = "orgId", required = false) Long orgId,
                                     @RequestParam(name = "orgTag", required = false) String orgTag,
                                     @RequestParam(name = "commitAuthor", required = false) String commitAuthor,
                                     @RequestParam(name = "commitEmail", required = false) String commitEmail,
                                     @RequestParam(name = "userId", required = false) Long userId,
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

        CodingSubmitterRecord record = new CodingSubmitterRecord();
        record.setId(id);
        if (META.enabledSaaS()) {
            record.setOrgId(JWTKit.getOrgId());
        }
        record.setOrgTag(orgTag);
        record.setCommitAuthor(commitAuthor);
        record.setCommitEmail(commitEmail);
        record.setUserId(userId);
        record.setCreateTime(createTime);
        page.setRecords(queryCodingSubmitterDao.findCodingSubmitterPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
