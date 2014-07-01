package findjobs.usuario;

import findjobs.Estado;
import findjobs.Sexo;
import findjobs.perfil.Perfil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-30T23:16:20")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senhaUsuario;
    public static volatile SingularAttribute<Usuario, Perfil> perfil;
    public static volatile SingularAttribute<Usuario, Sexo> sexo;
    public static volatile SingularAttribute<Usuario, Date> dataNascimento;
    public static volatile SingularAttribute<Usuario, String> cpf;
    public static volatile SingularAttribute<Usuario, String> telefoneUsuario;
    public static volatile SingularAttribute<Usuario, Estado> estadoUsuario;
    public static volatile SingularAttribute<Usuario, String> nomeUsuario;
    public static volatile SingularAttribute<Usuario, String> enderecoUsuario;
    public static volatile SingularAttribute<Usuario, String> cidadeUsuario;
    public static volatile SingularAttribute<Usuario, Long> codigoUsuario;

}