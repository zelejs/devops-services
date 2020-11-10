package com.jfeat.am.module.issue.services.gen.persistence.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Code generator
 * @since 2020-11-10
 */
@TableName("cr_issue_task")
public class IssueTask extends Model<IssueTask> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long orgId;

    private String orgTag;

    private Long pid;

    private String title;

    private String ticket;

    private String name;

    private String brief;

    private String originator;

    private Long originatorUserId;

    private String moduleName;

    private String status;

    private Integer type;

    private String referenceUrl;

    private Integer priority;

    private Long followerUserId;

    private String follower;

    private String remark;

    private Integer isDeleted;

    private Date createTime;

    private Date updateTime;

    
    public Long getId() {
        return id;
    }

      public IssueTask setId(Long id) {
          this.id = id;
          return this;
      }
    
    public Long getOrgId() {
        return orgId;
    }

      public IssueTask setOrgId(Long orgId) {
          this.orgId = orgId;
          return this;
      }
    
    public String getOrgTag() {
        return orgTag;
    }

      public IssueTask setOrgTag(String orgTag) {
          this.orgTag = orgTag;
          return this;
      }
    
    public Long getPid() {
        return pid;
    }

      public IssueTask setPid(Long pid) {
          this.pid = pid;
          return this;
      }
    
    public String getTitle() {
        return title;
    }

      public IssueTask setTitle(String title) {
          this.title = title;
          return this;
      }
    
    public String getTicket() {
        return ticket;
    }

      public IssueTask setTicket(String ticket) {
          this.ticket = ticket;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public IssueTask setName(String name) {
          this.name = name;
          return this;
      }
    
    public String getBrief() {
        return brief;
    }

      public IssueTask setBrief(String brief) {
          this.brief = brief;
          return this;
      }
    
    public String getOriginator() {
        return originator;
    }

      public IssueTask setOriginator(String originator) {
          this.originator = originator;
          return this;
      }
    
    public Long getOriginatorUserId() {
        return originatorUserId;
    }

      public IssueTask setOriginatorUserId(Long originatorUserId) {
          this.originatorUserId = originatorUserId;
          return this;
      }
    
    public String getModuleName() {
        return moduleName;
    }

      public IssueTask setModuleName(String moduleName) {
          this.moduleName = moduleName;
          return this;
      }
    
    public String getStatus() {
        return status;
    }

      public IssueTask setStatus(String status) {
          this.status = status;
          return this;
      }
    
    public Integer getType() {
        return type;
    }

      public IssueTask setType(Integer type) {
          this.type = type;
          return this;
      }
    
    public String getReferenceUrl() {
        return referenceUrl;
    }

      public IssueTask setReferenceUrl(String referenceUrl) {
          this.referenceUrl = referenceUrl;
          return this;
      }
    
    public Integer getPriority() {
        return priority;
    }

      public IssueTask setPriority(Integer priority) {
          this.priority = priority;
          return this;
      }
    
    public Long getFollowerUserId() {
        return followerUserId;
    }

      public IssueTask setFollowerUserId(Long followerUserId) {
          this.followerUserId = followerUserId;
          return this;
      }
    
    public String getFollower() {
        return follower;
    }

      public IssueTask setFollower(String follower) {
          this.follower = follower;
          return this;
      }
    
    public String getRemark() {
        return remark;
    }

      public IssueTask setRemark(String remark) {
          this.remark = remark;
          return this;
      }
    
    public Integer getIsDeleted() {
        return isDeleted;
    }

      public IssueTask setIsDeleted(Integer isDeleted) {
          this.isDeleted = isDeleted;
          return this;
      }
    
    public Date getCreateTime() {
        return createTime;
    }

      public IssueTask setCreateTime(Date createTime) {
          this.createTime = createTime;
          return this;
      }
    
    public Date getUpdateTime() {
        return updateTime;
    }

      public IssueTask setUpdateTime(Date updateTime) {
          this.updateTime = updateTime;
          return this;
      }

      public static final String ID = "id";

      public static final String ORG_ID = "org_id";

      public static final String ORG_TAG = "org_tag";

      public static final String PID = "pid";

      public static final String TITLE = "title";

      public static final String TICKET = "ticket";

      public static final String NAME = "name";

      public static final String BRIEF = "brief";

      public static final String ORIGINATOR = "originator";

      public static final String ORIGINATOR_USER_ID = "originator_user_id";

      public static final String MODULE_NAME = "module_name";

      public static final String STATUS = "status";

      public static final String TYPE = "type";

      public static final String REFERENCE_URL = "reference_url";

      public static final String PRIORITY = "priority";

      public static final String FOLLOWER_USER_ID = "follower_user_id";

      public static final String FOLLOWER = "follower";

      public static final String REMARK = "remark";

      public static final String IS_DELETED = "is_deleted";

      public static final String CREATE_TIME = "create_time";

      public static final String UPDATE_TIME = "update_time";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "IssueTask{" +
              "id=" + id +
                  ", orgId=" + orgId +
                  ", orgTag=" + orgTag +
                  ", pid=" + pid +
                  ", title=" + title +
                  ", ticket=" + ticket +
                  ", name=" + name +
                  ", brief=" + brief +
                  ", originator=" + originator +
                  ", originatorUserId=" + originatorUserId +
                  ", moduleName=" + moduleName +
                  ", status=" + status +
                  ", type=" + type +
                  ", referenceUrl=" + referenceUrl +
                  ", priority=" + priority +
                  ", followerUserId=" + followerUserId +
                  ", follower=" + follower +
                  ", remark=" + remark +
                  ", isDeleted=" + isDeleted +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
