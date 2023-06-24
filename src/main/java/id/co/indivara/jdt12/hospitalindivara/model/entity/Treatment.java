package id.co.indivara.jdt12.hospitalindivara.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="mst_treatments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Treatment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String typeOfTreatment;
    private String diagnosis;
    private String medicine;

    @OneToMany(mappedBy = "treatment",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Record>record;


}
