package learning.datascience.shailu.project1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "LUEKAMIA_DATA")
public class Luekamia {

    @Id
    @Column(name = "Patient_ID")
    private String patientID;

    @Column(name = "Age_at_Diagnosis")
    private int ageAtDiagnosis;

    @Column(name = "Cancer_Type")
    private String cancerType;

    @Column(name = "Dead_Disease")
    private String cancerTypeDetailed;

    @Column(name = "Cause_of_death_source")
    private String CauseOfDeathSource;

    @Column(name = "Chemotherapy")
    private boolean chemotherapy;

    @Column(name = "Cumulative_Treatment_Stages")
    private String cumulativeTreatmentStages;

    @Column(name = "Cumulative_Treatment_Types")
    private String cumulativeTreatmentTypes;

    @Column(name = "Current_Regimen")
    private String currentRegimen;

    @Column(name = "Current_Stage")
    private String currentStage;

    @Column(name = "Diagnosis")
    private String diagnosis;

    @Column(name = "Diagnosis_at_Inclusion")
    private String diagnosisAtInclusion;

    @Column(name = "Drug_Testing_data_in_Analysis")
    private String drugTestingDataInAnalysis;

    @Column(name = "Duration_of_Induction_Treatment")
    private String durationOfInductionTreatment;

    @Column(name = "Ethnicity_Category")
    private String ethnicityCategory;

    @Column(name = "Negative_for_FLT3")
    private String negativeForFLT3;

    @Column(name = "Fusion")
    private String fusion;

    @Column(name = "GroupData")
    private String group;

    @Column(name = "Response_to_Induction_Treatment")
    private String responseToInductionTreatment;

    @Column(name = "Sex")
    private Sex sex;

    @Column(name = "Specific_Diagnosis_at_Acquisition")
    private String specificDiagnosisAtAcquisition;

    @Column(name = "Specific_Diagnosis_at_Inclusion")
    private String specificDiagnosisAtInclusion;

    @Column(name = "Treatment_Type")
    private String treatmentType;

    @Column(name = "Type_of_Induction_Treatment")
    private String typeOfInductionTreatment;
}
