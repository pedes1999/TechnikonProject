package gr.ed.TechnikonProject.model;

import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
import java.time.LocalDate;

public class PropertyRepair extends PersistentClass{
    private String repairOwnerVAT;
    private String repairPropertyE9;
    private RepairType repairType;
    private String repairDescription;
    private LocalDate repairSubmissionDate;
    private String repairWorkToBeDone;
    private LocalDate repairProsopedStartDate;
    private LocalDate repairProposedEndDate;
    private Double repairProposedCost;
    private Boolean repairAcceptance;
    private RepairStatus repairStatus;
    private LocalDate repairActualStartDate;
    private LocalDate repairActualEndDate;
    
    public PropertyRepair(){}

    
    public String getRepairOwnerVAT() {
        return repairOwnerVAT;
    }

    public void setRepairOwnerVAT(String repairOwnerVAT) {
        this.repairOwnerVAT = repairOwnerVAT;
    }

    public String getRepairPropertyE9() {
        return repairPropertyE9;
    }

    public void setRepairPropertyE9(String repairPropertyE9) {
        this.repairPropertyE9 = repairPropertyE9;
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

    public LocalDate getRepairProsopedStartDate() {
        return repairProsopedStartDate;
    }

    public void setRepairProsopedStartDate(LocalDate repairProsopedStartDate) {
        this.repairProsopedStartDate = repairProsopedStartDate;
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
    
    
    
    
}
