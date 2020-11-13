package com.jfeat.am.module.issue.api;


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
import com.jfeat.am.module.issue.services.domain.dao.QueryIssueTaskDao;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.request.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import com.jfeat.am.module.issue.api.permission.*;
import com.jfeat.am.common.annotation.Permission;

import java.math.BigDecimal;

import com.jfeat.am.module.issue.services.domain.service.*;
import com.jfeat.am.module.issue.services.domain.model.IssueTaskRecord;
import com.jfeat.am.module.issue.services.gen.persistence.model.IssueTask;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * api
 * </p>
 *
 * @author Code generator
 * @since 2020-11-10
 */
@RestController

@Api("IssueTask")
@RequestMapping("/api/crud/issueTask/issueTasks")
public class IssueTaskEndpoint {

    @Resource
    IssueTaskService issueTaskService;


    @Resource
    QueryIssueTaskDao queryIssueTaskDao;

    @BusinessLog(name = "IssueTask", value = "create IssueTask")
    @Permission(IssueTaskPermission.ISSUETASK_NEW)
    @PostMapping
    @ApiOperation(value = "新建 IssueTask", response = IssueTask.class)
    public Tip createIssueTask(@RequestBody IssueTask entity) {

        Integer affected = 0;
        try {
            affected = issueTaskService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @Permission(IssueTaskPermission.ISSUETASK_VIEW)
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 IssueTask", response = IssueTask.class)
    public Tip getIssueTask(@PathVariable Long id) {
        return SuccessTip.create(issueTaskService.queryMasterModel(queryIssueTaskDao, id));
    }

    @BusinessLog(name = "IssueTask", value = "update IssueTask")
    @Permission(IssueTaskPermission.ISSUETASK_EDIT)
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 IssueTask", response = IssueTask.class)
    public Tip updateIssueTask(@PathVariable Long id, @RequestBody IssueTask entity) {
        entity.setId(id);
        return SuccessTip.create(issueTaskService.updateMaster(entity));
    }

    @BusinessLog(name = "IssueTask", value = "delete IssueTask")
    @Permission(IssueTaskPermission.ISSUETASK_DELETE)
    @DeleteMapping("/{id}")
    @ApiOperation("删除 IssueTask")
    public Tip deleteIssueTask(@PathVariable Long id) {
        return SuccessTip.create(issueTaskService.deleteMaster(id));
    }

    @Permission(IssueTaskPermission.ISSUETASK_VIEW)
    @ApiOperation(value = "IssueTask 列表信息", response = IssueTaskRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "orgId", dataType = "Long"),
            @ApiImplicitParam(name = "orgTag", dataType = "String"),
            @ApiImplicitParam(name = "pid", dataType = "Long"),
            @ApiImplicitParam(name = "title", dataType = "String"),
            @ApiImplicitParam(name = "ticket", dataType = "String"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "brief", dataType = "String"),
            @ApiImplicitParam(name = "originator", dataType = "String"),
            @ApiImplicitParam(name = "originatorUserId", dataType = "Long"),
            @ApiImplicitParam(name = "moduleName", dataType = "String"),
            @ApiImplicitParam(name = "status", dataType = "String"),
            @ApiImplicitParam(name = "type", dataType = "Integer"),
            @ApiImplicitParam(name = "referenceUrl", dataType = "String"),
            @ApiImplicitParam(name = "priority", dataType = "Integer"),
            @ApiImplicitParam(name = "followerUserId", dataType = "Long"),
            @ApiImplicitParam(name = "follower", dataType = "String"),
            @ApiImplicitParam(name = "remark", dataType = "String"),
            @ApiImplicitParam(name = "isDeleted", dataType = "Integer"),
            @ApiImplicitParam(name = "createTime", dataType = "Date"),
            @ApiImplicitParam(name = "updateTime", dataType = "Date"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    public Tip queryIssueTasks(Page<IssueTaskRecord> page,
                               @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                               @RequestParam(name = "search", required = false) String search,
                               @RequestParam(name = "id", required = false) Long id,
                               @RequestParam(name = "orgId", required = false) Long orgId,
                               @RequestParam(name = "orgTag", required = false) String orgTag,
                               @RequestParam(name = "pid", required = false) Long pid,
                               @RequestParam(name = "title", required = false) String title,
                               @RequestParam(name = "ticket", required = false) String ticket,
                               @RequestParam(name = "name", required = false) String name,
                               @RequestParam(name = "brief", required = false) String brief,
                               @RequestParam(name = "originator", required = false) String originator,
                               @RequestParam(name = "originatorUserId", required = false) Long originatorUserId,
                               @RequestParam(name = "moduleName", required = false) String moduleName,
                               @RequestParam(name = "status", required = false) String status,
                               @RequestParam(name = "type", required = false) Integer type,
                               @RequestParam(name = "referenceUrl", required = false) String referenceUrl,
                               @RequestParam(name = "priority", required = false) Integer priority,
                               @RequestParam(name = "followerUserId", required = false) Long followerUserId,
                               @RequestParam(name = "follower", required = false) String follower,
                               @RequestParam(name = "remark", required = false) String remark,
                               @RequestParam(name = "isDeleted", required = false) Integer isDeleted,
                               @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                               @RequestParam(name = "createTime", required = false) Date createTime,
                               @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                               @RequestParam(name = "updateTime", required = false) Date updateTime,
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

        IssueTaskRecord record = new IssueTaskRecord();
        record.setId(id);
        if (META.enabledSaaS()) {
            record.setOrgId(JWTKit.getOrgId());
        }
        record.setOrgTag(orgTag);
        record.setPid(pid);
        record.setTitle(title);
        record.setTicket(ticket);
        record.setName(name);
        record.setBrief(brief);
        record.setOriginator(originator);
        record.setOriginatorUserId(originatorUserId);
        record.setModuleName(moduleName);
        record.setStatus(status);
        record.setType(type);
        record.setReferenceUrl(referenceUrl);
        record.setPriority(priority);
        record.setFollowerUserId(followerUserId);
        record.setFollower(follower);
        record.setRemark(remark);
        record.setIsDeleted(isDeleted);
        record.setCreateTime(createTime);
        record.setUpdateTime(updateTime);
        page.setRecords(queryIssueTaskDao.findIssueTaskPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
