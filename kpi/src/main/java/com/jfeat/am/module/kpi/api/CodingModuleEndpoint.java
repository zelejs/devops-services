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
import com.jfeat.am.module.kpi.services.domain.dao.QueryCodingModuleDao;
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
import com.jfeat.am.module.kpi.services.domain.model.CodingModuleRecord;
import com.jfeat.am.module.kpi.services.gen.persistence.model.CodingModule;

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

@Api("CodingModule")
@RequestMapping("/api/crud/codingModule/codingModules")
public class CodingModuleEndpoint {

    @Resource
    CodingModuleService codingModuleService;


    @Resource
    QueryCodingModuleDao queryCodingModuleDao;

    @BusinessLog(name = "CodingModule", value = "create CodingModule")
    @Permission(CodingModulePermission.CODINGMODULE_NEW)
    @PostMapping
    @ApiOperation(value = "新建 CodingModule", response = CodingModule.class)
    public Tip createCodingModule(@RequestBody CodingModule entity) {

        Integer affected = 0;
        try {
            affected = codingModuleService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @Permission(CodingModulePermission.CODINGMODULE_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 CodingModule", response = CodingModule.class)
    public Tip getCodingModule(@PathVariable Long id) {
        return SuccessTip.create(codingModuleService.queryMasterModel(queryCodingModuleDao, id));
    }

    @BusinessLog(name = "CodingModule", value = "update CodingModule")
    @Permission(CodingModulePermission.CODINGMODULE_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 CodingModule", response = CodingModule.class)
    public Tip updateCodingModule(@PathVariable Long id, @RequestBody CodingModule entity) {
        entity.setId(id);
        return SuccessTip.create(codingModuleService.updateMaster(entity));
    }

    @BusinessLog(name = "CodingModule", value = "delete CodingModule")
    @Permission(CodingModulePermission.CODINGMODULE_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 CodingModule")
    public Tip deleteCodingModule(@PathVariable Long id) {
        return SuccessTip.create(codingModuleService.deleteMaster(id));
    }

    @Permission(CodingModulePermission.CODINGMODULE_VIEW)
    @ApiOperation(value = "CodingModule 列表信息", response = CodingModuleRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "orgId", dataType = "Long"),
            @ApiImplicitParam(name = "orgTag", dataType = "String"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "projectId", dataType = "Long"),
            @ApiImplicitParam(name = "projectName", dataType = "String"),
            @ApiImplicitParam(name = "repoUrl", dataType = "String"),
            @ApiImplicitParam(name = "isDeleted", dataType = "Integer"),
            @ApiImplicitParam(name = "createTime", dataType = "Date"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryCodingModules(Page<CodingModuleRecord> page,
                                  @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(name = "search", required = false) String search,
                                  @RequestParam(name = "id", required = false) Long id,
                                  @RequestParam(name = "orgId", required = false) Long orgId,
                                  @RequestParam(name = "orgTag", required = false) String orgTag,
                                  @RequestParam(name = "name", required = false) String name,
                                  @RequestParam(name = "projectId", required = false) Long projectId,
                                  @RequestParam(name = "projectName", required = false) String projectName,
                                  @RequestParam(name = "repoUrl", required = false) String repoUrl,
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

        CodingModuleRecord record = new CodingModuleRecord();
        record.setId(id);
        if (META.enabledSaaS()) {
            record.setOrgId(JWTKit.getOrgId());
        }
        record.setOrgTag(orgTag);
        record.setName(name);
        record.setProjectId(projectId);
        record.setProjectName(projectName);
        record.setRepoUrl(repoUrl);
        record.setIsDeleted(isDeleted);
        record.setCreateTime(createTime);
        page.setRecords(queryCodingModuleDao.findCodingModulePage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
