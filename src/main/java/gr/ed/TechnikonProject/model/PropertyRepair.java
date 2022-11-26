package gr.ed.TechnikonProject.model;

import gr.ed.TechnikonProject.enums.RepairAcceptance;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class PropertyRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyRepairId;

    @ManyToOne
    private Property repairProperty;

    @Column(columnDefinition = "enum('PAINTING','INSULATION', 'FRAMES', 'PLUMBING', 'ELECTRICAL_WORK')")
    @Enumerated(EnumType.STRING)
    private RepairType repairType;
    
    @Column(columnDefinition = "enum('PENDING','DECLINED','IN_PROGRESS', 'COMPLETE')")
    @Enumerated(EnumType.STRING)
    private RepairStatus repairStatus;

    private String repairDescription;
    private String repairWorkToBeDone;
    
    //Actual Dates
    private LocalDate repairSubmissionDate;
    private LocalDate repairActualStartDate;
    private LocalDate repairActualEndDate;
    //Proposed by admin Data
    private LocalDate repairProposedStartDate;
    private LocalDate repairProposedEndDate;
    private BigDecimal repairProposedCost;
    
    @Column(columnDefinition = "enum('PENDING','DECLINED','ACCEPTED')")
    @Enumerated(EnumType.STRING)
    private RepairAcceptance repairAcceptance;

    public PropertyRepair() {
    }

    public PropertyRepair(Property repairProperty, RepairType repairType, RepairStatus repairStatus, String repairDescription, String repairWorkToBeDone, LocalDate repairSubmissionDate, BigDecimal repairProposedCost) {
        this.repairProperty = repairProperty;
        this.repairType = repairType;
        this.repairStatus = repairStatus;
        this.repairDescription = repairDescription;
        this.repairWorkToBeDone = repairWorkToBeDone;
        this.repairSubmissionDate = repairSubmissionDate;
        this.repairProposedCost = repairProposedCost;
    }
    

    public int getPropertyRepairId() {
        return propertyRepairId;
    }

    public void setPropertyRepairId(int propertyRepairId) {
        this.propertyRepairId = propertyRepairId;
    }

    public Property getRepairProperty() {
        return repairProperty;
    }

    public void setRepairProperty(Property repairProperty) {
        this.repairProperty = repairProperty;
    }

    public RepairType getRepairType() {
        return repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }

    public RepairStatus getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(RepairStatus repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public String getRepairWorkToBeDone() {
        return repairWorkToBeDone;
    }

    public void setRepairWorkToBeDone(String repairWorkToBeDone) {
        this.repairWorkToBeDone = repairWorkToBeDone;
    }

    public LocalDate getRepairSubmissionDate() {
        return repairSubmissionDate;
    }

    public void setRepairSubmissionDate(LocalDate repairSubmissionDate) {
        this.repairSubmissionDate = repairSubmissionDate;
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

    public BigDecimal getRepairProposedCost() {
        return repairProposedCost;
    }

    public void setRepairProposedCost(BigDecimal repairProposedCost) {
        this.repairProposedCost = repairProposedCost;
    }

    public RepairAcceptance getRepairAcceptance() {
        return repairAcceptance;
    }

    public void setRepairAcceptance(RepairAcceptance repairAcceptance) {
        this.repairAcceptance = repairAcceptance;
    }



    @Override
    public final String toString() {
        return "PropertyRepair{" + "\n propertyRepairId=" + propertyRepairId + ",\n repairProperty=" + repairProperty.getPropertyId() + ",\n repairType=" + repairType + ",\n repairStatus=" + repairStatus + ",\n repairDescription=" + repairDescription + ",\n repairWorkToBeDone=" + repairWorkToBeDone + ",\n repairSubmissionDate=" + repairSubmissionDate + ",\n repairActualStartDate=" + repairActualStartDate + ",\n repairActualEndDate=" + repairActualEndDate + ",\n repairProposedStartDate=" + repairProposedStartDate + ",\n repairProposedEndDate=" + repairProposedEndDate + ",\n repairProposedCost=" + repairProposedCost + ",\n repairAcceptance=" + repairAcceptance + '}' + "\n";
    }
    
    

}
