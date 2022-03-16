/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.utilrelatorios;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.modelo.Receituario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author João
 */
public class FabricaObjetos {
    
    public static List<Medico> carregaMedicos(){
        List<Medico> lista = new ArrayList<>();
        Medico m = new Medico();
        m.setId(1);
        m.setNome("Dr. Alberto");
        m.setCrm("7465467");
        m.setSexo("Masculino");
        m.setTelefone("((54)6666-4444");
        m.setHistorico("Dr. Alberto");
        m.setPeso(33.40);
        m.setAltura(1.20);
        m.setNascimento(Calendar.getInstance());
        Especialidade e = new Especialidade();
        e.setDescricao("Ortopedista");
        m.setEspecialidade(e);
        lista.add(m);
        return lista;
    }
    
    public static List<Paciente> carregaPacientes(){
        List<Paciente> lista = new ArrayList<>();
        Paciente p = new Paciente();
        p.setId(2);
        p.setNome("Leandro");
        p.setSexo("Masculino");
        p.setTelefone("((54)4444-6666");
        p.setHistorico("hist");
        p.setPeso(33.40);
        p.setAltura(1.20);
        p.setNascimento(Calendar.getInstance());
        lista.add(p);
        return lista;
    }
    
    public static List<Consulta> carregaConsultas(){
        List<Consulta> lista = new ArrayList<>();
        Consulta c = new Consulta();
        c.setId(1);
        c.setData(Calendar.getInstance());
        c.setHora(Calendar.getInstance());
        c.setPreConsulta("pre");
        c.setPosConsulta("pos");
        c.setMedico(carregaMedicos().get(0));
        c.setPaciente(carregaPacientes().get(0));
        
        Exame e1 = new Exame();
        e1.setId(1);
        e1.setNome("Exame 1");
        e1.setDescricao("Exame 1");
        Exame e2 = new Exame();
        e2.setId(2);
        e2.setNome("Exame 2");
        e2.setDescricao("Exame 2");
        c.adicionarExame(e1);
        c.adicionarExame(e2);
        
        Receituario r1 = new Receituario();
        r1.setId(1);
        r1.setPosologia("posologia 1");
        r1.setValidade(Calendar.getInstance());
        Receituario r2 = new Receituario();
        r2.setId(2);
        r2.setPosologia("posologia 2");
        r2.setValidade(Calendar.getInstance());
        c.adicionarReceituario(r1);
        c.adicionarReceituario(r2);
        
        lista.add(c);
        //------------------------------------------------------
        Consulta c2 = new Consulta();
        c2.setId(2);
        c2.setData(Calendar.getInstance());
        c2.setHora(Calendar.getInstance());
        c2.setPreConsulta("pre2");
        c2.setPosConsulta("pos2");
        c2.setMedico(carregaMedicos().get(0));
        c2.setPaciente(carregaPacientes().get(0));
        
        Exame e3 = new Exame();
        e3.setId(3);
        e3.setNome("Exame 3");
        e3.setDescricao("Exame 3");
        Exame e4 = new Exame();
        e4.setId(4);
        e4.setNome("Exame 4");
        e4.setDescricao("Exame 4");
        c2.adicionarExame(e3);
        c2.adicionarExame(e4);
        
        Receituario r3 = new Receituario();
        r3.setId(3);
        r3.setPosologia("posologia 3");
        r3.setValidade(Calendar.getInstance());
        Receituario r4 = new Receituario();
        r4.setId(4);
        r4.setPosologia("posologia 4");
        r4.setValidade(Calendar.getInstance());
        c2.adicionarReceituario(r3);
        c2.adicionarReceituario(r4);
        
        lista.add(c2);
        return lista;
    }
    
}
