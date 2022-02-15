/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author João
 */
@Entity
public class Receituario implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_receituario", sequenceName = "seq_receituario_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_receituario", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A posologia não pode estar vazia")
    @Column(name = "posologia", nullable = false)
    private String posologia;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de validade deve ser informada")
    @Column(name = "validade", nullable = false)
    private Calendar validade;
    
    @JoinColumn(name = "consulta_id", referencedColumnName = "id", nullable = false)
    private Consulta consulta;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "medicamentos",
            joinColumns = 
            @JoinColumn(name = "posologia", referencedColumnName = "posologia", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "medicamento", referencedColumnName = "nome", nullable = false)
    )
    private Set<Medicamento> medicamentos = new HashSet<>();
    
    public Receituario(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Set<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Set<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.posologia);
        hash = 89 * hash + Objects.hashCode(this.validade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Receituario other = (Receituario) obj;
        if (!Objects.equals(this.posologia, other.posologia)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.validade, other.validade);
    }
    
    public void adicionarMedicamento(Medicamento med){
       if(medicamentos.size() == 0){
           medicamentos = new HashSet<>();
       }
       medicamentos.add(med);
    }
    
    public void removerMedicamento(int index){
        medicamentos.remove(index);
    }
}
