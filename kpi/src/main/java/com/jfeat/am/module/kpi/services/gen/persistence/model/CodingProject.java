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
@TableName("kpi_coding_project")
public class CodingProject extends Model<CodingProject> {

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
     * 椤圭洰鍚嶇О
     */
      private String name;

      /**
     * 瀹㈡埛ID
     */
      private Long clientId;

      /**
     * 椤圭洰鎻忚堪
     */
      private String desc;

      /**
     * 閫昏緫鍒犻櫎 榛樿鍊�0, 1涓哄垹闄ゆ爣璁�
     */
      private Integer isDeleted;

      /**
     * 椤圭洰淇℃伅鍒涘缓鏃堕棿锛宑rud-plus妗嗘灦淇濈暀瀛楁,鑷姩蹇界暐鏇存柊
     */
      private Date createTime;

    
    public Long getId() {
        return id;
    }

      public CodingProject setId(Long id) {
          this.id = id;
          return this;
      }
    
    public Long getOrgId() {
        return orgId;
    }

      public CodingProject setOrgId(Long orgId) {
          this.orgId = orgId;
          return this;
      }
    
    public String getOrgTag() {
        return orgTag;
    }

      public CodingProject setOrgTag(String orgTag) {
          this.orgTag = orgTag;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public CodingProject setName(String name) {
          this.name = name;
          return this;
      }
    
    public Long getClientId() {
        return clientId;
    }

      public CodingProject setClientId(Long clientId) {
          this.clientId = clientId;
          return this;
      }
    
    public String getDesc() {
        return desc;
    }

      public CodingProject setDesc(String desc) {
          this.desc = desc;
          return this;
      }
    
    public Integer getIsDeleted() {
        return isDeleted;
    }

      public CodingProject setIsDeleted(Integer isDeleted) {
          this.isDeleted = isDeleted;
          return this;
      }
    
    public Date getCreateTime() {
        return createTime;
    }

      public CodingProject setCreateTime(Date createTime) {
          this.createTime = createTime;
          return this;
      }

      public static final String ID = "id";

      public static final String ORG_ID = "org_id";

      public static final String ORG_TAG = "org_tag";

      public static final String NAME = "name";

      public static final String CLIENT_ID = "client_id";

      public static final String DESC = "desc";

      public static final String IS_DELETED = "is_deleted";

      public static final String CREATE_TIME = "create_time";

      @Override
    protected Serializable pkVal() {
          return this.id;
      }

    @Override
    public String toString() {
        return "CodingProject{" +
              "id=" + id +
                  ", orgId=" + orgId +
                  ", orgTag=" + orgTag +
                  ", name=" + name +
                  ", clientId=" + clientId +
                  ", desc=" + desc +
                  ", isDeleted=" + isDeleted +
                  ", createTime=" + createTime +
              "}";
    }
}
