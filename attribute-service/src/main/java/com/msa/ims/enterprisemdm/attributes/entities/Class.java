package com.msa.ims.enterprisemdm.attributes.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="class"
)
public class Class extends BaseEntity implements java.io.Serializable {


   private Long classSkey;
   private String industrySector;
   private String industrySegment;
   private String industryClass;
   private Date effStartDt;
   private Date effEndDt;
   private Date createTs;
   private String createUser;
   private Date updateTs;
   private String updateUser;
   private Set<ClassAttributeMap> classAttributeMaps = new HashSet<ClassAttributeMap>(0);

    public Class() {
    }

	
    public Class(Long classSkey, String industrySector, String industrySegment, String industryClass, Date effStartDt, Date effEndDt, Date createTs, String createUser) {
        this.classSkey = classSkey;
        this.industrySector = industrySector;
        this.industrySegment = industrySegment;
        this.industryClass = industryClass;
        this.effStartDt = effStartDt;
        this.effEndDt = effEndDt;
        this.createTs = createTs;
        this.createUser = createUser;
    }

    public Class(Long classSkey, String industrySector, String industrySegment, String industryClass, Date effStartDt, Date effEndDt, Date createTs, String createUser, Date updateTs, String updateUser, Set<ClassAttributeMap> classAttributeMaps) {
       this.classSkey = classSkey;
       this.industrySector = industrySector;
       this.industrySegment = industrySegment;
       this.industryClass = industryClass;
       this.effStartDt = effStartDt;
       this.effEndDt = effEndDt;
       this.createTs = createTs;
       this.createUser = createUser;
       this.updateTs = updateTs;
       this.updateUser = updateUser;
       this.classAttributeMaps = classAttributeMaps;
    }
   
     @Id 
     @GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column(name="class_skey", unique=true, nullable=false)
    public Long getClassSkey() {
        return this.classSkey;
    }
    
    public void setClassSkey(Long classSkey) {
        this.classSkey = classSkey;
    }

    
    @Column(name="industry_sector", nullable=false, length=50)
    public String getIndustrySector() {
        return this.industrySector;
    }
    
    public void setIndustrySector(String industrySector) {
        this.industrySector = industrySector;
    }

    
    @Column(name="industry_segment", nullable=false, length=50)
    public String getIndustrySegment() {
        return this.industrySegment;
    }
    
    public void setIndustrySegment(String industrySegment) {
        this.industrySegment = industrySegment;
    }

    
    @Column(name="industry_class", nullable=false, length=50)
    public String getIndustryClass() {
        return this.industryClass;
    }
    
    public void setIndustryClass(String industryClass) {
        this.industryClass = industryClass;
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

@OneToMany(fetch=FetchType.EAGER, mappedBy="classIns")
    public Set<ClassAttributeMap> getClassAttributeMaps() {
        return this.classAttributeMaps;
    }
    
    public void setClassAttributeMaps(Set<ClassAttributeMap> classAttributeMaps) {
        this.classAttributeMaps = classAttributeMaps;
    }

	 /* (non-Javadoc)
      * @see java.lang.Object#toString()
      */
     public String toString() {
		 
		 return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append( "classSkey" ,classSkey )
					.append( "industrySector" ,industrySector )
					.append( "industrySegment" ,industrySegment )
					.append( "industryClass" ,industryClass )
					.append( "effStartDt" ,effStartDt )
					.append( "effEndDt" ,effEndDt )
					.append( "createTs" ,createTs )
					.append( "createUser" ,createUser )
					.append( "updateTs" ,updateTs )
					.append( "updateUser" ,updateUser )
					.append( "classAttributeMaps" ,classAttributeMaps )
					.toString();
     }

	/* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
	public boolean equals(Object other) {
	
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Class) ) return false;
		 
		 Class castOther = ( Class ) other; 
         
		 return new EqualsBuilder().append( classSkey ,castOther.classSkey )
					.append( industrySector ,castOther.industrySector )
					.append( industrySegment ,castOther.industrySegment )
					.append( industryClass ,castOther.industryClass )
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
		          
         return new HashCodeBuilder().append( classSkey)
					.append( industrySector)
					.append( industrySegment)
					.append( industryClass)
					.append( effStartDt)
					.append( effEndDt)
					.append( createTs)
					.append( createUser)
					.append( updateTs)
					.append( updateUser)
					.toHashCode();
   }   


}


