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
@Table(name = "Physician_Data")
public class Physician {

    @Id
    @Column(name = "NPI")
    private long physicianID;

    @Column(name = "Professional_Enrollment_ID")
    private long ProfessionalEnrollmentID;

    @Column(name = "Last_Name")
    private String lastname;

    @Column(name = "First_Name")
    private String firstname;

    @Column(name = "Middle_Name")
    private String middlename;

    @Column(name = "Suffix")
    private String suffix;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Credential")
    private String credentials;

    @Column(name = "Primary_specialty")
    private String primaryspecialty;

    @Column(name = "Secondary_specialty")
    private String secondaryspecialty;

    @Column(name = "Line_1_Street_Address")
    private String line1addr;

    @Column(name = "Line_2_Street_Address")
    private String line2addr;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Zip_Code")
    private int zip;

    @Column(name = "Phone_Number")
    private int phone;

}