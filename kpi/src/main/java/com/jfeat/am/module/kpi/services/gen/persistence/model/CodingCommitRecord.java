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
@TableName("kpi_coding_commit_record")
public class CodingCommitRecord extends Model<CodingCommitRecord> {

    private static final long serialVersionUID=1L;

      /**
     * 璁板綍ID
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 鐢ㄤ簬闅旂鐨勭粍缁嘔D锛岀敱crud-plus缁存姢锛堜繚鐣欎究浜庢墿灞曪級
     */
      private Long orgId;

      /**
     * 鐢ㄤ簬闅旂鐨勭粍缁囨爣璇�
     */
      private String orgTag;

      /**
     * 妯″潡ID
     */
      private Long moduleId;

      /**
     * 妯″潡鍚嶇О
     */
      private String moduleName;

      /**
     * 鎻愪氦ID
     */
      private String commitId;

      /**
     * 浣滆��
     */
      private String commitAuthor;

      /**
     * 璇勮鍐呭
     */
      private String commitComment;

      /**
     * 鎻愪氦琛屾暟
     */
      private Integer commitLines;

      /**
     * 閫昏緫鍒犻櫎 榛樿鍊�0, 1涓哄垹闄ゆ爣璁�
     */
      private Integer isDeleted;

      /**
     * 璁板綍鍒涘缓鏃堕棿锛宑rud-plus妗嗘灦淇濈暀瀛楁**,**鑷姩蹇界暐鏇存柊
     */
      private Date createTime;

    
    public Long getId() {
        return id;
    }

      public CodingCommitRecord setId(Long id) {
          this.id = id;
          return this;
      }
    
    public Long getOrgId() {
        return orgId;
    }

      public CodingCommitRecord setOrgId(Long orgId) {
          this.orgId = orgId;
          return this;
      }
    
    public String getOrgTag() {
        return orgTag;
    }

      public CodingCommitRecord setOrgTag(String orgTag) {
          this.orgTag = orgTag;
          return this;
      }
    
    public Long getModuleId() {
        return moduleId;
    }

      public CodingCommitRecord setModuleId(Long moduleId) {
          this.moduleId = moduleId;
          return this;
      }
    
    public String getModuleName() {
        return moduleName;
    }

      public CodingCommitRecord setModuleName(String moduleName) {
          this.moduleName = moduleName;
          return this;
      }
    
    public String getCommitId() {
        return commitId;
    }

      public CodingCommitRecord setCommitId(String commitId) {
          this.commitId = commitId;
          return this;
      }
    
    public String getCommitAuthor() {
        return commitAuthor;
    }

      public CodingCommitRecord setCommitAuthor(String commitAuthor) {
          this.commitAuthor = commitAuthor;
          return this;
      }
    
    public String getCommitComment() {
        return commitComment;
    }

      public CodingCommitRecord setCommitComment(String commitComment) {
          this.commitComment = commitComment;
          return this;
      }
    
    public Integer getCommitLines() {
        return commitLines;
    }

      public CodingCommitRecord setCommitLines(Integer commitLines) {
          this.commitLines = commitLines;
          return this;
      }
    
    public Integer getIsDeleted() {
        return isDeleted;
    }

      public CodingCommitRecord setIsDeleted(Integer isDeleted) {
          this.isDeleted = isDeleted;
          return this;
      }
    
    public Date getCreateTime() {
        return createTime;
    }

      public CodingCommitRecord setCreateTime(Date createTime) {
          this.createTime = createTime;
          return this;
      }

      public static final String ID = "id";

      public static final String ORG_ID = "org_id";

      public static final String ORG_TAG = "org_tag";

      public static final String MODULE_ID = "module_id";

      public static final String MODULE_NAME = "module_name";

      public static final String COMMIT_ID = "commit_id";

      public static final String COMMIT_AUTHOR = "commit_author";

      public static final String COMMIT_COMMENT = "commit_comment";

      public static final String COMMIT_LINES = "commit_lines";

      public static final String IS_DELETED = "is_deleted";

      public static final String CREATE_TIME = "create_time";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "CodingCommitRecord{" +
              "id=" + id +
                  ", orgId=" + orgId +
                  ", orgTag=" + orgTag +
                  ", moduleId=" + moduleId +
                  ", moduleName=" + moduleName +
                  ", commitId=" + commitId +
                  ", commitAuthor=" + commitAuthor +
                  ", commitComment=" + commitComment +
                  ", commitLines=" + commitLines +
                  ", isDeleted=" + isDeleted +
                  ", createTime=" + createTime +
              "}";
    }
}
