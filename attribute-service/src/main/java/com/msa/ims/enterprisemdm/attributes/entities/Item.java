package com.msa.ims.enterprisemdm.attributes.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="item"
    ,schema="public"
)
public class Item extends BaseEntity implements java.io.Serializable {


   private Long itemSkey;
   private String industrySector;
   private String industrySegment;
   private String industryClass;
   private String upc;
   private String shortDescription;
   private String longDesctiption;
   private String status;
   private String reasonForChange;
   private Date createTs;
   private String createUser;
   private Date updateTs;
   private String updateUser;
   private Serializable atributes;

    public Item() {
    }

	
    public Item(Long itemSkey, String industrySector, String industrySegment, String industryClass, String upc, String shortDescription, String longDesctiption, String status, String reasonForChange, Date createTs, String createUser) {
        this.itemSkey = itemSkey;
        this.industrySector = industrySector;
        this.industrySegment = industrySegment;
        this.industryClass = industryClass;
        this.upc = upc;
        this.shortDescription = shortDescription;
        this.longDesctiption = longDesctiption;
        this.status = status;
        this.reasonForChange = reasonForChange;
        this.createTs = createTs;
        this.createUser = createUser;
    }

    public Item(Long itemSkey, String industrySector, String industrySegment, String industryClass, String upc, String shortDescription, String longDesctiption, String status, String reasonForChange, Date createTs, String createUser, Date updateTs, String updateUser, Serializable atributes) {
       this.itemSkey = itemSkey;
       this.industrySector = industrySector;
       this.industrySegment = industrySegment;
       this.industryClass = industryClass;
       this.upc = upc;
       this.shortDescription = shortDescription;
       this.longDesctiption = longDesctiption;
       this.status = status;
       this.reasonForChange = reasonForChange;
       this.createTs = createTs;
       this.createUser = createUser;
       this.updateTs = updateTs;
       this.updateUser = updateUser;
       this.atributes = atributes;
    }
   
     @Id 

     @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="item_skey", unique=true, nullable=false)
    public Long getItemSkey() {
        return this.itemSkey;
    }
    
    public void setItemSkey(Long itemSkey) {
        this.itemSkey = itemSkey;
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

    
    @Column(name="upc", nullable=false, length=50)
    public String getUpc() {
        return this.upc;
    }
    
    public void setUpc(String upc) {
        this.upc = upc;
    }

    
    @Column(name="short_description", nullable=false, length=50)
    public String getShortDescription() {
        return this.shortDescription;
    }
    
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    
    @Column(name="long_desctiption", nullable=false, length=50)
    public String getLongDesctiption() {
        return this.longDesctiption;
    }
    
    public void setLongDesctiption(String longDesctiption) {
        this.longDesctiption = longDesctiption;
    }

    
    @Column(name="status", nullable=false, length=50)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    
    @Column(name="reason_for_change", nullable=false, length=50)
    public String getReasonForChange() {
        return this.reasonForChange;
    }
    
    public void setReasonForChange(String reasonForChange) {
        this.reasonForChange = reasonForChange;
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

    
    @Column(name="atributes")
    public Serializable getAtributes() {
        return this.atributes;
    }
    
    public void setAtributes(Serializable atributes) {
        this.atributes = atributes;
    }

	 /* (non-Javadoc)
      * @see java.lang.Object#toString()
      */
     public String toString() {
		 
		 return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append( "itemSkey" ,itemSkey )
					.append( "industrySector" ,industrySector )
					.append( "industrySegment" ,industrySegment )
					.append( "industryClass" ,industryClass )
					.append( "upc" ,upc )
					.append( "shortDescription" ,shortDescription )
					.append( "longDesctiption" ,longDesctiption )
					.append( "status" ,status )
					.append( "reasonForChange" ,reasonForChange )
					.append( "createTs" ,createTs )
					.append( "createUser" ,createUser )
					.append( "updateTs" ,updateTs )
					.append( "updateUser" ,updateUser )
					.append( "atributes" ,atributes )
					.toString();
     }

	/* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
	public boolean equals(Object other) {
	
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Item) ) return false;
		 
		 Item castOther = ( Item ) other; 
         
		 return new EqualsBuilder().append( itemSkey ,castOther.itemSkey )
					.append( industrySector ,castOther.industrySector )
					.append( industrySegment ,castOther.industrySegment )
					.append( industryClass ,castOther.industryClass )
					.append( upc ,castOther.upc )
					.append( shortDescription ,castOther.shortDescription )
					.append( longDesctiption ,castOther.longDesctiption )
					.append( status ,castOther.status )
					.append( reasonForChange ,castOther.reasonForChange )
					.append( createTs ,castOther.createTs )
					.append( createUser ,castOther.createUser )
					.append( updateTs ,castOther.updateTs )
					.append( updateUser ,castOther.updateUser )
					.append( atributes ,castOther.atributes )
					.isEquals();
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
		          
         return new HashCodeBuilder().append( itemSkey)
					.append( industrySector)
					.append( industrySegment)
					.append( industryClass)
					.append( upc)
					.append( shortDescription)
					.append( longDesctiption)
					.append( status)
					.append( reasonForChange)
					.append( createTs)
					.append( createUser)
					.append( updateTs)
					.append( updateUser)
					.append( atributes)
					.toHashCode();
   }   


}


