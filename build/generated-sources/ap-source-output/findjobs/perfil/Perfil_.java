package findjobs.perfil;

import findjobs.Categoria;
import findjobs.perfil.Perfil;
import findjobs.usuario.Usuario;
import findjobs.vaga.Vaga;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-30T23:16:20")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile ListAttribute<Perfil, Vaga> vagas;
    public static volatile SingularAttribute<Perfil, Categoria> categoria;
    public static volatile SingularAttribute<Perfil, Double> remuneracao;
    public static volatile SingularAttribute<Perfil, Vaga> vaga;
    public static volatile SingularAttribute<Perfil, Usuario> usuario;
    public static volatile SingularAttribute<Perfil, Perfil> perfil;
    public static volatile SingularAttribute<Perfil, Long> codigoPerfil;
    public static volatile SingularAttribute<Perfil, Integer> horasTrabalho;

}