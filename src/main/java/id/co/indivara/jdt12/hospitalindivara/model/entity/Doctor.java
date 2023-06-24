package id.co.indivara.jdt12.hospitalindivara.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="mst_doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "don't be empty")
    private String nameDoctor;

    @NotBlank(message = "don't be empty")
    private String address;

    @Size(max = 10,message = "not to much")
    private String numberPhone;

    private Boolean doctorReady;

    @OneToMany(mappedBy = "doctor" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointment;

    @ManyToOne
    @JsonIgnore
    private Specialization specialization;
}
