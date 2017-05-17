package com.msa.ims.enterprisemdm.attributes.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * @author
 */
@Entity
@Table(name="master_attribute_value"
    ,schema="public"
)
public class MasterAttributeValue extends BaseEntity implements java.io.Serializable {


   private int masterAttrValSkey;
   private MasterAttribute masterAttribute;
   private String masterAttrValCode;
   private String masterAttrValShortName;
   private String masterAttrValLongName;
   private Date effStartDt;
   private Date effEndDt;
   private Date createTs;
   private String createUser;
   private Date updateTs;
   private String updateUser;
   private Set<ClassAttributeValueMap> classAttributeValueMaps = new HashSet<ClassAttributeValueMap>(0);

    public MasterAttributeValue() {
    }

	
    public MasterAttributeValue(int masterAttrValSkey, MasterAttribute masterAttribute, String masterAttrValCode, Date effStartDt, Date effEndDt, Date createTs, String createUser) {
        this.masterAttrValSkey = masterAttrValSkey;
        this.masterAttribute = masterAttribute;
        this.masterAttrValCode = masterAttrValCode;
        this.effStartDt = effStartDt;
        this.effEndDt = effEndDt;
        this.createTs = createTs;
        this.createUser = createUser;
    }

    public MasterAttributeValue(int masterAttrValSkey, MasterAttribute masterAttribute, String masterAttrValCode, String masterAttrValShortName, String masterAttrValLongName, Date effStartDt, Date effEndDt, Date createTs, String createUser, Date updateTs, String updateUser, Set<ClassAttributeValueMap> classAttributeValueMaps) {
       this.masterAttrValSkey = masterAttrValSkey;
       this.masterAttribute = masterAttribute;
       this.masterAttrValCode = masterAttrValCode;
       this.masterAttrValShortName = masterAttrValShortName;
       this.masterAttrValLongName = masterAttrValLongName;
       this.effStartDt = effStartDt;
       this.effEndDt = effEndDt;
       this.createTs = createTs;
       this.createUser = createUser;
       this.updateTs = updateTs;
       this.updateUser = updateUser;
       this.classAttributeValueMaps = classAttributeValueMaps;
    }
   
     @Id 

    
    @Column(name="master_attr_val_skey", unique=true, nullable=false)
    public int getMasterAttrValSkey() {
        return this.masterAttrValSkey;
    }
    
    public void setMasterAttrValSkey(int masterAttrValSkey) {
        this.masterAttrValSkey = masterAttrValSkey;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="attr_skey", nullable=false)
    public MasterAttribute getMasterAttribute() {
        return this.masterAttribute;
    }
    
    public void setMasterAttribute(MasterAttribute masterAttribute) {
        this.masterAttribute = masterAttribute;
    }

    
    @Column(name="master_attr_val_code", nullable=false, length=20)
    public String getMasterAttrValCode() {
        return this.masterAttrValCode;
    }
    
    public void setMasterAttrValCode(String masterAttrValCode) {
        this.masterAttrValCode = masterAttrValCode;
    }

    
    @Column(name="master_attr_val_short_name", length=50)
    public String getMasterAttrValShortName() {
        return this.masterAttrValShortName;
    }
    
    public void setMasterAttrValShortName(String masterAttrValShortName) {
        this.masterAttrValShortName = masterAttrValShortName;
    }

    
    @Column(name="master_attr_val_long_name", length=250)
    public String getMasterAttrValLongName() {
        return this.masterAttrValLongName;
    }
    
    public void setMasterAttrValLongName(String masterAttrValLongName) {
        this.masterAttrValLongName = masterAttrValLongName;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="masterAttributeValue")
    public Set<ClassAttributeValueMap> getClassAttributeValueMaps() {
        return this.classAttributeValueMaps;
    }
    
    public void setClassAttributeValueMaps(Set<ClassAttributeValueMap> classAttributeValueMaps) {
        this.classAttributeValueMaps = classAttributeValueMaps;
    }

	 /* (non-Javadoc)
      * @see java.lang.Object#toString()
      */
     public String toString() {
		 
		 return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append( "masterAttrValSkey" ,masterAttrValSkey )
					.append( "masterAttribute" ,masterAttribute )
					.append( "masterAttrValCode" ,masterAttrValCode )
					.append( "masterAttrValShortName" ,masterAttrValShortName )
					.append( "masterAttrValLongName" ,masterAttrValLongName )
					.append( "effStartDt" ,effStartDt )
					.append( "effEndDt" ,effEndDt )
					.append( "createTs" ,createTs )
					.append( "createUser" ,createUser )
					.append( "updateTs" ,updateTs )
					.append( "updateUser" ,updateUser )
					.append( "classAttributeValueMaps" ,classAttributeValueMaps )
					.toString();
     }

	/* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
	public boolean equals(Object other) {
	
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MasterAttributeValue) ) return false;
		 
		 MasterAttributeValue castOther = ( MasterAttributeValue ) other; 
         
		 return new EqualsBuilder().append( masterAttrValSkey ,castOther.masterAttrValSkey )
					.append( masterAttribute ,castOther.masterAttribute )
					.append( masterAttrValCode ,castOther.masterAttrValCode )
					.append( masterAttrValShortName ,castOther.masterAttrValShortName )
					.append( masterAttrValLongName ,castOther.masterAttrValLongName )
					.append( effStartDt ,castOther.effStartDt )
					.append( effEndDt ,castOther.effEndDt )
					.append( createTs ,castOther.createTs )
					.append( createUser ,castOther.createUser )
					.append( updateTs ,castOther.updateTs )
					.append( updateUser ,castOther.updateUser )
					.append( classAttributeValueMaps ,castOther.classAttributeValueMaps )
					.isEquals();
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
		          
         return new HashCodeBuilder().append( masterAttrValSkey)
					.append( masterAttribute)
					.append( masterAttrValCode)
					.append( masterAttrValShortName)
					.append( masterAttrValLongName)
					.append( effStartDt)
					.append( effEndDt)
					.append( createTs)
					.append( createUser)
					.append( updateTs)
					.append( updateUser)
					.append( classAttributeValueMaps)
					.toHashCode();
   }   


}


