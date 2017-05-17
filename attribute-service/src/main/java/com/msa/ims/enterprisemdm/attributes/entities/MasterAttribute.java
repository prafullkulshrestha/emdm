package com.msa.ims.enterprisemdm.attributes.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="master_attribute"
    ,schema="public"
)
public class MasterAttribute extends BaseEntity implements java.io.Serializable {


   private int attrSkey;
   private String masterAttrName;
   private String masterAttrDisplayName;
   private String masterAttrType;
   private Date effStartDt;
   private Date effEndDt;
   private Date createTs;
   private String createUser;
   private Date updateTs;
   private String updateUser;
   private Set<ClassAttributeMap> classAttributeMaps = new HashSet<ClassAttributeMap>(0);
   private Set<MasterAttributeValue> masterAttributeValues = new HashSet<MasterAttributeValue>(0);

    public MasterAttribute() {
    }

	
    public MasterAttribute(int attrSkey, Date effStartDt, Date effEndDt, Date createTs, String createUser) {
        this.attrSkey = attrSkey;
        this.effStartDt = effStartDt;
        this.effEndDt = effEndDt;
        this.createTs = createTs;
        this.createUser = createUser;
    }

    public MasterAttribute(int attrSkey, String masterAttrName, String masterAttrDisplayName, String masterAttrType, Date effStartDt, Date effEndDt, Date createTs, String createUser, Date updateTs, String updateUser, Set<ClassAttributeMap> classAttributeMaps, Set<MasterAttributeValue> masterAttributeValues) {
       this.attrSkey = attrSkey;
       this.masterAttrName = masterAttrName;
       this.masterAttrDisplayName = masterAttrDisplayName;
       this.masterAttrType = masterAttrType;
       this.effStartDt = effStartDt;
       this.effEndDt = effEndDt;
       this.createTs = createTs;
       this.createUser = createUser;
       this.updateTs = updateTs;
       this.updateUser = updateUser;
       this.classAttributeMaps = classAttributeMaps;
       this.masterAttributeValues = masterAttributeValues;
    }
   
     @Id 

    
    @Column(name="attr_skey", unique=true, nullable=false)
    public int getAttrSkey() {
        return this.attrSkey;
    }
    
    public void setAttrSkey(int attrSkey) {
        this.attrSkey = attrSkey;
    }

    
    @Column(name="master_attr_name", length=50)
    public String getMasterAttrName() {
        return this.masterAttrName;
    }
    
    public void setMasterAttrName(String masterAttrName) {
        this.masterAttrName = masterAttrName;
    }

    
    @Column(name="master_attr_display_name", length=50)
    public String getMasterAttrDisplayName() {
        return this.masterAttrDisplayName;
    }
    
    public void setMasterAttrDisplayName(String masterAttrDisplayName) {
        this.masterAttrDisplayName = masterAttrDisplayName;
    }

    
    @Column(name="master_attr_type", length=50)
    public String getMasterAttrType() {
        return this.masterAttrType;
    }
    
    public void setMasterAttrType(String masterAttrType) {
        this.masterAttrType = masterAttrType;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="masterAttribute")
    public Set<ClassAttributeMap> getClassAttributeMaps() {
        return this.classAttributeMaps;
    }
    
    public void setClassAttributeMaps(Set<ClassAttributeMap> classAttributeMaps) {
        this.classAttributeMaps = classAttributeMaps;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="masterAttribute")
    public Set<MasterAttributeValue> getMasterAttributeValues() {
        return this.masterAttributeValues;
    }
    
    public void setMasterAttributeValues(Set<MasterAttributeValue> masterAttributeValues) {
        this.masterAttributeValues = masterAttributeValues;
    }

	 /* (non-Javadoc)
      * @see java.lang.Object#toString()
      */
     public String toString() {
		 
		 return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append( "attrSkey" ,attrSkey )
					.append( "masterAttrName" ,masterAttrName )
					.append( "masterAttrDisplayName" ,masterAttrDisplayName )
					.append( "masterAttrType" ,masterAttrType )
					.append( "effStartDt" ,effStartDt )
					.append( "effEndDt" ,effEndDt )
					.append( "createTs" ,createTs )
					.append( "createUser" ,createUser )
					.append( "updateTs" ,updateTs )
					.append( "updateUser" ,updateUser )
					.append( "classAttributeMaps" ,classAttributeMaps )
					.append( "masterAttributeValues" ,masterAttributeValues )
					.toString();
     }

	/* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
	public boolean equals(Object other) {
	
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MasterAttribute) ) return false;
		 
		 MasterAttribute castOther = ( MasterAttribute ) other; 
         
		 return new EqualsBuilder().append( attrSkey ,castOther.attrSkey )
					.append( masterAttrName ,castOther.masterAttrName )
					.append( masterAttrDisplayName ,castOther.masterAttrDisplayName )
					.append( masterAttrType ,castOther.masterAttrType )
					.append( effStartDt ,castOther.effStartDt )
					.append( effEndDt ,castOther.effEndDt )
					.append( createTs ,castOther.createTs )
					.append( createUser ,castOther.createUser )
					.append( updateTs ,castOther.updateTs )
					.append( updateUser ,castOther.updateUser )
					.append( classAttributeMaps ,castOther.classAttributeMaps )
					.append( masterAttributeValues ,castOther.masterAttributeValues )
					.isEquals();
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
		          
         return new HashCodeBuilder().append( attrSkey)
					.append( masterAttrName)
					.append( masterAttrDisplayName)
					.append( masterAttrType)
					.append( effStartDt)
					.append( effEndDt)
					.append( createTs)
					.append( createUser)
					.append( updateTs)
					.append( updateUser)
					.append( classAttributeMaps)
					.append( masterAttributeValues)
					.toHashCode();
   }   


}


