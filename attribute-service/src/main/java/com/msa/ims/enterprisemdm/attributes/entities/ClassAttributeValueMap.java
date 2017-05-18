package com.msa.ims.enterprisemdm.attributes.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
/**
 * @author
 */
@Entity
@Table(name="class_attribute_value_map"
    ,schema="public"
)
public class ClassAttributeValueMap extends BaseEntity implements java.io.Serializable {


   private Long classAttrValSkey;
   private ClassAttributeMap classAttributeMap;
   private MasterAttributeValue masterAttributeValue;
   private boolean isDefaultVal;
   private Date effStartDt;
   private Date effEndDt;
   private Date createTs;
   private String createUser;
   private Date updateTs;
   private String updateUser;

    public ClassAttributeValueMap() {
    }

	
    public ClassAttributeValueMap(Long classAttrValSkey, ClassAttributeMap classAttributeMap, MasterAttributeValue masterAttributeValue, boolean isDefaultVal, Date effStartDt, Date effEndDt, Date createTs, String createUser) {
        this.classAttrValSkey = classAttrValSkey;
        this.classAttributeMap = classAttributeMap;
        this.masterAttributeValue = masterAttributeValue;
        this.isDefaultVal = isDefaultVal;
        this.effStartDt = effStartDt;
        this.effEndDt = effEndDt;
        this.createTs = createTs;
        this.createUser = createUser;
    }

    public ClassAttributeValueMap(Long classAttrValSkey, ClassAttributeMap classAttributeMap, MasterAttributeValue masterAttributeValue, boolean isDefaultVal, Date effStartDt, Date effEndDt, Date createTs, String createUser, Date updateTs, String updateUser) {
       this.classAttrValSkey = classAttrValSkey;
       this.classAttributeMap = classAttributeMap;
       this.masterAttributeValue = masterAttributeValue;
       this.isDefaultVal = isDefaultVal;
       this.effStartDt = effStartDt;
       this.effEndDt = effEndDt;
       this.createTs = createTs;
       this.createUser = createUser;
       this.updateTs = updateTs;
       this.updateUser = updateUser;
    }
   
     @Id 

     @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_attr_val_skey", unique=true, nullable=false)
    public Long getClassAttrValSkey() {
        return this.classAttrValSkey;
    }
    
    public void setClassAttrValSkey(Long classAttrValSkey) {
        this.classAttrValSkey = classAttrValSkey;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_attr_skey", nullable=false)
    public ClassAttributeMap getClassAttributeMap() {
        return this.classAttributeMap;
    }
    
    public void setClassAttributeMap(ClassAttributeMap classAttributeMap) {
        this.classAttributeMap = classAttributeMap;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="master_attr_val_skey", nullable=false)
    public MasterAttributeValue getMasterAttributeValue() {
        return this.masterAttributeValue;
    }
    
    public void setMasterAttributeValue(MasterAttributeValue masterAttributeValue) {
        this.masterAttributeValue = masterAttributeValue;
    }

    
    @Column(name="is_default_val", nullable=false)
    public boolean isIsDefaultVal() {
        return this.isDefaultVal;
    }
    
    public void setIsDefaultVal(boolean isDefaultVal) {
        this.isDefaultVal = isDefaultVal;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="eff_start_dt", nullable=false, length=13)
    public Date getEffStartDt() {
        return this.effStartDt;
    }
    
    public void setEffStartDt(Date effStartDt) {
        this.effStartDt = effStartDt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="eff_end_dt", nullable=false, length=13)
    public Date getEffEndDt() {
        return this.effEndDt;
    }
    
    public void setEffEndDt(Date effEndDt) {
        this.effEndDt = effEndDt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_ts", nullable=false, length=29)
    public Date getCreateTs() {
        return this.createTs;
    }
    
    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    
    @Column(name="create_user", nullable=false, length=50)
    public String getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_ts", length=29)
    public Date getUpdateTs() {
        return this.updateTs;
    }
    
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    
    @Column(name="update_user", length=50)
    public String getUpdateUser() {
        return this.updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

	 /* (non-Javadoc)
      * @see java.lang.Object#toString()
      */
     public String toString() {
		 
		 return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append( "classAttrValSkey" ,classAttrValSkey )
					.append( "classAttributeMap" ,classAttributeMap )
					.append( "masterAttributeValue" ,masterAttributeValue )
					.append( "isDefaultVal" ,isDefaultVal )
					.append( "effStartDt" ,effStartDt )
					.append( "effEndDt" ,effEndDt )
					.append( "createTs" ,createTs )
					.append( "createUser" ,createUser )
					.append( "updateTs" ,updateTs )
					.append( "updateUser" ,updateUser )
					.toString();
     }

	/* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
	public boolean equals(Object other) {
	
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ClassAttributeValueMap) ) return false;
		 
		 ClassAttributeValueMap castOther = ( ClassAttributeValueMap ) other; 
         
		 return new EqualsBuilder().append( classAttrValSkey ,castOther.classAttrValSkey )
					.append( masterAttributeValue ,castOther.masterAttributeValue )
					.append( isDefaultVal ,castOther.isDefaultVal )
					.append( effStartDt ,castOther.effStartDt )
					.append( effEndDt ,castOther.effEndDt )
					.append( createTs ,castOther.createTs )
					.append( createUser ,castOther.createUser )
					.append( updateTs ,castOther.updateTs )
					.append( updateUser ,castOther.updateUser )
					.isEquals();
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
		          
         return new HashCodeBuilder().append( classAttrValSkey)
					.append( masterAttributeValue)
					.append( isDefaultVal)
					.append( effStartDt)
					.append( effEndDt)
					.append( createTs)
					.append( createUser)
					.append( updateTs)
					.append( updateUser)
					.toHashCode();
   }   


}


