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
@TableName("kpi_coding_submitter")
public class CodingSubmitter extends Model<CodingSubmitter> {

    private static final long serialVersionUID=1L;

      /**
     * 浜哄憳ID
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
     * 寮�鍙戣�呭悕绉�
     */
      private String commitAuthor;

      /**
     * 寮�鍙戣�呴偖绠�
     */
      private String commitEmail;

      /**
     * 绯荤粺鐢ㄦ埛ID
     */
      private Long userId;

      /**
     * 寮�鍙戜汉鍛樹俊鎭垱寤烘椂闂达紝crud-plus妗嗘灦淇濈暀瀛楁,鑷姩蹇界暐鏇存柊
     */
      private Date createTime;

    
    public Long getId() {
        return id;
    }

      public CodingSubmitter setId(Long id) {
          this.id = id;
          return this;
      }
    
    public Long getOrgId() {
        return orgId;
    }

      public CodingSubmitter setOrgId(Long orgId) {
          this.orgId = orgId;
          return this;
      }
    
    public String getOrgTag() {
        return orgTag;
    }

      public CodingSubmitter setOrgTag(String orgTag) {
          this.orgTag = orgTag;
          return this;
      }
    
    public String getCommitAuthor() {
        return commitAuthor;
    }

      public CodingSubmitter setCommitAuthor(String commitAuthor) {
          this.commitAuthor = commitAuthor;
          return this;
      }
    
    public String getCommitEmail() {
        return commitEmail;
    }

      public CodingSubmitter setCommitEmail(String commitEmail) {
          this.commitEmail = commitEmail;
          return this;
      }
    
    public Long getUserId() {
        return userId;
    }

      public CodingSubmitter setUserId(Long userId) {
          this.userId = userId;
          return this;
      }
    
    public Date getCreateTime() {
        return createTime;
    }

      public CodingSubmitter setCreateTime(Date createTime) {
          this.createTime = createTime;
          return this;
      }

      public static final String ID = "id";

      public static final String ORG_ID = "org_id";

      public static final String ORG_TAG = "org_tag";

      public static final String COMMIT_AUTHOR = "commit_author";

      public static final String COMMIT_EMAIL = "commit_email";

      public static final String USER_ID = "user_id";

      public static final String CREATE_TIME = "create_time";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "CodingSubmitter{" +
              "id=" + id +
                  ", orgId=" + orgId +
                  ", orgTag=" + orgTag +
                  ", commitAuthor=" + commitAuthor +
                  ", commitEmail=" + commitEmail +
                  ", userId=" + userId +
                  ", createTime=" + createTime +
              "}";
    }
}
