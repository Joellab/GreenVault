package com.hongmai.clonfer.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName cp_conference_pipeline
 */
@TableName(value ="cp_conference_pipeline")
@Data
public class CpConferencePipeline implements Serializable {
    /**
     * 
     */
    @TableId
    private String uuid;

    /**
     * 
     */
    private String cpConferenceRecordUuid;

    /**
     * 
     */
    private Integer sequence;

    /**
     * 
     */
    private String action;

    /**
     * 
     */
    private String owner;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String appliedPopulation;

    /**
     * 
     */
    private String extInfo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CpConferencePipeline other = (CpConferencePipeline) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCpConferenceRecordUuid() == null ? other.getCpConferenceRecordUuid() == null : this.getCpConferenceRecordUuid().equals(other.getCpConferenceRecordUuid()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getAction() == null ? other.getAction() == null : this.getAction().equals(other.getAction()))
            && (this.getOwner() == null ? other.getOwner() == null : this.getOwner().equals(other.getOwner()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAppliedPopulation() == null ? other.getAppliedPopulation() == null : this.getAppliedPopulation().equals(other.getAppliedPopulation()))
            && (this.getExtInfo() == null ? other.getExtInfo() == null : this.getExtInfo().equals(other.getExtInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getCpConferenceRecordUuid() == null) ? 0 : getCpConferenceRecordUuid().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getAction() == null) ? 0 : getAction().hashCode());
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAppliedPopulation() == null) ? 0 : getAppliedPopulation().hashCode());
        result = prime * result + ((getExtInfo() == null) ? 0 : getExtInfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", cpConferenceRecordUuid=").append(cpConferenceRecordUuid);
        sb.append(", sequence=").append(sequence);
        sb.append(", action=").append(action);
        sb.append(", owner=").append(owner);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", appliedPopulation=").append(appliedPopulation);
        sb.append(", extInfo=").append(extInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}