/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.edu.ea.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author TSPDEV
 */
@Embeddable
public class WebuserUserprofilePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "WebUser_ID")
    private long webUserID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userProfiles_ID")
    private long userProfilesID;

    public WebuserUserprofilePK() {
    }

    public WebuserUserprofilePK(long webUserID, long userProfilesID) {
        this.webUserID = webUserID;
        this.userProfilesID = userProfilesID;
    }

    public long getWebUserID() {
        return webUserID;
    }

    public void setWebUserID(long webUserID) {
        this.webUserID = webUserID;
    }

    public long getUserProfilesID() {
        return userProfilesID;
    }

    public void setUserProfilesID(long userProfilesID) {
        this.userProfilesID = userProfilesID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) webUserID;
        hash += (int) userProfilesID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebuserUserprofilePK)) {
            return false;
        }
        WebuserUserprofilePK other = (WebuserUserprofilePK) object;
        if (this.webUserID != other.webUserID) {
            return false;
        }
        if (this.userProfilesID != other.userProfilesID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.domain.WebuserUserprofilePK[ webUserID=" + webUserID + ", userProfilesID=" + userProfilesID + " ]";
    }
    
}
