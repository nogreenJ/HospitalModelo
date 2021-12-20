/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author João
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Paciente implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome não pode estar vazio")
    @Length(max = 40, message = "O nome não pode ultrapassar 40 caracteres")
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @NotNull(message = "A data de nascimento não pode estar vazia")
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @NotNull(message = "O telefone não pode estar vazio")
    @Length(max = 13, message = "O telefone não pode ultrapassar 13 caracteres")
    @Column(name = "telefone", nullable = false)
    private String telefone;
    
    @NotNull(message = "O sexo não pode estar vazio")
    @Column(name = "sexo", nullable = false)
    private String sexo;
    
    @NotNull(message = "O histórico não pode estar vazio")
    @Column(name = "historico", nullable = false)
    private String historico;
    
    @NotNull(message = "O peso não pode estar vazio")
    @Column(name = "peso", nullable = false, columnDefinition = "numeric(6,3)")
    private Double peso;
    
    @NotNull(message = "A altura não pode estar vazia")
    @Column(name = "altura", nullable = false, columnDefinition = "numeric(4,2)")
    private Double altura;
    
    public Paciente(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.nascimento);
        hash = 73 * hash + Objects.hashCode(this.telefone);
        hash = 73 * hash + Objects.hashCode(this.sexo);
        hash = 73 * hash + Objects.hashCode(this.historico);
        hash = 73 * hash + Objects.hashCode(this.peso);
        hash = 73 * hash + Objects.hashCode(this.altura);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.historico, other.historico)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.peso, other.peso)) {
            return false;
        }
        return Objects.equals(this.altura, other.altura);
    }
    
    
    
}
