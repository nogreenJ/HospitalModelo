/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author João
 */
@Entity
public class Consulta implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data da consulta deve ser informada")
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "A hora da consulta deve ser informada")
    @Column(name = "hora", nullable = false)
    private Calendar hora;
    
    @NotBlank(message = "A pré consulta não pode estar vazia")
    @Column(name = "preConsulta", nullable = false)
    private String preConsulta;
    
    @NotBlank(message = "A pós consulta não pode estar vazia")
    @Column(name = "posConsulta", nullable = false)
    private String posConsulta;
    
    @NotNull(message = "O médico deve ser informado")
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Medico medico;
    
    @NotNull(message = "O paciente deve ser informado")
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Paciente paciente;
    
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Exame> exames = new ArrayList<>();
    
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Receituario> receituarios = new ArrayList<>();
    
    public Consulta(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public String getPreConsulta() {
        return preConsulta;
    }

    public void setPreConsulta(String preConsulta) {
        this.preConsulta = preConsulta;
    }

    public String getPosConsulta() {
        return posConsulta;
    }

    public void setPosConsulta(String posConsulta) {
        this.posConsulta = posConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> Exames) {
        this.exames = Exames;
    }

    public List<Receituario> getReceituarios() {
        return receituarios;
    }

    public void setReceituarios(List<Receituario> receituarios) {
        this.receituarios = receituarios;
    }
    
    public void adicionarExame(Exame exame){
        exame.setConsulta(this);
        exames.add(exame);
    }
    
    public void removerExame(int index){
        exames.remove(index);
    }
    
    public void adicionarReceituario(Receituario receituario){
        receituario.setConsulta(this);
        receituarios.add(receituario);
    }
    
    public void removerReceituario(int index){
        receituarios.remove(index);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.data);
        hash = 17 * hash + Objects.hashCode(this.hora);
        hash = 17 * hash + Objects.hashCode(this.preConsulta);
        hash = 17 * hash + Objects.hashCode(this.posConsulta);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.preConsulta, other.preConsulta)) {
            return false;
        }
        if (!Objects.equals(this.posConsulta, other.posConsulta)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return Objects.equals(this.hora, other.hora);
    }
    
    
}
