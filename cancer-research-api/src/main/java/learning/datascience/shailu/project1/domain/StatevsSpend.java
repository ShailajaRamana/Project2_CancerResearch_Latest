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
@Table(name = "State_Vs_Spend_Data")
public class StatevsSpend {

    @Id
    @Column(name = "Location")
    private String location;

    @Column(name = "Total_Health_Spending")
    private String healthspend;

}