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

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.builder.EqualsBuilder;
/**
 * @author
 */
@Entity
@Table(name="class_attribute_map"
    ,schema="public"
)
public class ClassAttributeMap extends BaseEntity implements java.io.Serializable {


   private int classAttrSkey;
   private Class classIns;
   private MasterAttribute masterAttribute;
   private int masterAttrDisplaySeq;
   private Integer masterAttrDescSeq;
   private String masterAttrBusImp;
   private Date effStartDt;
   private Date effEndDt;
   private Date createTs;
   private String createUser;
   private Date updateTs;
   private String updateUser;
   private Set<ClassAttributeValueMap> classAttributeValueMaps = new HashSet<ClassAttributeValueMap>(0);

    public ClassAttributeMap() {
    }

	
    public ClassAttributeMap(int classAttrSkey, Class classIns, MasterAttribute masterAttribute, int masterAttrDisplaySeq, String masterAttrBusImp, Date effStartDt, Date effEndDt, Date createTs, String createUser) {
        this.classAttrSkey = classAttrSkey;
        this.classIns = classIns;
        this.masterAttribute = masterAttribute;
        this.masterAttrDisplaySeq = masterAttrDisplaySeq;
        this.masterAttrBusImp = masterAttrBusImp;
        this.effStartDt = effStartDt;
        this.effEndDt = effEndDt;
        this.createTs = createTs;
        this.createUser = createUser;
    }

    public ClassAttributeMap(int classAttrSkey, Class classIns, MasterAttribute masterAttribute, int masterAttrDisplaySeq, Integer masterAttrDescSeq, String masterAttrBusImp, Date effStartDt, Date effEndDt, Date createTs, String createUser, Date updateTs, String updateUser, Set<ClassAttributeValueMap> classAttributeValueMaps) {
       this.classAttrSkey = classAttrSkey;
       this.classIns = classIns;
       this.masterAttribute = masterAttribute;
       this.masterAttrDisplaySeq = masterAttrDisplaySeq;
       this.masterAttrDescSeq = masterAttrDescSeq;
       this.masterAttrBusImp = masterAttrBusImp;
       this.effStartDt = effStartDt;
       this.effEndDt = effEndDt;
       this.createTs = createTs;
       this.createUser = createUser;
       this.updateTs = updateTs;
       this.updateUser = updateUser;
       this.classAttributeValueMaps = classAttributeValueMaps;
    }
   
     @Id 

    
    @Column(name="class_attr_skey", unique=true, nullable=false)
    public int getClassAttrSkey() {
        return this.classAttrSkey;
    }
    
    public void setClassAttrSkey(int classAttrSkey) {
        this.classAttrSkey = classAttrSkey;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_skey", nullable=false)
    public Class getClassIns() {
        return this.classIns;
    }
    
    public void setClassIns(Class classIns) {
        this.classIns = classIns;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="attr_skey", nullable=false)
    public MasterAttribute getMasterAttribute() {
        return this.masterAttribute;
    }
    
    public void setMasterAttribute(MasterAttribute masterAttribute) {
        this.masterAttribute = masterAttribute;
    }

    
    @Column(name="master_attr_display_seq", nullable=false)
    public int getMasterAttrDisplaySeq() {
        return this.masterAttrDisplaySeq;
    }
    
    public void setMasterAttrDisplaySeq(int masterAttrDisplaySeq) {
        this.masterAttrDisplaySeq = masterAttrDisplaySeq;
    }

    
    @Column(name="master_attr_desc_seq")
    public Integer getMasterAttrDescSeq() {
        return this.masterAttrDescSeq;
    }
    
    public void setMasterAttrDescSeq(Integer masterAttrDescSeq) {
        this.masterAttrDescSeq = masterAttrDescSeq;
    }

    
    @Column(name="master_attr_bus_imp", nullable=false, length=50)
    public String getMasterAttrBusImp() {
        return this.masterAttrBusImp;
    }
    
    public void setMasterAttrBusImp(String masterAttrBusImp) {
        this.masterAttrBusImp = masterAttrBusImp;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="classAttributeMap")
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
				.append( "classAttrSkey" ,classAttrSkey )
					.append( "class" ,classIns )
					.append( "masterAttribute" ,masterAttribute )
					.append( "masterAttrDisplaySeq" ,masterAttrDisplaySeq )
					.append( "masterAttrDescSeq" ,masterAttrDescSeq )
					.append( "masterAttrBusImp" ,masterAttrBusImp )
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
		 if ( !(other instanceof ClassAttributeMap) ) return false;
		 
		 ClassAttributeMap castOther = ( ClassAttributeMap ) other; 
         
		 return new EqualsBuilder().append( classAttrSkey ,castOther.classAttrSkey )
					.append( classIns ,castOther.classIns )
					.append( masterAttribute ,castOther.masterAttribute )
					.append( masterAttrDisplaySeq ,castOther.masterAttrDisplaySeq )
					.append( masterAttrDescSeq ,castOther.masterAttrDescSeq )
					.append( masterAttrBusImp ,castOther.masterAttrBusImp )
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
		          
         return new HashCodeBuilder().append( classAttrSkey)
					.append( classIns)
					.append( masterAttribute)
					.append( masterAttrDisplaySeq)
					.append( masterAttrDescSeq)
					.append( masterAttrBusImp)
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


