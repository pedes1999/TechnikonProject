package gr.ed.TechnikonProject.model;

import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
import java.time.LocalDate;

public class PropertyRepair{
    private Integer repairOwnerId;
    private Integer repairPropertyId;
    private RepairType repairType;
    private String repairDescription;
    private LocalDate repairSubmissionDate;
    private String repairWorkToBeDone;
    private LocalDate repairProposedStartDate;
    private LocalDate repairProposedEndDate;
    private Double repairProposedCost;
    private Boolean repairAcceptance;
    private RepairStatus repairStatus;
    private LocalDate repairActualStartDate;
    private LocalDate repairActualEndDate;
    
    public PropertyRepair(){}

    
    public Integer getRepairOwnerId() {
        return repairOwnerId;
    }

    public void setRepairOwnerId(Integer repairOwnerId) {
        this.repairOwnerId = repairOwnerId;
    }

    public Integer getRepairPropertyId() {
        return repairPropertyId;
    }

    public void setRepairPropertyId(Integer repairPropertyId) {
        this.repairPropertyId = repairPropertyId;
    }

    public RepairType getRepairType() {
        return repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public LocalDate getRepairSubmissionDate() {
        return repairSubmissionDate;
    }

    public void setRepairSubmissionDate(LocalDate repairSubmissionDate) {
        this.repairSubmissionDate = repairSubmissionDate;
    }

    public String getRepairWorkToBeDone() {
        return repairWorkToBeDone;
    }

    public void setRepairWorkToBeDone(String repairWorkToBeDone) {
        this.repairWorkToBeDone = repairWorkToBeDone;
    }

    public LocalDate getRepairProposedStartDate() {
        return repairProposedStartDate;
    }

    public void setRepairProposedStartDate(LocalDate repairProposedStartDate) {
        this.repairProposedStartDate = repairProposedStartDate;
    }

    public LocalDate getRepairProposedEndDate() {
        return repairProposedEndDate;
    }

    public void setRepairProposedEndDate(LocalDate repairProposedEndDate) {
        this.repairProposedEndDate = repairProposedEndDate;
    }

    public Double getRepairProposedCost() {
        return repairProposedCost;
    }

    public void setRepairProposedCost(Double repairProposedCost) {
        this.repairProposedCost = repairProposedCost;
    }

    public Boolean getRepairAcceptance() {
        return repairAcceptance;
    }

    public void setRepairAcceptance(Boolean repairAcceptance) {
        this.repairAcceptance = repairAcceptance;
    }

    public RepairStatus getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(RepairStatus repairStatus) {
        this.repairStatus = repairStatus;
    }

    public LocalDate getRepairActualStartDate() {
        return repairActualStartDate;
    }

    public void setRepairActualStartDate(LocalDate repairActualStartDate) {
        this.repairActualStartDate = repairActualStartDate;
    }

    public LocalDate getRepairActualEndDate() {
        return repairActualEndDate;
    }

    public void setRepairActualEndDate(LocalDate repairActualEndDate) {
        this.repairActualEndDate = repairActualEndDate;
    }

    @Override
    public String toString() {
        return "PropertyRepair{" + "repairOwnerId=" + repairOwnerId + ", repairPropertyId=" + repairPropertyId + ", repairType=" + repairType + ", repairDescription=" + repairDescription + ", repairSubmissionDate=" + repairSubmissionDate + ", repairWorkToBeDone=" + repairWorkToBeDone + ", repairProposedStartDate=" + repairProposedStartDate + ", repairProposedEndDate=" + repairProposedEndDate + ", repairProposedCost=" + repairProposedCost + ", repairAcceptance=" + repairAcceptance + ", repairStatus=" + repairStatus + ", repairActualStartDate=" + repairActualStartDate + ", repairActualEndDate=" + repairActualEndDate + '}';
    }

   
    
    
    
    
    
}
