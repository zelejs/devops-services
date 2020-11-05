package com.jfeat.am.module.kpi.services.gen.persistence.model;

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
 * @since 2020-10-29
 */
@TableName("kpi_coding_module")
public class CodingModule extends Model<CodingModule> {

    private static final long serialVersionUID=1L;

      /**
     * 妯″潡ID
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 鐢ㄤ簬闅旂鐨勭粍缁嘔D锛岀敱crud-plus缁存姢
     */
      private Long orgId;

      /**
     * 鐢ㄤ簬闅旂鐨勭粍缁囨爣璇�
     */
      private String orgTag;

      /**
     * 妯″潡鍚嶇О
     */
      private String name;

      /**
     * 浠撳簱ID
     */
      private Long projectId;

      /**
     * 妯″潡浠ｇ爜椤圭洰鍚嶇О
     */
      private String projectName;

      /**
     * 浠撳簱鍦板潃
     */
      private String repoUrl;

      /**
     * 閫昏緫鍒犻櫎 榛樿鍊�0, 1涓哄垹闄ゆ爣璁�
     */
      private Integer isDeleted;

      /**
     * 妯″潡淇℃伅鍒涘缓鏃堕棿锛宑rud-plus妗嗘灦淇濈暀瀛楁**,**鑷姩蹇界暐鏇存柊
     */
      private Date createTime;

    
    public Long getId() {
        return id;
    }

      public CodingModule setId(Long id) {
          this.id = id;
          return this;
      }
    
    public Long getOrgId() {
        return orgId;
    }

      public CodingModule setOrgId(Long orgId) {
          this.orgId = orgId;
          return this;
      }
    
    public String getOrgTag() {
        return orgTag;
    }

      public CodingModule setOrgTag(String orgTag) {
          this.orgTag = orgTag;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public CodingModule setName(String name) {
          this.name = name;
          return this;
      }
    
    public Long getProjectId() {
        return projectId;
    }

      public CodingModule setProjectId(Long projectId) {
          this.projectId = projectId;
          return this;
      }
    
    public String getProjectName() {
        return projectName;
    }

      public CodingModule setProjectName(String projectName) {
          this.projectName = projectName;
          return this;
      }
    
    public String getRepoUrl() {
        return repoUrl;
    }

      public CodingModule setRepoUrl(String repoUrl) {
          this.repoUrl = repoUrl;
          return this;
      }
    
    public Integer getIsDeleted() {
        return isDeleted;
    }

      public CodingModule setIsDeleted(Integer isDeleted) {
          this.isDeleted = isDeleted;
          return this;
      }
    
    public Date getCreateTime() {
        return createTime;
    }

      public CodingModule setCreateTime(Date createTime) {
          this.createTime = createTime;
          return this;
      }

      public static final String ID = "id";

      public static final String ORG_ID = "org_id";

      public static final String ORG_TAG = "org_tag";

      public static final String NAME = "name";

      public static final String PROJECT_ID = "project_id";

      public static final String PROJECT_NAME = "project_name";

      public static final String REPO_URL = "repo_url";

      public static final String IS_DELETED = "is_deleted";

      public static final String CREATE_TIME = "create_time";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "CodingModule{" +
              "id=" + id +
                  ", orgId=" + orgId +
                  ", orgTag=" + orgTag +
                  ", name=" + name +
                  ", projectId=" + projectId +
                  ", projectName=" + projectName +
                  ", repoUrl=" + repoUrl +
                  ", isDeleted=" + isDeleted +
                  ", createTime=" + createTime +
              "}";
    }
}
