package findjobs.vaga;

import findjobs.Categoria;
import findjobs.Estado;
import findjobs.empresa.Empresa;
import findjobs.perfil.Perfil;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-30T23:16:20")
@StaticMetamodel(Vaga.class)
public class Vaga_ { 

    public static volatile SingularAttribute<Vaga, Categoria> categoria;
    public static volatile SingularAttribute<Vaga, String> cidade;
    public static volatile SingularAttribute<Vaga, Integer> vagasDisponiveis;
    public static volatile SingularAttribute<Vaga, Estado> estado;
    public static volatile SingularAttribute<Vaga, Double> remuneracao;
    public static volatile SingularAttribute<Vaga, String> nomeVaga;
    public static volatile SingularAttribute<Vaga, Empresa> empresa;
    public static volatile SingularAttribute<Vaga, Perfil> perfil;
    public static volatile SingularAttribute<Vaga, Long> codigoVaga;
    public static volatile SingularAttribute<Vaga, String> requisitos;
    public static volatile SingularAttribute<Vaga, Integer> horasTrabalho;

}